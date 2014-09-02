package botanyMain;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import botanyBiomes.BiomeGenBlight;
import botanyBlocks.BlockBlueMushroom;
import botanyBlocks.BlockBlueMushroomStem;
import botanyBlocks.BlockCropStaff;
import botanyBlocks.BlockFungleDirt;
import botanyBlocks.BlockFungleGrass;
import botanyBlocks.BlockGemGlass;
import botanyBlocks.BlockGemRoot;
import botanyBlocks.BlockInfectedLeaf;
import botanyBlocks.BlockInfectedLog;
import botanyBlocks.BlockInfectedSapling;
import botanyBlocks.BlockLifeBasin;
import botanyBlocks.BlockMushroomGiant;
import botanyBlocks.BlockPowerBulb;
import botanyBlocks.BlockPowerStaff;
import botanyBlocks.BlockRottenPlanks;
import botanyBlocks.BlockSalvagedPlanks;
import botanyBlocks.BlockSapphireCrop;
import botanyBlocks.BlockShroomWood;
import botanyBlocks.BlockVibrantBloom;
import botanyBlocks.BlockVibrantBloomRoot;
import botanyBlocks.BlockVileMushroom;
import botanyDrops.HandlerPlantGreens;
import botanyEntity.EntityArrowFish;
import botanyEntity.EntityBarbedSpike;
import botanyEntity.EntityBasilisk;
import botanyEntity.EntityFungleCrab;
import botanyEntity.EntityGreanBaen;
import botanyEntity.EntityMongrel;
import botanyEntity.EntityPrizeRunner;
import botanyEntity.EntitySapphireBerry;
import botanyEntity.EntitySapphireLawncher;
import botanyEntity.EntitySporeRay;
import botanyEntity.EntityWanderingShoot;
import botanyItems.ItemBioBottle;
import botanyItems.ItemBioBottleCooked;
import botanyItems.ItemCleansingPowder;
import botanyItems.ItemCompost;
import botanyItems.ItemCookedCrabMorsel;
import botanyItems.ItemCrabMorsel;
import botanyItems.ItemFangBlade;
import botanyItems.ItemIncendiarySlimeball;
import botanyItems.ItemMatter;
import botanyItems.ItemMobPart;
import botanyItems.ItemMobSpawnEgg;
import botanyItems.ItemSapphireBerry;
import botanyItems.ItemVileFlesh;
import botanyItems.ItemZombieArm;
import botanyTileEntity.TileEntityCropStaff;
import botanyTileEntity.TileEntityLifeBasin;
import botanyTileEntity.TileEntityPowerBulb;
import botanyTileEntity.TileEntityPowerStaff;
import botanyTileEntity.TileEntitySapphireCrop;
import botanyTileEntity.TileEntityVibrantBloom;
import botanyWorldGen.WorldGenInfectedTree;
import botanyWorldGen.WorldGenMushroomGiant;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/* _=-*CURRENT MOD NAME*-=_
 * "The" Botany Mod
 */

@Mod(modid = Base.modid, version = Base.version)

public class Base
{	
	@SidedProxy(clientSide = "botanyMain.ClientProxy",
				serverSide = "botanyMain.CommonProxy")
	public static CommonProxy proxy;
	
	public static final String modid = "botany";
	public static final String version = "2.0";
	
	//Used for ore generation
	EventManager eventManager = new EventManager();
	
	//Biomes
	public static BiomeGenBase blight;
	
	/* Blocks */
	public static Block blockFungleDirt;
	public static Block blockFungleGrass;
	public static Block blockInfectedLeaf;
	public static Block blockInfectedLog;
	public static Block blockInfectedSapling;
	public static Block blockVileMushroom;
	public static Block blockBlueMushroom;
	public static Block blockBlueMushroomStem;
	public static Block blockRottenPlanks;
	public static Block blockMushroomGiant;
	public static Block blockPowerStaff;
	public static Block blockSapphireCrop;
	public static Block blockPowerBulb;
	public static Block blockCropStaff;
	public static Block blockLifeBasin;
	public static Block blockGemRoot;
	public static Block blockShroomWood;
	public static Block blockSalvagedPlanks;
	public static Block blockGemGlass;
	public static Block blockVibrantBloomMain;     // VIBRANT
	public static Block blockVibrantBloomBranch;  //   BLOOM
	public static Block blockVibrantBloomRoot;   //     PARTS
	
	/* Items */
	public static Item itemMobPart;
	public static Item itemMatter;
	public static Item itemIncendiarySlimeball;
	public static Item itemBioBottle;
	public static Item itemBioBottleCooked;
	public static Item itemCompost;
	public static Item itemMobSpawnEgg;
	public static Item itemSapphireBerry;
	public static Item itemThornedBranch;
	public static Item itemStoneCrown;
	public static Item itemCrabMorsel;
	public static Item itemCookedCrabMorsel;
	public static Item itemVileFlesh;
	public static Item itemCleansingPowder;
	public static Item itemFangBlade;
	public static Item itemZombieArm;
	public static Item itemGemRootShard;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		/* Block Init. */
		blockFungleDirt = new BlockFungleDirt();
		blockFungleGrass = new BlockFungleGrass();
		blockInfectedLeaf = new BlockInfectedLeaf();
		blockInfectedLog = new BlockInfectedLog();
		blockInfectedSapling = new BlockInfectedSapling();
		blockVileMushroom = new BlockVileMushroom();
		blockBlueMushroom = new BlockBlueMushroom();
		blockBlueMushroomStem = new BlockBlueMushroomStem();
		blockRottenPlanks = new BlockRottenPlanks();
		blockMushroomGiant = new BlockMushroomGiant();
		blockPowerStaff = new BlockPowerStaff();
		blockSapphireCrop = new BlockSapphireCrop();
		blockPowerBulb = new BlockPowerBulb();
		blockCropStaff = new BlockCropStaff();
		blockLifeBasin = new BlockLifeBasin();
		blockGemRoot = new BlockGemRoot();
		blockShroomWood = new BlockShroomWood();
		blockSalvagedPlanks = new BlockSalvagedPlanks();
		blockGemGlass = new BlockGemGlass();
		blockVibrantBloomMain = new BlockVibrantBloom();
		blockVibrantBloomRoot = new BlockVibrantBloomRoot();
		
		/* Item Init. */
		itemMobPart = new ItemMobPart();
		itemMatter = new ItemMatter();
		itemIncendiarySlimeball = new ItemIncendiarySlimeball();
		itemBioBottle = new ItemBioBottle();
		itemBioBottleCooked = new ItemBioBottleCooked();
		itemCompost = new ItemCompost();
		itemMobSpawnEgg = new ItemMobSpawnEgg();
		itemSapphireBerry = new ItemSapphireBerry();
		itemThornedBranch = new Item().setUnlocalizedName(Base.modid + "_" + "thornedBranch").setTextureName(Base.modid + ":" + "thornedBranch").setCreativeTab(Base.tabSometimes);
		itemStoneCrown = new Item().setUnlocalizedName(Base.modid +"_" + "stoneCrown").setTextureName(Base.modid + ":" + "stoneCrown").setCreativeTab(Base.tabSometimes);
		itemCrabMorsel = new ItemCrabMorsel(2, 0.3F, false);
		itemCookedCrabMorsel = new ItemCookedCrabMorsel(6, 0.7F, false);
		itemVileFlesh = new ItemVileFlesh();
		itemCleansingPowder = new ItemCleansingPowder();
		itemFangBlade = new ItemFangBlade();
		itemZombieArm = new ItemZombieArm(2, 0.2F, true);
		itemGemRootShard = new Item().setUnlocalizedName(Base.modid + "_" + "gemRootShard").setTextureName(Base.modid + ":" + "gemRootShard").setCreativeTab(Base.tabSometimes);
		
		//Biomes
		blight = new BiomeGenBlight(50);
		
		//Event Handlers
		DropHandlersInit.init(); //Vanilla Mob Drops
		MobDrops(); //Our Mob Drops
		MinecraftForge.EVENT_BUS.register(new EventBonemealClass());
		
		//Call to registry's
		GameReg();//Game
		EntityReg();//Entity
		TileEntityReg();//Tile Entities
		
		//Proxy Calls to Renderers and Sounds
		proxy.registerRenderThings();
//		proxy.registerSound(); UNUSED ATM
		
		//Crafting Registry
		Crafting.addRecipes();
	}
	
	@EventHandler
	public void Load(FMLInitializationEvent load)
	{
		//load
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event) {}
	
	 // -- Game Registry -- \\
	// -For registering blocks to forge
	public void GameReg()
	{	
		//Blocks --GameRegistry.registerBlock(block, "block"); <-- SKELETON
		GameRegistry.registerBlock(blockFungleDirt, "blockFungleDirt");
		GameRegistry.registerBlock(blockFungleGrass, "blockFungleGrass");
		GameRegistry.registerBlock(blockInfectedLeaf, "blockInfectedLeaf");
		GameRegistry.registerBlock(blockInfectedLog, "blockInfectedLog");
		GameRegistry.registerBlock(blockInfectedSapling, "blockInfectedSapling");
		GameRegistry.registerBlock(blockVileMushroom, "blockVileMushroom");
		GameRegistry.registerBlock(blockBlueMushroom, "blockBlueMushroom");
		GameRegistry.registerBlock(blockBlueMushroomStem, "blockBlueMushroomStem");
		GameRegistry.registerBlock(blockRottenPlanks, "blockRottenPlanks");
		GameRegistry.registerBlock(blockMushroomGiant, "blockMushroomGiant");
		GameRegistry.registerBlock(blockPowerStaff, "blockPowerStaff");
		GameRegistry.registerBlock(blockCropStaff, "blockCropStaff");
		GameRegistry.registerBlock(blockSapphireCrop, "blockSapphireCrop");
		GameRegistry.registerBlock(blockPowerBulb, "blockPowerBulb");
		GameRegistry.registerBlock(blockLifeBasin, "blockLifeBasin");
		GameRegistry.registerBlock(blockGemRoot, "blockGemRoot");
		GameRegistry.registerBlock(blockShroomWood, "blockShroomWood");
		GameRegistry.registerBlock(blockSalvagedPlanks, "blockSalvagedPlanks");
		GameRegistry.registerBlock(blockGemGlass, "blockGemGlass");
		GameRegistry.registerBlock(blockVibrantBloomMain, "blockVibrantBloom");
		
		//Items --GameRegistry.registerItem(item, "item"); <-- SKELETON
		GameRegistry.registerItem(itemMobPart, "itemMobPart");
		GameRegistry.registerItem(itemMatter, "itemMatter");
		GameRegistry.registerItem(itemIncendiarySlimeball, "itemIncendiarySlimeball");
		GameRegistry.registerItem(itemBioBottle, "itemBioBottle");
		GameRegistry.registerItem(itemBioBottleCooked, "itemBioBottleCooked");
		GameRegistry.registerItem(itemCompost, "itemCompost");
		GameRegistry.registerItem(itemMobSpawnEgg, "itemMobSpawnEgg");
		GameRegistry.registerItem(itemSapphireBerry, "itemSapphireBerry");
		GameRegistry.registerItem(itemThornedBranch, "itemThornedBranch");
		GameRegistry.registerItem(itemStoneCrown, "itemStoneCrown");
		GameRegistry.registerItem(itemCrabMorsel, "itemCrabMorsel");
		GameRegistry.registerItem(itemCookedCrabMorsel, "itemCookedCrabMorsel");
		GameRegistry.registerItem(itemVileFlesh, "itemVileFlesh");
		GameRegistry.registerItem(itemCleansingPowder, "itemCleansingPowder");
		GameRegistry.registerItem(itemFangBlade, "itemFangBlade");
		GameRegistry.registerItem(itemZombieArm, "itemZombieArm");
		GameRegistry.registerItem(itemGemRootShard, "itemGemRootShard");
		
		//World Generation Generation
		GameRegistry.registerWorldGenerator(eventManager, 2);
		GameRegistry.registerWorldGenerator(new WorldGenInfectedTree(false), 2);
		GameRegistry.registerWorldGenerator(new WorldGenMushroomGiant(), 2);
	}
	
	 // -- Entity Registry -- \\
	//-For registering entites (mobs) -- EntityRegistry.registerModEntity(Entity.class, "", id, this, 80, 1, true);
	public void EntityReg()
	{
		int id = 0;
		
		EntityRegistry.registerModEntity(EntityGreanBaen.class, "Grean Baen", id, this, 80, 1, true);
		id++;
		EntityRegistry.addSpawn(EntityGreanBaen.class, 5, 2, 3, EnumCreatureType.creature, BiomeGenBase.extremeHills);
		EntityRegistry.addSpawn(EntityGreanBaen.class, 5, 2, 3, EnumCreatureType.creature, BiomeGenBase.extremeHillsEdge);
		
		EntityRegistry.registerModEntity(EntityFungleCrab.class, "Fungle Crab", id, this, 80, 1, true);
		id++;
		EntityRegistry.addSpawn(EntityFungleCrab.class, 5, 4, 8, EnumCreatureType.creature, Base.blight);
		
		EntityRegistry.registerModEntity(EntityPrizeRunner.class, "Prize Runner", id, this, 80, 1, true);
		id++;
		EntityRegistry.addSpawn(EntityPrizeRunner.class, 3, 1, 2, EnumCreatureType.creature, BiomeGenBase.plains);
		
		EntityRegistry.registerModEntity(EntityBarbedSpike.class, "Barbed Spike", id, this, 80, 1, true);
		id++;
		EntityRegistry.addSpawn(EntityBarbedSpike.class, 5, 1, 2, EnumCreatureType.monster, BiomeGenBase.jungle);
		EntityRegistry.addSpawn(EntityBarbedSpike.class, 5, 1, 2, EnumCreatureType.monster, BiomeGenBase.jungleHills);
		EntityRegistry.addSpawn(EntityBarbedSpike.class, 5, 1, 2, EnumCreatureType.monster, BiomeGenBase.forest);
		EntityRegistry.addSpawn(EntityBarbedSpike.class, 5, 1, 2, EnumCreatureType.monster, BiomeGenBase.forestHills);
		
		EntityRegistry.registerModEntity(EntityArrowFish.class, "Arrow Fish", id, this, 80, 1, true);
		id++;
		EntityRegistry.addSpawn(EntityArrowFish.class, 5, 15, 40, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
		EntityRegistry.addSpawn(EntityArrowFish.class, 5, 15, 40, EnumCreatureType.waterCreature, BiomeGenBase.river);
		
		EntityRegistry.registerModEntity(EntityMongrel.class, "Mongrel", id, this, 80, 1, true);
		id++;
		
		EntityRegistry.registerModEntity(EntitySapphireLawncher.class, "Sapphire Lawncher", id, this, 80, 1, true);
		id++;
		EntityRegistry.addSpawn(EntitySapphireLawncher.class, 5, 2, 7, EnumCreatureType.monster, BiomeGenBase.jungle);
		
		EntityRegistry.registerModEntity(EntityWanderingShoot.class, "Wandering Shoot", id, this, 80, 1, true);
		id++;
		EntityRegistry.addSpawn(EntityWanderingShoot.class, 2, 1, 3, EnumCreatureType.monster, BiomeGenBase.plains);
		EntityRegistry.addSpawn(EntityWanderingShoot.class, 2, 1, 3, EnumCreatureType.monster, BiomeGenBase.forest);
		
		EntityRegistry.registerModEntity(EntitySapphireBerry.class, "Sapphire Berry", id, this, 64, 10, true);
		id++;
		
		EntityRegistry.registerModEntity(EntitySporeRay.class, "Spore Ray", id, this, 80, 1, true);
		id++;
		EntityRegistry.addSpawn(EntitySporeRay.class, 3, 5, 9, EnumCreatureType.creature, Base.blight);
		
		EntityRegistry.registerModEntity(EntityBasilisk.class, "Basilisk", id, this, 80, 1, true);
		id++;
		EntityRegistry.addSpawn(EntityBasilisk.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.forest);
	}
	
	 // -- Tile Entity Registry -- \\
	//-For registering custom rendered blocks -- GameRegistry.registerTileEntity(TileEntity.class, "");
	public void TileEntityReg()
	{
		GameRegistry.registerTileEntity(TileEntityPowerBulb.class, "powerBulbTE");
		GameRegistry.registerTileEntity(TileEntityCropStaff.class, "cropStaffTE");
		GameRegistry.registerTileEntity(TileEntityLifeBasin.class, "lifeBasinTE");
		GameRegistry.registerTileEntity(TileEntitySapphireCrop.class, "sapphireCropTE");
		GameRegistry.registerTileEntity(TileEntityPowerStaff.class, "powerStaffTE");
		GameRegistry.registerTileEntity(TileEntityVibrantBloom.class, "vibrantBloomTE");
	}
	
	public void MobDrops()
	{
		MinecraftForge.EVENT_BUS.register(new HandlerPlantGreens());
	}
	
	 // -- Creative Tab -- \\
	// -Default custom tab for modded items + blocks
	public static CreativeTabs tabSometimes = new CreativeTabs("tabBotony")
	{
		@Override
		public ItemStack getIconItemStack()
		{
			return new ItemStack(Item.getItemFromBlock(Base.blockPowerStaff), 1, 0);
		}
		
		@Override
		public String getTranslatedTabLabel()
		{
			return "Plantology";
		}

		@Override
		public Item getTabIconItem()
		{
			return null;
		}
	};
}