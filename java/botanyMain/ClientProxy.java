package botanyMain;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
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
import botanyModels.ModelArrowFish;
import botanyModels.ModelBarbedSpike;
import botanyModels.ModelBasilisk;
import botanyModels.ModelFungleCrab;
import botanyModels.ModelGreanBaen;
import botanyModels.ModelMongrel;
import botanyModels.ModelPrizeRunner;
import botanyModels.ModelSapphireLawncher;
import botanyModels.ModelSporeRay;
import botanyModels.ModelWanderingShoot;
import botanyRenderers.ItemRenderCropStaff;
import botanyRenderers.ItemRenderLifeBasin;
import botanyRenderers.ItemRenderPowerBulb;
import botanyRenderers.ItemRenderPowerStaff;
import botanyRenderers.ItemRenderSapphireCrop;
import botanyRenderers.ItemRenderVibrantBloom;
import botanyRenderers.RenderArrowFish;
import botanyRenderers.RenderBarbedSpike;
import botanyRenderers.RenderBasilisk;
import botanyRenderers.RenderCropStaff;
import botanyRenderers.RenderFungleCrab;
import botanyRenderers.RenderGreanBaen;
import botanyRenderers.RenderLifeBasin;
import botanyRenderers.RenderMongrel;
import botanyRenderers.RenderPowerBulb;
import botanyRenderers.RenderPowerStaff;
import botanyRenderers.RenderPrizeRunner;
import botanyRenderers.RenderSapphireCrop;
import botanyRenderers.RenderSapphireLawncher;
import botanyRenderers.RenderSporeRay;
import botanyRenderers.RenderVibrantBloom;
import botanyRenderers.RenderWanderingShoot;
import botanyTileEntity.TileEntityCropStaff;
import botanyTileEntity.TileEntityLifeBasin;
import botanyTileEntity.TileEntityPowerBulb;
import botanyTileEntity.TileEntityPowerStaff;
import botanyTileEntity.TileEntitySapphireCrop;
import botanyTileEntity.TileEntityVibrantBloom;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public void registerRenderThings()
	{	
		/**Tile Entity Rendering**/
		//Power Staff
		TileEntitySpecialRenderer powerStaff = new RenderPowerStaff();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPowerStaff.class, powerStaff);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Base.blockPowerStaff), new ItemRenderPowerStaff(powerStaff, new TileEntityPowerStaff()));
		
		//Sapphire Crop GAY
		TileEntitySpecialRenderer sapphireCrop = new RenderSapphireCrop();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySapphireCrop.class, sapphireCrop);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Base.blockSapphireCrop), new ItemRenderSapphireCrop(sapphireCrop, new TileEntitySapphireCrop()));
		
		//Power Bulb
		TileEntitySpecialRenderer powerBulb = new RenderPowerBulb();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPowerBulb.class, powerBulb);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Base.blockPowerBulb), new ItemRenderPowerBulb(powerBulb, new TileEntityPowerBulb()));
		
		//Crop Staff
		TileEntitySpecialRenderer cropStaff = new RenderCropStaff();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCropStaff.class, cropStaff);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Base.blockCropStaff), new ItemRenderCropStaff(cropStaff, new TileEntityCropStaff()));
		
		//Life Basin
		TileEntitySpecialRenderer lifeBasin = new RenderLifeBasin();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLifeBasin.class, lifeBasin);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Base.blockLifeBasin), new ItemRenderLifeBasin(lifeBasin, new TileEntityLifeBasin()));
		
		//Vibrant Bloom Main
		TileEntitySpecialRenderer vibrantBloom = new RenderVibrantBloom();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVibrantBloom.class, vibrantBloom);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Base.blockVibrantBloomMain), new ItemRenderVibrantBloom(vibrantBloom, new TileEntityVibrantBloom()));
		
		/**Thrown Entity Rendering**/
		//Entity Rendering
		RenderingRegistry.registerEntityRenderingHandler(EntitySapphireBerry.class, new RenderSnowball(Base.itemSapphireBerry));
		
		//Mob Registry
		MobReg();
	}
	
	public void MobReg()
	{
		/**Mob Rendering**/
		RenderingRegistry.registerEntityRenderingHandler(EntityGreanBaen.class, new RenderGreanBaen(new ModelGreanBaen(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFungleCrab.class, new RenderFungleCrab(new ModelFungleCrab(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPrizeRunner.class, new RenderPrizeRunner(new ModelPrizeRunner(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBarbedSpike.class, new RenderBarbedSpike(new ModelBarbedSpike(), 0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntityArrowFish.class, new RenderArrowFish(new ModelArrowFish(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMongrel.class, new RenderMongrel(new ModelMongrel(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySapphireLawncher.class, new RenderSapphireLawncher(new ModelSapphireLawncher(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityWanderingShoot.class, new RenderWanderingShoot(new ModelWanderingShoot(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySporeRay.class, new RenderSporeRay(new ModelSporeRay(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBasilisk.class, new RenderBasilisk(new ModelBasilisk(), 0.5F));
	}
	
	@Override
	public void registerSound()
	{
		
	}
}
