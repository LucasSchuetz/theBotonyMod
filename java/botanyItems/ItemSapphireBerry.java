package botanyItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import botanyEntity.EntitySapphireBerry;
import botanyMain.Base;

public class ItemSapphireBerry extends Item
{
	public ItemSapphireBerry()
	{
		super();
		
		this.setUnlocalizedName(Base.modid + "_" + "sapphireBerry");
		this.setTextureName(Base.modid + ":" + "sapphireBerry");
		
		this.setMaxStackSize(16);
		
		this.setCreativeTab(Base.tabSometimes);
	}
	
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!par2World.isRemote)
        {
            par2World.spawnEntityInWorld(new EntitySapphireBerry(par2World, par3EntityPlayer));
        }

        return par1ItemStack;
    }
}