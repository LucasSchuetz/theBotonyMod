package botanyMain;

import net.minecraftforge.common.MinecraftForge;
import botanyDrops.HandlerBasiliskDrops;
import botanyDrops.HandlerCowUtter;
import botanyDrops.HandlerCreeperMouth;
import botanyDrops.HandlerMobDrops;
import botanyDrops.HandlerPigSnout;
import botanyDrops.HandlerPlantGreens;
import botanyDrops.HandlerPrizeRunner;
import botanyDrops.HandlerRareDrops;
import botanyDrops.HandlerSheepLeg;
import botanyDrops.HandlerSkeletonRibcage;
import botanyDrops.HandlerZombieArm;

/** VANILLA MOB DROPS **/
// Adds ability for vanilla mobs to drop non-vanilla items.

public class DropHandlersInit
{
	//All defaulted to TRUE in BASE.preInit
	public static boolean zombieArmDrop = true;
	public static boolean cowUtterDrop = true;
	public static boolean creeperMouthDrop = true;
	public static boolean pigSnoutDrop = true;
	public static boolean sheepLegDrop = true;
	public static boolean skeletonRibcageDrop = true;
	public static boolean runicItemsDrop = false;
	
	// % Drop Chances
	public static double zombieArm_CHANCE = 0.4D;
	public static double cowUtter_CHANCE = 0.3D;
	public static double creeperMouth_CHANCE = 0.3D;
	public static double pigSnout_CHANCE = 0.3D;
	public static double sheepLeg_CHANCE = 0.4D;
	public static double skeletonRibcage_CHANCE = 0.3D;
	public static double runicItem_CHANCE = 0.3D;

	public static void init()
	{
		if(zombieArmDrop){MinecraftForge.EVENT_BUS.register(new HandlerZombieArm());}
		if(cowUtterDrop){MinecraftForge.EVENT_BUS.register(new HandlerCowUtter());}
		if(creeperMouthDrop){MinecraftForge.EVENT_BUS.register(new HandlerCreeperMouth());}
		if(pigSnoutDrop){MinecraftForge.EVENT_BUS.register(new HandlerPigSnout());}
		if(sheepLegDrop){MinecraftForge.EVENT_BUS.register(new HandlerSheepLeg());}
		if(skeletonRibcageDrop){MinecraftForge.EVENT_BUS.register(new HandlerSkeletonRibcage());}
		
		MinecraftForge.EVENT_BUS.register(new HandlerPlantGreens()); //Plant Greens drops (regular mob drops, no choice given to remove drop)
		MinecraftForge.EVENT_BUS.register(new HandlerRareDrops());
		MinecraftForge.EVENT_BUS.register(new HandlerBasiliskDrops());
		MinecraftForge.EVENT_BUS.register(new HandlerMobDrops());
		MinecraftForge.EVENT_BUS.register(new HandlerPrizeRunner());
	}
}
