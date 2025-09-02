package net.lordofthetime.dumbadditions.datagen;

import net.lordofthetime.dumbadditions.DumbAdditions;
import net.lordofthetime.dumbadditions.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

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
            simpleBlockState(simpleBlock);
        }
    }
    private void simpleBlockState(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
