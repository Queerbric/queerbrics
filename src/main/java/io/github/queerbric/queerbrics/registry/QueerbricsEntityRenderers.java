package io.github.queerbric.queerbrics.registry;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

@Environment(EnvType.CLIENT)
public class QueerbricsEntityRenderers {

	public static void init() {
		EntityRendererRegistry.INSTANCE.register(QueerbricsEntityTypes.throwableBrick,
			(dispatcher, ctx) -> new FlyingItemEntityRenderer<>(dispatcher, ctx.getItemRenderer()));
	}

}
