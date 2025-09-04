package net.lordofthetime.dumbadditions.datagen;

import net.lordofthetime.dumbadditions.DumbAdditions;
import net.lordofthetime.dumbadditions.block.ModBlocks;
import net.lordofthetime.dumbadditions.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
                ModBlocks.CORRUPTED_BRICK_WALL.get(),
                ModBlocks.CORRUPTED_BRICK_STAIRS.get(),
                ModBlocks.CORRUPTED_BRICK_SLAB.get(),

                ModBlocks.MAGICAL_BRICKS.get(),
                ModBlocks.MAGICAL_BRICK_WALL.get(),
                ModBlocks.MAGICAL_BRICK_STAIRS.get(),
                ModBlocks.MAGICAL_BRICK_SLAB.get()

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
//        );

        //Fence, fence gates, walls tags
        this.tag(BlockTags.WALLS).add(
                ModBlocks.CORRUPTED_BRICK_WALL.get(),
                ModBlocks.MAGICAL_BRICK_WALL.get()
        );
//        this.tag(BlockTags.FENCES).add(
//        );
//        this.tag(BlockTags.FENCE_GATES).add(
//        );


        // Mod Tags

        this.tag(ModTags.Blocks.IS_CORRUPTED).add(
                ModBlocks.CORRUPTED_BRICKS.get(),
                ModBlocks.CORRUPTED_BRICK_WALL.get(),
                ModBlocks.CORRUPTED_BRICK_STAIRS.get(),
                ModBlocks.CORRUPTED_BRICK_SLAB.get(),

                ModBlocks.CORRUPTED_BLOCK.get(),

                ModBlocks.CORRUPTOR.get()
        );

        this.tag(ModTags.Blocks.IS_PURIFIED).add(
                ModBlocks.MAGICAL_BRICKS.get(),
                ModBlocks.MAGICAL_BRICK_WALL.get(),
                ModBlocks.MAGICAL_BRICK_STAIRS.get(),
                ModBlocks.MAGICAL_BRICK_SLAB.get(),

                ModBlocks.MAGICAL_BLOCK.get()
        );

        this.tag(ModTags.Blocks.IS_NOT_CORRUPTABLE).add(
                Blocks.BEDROCK,
                Blocks.AIR,
                Blocks.WATER,
                Blocks.LAVA
        );




    }
}
