package botanyDrops;

import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import botanyEntity.EntityFungleCrab;
import botanyEntity.EntitySporeRay;
import botanyMain.Base;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class HandlerMobDrops
{
	@SubscribeEvent
	public void onEntityDrop(LivingDeathEvent event)
	{
		Random rand = new Random();

		if(event.entity instanceof EntityFungleCrab)
		{
			//Doesn't drop if mob dies from ticking fire damage
			if(!event.source.getDamageType().equals("fire"))
			{
				if(!event.entity.worldObj.isRemote)
				{
					event.entity.entityDropItem(new ItemStack(Base.itemCrabMorsel), 0.0F);
				}
			}
		}
		
		if(event.entity instanceof EntitySporeRay)
		{
			//Doesn't drop if mob dies from ticking fire damage
			if(!event.source.getDamageType().equals("fire"))
			{
				if(!event.entity.worldObj.isRemote)
				{
					for(int i = 0; i <= rand.nextInt(3); ++i)
					{
						event.entity.entityDropItem(new ItemStack(Base.itemCleansingPowder), 0.0F);
					}
				}
			}
		}
	}
}
