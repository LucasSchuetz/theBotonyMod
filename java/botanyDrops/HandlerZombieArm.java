package botanyDrops;

import java.util.Random;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import botanyMain.Base;
import botanyMain.DropHandlersInit;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class HandlerZombieArm
{
	@SubscribeEvent
	public void onEntityLivingDeath(LivingDeathEvent event)
	{
		if(event.source.getDamageType().equals("player"))
		{	
			if(event.entityLiving instanceof EntityZombie)
			{
				double rand = Math.random();
				
				if(rand < DropHandlersInit.zombieArm_CHANCE)
				{
					Random random = new Random();
					
					if(random.nextInt(10) <= 2) event.entityLiving.entityDropItem(new ItemStack(Base.itemZombieArm, 1, 0), 2);
					else event.entityLiving.entityDropItem(new ItemStack(Base.itemZombieArm, 1, 0), 1);
				}
			}
		}
		
		if(event.source.getSourceOfDamage() instanceof EntityArrow)
		{
			if(((EntityArrow) event.source.getSourceOfDamage()).shootingEntity != null)
			{
				if(event.entityLiving instanceof EntityZombie)
				{
					double rand = Math.random();
					
					if(rand < DropHandlersInit.zombieArm_CHANCE)
					{
						Random random = new Random();
						
						if(random.nextInt(10) <= 3) event.entityLiving.entityDropItem(new ItemStack(Base.itemZombieArm, 1, 0), 2);
						else event.entityLiving.entityDropItem(new ItemStack(Base.itemZombieArm, 1, 0), 1);
					}
				}
			}
		}
	}
}
