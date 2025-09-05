package com.fullskele.elementalend.block;

import com.google.common.base.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class AbstractBlockEndPortalFrame extends Block {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    public static final PropertyBool EYE = PropertyBool.create("eye");
    private static BlockPattern portalShape;

    public AbstractBlockEndPortalFrame() {
        super(Material.ROCK, MapColor.GREEN);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(EYE, false));
        this.setBlockUnbreakable();
        this.setResistance(Float.MAX_VALUE);
        this.setHarvestLevel("pickaxe", -1);
        this.setLightOpacity(0);
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
                                            float hitX, float hitY, float hitZ, int meta,
                                            EntityLivingBase placer) {
        return this.getDefaultState()
                .withProperty(FACING, placer.getHorizontalFacing().getOpposite())
                .withProperty(EYE, false);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.8125D, 1.0D);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState()
                .withProperty(EYE, (meta & 4) != 0)
                .withProperty(FACING, EnumFacing.byHorizontalIndex(meta & 3));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i = ((EnumFacing) state.getValue(FACING)).getHorizontalIndex();
        if (state.getValue(EYE)) {
            i |= 4;
        }
        return i;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, EYE);
    }

    protected abstract Item getActivationItem();

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state,
                                    EntityPlayer player, EnumHand hand, EnumFacing side,
                                    float hitX, float hitY, float hitZ) {
        ItemStack held = player.getHeldItem(hand);

        if (!state.getValue(EYE) && held.getItem() == getActivationItem()) {
            if (!world.isRemote) {
                world.setBlockState(pos, state.withProperty(EYE, true), 2);
                world.playSound(null, pos, SoundEvents.BLOCK_END_PORTAL_FRAME_FILL,
                        SoundCategory.BLOCKS, 1.0F, 1.0F);
                if (!player.isCreative()) {
                    held.shrink(1);
                }

                BlockPattern.PatternHelper helper = getOrCreatePortalShape().match(world, pos);
                if (helper != null) {
                    int width = helper.getWidth();
                    int height = helper.getHeight();
                    boolean portalCreated = false;

                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < height; j++) {
                            BlockWorldState frameState = helper.translateOffset(i, j, 1);

                            BlockPos portalPos = frameState.getPos();

                            if (i > 0 && i < width - 1 && j > 0 && j < height - 1) {
                                BlockPos raised = portalPos.up();
                                world.setBlockState(raised, Blocks.END_PORTAL.getDefaultState(), 2);
                                portalCreated = true;
                            }
                        }
                    }
                    if (portalCreated) {
                        world.playSound(null, pos, SoundEvents.BLOCK_END_PORTAL_SPAWN,
                                SoundCategory.BLOCKS, 1.0F, 1.0F);
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static BlockPattern getOrCreatePortalShape() {
        if (portalShape == null) {
            portalShape = FactoryBlockPattern.start()
                    .aisle("?vvv?", ">???<", ">???<", ">???<", "?^^^?")
                    .where('?', BlockWorldState.hasState(BlockStateMatcher.ANY))
                    .where('^', frameMatcher(EnumFacing.SOUTH))
                    .where('>', frameMatcher(EnumFacing.WEST))
                    .where('v', frameMatcher(EnumFacing.NORTH))
                    .where('<', frameMatcher(EnumFacing.EAST))
                    .build();
        }
        return portalShape;
    }

    private static Predicate<BlockWorldState> frameMatcher(EnumFacing facing) {
        return state -> {
            IBlockState blockState = state.getBlockState();
            Block block = blockState.getBlock();
            if (block instanceof BlockCustomEndPortalFrame) {
                return blockState.getValue(EYE) && blockState.getValue(FACING) == facing;
            }
            return false;
        };
    }
}

