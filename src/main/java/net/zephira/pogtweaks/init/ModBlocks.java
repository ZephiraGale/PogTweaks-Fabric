package net.zephira.pogtweaks.init;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zephira.pogtweaks.PogTweaks;

public class ModBlocks {

    //NEEDS CUSTOM SOUND
    public static final Block REINFORCED_OBSIDIAN = registerBlock("reinforced_obsidian", new Block(FabricBlockSettings.of(Material.METAL).strength(3.5f, 1200.0f).sounds(BlockSoundGroup.METAL).requiresTool()), new FabricItemSettings().fireproof().group(ItemGroup.BUILDING_BLOCKS));

    private static Block registerBlock(String name, Block block, FabricItemSettings itemSettings){
        registerBlockItem(name, block, itemSettings);
        return Registry.register(Registry.BLOCK, new Identifier(PogTweaks.MOD_ID, name), block);
    }
    private static Item registerBlockItem (String name, Block block, FabricItemSettings itemSettings) {
        return Registry.register(Registry.ITEM, new Identifier(PogTweaks.MOD_ID, name), new BlockItem(block, itemSettings));
    }

    public static void registerModBlocks() {
        PogTweaks.LOGGER.debug("Registering Mod Blocks for " + PogTweaks.MOD_ID);
    }
}
