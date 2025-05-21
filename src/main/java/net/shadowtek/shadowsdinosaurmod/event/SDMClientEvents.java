package net.shadowtek.shadowsdinosaurmod.event;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import net.shadowtek.shadowsdinosaurmod.ShadowsDinosaurMod;
import net.shadowtek.shadowsdinosaurmod.dinosaurentities.SDMEntities;
import net.shadowtek.shadowsdinosaurmod.dinosaurentities.carnivores.tyrannosaurus.TyrannosaurusRenderer;

@Mod.EventBusSubscriber(modid = ShadowsDinosaurMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class SDMClientEvents {


}