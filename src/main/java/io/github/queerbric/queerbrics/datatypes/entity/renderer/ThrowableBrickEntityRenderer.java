package io.github.queerbric.queerbrics.datatypes.entity.renderer;

import io.github.queerbric.queerbrics.datatypes.entity.ThrowableBrickEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ThrowableBrickEntityRenderer extends EntityRenderer<ThrowableBrickEntity> {
	public ThrowableBrickEntityRenderer(EntityRenderDispatcher dispatcher) {
		super(dispatcher);
	}
	
	@Override
	public Identifier getTexture(ThrowableBrickEntity entity) {
		return null;
	}
}
