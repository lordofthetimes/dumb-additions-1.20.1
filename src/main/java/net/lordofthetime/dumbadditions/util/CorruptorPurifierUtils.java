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

    public static Stream<BlockPos> getTargets(BlockPos topPos, BlockPos bottomPos , Level level, TagKey<Block> tag){
        return BlockPos.betweenClosedStream(bottomPos,topPos).filter(pos -> {
            BlockState block = level.getBlockState(pos);
            boolean isNotCorruptable = block.getTags().anyMatch(Predicate.isEqual(ModTags.Blocks.IS_NOT_CORRUPTABLE));
            boolean isAlreadyCorrupted = block.getTags().anyMatch(Predicate.isEqual(tag));
            if (!isNotCorruptable && !isAlreadyCorrupted) {
            }
            return !isNotCorruptable && !isAlreadyCorrupted;
        });
    }
    public static String getTranslationKey(BlockState block) {
        return ((TranslatableContents) block.getBlock().getName().getContents()).getKey();
    }

    public static BlockState pickBlock(BlockState block){
        BlockState toSet;
        String name = getTranslationKey(block);
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
        } else{
            toSet = ModBlocks.CORRUPTED_BLOCK.get().withPropertiesOf(block);
        }
        return toSet;

    }

}
