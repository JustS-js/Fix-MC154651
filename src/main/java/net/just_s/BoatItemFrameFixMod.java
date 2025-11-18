package net.just_s;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoatItemFrameFixMod implements ModInitializer {
	public static final String MOD_ID = "boatframefix";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Fix for MC154651 loaded.");
	}
}