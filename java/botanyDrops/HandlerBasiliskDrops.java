package botanyDrops;

import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import botanyEntity.EntityBasilisk;
import botanyMain.Base;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class HandlerBasiliskDrops
{
	@SubscribeEvent
	public void onEntityDrop(LivingDeathEvent event)
	{
		Random rand = new Random();

		if(event.entity instanceof EntityBasilisk)
		{
			int numGot = rand.nextInt(8) + 1;
			
			for(int i = 0; i <= numGot; i++)
			{
				if(!event.entity.worldObj.isRemote)
				{
					event.entity.entityDropItem(new ItemStack(Base.itemMobPart, 1, 6), 0.0F);
				}
			}
			
			numGot = rand.nextInt(8) + 1;
			
			for(int i = 0; i <= numGot; i++)
			{
				if(!event.entity.worldObj.isRemote)
				{
					event.entity.entityDropItem(new ItemStack(Base.itemMobPart, 1, 7), 0.0F);
				}
			}
			
			numGot = rand.nextInt(8) + 1;
			
			for(int i = 0; i <= numGot; i++)
			{
				if(!event.entity.worldObj.isRemote)
				{
					event.entity.entityDropItem(new ItemStack(Base.itemMobPart, 1, 8), 0.0F);
				}
			}
		}
	}
}
