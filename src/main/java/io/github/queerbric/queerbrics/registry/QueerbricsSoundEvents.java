package io.github.queerbric.queerbrics.registry;

import io.github.queerbric.queerbrics.QueerbricsMain;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class QueerbricsSoundEvents {
	public static SoundEvent brickHitLiving;
	public static SoundEvent brickThrow;

	public static void init() {
		brickHitLiving = register("brick.hit.living");
		brickThrow = register("brick.throw");
	}

	private static SoundEvent register(String name) {
		Identifier id = QueerbricsMain.getId(name);
		return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
	}
}
