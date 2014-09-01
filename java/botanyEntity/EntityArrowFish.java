package botanyEntity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityArrowFish extends EntityWaterMob
{
	public EntityArrowFish(World world)
	{
		super(world);
		
		this.setSize(1.0F, 1.0F);
		this.tasks.addTask(0, new EntityAIPanic(this, 2.0D));
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.200000000298023224D);
	}

	protected String getLivingSound()
	{
		return "null";
	}

	protected String getHurtSound()
	{
		return "null";
	}

	protected String getDeathSound()
	{
		return "null";
	}

	protected float getSoundVolume()
	{
		return 0.4F;
	}
	
    protected Item getDropItem()
    {
        return Items.fish;
    }
    
    protected void dropRareDrop(int par1)
    {
        this.entityDropItem(new ItemStack(Items.fishing_rod, 1, 1), 0.0F);
    }
	
	public EntityAgeable createChild(EntityAgeable entityageable)
	{
		return null;
	}
}