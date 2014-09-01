package botanyDrops;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import botanyEntity.EntityBarbedSpike;
import botanyEntity.EntitySapphireLawncher;
import botanyEntity.EntityWanderingShoot;
import botanyMain.Base;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class HandlerPlantGreens
{
	@SubscribeEvent
	public void onEntityDrop(LivingDeathEvent event)
	{
		if(event.entity instanceof EntityWanderingShoot || 
		   event.entity instanceof EntityBarbedSpike ||
		   event.entity instanceof EntitySapphireLawncher)
		{
			//Doesn't drop if mob dies from ticking fire damage
			if(!event.source.getDamageType().equals("fire"))
			{
				if(!event.entity.worldObj.isRemote)
				{
					event.entity.entityDropItem(new ItemStack(Base.itemMobPart, 1, 5), 0.0F);
				}
			}
		}
	}
}
