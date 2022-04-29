package io.github.tkfrvisionofficial.allpalmsarebeautiful.mixin;

import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.palm.PalmTree3;
import io.github.tkfrvisionofficial.allpalmsarebeautiful.feature.Utils;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.tropicraft.core.common.dimension.feature.tree.PalmTreeFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;
import java.util.Set;

@Mixin(PalmTree3.class)
public class PalmTree3Mixin {

    @Inject(at = @At("RETURN"), method = "generate", remap = false)
    private void generate(Set<BlockPos> changedBlocks,
                          ISeedReader worldIn,
                          Random rand,
                          BlockPos pos,
                          MutableBoundingBox boundsIn,
                          boolean isSapling,
                          BYGTreeConfig config,
                          CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) {
            Utils.spawnCoconuts(changedBlocks, worldIn, rand);
        }
    }

}
