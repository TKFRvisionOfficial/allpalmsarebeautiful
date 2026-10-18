package io.github.tkfrvisionofficial.allpalmsarebeautiful.event;

import io.github.tkfrvisionofficial.allpalmsarebeautiful.AllPalmsAreBeautiful;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.resource.PathPackResources;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
    modid = AllPalmsAreBeautiful.MODID,
    bus = Mod.EventBusSubscriber.Bus.MOD
)
public final class BuiltInPacks {
    @SubscribeEvent 
    public static void addPacksFinders(AddPackFindersEvent event) {
        if (event.getPackType() != PackType.SERVER_DATA) {
            return;
        }

        var packPath = ModList.get()
            .getModFileById(AllPalmsAreBeautiful.MODID)
            .getFile()
            .findResource("builtin_packs/allpalmsarebeautiful"
        );

        Pack.ResourcesSupplier supplier = new Pack.ResourcesSupplier() {
            @Override
            public PackResources open(String packId) {
                return new PathPackResources(packId, true, packPath);
            }
        };

        var pack = Pack.readMetaAndCreate(
            "builtin/" + AllPalmsAreBeautiful.MODID + "/allpalmsarebeautiful",
            Component.literal("All Palms are Beautiful"),
            false,
            supplier, 
            PackType.SERVER_DATA, Pack.Position.TOP, PackSource.BUILT_IN
        );

        if (pack != null) {
            event.addRepositorySource(source -> source.accept(pack));
        }
    }

    private BuiltInPacks() {}
}
