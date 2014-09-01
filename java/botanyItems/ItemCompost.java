package botanyItems;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.BonemealEvent;
import botanyMain.Base;
import cpw.mods.fml.common.eventhandler.Event.Result;

public class ItemCompost extends Item
{
	public ItemCompost()
	{
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(10);
		
		this.setUnlocalizedName(Base.modid + "_" + "compost");
		this.setTextureName(Base.modid + ":" + "compost");
		
		this.setCreativeTab(Base.tabSometimes);
	}
	
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entity, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (!entity.canPlayerEdit(par4, par5, par6, par7, itemStack))
        {
            return false;
        }
        else
        {
            if (applyBonemeal(itemStack, world, par4, par5, par6, entity))
            {
                if (!world.isRemote)
                {
                    world.playAuxSFX(2005, par4, par5, par6, 0);
                }

                return true;
            }

            return false;
        }
    }
	
    public static boolean applyBonemeal(ItemStack itemStack, World world, int x, int y, int z, EntityPlayer player)
    {
        Block block = world.getBlock(x, y, z);

        BonemealEvent event = new BonemealEvent(player, world, block, x, y, z);
        if (MinecraftForge.EVENT_BUS.post(event))
        {
            return false;
        }

        if (event.getResult() == Result.ALLOW)
        {
            if (!world.isRemote)
            {
                itemStack.stackSize--;
            }
            return true;
        }

        if (block instanceof IGrowable)
        {
            IGrowable igrowable = (IGrowable)block;

            if (igrowable.func_149851_a(world, x, y, z, world.isRemote))
            {
                if (!world.isRemote)
                {
                    if (igrowable.func_149852_a(world, world.rand, x, y, z))
                    {
                        igrowable.func_149853_b(world, world.rand, x, y, z);
                    }

                    --itemStack.stackSize;
                }

                return true;
            }
        }

        return false;
    }
}
