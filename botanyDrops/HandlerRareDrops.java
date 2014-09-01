package botanyDrops;

import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import botanyEntity.EntityBarbedSpike;
import botanyEntity.EntityFungleCrab;
import botanyEntity.EntityGreanBaen;
import botanyEntity.EntitySapphireLawncher;
import botanyEntity.EntityWanderingShoot;
import botanyMain.Base;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class HandlerRareDrops
{
	@SubscribeEvent
	public void onEntityDrop(LivingDeathEvent event)
	{
		Random rand = new Random();
		int numGot = rand.nextInt(10);
		
		if(numGot == 0)
		{
			if(event.entity instanceof EntityWanderingShoot)
			{
				if(!event.entity.worldObj.isRemote)
				{
					event.entity.entityDropItem(new ItemStack(Base.blockPowerBulb), 0.0F);
				}
			}
		}
		if(numGot >= 7)
		{
			if(event.entity instanceof EntityFungleCrab)
			{
				if(!event.entity.worldObj.isRemote)
				{
					event.entity.entityDropItem(new ItemStack(Base.blockVileMushroom), 0.0F);
				}
			}
			if(event.entity instanceof EntityBarbedSpike)
			{
				if(!event.entity.worldObj.isRemote)
				{
					event.entity.entityDropItem(new ItemStack(Base.itemMobPart, 1, 10), 0.0F);
				}
			}
		}
		if(numGot >= 5)
		{
			if(event.entity instanceof EntitySapphireLawncher)
			{
				if(!event.entity.worldObj.isRemote)
				{
					event.entity.entityDropItem(new ItemStack(Base.blockSapphireCrop), 0.0F);
				}
			}
		}
		
		if(event.entity instanceof EntityWanderingShoot || 
		   event.entity instanceof EntityBarbedSpike ||
		   event.entity instanceof EntitySapphireLawncher)
		{
			//Doesn't drop if mob dies from ticking fire damage
			if(event.source.getDamageType().equals("fire"))
			{
				if(!event.entity.worldObj.isRemote)
				{
					event.entity.entityDropItem(new ItemStack(Base.itemMobPart, 1, 6), 0.0F);
				}
			}
		}
		
		if(event.entity instanceof EntityGreanBaen)
		{
			if(!event.source.getDamageType().equals("fire"))
			{
				if(!event.entity.worldObj.isRemote)
				{
					event.entity.entityDropItem(new ItemStack(Base.itemMobPart, 1, 10), 0.0F);
				}
			}
		}
	}
}
