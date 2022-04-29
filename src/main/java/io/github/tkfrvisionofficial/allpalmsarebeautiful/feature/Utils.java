package io.github.tkfrvisionofficial.allpalmsarebeautiful.feature;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraftforge.common.util.Constants;
import net.tropicraft.core.common.block.CoconutBlock;
import net.tropicraft.core.common.block.TropicraftBlocks;

import java.util.Comparator;
import java.util.Random;
import java.util.Set;

public final class Utils {
    private Utils() {
        throw new UnsupportedOperationException();
    }

    public static void spawnCoconuts(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand) {
        final BlockState coconut = TropicraftBlocks.COCONUT.get().defaultBlockState();

        changedBlocks.stream()
                .filter(blockPos -> !TreeFeature.isAirOrLeaves(worldIn, blockPos) && TreeFeature.isAir(worldIn, blockPos.below()))
                .sorted((a, b) -> b.getY() - a.getY())
                .limit(Math.round(rand.nextDouble() * (changedBlocks.size() / 3d)))
                .forEach(blockPos -> worldIn.setBlock(blockPos.below(),
                        coconut.setValue(CoconutBlock.FACING, Direction.UP), Constants.BlockFlags.DEFAULT));
    }


}
