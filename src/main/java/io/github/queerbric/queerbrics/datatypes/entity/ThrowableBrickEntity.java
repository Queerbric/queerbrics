package io.github.queerbric.queerbrics.datatypes.entity;

import io.github.queerbric.queerbrics.registry.QueerbricsEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ThrowableBrickEntity extends ThrownItemEntity {
	private final Item type;
	
	public ThrowableBrickEntity(EntityType<? extends ThrowableBrickEntity> entityType, World world) {
		super(entityType, world);
		this.type = null;
	}
	
	public ThrowableBrickEntity(World world, LivingEntity owner, Item type) {
		super(QueerbricsEntityTypes.throwableBrick, owner, world);
		this.type = type;
	}
	
	@Override
	protected Item getDefaultItem() {
		return type;
	}
	
	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		super.onEntityHit(entityHitResult);
		Entity entity = entityHitResult.getEntity();
		entity.damage(DamageSource.thrownProjectile(this, this.getOwner()),
				(float) Math.sqrt((
								getVelocity().x * getVelocity().x +
								getVelocity().y * getVelocity().y +
								getVelocity().z * getVelocity().z)));
	}
	
	@Override
	protected void onCollision(HitResult hitResult) {
		super.onCollision(hitResult);
	}
}
