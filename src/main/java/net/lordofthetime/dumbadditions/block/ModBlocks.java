package net.lordofthetime.dumbadditions.block;

import net.lordofthetime.dumbadditions.DumbAdditions;
import net.lordofthetime.dumbadditions.block.custom.CorruptorBlock;
import net.lordofthetime.dumbadditions.block.custom.flammable.ModFlammableRotatedPillarBlock;
import net.lordofthetime.dumbadditions.block.custom.PurifierBlock;
import net.lordofthetime.dumbadditions.block.custom.flammable.ModLeavesBlock;
import net.lordofthetime.dumbadditions.block.custom.flammable.ModPlankBlock;
import net.lordofthetime.dumbadditions.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;

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
    //Corrupted bricks blocks
    public static final RegistryObject<Block> CORRUPTED_BRICKS =
            registerBlock("corrupted_bricks",() -> new Block(BlockBehaviour
                    .Properties.copy(Blocks.STONE_BRICKS)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CORRUPTED_BRICK_STAIRS =
            registerBlock("corrupted_brick_stairs",() -> new StairBlock(() ->  ModBlocks.CORRUPTED_BRICKS.get().defaultBlockState(),BlockBehaviour
                    .Properties.copy(Blocks.STONE_BRICKS)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CORRUPTED_BRICK_SLAB =
            registerBlock("corrupted_brick_slab",() -> new SlabBlock(BlockBehaviour
                    .Properties.copy(Blocks.STONE_BRICKS)
                    .requiresCorrectToolForDrops()));public static final RegistryObject<Block> CORRUPTED_BRICK_WALL =
            registerBlock("corrupted_brick_wall",() -> new WallBlock(BlockBehaviour
                    .Properties.copy(Blocks.STONE_BRICKS)
                    .requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> MAGICAL_BRICKS =
            registerBlock("magical_bricks",() -> new Block(BlockBehaviour
                    .Properties.copy(Blocks.STONE_BRICKS)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGICAL_BRICK_STAIRS =
            registerBlock("magical_brick_stairs",() -> new StairBlock(() ->  ModBlocks.CORRUPTED_BRICKS.get().defaultBlockState(),BlockBehaviour
                    .Properties.copy(Blocks.STONE_BRICKS)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGICAL_BRICK_SLAB =
            registerBlock("magical_brick_slab",() -> new SlabBlock(BlockBehaviour
                    .Properties.copy(Blocks.STONE_BRICKS)
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGICAL_BRICK_WALL =
            registerBlock("magical_brick_wall",() -> new WallBlock(BlockBehaviour
                    .Properties.copy(Blocks.STONE_BRICKS)
                    .requiresCorrectToolForDrops()));



    public static final RegistryObject<Block> CORRUPTOR =
            registerBlock("corruptor",() -> new CorruptorBlock(BlockBehaviour
                    .Properties.copy(Blocks.REINFORCED_DEEPSLATE)));
    public static final RegistryObject<Block> PURIFIER =
            registerBlock("purifier",() -> new PurifierBlock(BlockBehaviour
                    .Properties.copy(Blocks.REINFORCED_DEEPSLATE)));


    //corrupted wood
    public static final RegistryObject<Block> CORRUPTED_LOG =
            registerBlock("corrupted_log",() -> new ModFlammableRotatedPillarBlock(BlockBehaviour
                    .Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> CORRUPTED_WOOD =
            registerBlock("corrupted_wood",() -> new ModFlammableRotatedPillarBlock(BlockBehaviour
                    .Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_CORRUPTED_LOG =
            registerBlock("stripped_corrupted_log",() -> new ModFlammableRotatedPillarBlock(BlockBehaviour
                    .Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_CORRUPTED_WOOD =
            registerBlock("stripped_corrupted_wood",() -> new ModFlammableRotatedPillarBlock(BlockBehaviour
                    .Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> CORRUPTED_PLANKS =
            registerBlock("corrupted_planks",() -> new ModPlankBlock(BlockBehaviour
                    .Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> CORRUPTED_PLANK_STAIRS =
            registerBlock("corrupted_plank_stairs",() -> new StairBlock(() ->  CORRUPTED_PLANKS.get().defaultBlockState(),BlockBehaviour
                    .Properties.copy(CORRUPTED_PLANKS.get())
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CORRUPTED_PLANK_SLAB =
            registerBlock("corrupted_plank_slab",() -> new SlabBlock(BlockBehaviour
                    .Properties.copy(CORRUPTED_PLANKS.get())
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CORRUPTED_LEAVES =
            registerBlock("corrupted_leaves",() -> new ModLeavesBlock(BlockBehaviour
                    .Properties.copy(Blocks.OAK_LEAVES)));

    //magical wood
    public static final RegistryObject<Block> MAGICAL_LOG =
            registerBlock("magical_log",() -> new ModFlammableRotatedPillarBlock(BlockBehaviour
                    .Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> MAGICAL_WOOD =
            registerBlock("magical_wood",() -> new ModFlammableRotatedPillarBlock(BlockBehaviour
                    .Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_MAGICAL_LOG =
            registerBlock("stripped_magical_log",() -> new ModFlammableRotatedPillarBlock(BlockBehaviour
                    .Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_MAGICAL_WOOD =
            registerBlock("stripped_magical_wood",() -> new ModFlammableRotatedPillarBlock(BlockBehaviour
                    .Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> MAGICAL_PLANKS =
            registerBlock("magical_planks",() -> new ModPlankBlock(BlockBehaviour
                    .Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> MAGICAL_PLANK_STAIRS =
            registerBlock("magical_plank_stairs",() -> new StairBlock(() ->  MAGICAL_PLANKS.get().defaultBlockState(),BlockBehaviour
                    .Properties.copy(MAGICAL_PLANKS.get())
                    .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MAGICAL_PLANK_SLAB =
            registerBlock("magical_plank_slab",() -> new SlabBlock(BlockBehaviour
                    .Properties.copy(MAGICAL_PLANKS.get())
                    .requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> MAGICAL_LEAVES =
            registerBlock("magical_leaves",() -> new ModLeavesBlock(BlockBehaviour
                    .Properties.copy(Blocks.OAK_LEAVES)));

    //add ores to ORES DefferedRegister
//    public static final DeferredRegister<Block> ORES = DeferredRegister.create(ForgeRegistries.BLOCKS, DumbAdditions.MODID);

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
