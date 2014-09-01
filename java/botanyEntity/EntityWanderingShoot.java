package botanyEntity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class EntityWanderingShoot extends EntityAnimal
{
	public EntityWanderingShoot(World world)
	{
		super(world);
		
		this.setSize(1.0F, 2.0F);
		this.tasks.addTask(0, new EntityAIPanic(this, 2.0D));
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.200000000298023224D);
	}
	
	protected String getLivingSound()
	{
		return "step.grass";
	}

	protected String getHurtSound()
	{
		return "dig.grass";
	}

	protected String getDeathSound()
	{
		return "mob.cow.say";
	}

	protected float getSoundVolume()
	{
		return 0.4F;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable)
	{
		return null;
	}
}
