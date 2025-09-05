package com.fullskele.elementalend.mixin;

import com.fullskele.elementalend.block.ModBlocks;
import com.fullskele.elementalend.block.BlockCustomEndPortalFrame;
import net.minecraft.block.BlockEndPortalFrame;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(StructureStrongholdPieces.PortalRoom.class)
public abstract class PortalRoomMixin extends StructureComponent {

    @Inject(method = "addComponentParts", at = @At("TAIL"))
    private void replaceEndPortalFrames(World world, Random random, StructureBoundingBox box, CallbackInfoReturnable<Boolean> cir) {

        BlockCustomEndPortalFrame[] frames = new BlockCustomEndPortalFrame[]{
                ModBlocks.LIGHTNING_FRAME, ModBlocks.NETHER_FRAME, ModBlocks.ARID_FRAME,
                ModBlocks.MAGIC_FRAME, ModBlocks.AETHER_FRAME, ModBlocks.FIRE_FRAME,
                ModBlocks.EARTH_FRAME, ModBlocks.ICY_FRAME, ModBlocks.WATER_FRAME,
                 ModBlocks.CHAOS_FRAME, ModBlocks.VOID_FRAME, ModBlocks.ORDER_FRAME,
        };

        int[][] coords = {
                {4, 3, 8},  {5, 3, 8},  {6, 3, 8},
                {4, 3, 12}, {5, 3, 12}, {6, 3, 12},
                {3, 3, 9},  {3, 3, 10}, {3, 3, 11},
                {7, 3, 9},  {7, 3, 10}, {7, 3, 11}
        };

        final int centerLocalX = 5;
        final int centerLocalY = 3;
        final int centerLocalZ = 10;

        BlockPos centerWorld = new BlockPos(
                this.getXWithOffset(centerLocalX, centerLocalZ),
                this.getYWithOffset(centerLocalY),
                this.getZWithOffset(centerLocalX, centerLocalZ)
        );

        for (int i = 0; i < frames.length; i++) {
            int[] c = coords[i];

            BlockPos frameWorld = new BlockPos(
                    this.getXWithOffset(c[0], c[2]),
                    this.getYWithOffset(c[1]),
                    this.getZWithOffset(c[0], c[2])
            );

            double dx = centerWorld.getX() - frameWorld.getX();
            double dy = centerWorld.getY() - frameWorld.getY();
            double dz = centerWorld.getZ() - frameWorld.getZ();
            EnumFacing worldFacing = EnumFacing.getFacingFromVector((float) dx, (float) dy, (float) dz);

            IBlockState state = frames[i].getDefaultState().withProperty(BlockEndPortalFrame.FACING, worldFacing).withProperty(BlockEndPortalFrame.EYE, false);

            this.setBlockState(world, state, c[0], c[1], c[2], box);
        }
    }
}