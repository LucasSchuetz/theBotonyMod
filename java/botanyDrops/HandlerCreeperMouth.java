package botanyDrops;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import botanyMain.Base;
import botanyMain.DropHandlersInit;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class HandlerCreeperMouth
{
	@SubscribeEvent
	public void onEntityLivingDeath(LivingDeathEvent event)
	{
		if(event.source.getDamageType().equals("player"))
		{
			if(event.entityLiving instanceof EntityCreeper)
			{
				double rand = Math.random();
				
				if(rand < DropHandlersInit.creeperMouth_CHANCE)
				{
					event.entityLiving.entityDropItem(new ItemStack(Base.itemMobPart, 1, 1), 1);
				}
			}
		}
		
		if(event.source.getSourceOfDamage() instanceof EntityArrow)
		{
			if(((EntityArrow) event.source.getSourceOfDamage()).shootingEntity != null)
			{
				if(event.entityLiving instanceof EntityCreeper)
				{
					double rand = Math.random();
					
					if(rand < DropHandlersInit.creeperMouth_CHANCE)
					{
						event.entityLiving.entityDropItem(new ItemStack(Base.itemMobPart, 1, 1), 1);
					}
				}
			}
		}
	}
}
