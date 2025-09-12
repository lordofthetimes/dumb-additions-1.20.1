package net.lordofthetime.dumbadditions.block.custom;

import static net.lordofthetime.dumbadditions.util.CorruptorPurifierUtils.*;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;





public class PurifierBlock extends Block {
    public PurifierBlock(Properties p) {
        super(p);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit){
        int distance = 16;
        pLevel.playSound(pPlayer,pPos, SoundEvents.SCULK_SHRIEKER_SHRIEK, SoundSource.BLOCKS);
        BlockPos topPos = pPos.above(distance).east(distance).north(distance);
        BlockPos bottomPos = pPos.below(distance).west(distance).south(distance);

        getTargets(topPos,bottomPos,pLevel,1)
                .forEachOrdered(pos -> {
                            if (!pLevel.isClientSide) {
                                BlockState block = pLevel.getBlockState(pos);
                                pLevel.setBlock(pos, pickBlock(block, 1), 3 | 8);
                            }
                        }
                );
        return InteractionResult.SUCCESS;
    }

}