package botanyEntity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.world.World;
import botanyMain.Base;

public class EntityGreanBaen extends EntityTameable
{
	public EntityGreanBaen(World world)
	{
		super(world);
		
        this.getNavigator().setAvoidsWater(true);
		this.setSize(1.0F, 2.0F);
		this.tasks.addTask(0, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIFollowOwner(this, 1.0D, 1.0F, 2.0F));
        
        this.setTamed(false);
	}
	
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.200000000298023224D);
	}
	
    public void setTamed(boolean par1)
    {
        super.setTamed(par1);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
    }

    @Override
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();

        if (this.isTamed())
        {          	
        	if (itemstack.getItem() instanceof ItemFood)
            {
                ItemFood itemfood = (ItemFood)itemstack.getItem();

                if (itemfood == Items.beef && this.dataWatcher.getWatchableObjectFloat(18) < 20.0F)
                {
                    if (!player.capabilities.isCreativeMode)
                    {
                        --itemstack.stackSize;
                    }

                    this.heal((float)itemfood.func_150905_g(itemstack)); //func_150905_g is same as "getHealAmount"
                    System.out.println("Fed!");

                    if (itemstack.stackSize <= 0)
                    {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
                    }

                    return true;
                }
            }
        	
            if (this.func_152114_e(player) && !this.worldObj.isRemote)
            {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.setPathToEntity((PathEntity)null);
                this.setTarget((Entity)null);
                this.setAttackTarget((EntityLivingBase)null);
            }
        }
        else if (itemstack != null && itemstack.getItem() == Base.itemCrabMorsel)
        {
            if (!player.capabilities.isCreativeMode)
            {
                --itemstack.stackSize;
            }

            if (itemstack.stackSize <= 0)
            {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
            }

            if (!this.worldObj.isRemote)
            {
                if (this.rand.nextInt(10) == 0)
                {
                    this.setTamed(true);
                    this.setPathToEntity((PathEntity)null);
                    this.setAttackTarget((EntityLivingBase)null);
                    this.aiSit.setSitting(true);
                    this.setHealth(20.0F);
                    this.func_152115_b(player.getCommandSenderName()); //sets owner name as string
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte)7);
                    System.out.println("Tamed!");
                }
                else
                {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState(this, (byte)6);
                }
            }

            return true;
        }

        return super.interact(player);
    }
	
	protected String getLivingSound()
	{
		return "dig.snow";
	}

	protected String getHurtSound()
	{
		return "random.click";
	}

	protected String getDeathSound()
	{
		return "mob.villager.haggle";
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
