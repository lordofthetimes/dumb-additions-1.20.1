package net.lordofthetime.dumbadditions.item.custom;

import net.lordofthetime.dumbadditions.DumbAdditions;
import net.lordofthetime.dumbadditions.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import static net.lordofthetime.dumbadditions.util.CorruptorPurifierUtils.getTargets;
import static net.lordofthetime.dumbadditions.util.CorruptorPurifierUtils.pickBlock;

public class BlockPurifierItem extends Item {

    public BlockPurifierItem(Properties properties){
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext p) {
        if(!p.getLevel().isClientSide( )){
            int distance = 4;
            BlockPos topPos = p.getClickedPos().above(distance).east(distance).north(distance);
            BlockPos bottomPos = p.getClickedPos().below(distance).west(distance).south(distance);

            getTargets(topPos,bottomPos,p.getLevel(),1)
                    .forEachOrdered(pos -> {

                            BlockState block = p.getLevel().getBlockState(pos);
                        System.out.println("Currently changing block at " + pos + " from " + block+" to " + pickBlock(block,1));
                            p.getLevel().setBlock(pos, pickBlock(block,1), 3 | 8);
                            }
                    );
            p.getItemInHand().hurtAndBreak(1 ,p.getPlayer(),
                    player -> player.broadcastBreakEvent(player.getUsedItemHand()));
            p.getPlayer().getCooldowns().addCooldown(this, 5);

            }
        return InteractionResult.SUCCESS;//super.useOn(pContext);
        }

}
