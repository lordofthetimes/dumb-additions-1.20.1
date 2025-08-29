package net.lordofthetime.dumbadditions.item;

import net.lordofthetime.dumbadditions.DumbAdditions;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DumbAdditions.MODID);

    public static final RegistryObject<Item> MAGICAL_PARTICLE = ITEMS.register("magical_particle", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CORRUPTED_PARTICLE = ITEMS.register("corrupted_particle", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
