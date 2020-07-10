package io.github.queerbric.queerbrics;

import io.github.queerbric.queerbrics.registry.QueerbricsItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class QueerbricsMain implements ModInitializer {
	public static String modid = "queerbrics";
	
	// Returns an Identifier of "modid:key" (ex: "queerbrics:rainbow_brick")
	public static Identifier getId(String key) {
		return new Identifier(modid, key);
	}
	
	@Override
	public void onInitialize() {
		QueerbricsItems.init();
	}
}
