package net.shadowtek.shadowsdinosaurmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.shadowtek.shadowsdinosaurmod.ShadowsDinosaurMod;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ShadowsDinosaurMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
