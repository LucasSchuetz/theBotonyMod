package botanyDrops;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import botanyEntity.EntityPrizeRunner;
import botanyEntity.EntitySporeRay;
import botanyMain.Base;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class HandlerPrizeRunner
{
	@SubscribeEvent
	public void onEntityDrop(LivingDeathEvent event)
	{
		Random rand = new Random();

		if(event.entity instanceof EntityPrizeRunner)
		{
			//Doesn't drop if mob dies from ticking fire damage
			if(!event.source.getDamageType().equals("fire"))
			{
				if(!event.entity.worldObj.isRemote)
				{
					int drop = rand.nextInt(10);
					
					if(drop < 4)
					{
						int rareDrop = rand.nextInt(2);
						
						switch(rareDrop)
						{
						case 0:
						{
							event.entity.entityDropItem(new ItemStack(Items.emerald), 0.0F);
							break;
						}
						case 1:
							event.entity.entityDropItem(new ItemStack(Items.saddle), 0.0F);
							break;
						}
					}
					else
					{
						int commonDrop = rand.nextInt(9);
						
						switch(commonDrop)
						{
						case 0:
						{
							int seedsDrop = rand.nextInt(3);
							
							switch(seedsDrop)
							{
							case 0:
							{
								event.entity.entityDropItem(new ItemStack(Items.wheat_seeds), 0.0F);
								break;
							}
							case 1:
							{
								event.entity.entityDropItem(new ItemStack(Items.melon_seeds), 0.0F);
								break;
							}
							case 2:
							{
								event.entity.entityDropItem(new ItemStack(Items.pumpkin_seeds), 0.0F);
								break;
							}
							}
							
							break;
						}
						case 1:
						{
							event.entity.entityDropItem(new ItemStack(Items.carrot_on_a_stick), 0.0F);
							break;
						}
						case 2:
						{
							event.entity.entityDropItem(new ItemStack(Items.chainmail_chestplate), 0.0F);
							break;
						}
						case 3:
						{
							event.entity.entityDropItem(new ItemStack(Items.pumpkin_pie), 0.0F);
							break;
						}
						case 4:
						{
							event.entity.entityDropItem(new ItemStack(Blocks.ice), 0.0F);
							break;
						}
						case 5:
						{
							event.entity.entityDropItem(new ItemStack(Items.experience_bottle), 0.0F);
							break;
						}
						case 6:
						{
							event.entity.entityDropItem(new ItemStack(Items.speckled_melon), 0.0F);
							break;
						}
						case 7:
						{
							event.entity.entityDropItem(new ItemStack(Blocks.lapis_block), 0.0F);
							break;
						}
						case 8:
						{
							event.entity.entityDropItem(new ItemStack(Items.clock), 0.0F);
							break;
						}
						}
					}
					
//					event.entity.entityDropItem(new ItemStack(), 0.0F);
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