package botanyDrops;

import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import botanyMain.Base;
import botanyMain.DropHandlersInit;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class HandlerPigSnout
{
	@SubscribeEvent
	public void onEntityLivingDeath(LivingDeathEvent event)
	{
		if(event.source.getDamageType().equals("player"))
		{
			if(event.entityLiving instanceof EntityPig)
			{
				double rand = Math.random();
				
				if(rand < DropHandlersInit.pigSnout_CHANCE)
				{
					event.entityLiving.entityDropItem(new ItemStack(Base.itemMobPart, 1, 2), 1);
				}
			}
		}
		
		if(event.source.getSourceOfDamage() instanceof EntityArrow)
		{
			if(((EntityArrow) event.source.getSourceOfDamage()).shootingEntity != null)
			{
				if(event.entityLiving instanceof EntityPig)
				{
					double rand = Math.random();
					
					if(rand < DropHandlersInit.pigSnout_CHANCE)
					{
						event.entityLiving.entityDropItem(new ItemStack(Base.itemMobPart, 1, 2), 1);
					}
				}
			}
		}
	}
}
