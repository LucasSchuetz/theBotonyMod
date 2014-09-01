package botanyEntity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class EntityFungleCrab extends EntityAnimal
{
	public EntityFungleCrab(World world)
	{
		super(world);
		
		this.setSize(1.0F, 1.0F);
		this.tasks.addTask(0, new EntityAIPanic(this, 2.0D));
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.40D);
	}

	protected String getLivingSound()
	{
		return "mob.slime.small";
	}

	protected String getHurtSound()
	{
		return "random.burp";
	}

	protected String getDeathSound()
	{
		return "mob.spider.death";
	}

	protected float getSoundVolume()
	{
		return 0.4F;
	}
	
	public EntityAgeable createChild(EntityAgeable entityageable)
	{
		return null;
	}
}
