package botanyEntity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntitySapphireLawncher extends EntityMob implements IRangedAttackMob
{
    private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 0.2D, 20, 60, 15.0F);

	public EntitySapphireLawncher(World world)
	{
		super(world);
		
		this.setSize(1.0F, 2.0F);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        
        if (world != null && !world.isRemote)
        {
            this.setCombatTask();
        }
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30D);
	}
	
    public boolean isAIEnabled()
    {
        return true;
    }
	
    public boolean attackEntityAsMob(Entity par1Entity)
    {
        if (super.attackEntityAsMob(par1Entity))
            return true;
        else
            return false;
    }
	
    public void setCombatTask()
    {
        this.tasks.addTask(4, this.aiArrowAttack);
    }
	
    public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
    {
        EntitySapphireBerry entity = new EntitySapphireBerry(this.worldObj, this, par1EntityLivingBase, 1.6F, 14);
        entity.setThrownByLawncher(true);
        entity.setDamage((double)(par2 * 2.0F) + this.rand.nextGaussian() * 0.25D);

        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(entity);
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
}
