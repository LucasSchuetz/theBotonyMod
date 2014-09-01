package botanyMain;

import net.minecraftforge.event.entity.player.BonemealEvent;
import botanyBlocks.BlockInfectedSapling;
import botanyBlocks.BlockMushroomGiant;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventBonemealClass
{	
	@SubscribeEvent
	public void bonemealUsed(BonemealEvent event)
	{
		if(event.world.getBlock(event.x, event.y, event.z) == Base.blockInfectedSapling)
		{
			((BlockInfectedSapling)Base.blockInfectedSapling).growTree(event.world, event.x, event.y, event.z, event.world.rand);
		}
		
		if(event.world.getBlock(event.x, event.y, event.z) == Base.blockMushroomGiant)
		{
			((BlockMushroomGiant)Base.blockMushroomGiant).fertilizeMushroom(event.world, event.x, event.y, event.z, event.world.rand);
		}
	}
}
