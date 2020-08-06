package io.github.queerbric.queerbrics.mixin;

import java.util.Random;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.queerbric.queerbrics.datatypes.entity.ThrowableBrickEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
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
			world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (RANDOM.nextFloat() * 0.4F + 0.8F));
			if (!world.isClient) {
				ThrowableBrickEntity throwableBrickEntity = new ThrowableBrickEntity(world, user);
				throwableBrickEntity.setItem(itemStack);
				throwableBrickEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 1.5F, 1.0F);
				world.spawnEntity(throwableBrickEntity);
			}

			info.setReturnValue(TypedActionResult.method_29237(itemStack, world.isClient()));
		}
	}
}