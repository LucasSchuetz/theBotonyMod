package botanyItems;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import botanyEntity.EntityArrowFish;
import botanyEntity.EntityBarbedSpike;
import botanyEntity.EntityBasilisk;
import botanyEntity.EntityFungleCrab;
import botanyEntity.EntityGreanBaen;
import botanyEntity.EntityMongrel;
import botanyEntity.EntityPrizeRunner;
import botanyEntity.EntitySapphireLawncher;
import botanyEntity.EntitySporeRay;
import botanyEntity.EntityWanderingShoot;
import botanyMain.Base;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMobSpawnEgg extends Item
{
	public static final String[] partNames = new String [] {
		"greanBaen", "fungleCrab", "prizeRunner", "barbedSpike",
		"arrowFish", "mongrel", "wanderingShoot", "basilisk",
		"sapphireLawncher", "sporeRay"};
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	public ItemMobSpawnEgg()
	{
		super();
		
		this.setUnlocalizedName(Base.modid + "_" + "mobEgg");
		this.setTextureName(Base.modid + ":" + "mobEgg");
		
		this.setHasSubtypes(true);
		this.setCreativeTab(Base.tabSometimes);
	}
    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par2World.isRemote)
        {
            return par1ItemStack;
        }
        else
        {
            MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);

            if (movingobjectposition == null)
            {
                return par1ItemStack;
            }
            else
            {
                if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
                {
                    int i = movingobjectposition.blockX;
                    int j = movingobjectposition.blockY;
                    int k = movingobjectposition.blockZ;

                    if (!par2World.canMineBlock(par3EntityPlayer, i, j, k))
                    {
                        return par1ItemStack;
                    }

                    if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
                    {
                        return par1ItemStack;
                    }

                    if (par2World.getBlock(i, j, k) != null)
                    {
                        Entity entity = spawnCreature(par2World, par1ItemStack.getItemDamage(), (double)i, (double)j, (double)k);

                        if (entity != null)
                        {
                            if (entity instanceof EntityLivingBase && par1ItemStack.hasDisplayName())
                            {
                                ((EntityLiving)entity).setCustomNameTag(par1ItemStack.getDisplayName());
                            }

                            if (!par3EntityPlayer.capabilities.isCreativeMode)
                            {
                                --par1ItemStack.stackSize;
                            }
                        }
                    }
                }

                return par1ItemStack;
            }
        }
    }
    
    public static Entity spawnCreature(World world, int id, double par2, double par4, double par6)
    {
        Entity entity = null;

        switch(id)
        {
        case 0:
        {
        	entity = new EntityGreanBaen(world);
        	break;
        }
        case 1:
        {
        	entity = new EntityFungleCrab(world);
        	break;
        }
        case 2:
        {
        	entity = new EntityPrizeRunner(world);
        	break;
        }
        case 3:
        {
        	entity = new EntityBarbedSpike(world);
        	break;
        }
        case 4:
        {
        	entity = new EntityArrowFish(world);
        	break;
        }
        case 5:
        {
        	entity = new EntityMongrel(world);
        	break;
        }
        case 6:
        {
        	entity = new EntityWanderingShoot(world);
        	break;
        }
        case 7:
        {
        	entity = new EntityBasilisk(world);
        	break;
        }
        case 8:
        {
        	entity = new EntitySapphireLawncher(world);
        	break;
        }
        case 9:
        {
        	entity = new EntitySporeRay(world);
        	break;
        }
        default:
        {
        	entity = new EntityPigZombie(world);
        	break;
        }
        }

        EntityLiving entityliving = (EntityLiving)entity;
        entity.setLocationAndAngles(par2, par4 + 1, par6, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
        entityliving.rotationYawHead = entityliving.rotationYaw;
        entityliving.renderYawOffset = entityliving.rotationYaw;
        entityliving.onSpawnWithEgg((IEntityLivingData)null);
        world.spawnEntityInWorld(entity);
        entityliving.playLivingSound();

        return entity;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIconFromDamage(int damage)
	{
		return icons[damage];
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		int i = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 15);
		
		return super.getUnlocalizedName() + "." + partNames[i];
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List list)
	{
		for(int x = 0; x < 10; x++)
		{
			list.add(new ItemStack(this, 1, x));
		}
	}
	
	@Override
	public void registerIcons(IIconRegister icon)
	{
		icons = new IIcon[10];
		
		for(int i =  0; i < icons.length; i++)
		{
			icons[i] = icon.registerIcon(Base.modid + ":" + "mobSpawnEggs" + "/" + "spawn_" + partNames[i]);
		}
	}
}
