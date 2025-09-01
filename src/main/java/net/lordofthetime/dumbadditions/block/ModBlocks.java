package net.lordofthetime.dumbadditions.block;

import net.lordofthetime.dumbadditions.DumbAdditions;
import net.lordofthetime.dumbadditions.block.custom.CorruptorBlock;
import net.lordofthetime.dumbadditions.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DumbAdditions.MODID);

    public static final RegistryObject<Block> CORRUPTED_BLOCK =
            registerBlock("corrupted_block",() -> new Block(BlockBehaviour
                    .Properties.copy(Blocks.POWDER_SNOW)
                    .requiresCorrectToolForDrops().friction(0.8F)));
    public static final RegistryObject<Block> MAGICAL_BLOCK =
            registerBlock("magical_block",() -> new Block(BlockBehaviour
                    .Properties.copy(Blocks.POWDER_SNOW)
                    .requiresCorrectToolForDrops().friction(0.8F)));

    public static final RegistryObject<Block> CORRUPTED_BRICKS =
            registerBlock("corrupted_bricks",() -> new Block(BlockBehaviour
                    .Properties.copy(Blocks.STONE_BRICKS)
                    .requiresCorrectToolForDrops().friction(0.8F)));
    public static final RegistryObject<Block> MAGICAL_BRICKS =
            registerBlock("magical_bricks",() -> new Block(BlockBehaviour
                    .Properties.copy(Blocks.STONE_BRICKS)
                    .requiresCorrectToolForDrops().friction(0.8F)));
    public static final RegistryObject<Block> CORRUPTOR =
            registerBlock("corruptor",() -> new CorruptorBlock(BlockBehaviour
                    .Properties.copy(Blocks.REINFORCED_DEEPSLATE)));


    private static<T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    private static<T extends Block>RegistryObject<Item> registerBlockItem(String name,RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
