package net.lordofthetime.dumbadditions.datagen;

import net.lordofthetime.dumbadditions.DumbAdditions;
import net.lordofthetime.dumbadditions.block.ModBlocks;
import net.lordofthetime.dumbadditions.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

import static net.lordofthetime.dumbadditions.block.ModBlocks.isItemBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DumbAdditions.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        for(RegistryObject<Item> item : ModItems.ITEMS.getEntries()){
            simpleItem(item);
        }

    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        if(!isItemBlock(String.valueOf(item.getId()))){
            return withExistingParent(item.getId().getPath(),
                    ResourceLocation.tryParse("item/generated")).texture("layer0",
                    ResourceLocation.tryBuild(DumbAdditions.MODID, "item/" + item.getId().getPath()));
        }
        return null;
    }
}
