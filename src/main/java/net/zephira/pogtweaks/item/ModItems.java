package net.zephira.pogtweaks.item; 

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zephira.pogtweaks.PogTweaks;

public class ModItems {

    public static final Item LEVITATION_DUST = registerItem("levitation_dust", new LevitationDust(new FabricItemSettings().group(ItemGroup.MISC)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(PogTweaks.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PogTweaks.LOGGER.debug("Registering Mod Items for " + PogTweaks.MOD_ID);
    }
    
}
