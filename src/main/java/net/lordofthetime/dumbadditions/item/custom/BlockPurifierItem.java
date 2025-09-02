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

public class BlockPurifierItem extends Item {

    public BlockPurifierItem(Properties properties){
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext p) {
        if(!p.getLevel().isClientSide( )){
            int distance = 2;
            int radius = distance*2+1;
            BlockPos position = p.getClickedPos().above(distance).east(distance).north(distance);
            BlockState state = p.getLevel().getBlockState(position);

            for(int i = 0; i<radius; i++){
                for(int a = 0; a<radius; a++){
                    Level world = p.getLevel();
                    for(int b = 0; b<radius; b++) {
                        BlockState block = world.getBlockState(position);
                        if(!block.is(Blocks.AIR) && !block.liquid() && !block.is(ModBlocks.CORRUPTOR.get())&& !block.is(Blocks.BEDROCK) && block.is(ModBlocks.CORRUPTED_BLOCK.get())){
                            world.setBlock(position, ModBlocks.MAGICAL_BLOCK.get().defaultBlockState(),3);
                        }
                        position = position.south();
                    }
                    position = position.west().north(radius);
                }
                position = position.below().east(radius);
            }
            p.getItemInHand().hurtAndBreak(1 ,p.getPlayer(),
                    player -> player.broadcastBreakEvent(player.getUsedItemHand()));
            p.getPlayer().getCooldowns().addCooldown(this, 5);

            }
        return InteractionResult.SUCCESS;//super.useOn(pContext);
        }

}
