package io.github.queerbric.queerbrics.datatypes.item;

import io.github.queerbric.queerbrics.datatypes.entity.ThrowableBrickEntity;
import io.github.queerbric.queerbrics.registry.QueerbricsSoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SnowballItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class QueerBrickItem extends SnowballItem {
	public QueerBrickItem() {
		super(new Item.Settings().group(ItemGroup.MISC));
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		world.playSound(null, user.getX(), user.getY(), user.getZ(), QueerbricsSoundEvents.brickThrow, SoundCategory.NEUTRAL, 1.2F, 0.7f);
		if (!world.isClient) {
			ThrowableBrickEntity throwableBrickEntity = new ThrowableBrickEntity(world, user);
			throwableBrickEntity.setItem(itemStack);
			throwableBrickEntity.setProperties(user, user.pitch, user.yaw, 0.0F, 1.5F, 1.0F);
			world.spawnEntity(throwableBrickEntity);
			itemStack.decrement(1);
		}

		return TypedActionResult.method_29237(itemStack, world.isClient());
	}
}
