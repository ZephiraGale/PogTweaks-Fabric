package net.zephira.pogtweaks;

import net.fabricmc.api.ModInitializer;
import net.zephira.pogtweaks.init.ModBlocks;
import net.zephira.pogtweaks.init.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PogTweaks implements ModInitializer {
	public static final String MOD_ID = "pogtweaks";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}
