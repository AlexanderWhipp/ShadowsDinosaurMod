package net.shadowtek.shadowsdinosaurmod.dinosaurentities.carnivores.tyrannosaurus;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.shadowtek.shadowsdinosaurmod.ShadowsDinosaurMod;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TyrannosaurusRenderer extends GeoEntityRenderer<TyrannosaurusRexEntity> {



    public TyrannosaurusRenderer(EntityRendererProvider.Context context) {
        super(context, new TyrannosaurModel());
    }

    @Override
    public ResourceLocation getTextureLocation(TyrannosaurusRexEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(ShadowsDinosaurMod.MOD_ID, "dinosaurs/trex/textures/trexconcept2.png");
    }

    @Override
    public @Nullable RenderType getRenderType(TyrannosaurusRexEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }

    @Override
    public void render(TyrannosaurusRexEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()){
            poseStack.scale(0.2f,0.2f,0.2f);
        } else {
            poseStack.scale(1.0f, 1.0f, 1.0f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
