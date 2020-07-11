package io.github.queerbric.queerbrics.registry;

import io.github.queerbric.queerbrics.QueerbricsMain;
import io.github.queerbric.queerbrics.datatypes.entity.ThrowableBrickEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

public class QueerbricsEntityTypes {
	public static EntityType<ThrowableBrickEntity> throwableBrick;

	public static void init() {
		throwableBrick = Registry.register(Registry.ENTITY_TYPE, QueerbricsMain.getId("throwable_brick"),
				FabricEntityTypeBuilder.<ThrowableBrickEntity>create(null, ThrowableBrickEntity::new)
						.dimensions(EntityDimensions.fixed(0.5f,0.5f))
						.disableSummon().build());
	}
}
