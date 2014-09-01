package botanyEntity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBarbedSpike extends EntityMob
{
	public EntityBarbedSpike(World world)
	{
		super(world);
		
		this.setSize(1.0F, 1.0F);
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
	}

	//Used to give the entity knockback, receives argument Entity and returns the damage dealt
	public boolean attackEntityAsMob(Entity entity)
	{
		double var  = entity.posX - this.posX * 1.0012;
		double var0 = entity.posZ - this.posZ * 1.0012;
		
		entity.addVelocity(var, 0.0D, var0);
		return entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)var);
	}
	
	//Called frequently, deals with mob burning in daylight
	public void onLivingUpdate()
    {
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote && !this.isChild())
        {
            float f = this.getBrightness(1.0F);

            if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))
            {
                this.setFire(8);
            }
        }

        super.onLivingUpdate();
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
	
	public EntityAgeable createChild(EntityAgeable entityageable)
	{
		return null;
	}
}