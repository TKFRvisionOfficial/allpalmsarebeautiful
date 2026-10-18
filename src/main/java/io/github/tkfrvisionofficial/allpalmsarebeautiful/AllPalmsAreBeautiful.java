package io.github.tkfrvisionofficial.allpalmsarebeautiful;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import io.github.tkfrvisionofficial.allpalmsarebeautiful.decorator.TreeDecorators;

@Mod("allpalmsarebeautiful")
public class AllPalmsAreBeautiful {
    public static final String MODID = "allpalmsarebeautiful";

    public AllPalmsAreBeautiful(FMLJavaModLoadingContext context) {
        TreeDecorators.register(context.getModEventBus());
    }
}
