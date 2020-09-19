package io.github.queerbric.queerbrics.datatypes.entity;

import io.github.queerbric.queerbrics.registry.QueerbricsEntityTypes;
import io.github.queerbric.queerbrics.registry.QueerbricsItems;
import io.github.queerbric.queerbrics.registry.QueerbricsSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ThrowableBrickEntity extends ThrownItemEntity {

	private static final int WORLD_EVENT_BREAK_BLOCK = 2001;

	public ThrowableBrickEntity(EntityType<? extends ThrowableBrickEntity> entityType, World world) {
		super(entityType, world);
	}

	public ThrowableBrickEntity(World world, LivingEntity owner) {
		super(QueerbricsEntityTypes.throwableBrick, owner, world);
	}

	public ThrowableBrickEntity(World world, double x, double y, double z) {
		super(QueerbricsEntityTypes.throwableBrick, x, y, z, world);
	}

	@Override
	protected Item getDefaultItem() {
		return QueerbricsItems.rainbowBrick;
	}

	@Override
	protected void onEntityHit(EntityHitResult collision) {
		super.onEntityHit(collision);
		if (!world.isClient) {
			Entity entity = collision.getEntity();
			if (entity instanceof LivingEntity) {
				this.world.playSoundFromEntity(null, entity, QueerbricsSoundEvents.brickHitLiving, SoundCategory.BLOCKS, 1f, 0.8f + this.random.nextFloat() * 0.2f);
			}
			entity.damage(DamageSource.thrownProjectile(this, this.getOwner()),
				(float) Math.sqrt((
					getVelocity().x * getVelocity().x +
						getVelocity().y * getVelocity().y +
						getVelocity().z * getVelocity().z)));
		}
	}

	@Override
	protected void onBlockHit(BlockHitResult collision) {
		if (!world.isClient) {
			BlockPos target = collision.getBlockPos();
			BlockState state = this.world.getBlockState(target);
			if (state.getMaterial() == Material.GLASS) {
				this.world.breakBlock(target, true);
				return;
			} else {
				// play break sound + particles
				this.world.syncWorldEvent(WORLD_EVENT_BREAK_BLOCK, target, Block.getRawIdFromState(state));
			}
			this.destroy();
		}
		super.onBlockHit(collision);
	}

	@Override
	protected void onCollision(HitResult hitResult) {
		super.onCollision(hitResult);
		if (!this.world.isClient) {
			this.world.sendEntityStatus(this, (byte) 3);
			this.remove();
		}
	}

	// Don't make thrown brics disappear
	@Override
	public boolean shouldRender(double distance) {
		return true;
	}

	@Override
	protected float getGravity() {
		return super.getGravity() * 4;
	}
}
