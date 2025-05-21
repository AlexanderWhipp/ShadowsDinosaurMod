package net.shadowtek.shadowsdinosaurmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.shadowtek.shadowsdinosaurmod.block.ModBlocks;
import net.shadowtek.shadowsdinosaurmod.data.component.DinosaurDataComponents;
import net.shadowtek.shadowsdinosaurmod.dinosaurentities.SDMEntities;
import net.shadowtek.shadowsdinosaurmod.dinosaurentities.carnivores.tyrannosaurus.TyrannosaurusRenderer;
import net.shadowtek.shadowsdinosaurmod.item.ModItems;
import net.shadowtek.shadowsdinosaurmod.item.SDMCreativeTabs;
import org.slf4j.Logger;

@Mod(ShadowsDinosaurMod.MOD_ID)
public class ShadowsDinosaurMod
{

    public static final String MOD_ID = "shadowsdinosaurmod";
    private static final Logger LOGGER = LogUtils.getLogger();


    public ShadowsDinosaurMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);


        SDMCreativeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        DinosaurDataComponents.register(modEventBus);

        SDMEntities.register(modEventBus);







        modEventBus.addListener(this::addCreative);





        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(SDMEntities.TYRANNOSAURUS_REX.get(), TyrannosaurusRenderer::new);

        }
    }
}
