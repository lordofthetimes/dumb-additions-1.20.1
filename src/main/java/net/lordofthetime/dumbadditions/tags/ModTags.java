package net.lordofthetime.dumbadditions.tags;

import net.lordofthetime.dumbadditions.DumbAdditions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModTags {
    public static class Blocks{

        public static final TagKey<Block> IS_CORRUPTED = tag("is_corrupted");
        public static final TagKey<Block> IS_PURIFIED = tag("is_purified");
        public static final TagKey<Block> IS_NOT_CORRUPTABLE = tag("is_not_corruptable");


        private static TagKey<Block> tag(String name){
            return BlockTags.create(ResourceLocation.tryBuild(DumbAdditions.MODID,name));
        }
    }
    public static class BItems{

//        public static final TagKey<Item> NAME = tag("is_corrupted")

        private static TagKey<Item> tag(String name){
            return ItemTags.create(ResourceLocation.tryBuild(DumbAdditions.MODID,name));
        }
    }

}
