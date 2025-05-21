package net.shadowtek.shadowsdinosaurmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.shadowtek.shadowsdinosaurmod.ShadowsDinosaurMod;

public class SDMCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ShadowsDinosaurMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SHADOWS_DINOSAURS_ITEMS_TAB = CREATIVE_MODE_TABS.register( "fossilgencraft_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.BONE))
                    .title(Component.translatable( "creativetab.fossilgencraft.fossilgencraft_items"))
                    .displayItems((itemDisplayParameters, output) ->{



                    output.accept(ModItems.TREX_SPAWN_EGG.get());






                    }).build());
    public static final RegistryObject<CreativeModeTab> FOSSILGENCRAFT_BlOCKS_TAB = CREATIVE_MODE_TABS.register( "fossilgencraft_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Blocks.CRACKED_STONE_BRICKS))
                    .withTabsBefore(SHADOWS_DINOSAURS_ITEMS_TAB.getId())
                    .title(Component.translatable( "creativetab.fossilgencraft.fossilgencraft_blocks"))
                    .displayItems((itemDisplayParameters, output) ->{

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
