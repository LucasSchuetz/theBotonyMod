package botanyItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import botanyMain.Base;

public class ItemFangBlade extends ItemSword
{
	private final ToolMaterial enumToolMat;
	
	public ItemFangBlade()
	{
		super(ToolMaterial.IRON);
		
		this.setUnlocalizedName(Base.modid + "_" + "fangBlade");
		this.setTextureName(Base.modid + ":" + "fangBlade");
		
		this.enumToolMat = ToolMaterial.IRON;
		this.setMaxStackSize(1);
		this.setMaxDamage(999);
		
		this.setCreativeTab(Base.tabSometimes);
	}
	
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        if (par2Block == Blocks.web)
        {
            return 15.0F;
        }
        else
        {
            Material material = par2Block.getMaterial();
            return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves ? 1.0F : 1.5F;
        }
    }
    
    public int getItemEnchantability()
    {
        return this.enumToolMat.getEnchantability();
    }
    
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Blocks.web;
    }
    
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }
    
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }
    
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.block;
    }
    
    public boolean isFull3D()
    {
        return true;
    }
}
