package net.lordofthetime.dumbadditions.item.custom;

import net.lordofthetime.dumbadditions.DumbAdditions;
import net.lordofthetime.dumbadditions.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class BlockPurifierItem extends Item {

    public BlockPurifierItem(Properties properties){
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext p) {
        if(!p.getLevel().isClientSide( )){
            BlockPos position = p.getClickedPos();
            BlockState state = p.getLevel().getBlockState(position);
            if(state.is(ModBlocks.CORRUPTED_BLOCK.get())){
                p.getLevel().setBlock(position,ModBlocks.MAGICAL_BLOCK.get().defaultBlockState(),3);
                p.getItemInHand().hurtAndBreak(1 ,p.getPlayer(),
                        player -> player.broadcastBreakEvent(player.getUsedItemHand()));
                p.getPlayer().getCooldowns().addCooldown(this, 5);

            }
        }

        return InteractionResult.SUCCESS;//super.useOn(pContext);
    }
}
