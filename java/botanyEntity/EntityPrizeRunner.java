package botanyEntity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class EntityPrizeRunner extends EntityAnimal
{
	public EntityPrizeRunner(World world)
	{
		super(world);
		
		this.setSize(1.0F, 2.0F);
		this.tasks.addTask(0, new EntityAIPanic(this, 20.0D));
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.9D);
		
	}
	
	protected String getLivingSound()
	{
		return "step.cloth";
	}

	protected String getHurtSound()
	{
		return "random.breath";
	}

	protected String getDeathSound()
	{
		return "random.chestclosed";
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
