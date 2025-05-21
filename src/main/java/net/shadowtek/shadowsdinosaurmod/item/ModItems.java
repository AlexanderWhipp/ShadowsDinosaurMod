package net.shadowtek.shadowsdinosaurmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.shadowtek.shadowsdinosaurmod.ShadowsDinosaurMod;
import net.shadowtek.shadowsdinosaurmod.dinosaurentities.SDMEntities;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ShadowsDinosaurMod.MOD_ID);

    public static final RegistryObject<Item> TREX_SPAWN_EGG = ITEMS.register("trex_spawn_egg",
            () -> new ForgeSpawnEggItem(SDMEntities.TYRANNOSAURUS_REX,0x53524b, 0xdac741, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
