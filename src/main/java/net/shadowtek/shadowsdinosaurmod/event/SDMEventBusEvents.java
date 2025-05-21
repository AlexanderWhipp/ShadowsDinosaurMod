package net.shadowtek.shadowsdinosaurmod.event;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.shadowtek.shadowsdinosaurmod.ShadowsDinosaurMod;
import net.shadowtek.shadowsdinosaurmod.dinosaurentities.SDMEntities;
import net.shadowtek.shadowsdinosaurmod.dinosaurentities.carnivores.tyrannosaurus.TyrannosaurusRexEntity;

@Mod.EventBusSubscriber(modid = ShadowsDinosaurMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SDMEventBusEvents {

    @SubscribeEvent
    public static void registerDinosaurAttributes(EntityAttributeCreationEvent event){
        event.put(SDMEntities.TYRANNOSAURUS_REX.get(), TyrannosaurusRexEntity.createAttributes().build());
    }

}