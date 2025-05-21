package net.shadowtek.shadowsdinosaurmod.dinosaurentities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.shadowtek.shadowsdinosaurmod.ShadowsDinosaurMod;
import net.shadowtek.shadowsdinosaurmod.dinosaurentities.carnivores.tyrannosaurus.TyrannosaurusRexEntity;

public class SDMEntities {
    public static final DeferredRegister<EntityType<?>> CARNIVORE_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ShadowsDinosaurMod.MOD_ID);

    public static final RegistryObject<EntityType<TyrannosaurusRexEntity>> TYRANNOSAURUS_REX =
            CARNIVORE_TYPES.register("tyrannosaurus_rex", () -> EntityType.Builder.of(TyrannosaurusRexEntity::new, MobCategory.CREATURE)
                    .sized(1.0f,1.0f).build("tyrannosaurus_rex"));








    public static void register(IEventBus eventBus) {
        CARNIVORE_TYPES.register(eventBus);
    }

}
