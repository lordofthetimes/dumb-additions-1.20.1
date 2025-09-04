package net.lordofthetime.dumbadditions.datagen;

import net.lordofthetime.dumbadditions.DumbAdditions;
import net.lordofthetime.dumbadditions.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DumbAdditions.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        List<RegistryObject<Block>> simpleBlocks = List.of(
                ModBlocks.CORRUPTED_BLOCK,ModBlocks.MAGICAL_BLOCK,ModBlocks.CORRUPTED_BRICKS,ModBlocks.MAGICAL_BRICKS,ModBlocks.CORRUPTOR

        );


        for (RegistryObject<Block> simpleBlock : simpleBlocks) {
            System.out.println(simpleBlock.getId());
            simpleBlockState(simpleBlock);
        }

        Block baseBlock = ModBlocks.CORRUPTED_BRICKS.get();
        stairsBlock(((StairBlock) ModBlocks.CORRUPTED_BRICK_STAIRS.get()),blockTexture(baseBlock));
        slabBlock(((SlabBlock) ModBlocks.CORRUPTED_BRICK_SLAB.get()),blockTexture(baseBlock),blockTexture(baseBlock));
        wallBlock(((WallBlock) ModBlocks.CORRUPTED_BRICK_WALL.get()),blockTexture(baseBlock));

        baseBlock = ModBlocks.MAGICAL_BRICKS.get();
        stairsBlock(((StairBlock) ModBlocks.MAGICAL_BRICK_STAIRS.get()),blockTexture(baseBlock));
        slabBlock(((SlabBlock) ModBlocks.MAGICAL_BRICK_SLAB.get()),blockTexture(baseBlock),blockTexture(baseBlock));
        wallBlock(((WallBlock) ModBlocks.MAGICAL_BRICK_WALL.get()),blockTexture(baseBlock));
    }
    private void simpleBlockState(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
