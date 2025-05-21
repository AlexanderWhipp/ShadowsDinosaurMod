package net.shadowtek.shadowsdinosaurmod.dinosaurentities.carnivores.tyrannosaurus;

import net.minecraft.resources.ResourceLocation;
import net.shadowtek.shadowsdinosaurmod.ShadowsDinosaurMod;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class TyrannosaurModel extends DefaultedEntityGeoModel<TyrannosaurusRexEntity> {

    public TyrannosaurModel() {
        super(ResourceLocation.fromNamespaceAndPath(ShadowsDinosaurMod.MOD_ID, "dinosaurs/trex"), true);
    }

    @Override
    public ResourceLocation getModelResource(TyrannosaurusRexEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(ShadowsDinosaurMod.MOD_ID, "geo/trex002.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(TyrannosaurusRexEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(ShadowsDinosaurMod.MOD_ID, "animations/trex.animations.json");
    }
}
