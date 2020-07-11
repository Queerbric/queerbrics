package io.github.queerbric.queerbrics;

import io.github.queerbric.queerbrics.datatypes.entity.ThrowableBrickEntity;
import io.github.queerbric.queerbrics.registry.QueerbricsEntityTypes;
import io.github.queerbric.queerbrics.registry.QueerbricsItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class QueerbricsMain implements ModInitializer {
	public static String modid = "queerbrics";
	
	// Returns an Identifier of "modid:key" (ex: "queerbrics:rainbow_brick")
	public static Identifier getId(String key) {
		return new Identifier(modid, key);
	}
	
	@Override
	public void onInitialize() {
		QueerbricsEntityTypes.init();
		QueerbricsItems.init();
	}
}
