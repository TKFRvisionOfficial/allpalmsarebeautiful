package io.github.tkfrvisionofficial.allpalmsarebeautiful.decorator;

import io.github.tkfrvisionofficial.allpalmsarebeautiful.AllPalmsAreBeautiful;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class TreeDecorators {
    public static final DeferredRegister<TreeDecoratorType<?>> TYPES = DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, AllPalmsAreBeautiful.MODID);

    public static final RegistryObject<TreeDecoratorType<?>> COCONUT_ON_LOGS = TYPES.register(
        "coconut_on_log",
        () -> new TreeDecoratorType<>(CoconutOnLogsDecorator.CODEC));
    
    public static void register(IEventBus modEventBus) {
        TYPES.register(modEventBus);
    }

    private TreeDecorators() {}
}
