package botanyDrops;

import java.util.Random;

import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import botanyMain.Base;
import botanyMain.DropHandlersInit;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class HandlerSheepLeg
{
	@SubscribeEvent
	public void onEntityLivingDeath(LivingDeathEvent event)
	{
		if(event.source.getDamageType().equals("player"))
		{
			if(event.entityLiving instanceof EntitySheep)
			{
				double rand = Math.random();
				
				if(rand < DropHandlersInit.sheepLeg_CHANCE)
				{
					Random random = new Random();
					
					event.entityLiving.entityDropItem(new ItemStack(Base.itemMobPart, 1, 3), (random.nextInt(3) + 1));
				}
			}
		}
		
		if(event.source.getSourceOfDamage() instanceof EntityArrow)
		{
			if(((EntityArrow) event.source.getSourceOfDamage()).shootingEntity != null)
			{
				if(event.entityLiving instanceof EntitySheep)
				{
					double rand = Math.random();
					
					if(rand < DropHandlersInit.sheepLeg_CHANCE)
					{
						Random random = new Random();
						
						event.entityLiving.entityDropItem(new ItemStack(Base.itemMobPart, 1, 3), (random.nextInt(3) + 1));
					}
				}
			}
		}
	}
}
