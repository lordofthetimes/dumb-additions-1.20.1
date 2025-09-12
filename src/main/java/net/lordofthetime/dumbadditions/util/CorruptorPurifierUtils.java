package net.lordofthetime.dumbadditions.util;

import net.lordofthetime.dumbadditions.block.ModBlocks;
import net.lordofthetime.dumbadditions.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CorruptorPurifierUtils {

    public static Stream<BlockPos> getTargets(BlockPos topPos, BlockPos bottomPos , Level level, int mode){
        return BlockPos.betweenClosedStream(bottomPos,topPos).filter(pos -> {
            BlockState block = level.getBlockState(pos);
            boolean isNotCorruptable = block.getTags().anyMatch(Predicate.isEqual(ModTags.Blocks.IS_NOT_CORRUPTABLE));
            boolean isPurified = block.getTags().anyMatch(Predicate.isEqual(ModTags.Blocks.IS_PURIFIED));
            boolean isCorrupted = block.getTags().anyMatch(Predicate.isEqual(ModTags.Blocks.IS_CORRUPTED));
            if (mode == 1) {
                return !isNotCorruptable && !isPurified && isCorrupted;
            } else if (mode == 2) {
                return !isNotCorruptable && !isCorrupted;
            }

            return false;
        });
    }
    public static String getTranslationKey(BlockState block) {
        return ((TranslatableContents) block.getBlock().getName().getContents()).getKey();
    }

    public static BlockState pickBlock(BlockState block, int mode){
        BlockState toSet;
        String name = getTranslationKey(block);
        if(mode == 1){
            if (name.endsWith("corrupted_bricks")) {
                toSet = ModBlocks.MAGICAL_BRICKS.get().withPropertiesOf(block);
            }else if (name.endsWith("corrupted_brick_stairs")) {
                toSet = ModBlocks.MAGICAL_BRICK_STAIRS.get().withPropertiesOf(block);
            }else if (name.endsWith("corrupted_brick_slab")) {
                toSet = ModBlocks.MAGICAL_BRICK_SLAB.get().withPropertiesOf(block);
            }else if (name.endsWith("corrupted_brick_wall")) {
                toSet = ModBlocks.MAGICAL_BRICK_WALL.get().withPropertiesOf(block);
            }else if (name.endsWith("corruptor")) {
                toSet = ModBlocks.PURIFIER.get().withPropertiesOf(block);
            }else{
                toSet = ModBlocks.MAGICAL_BLOCK.get().withPropertiesOf(block);
            }
        }
        else{
            if(block.getTags().anyMatch(Predicate.isEqual(BlockTags.SWORD_EFFICIENT))
                    && !block.getTags().anyMatch(Predicate.isEqual(BlockTags.LEAVES))){
                toSet = Blocks.AIR.defaultBlockState();
            }else if (name.endsWith("bricks")) {
                toSet = ModBlocks.CORRUPTED_BRICKS.get().withPropertiesOf(block);
            }else if (name.endsWith("brick_stairs")) {
                toSet = ModBlocks.CORRUPTED_BRICK_STAIRS.get().withPropertiesOf(block);
            }else if (name.endsWith("brick_slab")) {
                toSet = ModBlocks.CORRUPTED_BRICK_SLAB.get().withPropertiesOf(block);
            }else if (name.endsWith("brick_wall")) {
                toSet = ModBlocks.CORRUPTED_BRICK_WALL.get().withPropertiesOf(block);
            }else if (name.endsWith("purifier")) {
                toSet = ModBlocks.CORRUPTOR.get().withPropertiesOf(block);
            }else{
                toSet = ModBlocks.CORRUPTED_BLOCK.get().withPropertiesOf(block);
            }
        }
        return toSet;

    }

}
