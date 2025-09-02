package net.lordofthetime.dumbadditions.block.custom;

import net.lordofthetime.dumbadditions.block.ModBlocks;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MossBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.logging.Logger;

public class CorruptorBlock extends Block {
    public CorruptorBlock(Properties p) {
        super(p);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit){
        int distance = 16;
        int radius = distance*2+1;
        pLevel.playSound(pPlayer,pPos, SoundEvents.SCULK_SHRIEKER_SHRIEK, SoundSource.BLOCKS);
        BlockPos pos = pPos.above(distance).east(distance).north(distance);
        for(int i = 0; i<radius; i++){
            for(int a = 0; a<radius; a++){
                for(int b = 0; b<radius; b++) {
                        BlockState block = pLevel.getBlockState(pos);
                        if(!block.is(Blocks.AIR) && !block.liquid() && !block.is(ModBlocks.CORRUPTOR.get())&& !block.is(Blocks.BEDROCK)){
                            pLevel.setBlock(pos, ModBlocks.CORRUPTED_BLOCK.get().defaultBlockState(),3);
                    }
                    pos = pos.south();
                }
                pos = pos.west().north(radius);
            }
            pos = pos.below().east(radius);
        }
        return InteractionResult.SUCCESS;
    }
}
