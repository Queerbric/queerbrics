package io.github.queerbric.queerbrics;

import io.github.queerbric.queerbrics.registry.QueerbricsEntityRenderers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class QueerbricsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		QueerbricsEntityRenderers.init();
	}
}
