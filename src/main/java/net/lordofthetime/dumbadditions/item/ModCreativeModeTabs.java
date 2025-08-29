package net.lordofthetime.dumbadditions.item;

import net.lordofthetime.dumbadditions.DumbAdditions;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DumbAdditions.MODID);

    public static final RegistryObject<CreativeModeTab> DumbAdditionsTab = CREATIVE_MODE_TABS.register("dumbadditions", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.CORRUPTED_PARTICLE.get()))
            .title(Component.translatable("creativetab.dumbadditionstab"))
            .displayItems((itemDisplayParameters, output) -> {
                for(RegistryObject<Item> item : ModItems.ITEMS.getEntries()){
                    output.accept(item.get());
                }

            })
            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
