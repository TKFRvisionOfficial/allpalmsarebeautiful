package io.github.tkfrvisionofficial.allpalmsarebeautiful.decorator;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.registries.ForgeRegistries;
import net.tropicraft.core.common.block.CoconutBlock;

public class CoconutOnLogsDecorator extends TreeDecorator {
    public static final Codec<CoconutOnLogsDecorator> CODEC = Codec.unit(CoconutOnLogsDecorator::new);

    @Override
    protected TreeDecoratorType<?> type() {
        return TreeDecorators.COCONUT_ON_LOGS.get();
    }

    @Override
    public void place(Context context) {
        var logs = context.logs();
        var leaves = context.leaves();
        var coconut = ForgeRegistries.BLOCKS
        .getValue(ResourceLocation.fromNamespaceAndPath("tropicraft", "coconut"))
        .defaultBlockState();
        var rand = context.random();

        logs.stream()
            .filter(blockPos -> context.isAir(blockPos.below()))
            .sorted((a, b) -> b.getY() - a.getY())
            .limit(Math.round(rand.nextDouble() * ((logs.size() + leaves.size()) / 3d)))
            .forEach(blockPos -> context.setBlock(
                blockPos.below(),
                coconut.setValue(CoconutBlock.FACING, Direction.UP)));
    }

}
