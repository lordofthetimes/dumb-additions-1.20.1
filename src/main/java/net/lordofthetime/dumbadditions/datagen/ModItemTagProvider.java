package net.lordofthetime.dumbadditions.datagen;

import net.lordofthetime.dumbadditions.DumbAdditions;
import net.lordofthetime.dumbadditions.block.ModBlocks;
import net.lordofthetime.dumbadditions.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, DumbAdditions.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // items tags when needed
        this.tag(ItemTags.LOGS_THAT_BURN).add(
                ModBlocks.CORRUPTED_LOG.get().asItem(),
                ModBlocks.MAGICAL_LOG.get().asItem(),
                ModBlocks.STRIPPED_CORRUPTED_LOG.get().asItem(),
                ModBlocks.STRIPPED_MAGICAL_LOG.get().asItem(),
                ModBlocks.CORRUPTED_WOOD.get().asItem(),
                ModBlocks.MAGICAL_WOOD.get().asItem(),
                ModBlocks.STRIPPED_CORRUPTED_WOOD.get().asItem(),
                ModBlocks.STRIPPED_MAGICAL_WOOD.get().asItem()
        );
        this.tag(ItemTags.PLANKS).add(
                ModBlocks.CORRUPTED_PLANKS.get().asItem(),
                ModBlocks.MAGICAL_PLANKS.get().asItem()
        );
    }
}
