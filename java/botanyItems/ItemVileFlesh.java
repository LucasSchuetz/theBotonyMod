package botanyItems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import botanyEntity.EntityMongrel;
import botanyMain.Base;

public class ItemVileFlesh extends Item
{
    public ItemVileFlesh()
    {
        super();
        
        this.setUnlocalizedName(Base.modid + "_" + "vileFlesh");
        this.setTextureName(Base.modid + ":" + "vileFlesh");
        
        this.setCreativeTab(Base.tabSometimes);
    }
    
    public boolean itemInteractionForEntity(ItemStack itemStack, EntityPlayer player, EntityLivingBase target)
    {	
		if (itemStack.getItem() == Base.itemVileFlesh)
		{
			if(target instanceof EntityWolf)
			{
				target.setDead();
				
				if(!target.worldObj.isRemote)
				{	
					EntityMongrel entity = new EntityMongrel(target.worldObj);
			        entity.setLocationAndAngles(target.posX, target.posY, target.posZ, target.rotationYaw, 0.0F);
			        target.worldObj.spawnEntityInWorld(entity);
			        
			        itemStack.stackSize--;
				}
				
		        for (int j = 0; j < 80; ++j)
		        {
		            target.worldObj.spawnParticle("explode", target.posX, target.posY + 0.5D, target.posZ, 0.0D, 0.0D, 0.0D);
		        }
			}
			
			return true;
		}
		else
		{
			return false;
		}
    }
}
