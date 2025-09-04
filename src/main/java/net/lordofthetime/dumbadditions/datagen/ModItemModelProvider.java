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
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

import static net.lordofthetime.dumbadditions.block.ModBlocks.CORRUPTED_BRICK_WALL;
import static net.lordofthetime.dumbadditions.block.ModBlocks.MAGICAL_BRICK_WALL;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DumbAdditions.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {


        wallItem(CORRUPTED_BRICK_WALL,ModBlocks.CORRUPTED_BRICKS);
        wallItem(MAGICAL_BRICK_WALL,ModBlocks.MAGICAL_BRICKS);

        for(RegistryObject<Item> item : ModItems.ITEMS.getEntries()){
            System.out.println(item.getId());
            if(!String.valueOf(item.getId()).endsWith("wall")){
                simpleItem(item);
            }

        }

    }
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.tryBuild(DumbAdditions.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void specialBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(DumbAdditions.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private boolean itemBlocks(String id){
        for(RegistryObject<Block> block : ModBlocks.BLOCKS.getEntries()){
            if(Objects.equals(String.valueOf(block.getId()), id)){
                if(id.endsWith("stairs") || id.endsWith("slab")){
                    specialBlockItem(block);
                    return true;
                }
                return true;
            }
        }

        //uncomment  when ores are added

//        for(RegistryObject<Block> block : ModBlocks.ORES.getEntries()){
//            if(block.getId().toString()==id){
//                return true;
//            }
//        }
        return false;
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        if(!itemBlocks(String.valueOf(item.getId()))){
            return withExistingParent(item.getId().getPath(),
                    ResourceLocation.tryParse("item/generated")).texture("layer0",
                    ResourceLocation.tryBuild(DumbAdditions.MODID, "item/" + item.getId().getPath()));
        }

        return null;
    }

}
