package net.just_s;

import net.fabricmc.api.DedicatedServerModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoatItemFrameFixMod implements DedicatedServerModInitializer {
	public static final String MOD_ID = "boatframefix";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeServer() {
		LOGGER.info("Fix for MC154651 loaded.");
	}
}