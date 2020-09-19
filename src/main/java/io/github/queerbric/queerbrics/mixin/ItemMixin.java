package io.github.queerbric.queerbrics.mixin;

import java.util.Random;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.queerbric.queerbrics.datatypes.entity.ThrowableBrickEntity;
import io.github.queerbric.queerbrics.registry.QueerbricsSoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

@Mixin(Item.class)
public class ItemMixin {
	@Shadow @Final
	protected static Random RANDOM;

	@Inject(at = @At("HEAD"), method = "use", cancellable = true)
	public void use(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> info) {
		ItemStack itemStack = user.getStackInHand(hand);
		if (itemStack.getItem() == Items.BRICK || itemStack.getItem() == Items.NETHER_BRICK) { // TODO tag for supporting other items?
			world.playSound(null, user.getX(), user.getY(), user.getZ(), QueerbricsSoundEvents.brickThrow, SoundCategory.NEUTRAL, 1.2F, 0.7f);
			if (!world.isClient) {
				ThrowableBrickEntity throwableBrickEntity = new ThrowableBrickEntity(world, user);
				throwableBrickEntity.setItem(itemStack);
				throwableBrickEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 1.5F, 1.0F);
				world.spawnEntity(throwableBrickEntity);
				itemStack.decrement(1);
			}

			info.setReturnValue(TypedActionResult.method_29237(itemStack, world.isClient()));
		}
	}
}
