package botanyEntity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;
import botanyMain.Base;

public class EntitySporeRay extends EntityAnimal
{
	public EntitySporeRay(World world)
	{
		super(world);
		
		this.setSize(1.0F, 1.0F);
		this.tasks.addTask(0, new EntityAIPanic(this, 2.0D));
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.200000000298023224D);
	}
	
	protected String getLivingSound()
	{
		return "mob.silverfish.say";
	}

	protected String getHurtSound()
	{
		return "mob.silverfish.hit";
	}

	protected String getDeathSound()
	{
		return "mob.enderman.death";
	}

	protected float getSoundVolume()
	{
		return 0.4F;
	}

    protected void dropFewItems(boolean par1, int par2)
    {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
        int k;

        for (k = 0; k < j; ++k)
        {
            this.dropItem(Base.itemCleansingPowder, 1);
        }
    }
	
	@Override
	public EntityAgeable createChild(EntityAgeable entityageable)
	{
		return null;
	}
}
