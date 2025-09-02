package net.lordofthetime.dumbadditions.datagen;

import net.lordofthetime.dumbadditions.DumbAdditions;
import net.lordofthetime.dumbadditions.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DumbAdditions.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        //tool tags

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.CORRUPTED_BRICKS.get(),
                ModBlocks.MAGICAL_BRICKS.get()
        );
//        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
//        );
//        this.tag(BlockTags.MINEABLE_WITH_HOE).add(
//        );
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                ModBlocks.CORRUPTED_BLOCK.get(),
                ModBlocks.MAGICAL_BLOCK.get()
        );

        //tool tier tags

//        this.tag(BlockTags.NEEDS_STONE_TOOL)add(
//        );
//        this.tag(BlockTags.NEEDS_STONE_TOOL)add(
//        );
//        this.tag(BlockTags.NEEDS_STONE_TOOL)add(
//        );
//        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)add(
////        );

        // Mod Tags




    }
}
