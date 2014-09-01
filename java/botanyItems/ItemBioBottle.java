package botanyItems;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import botanyMain.Base;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBioBottle extends Item
{
	public static final String[] bottleNames = new String [] {
		"empty", "full"};
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	public ItemBioBottle()
	{
		super();
		
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
		
		this.setUnlocalizedName(Base.modid + "_" + "bioBottle");
		this.setTextureName(Base.modid + ":" + "bioBottle");
		
//		this.setCreativeTab(Base.tabSometimes);
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int damage)
	{
		return icons[damage];
	}
	
	public void registerIcons(IIconRegister icon)
	{
		icons = new IIcon[bottleNames.length];
		
		for(int i =  0; i < icons.length; i++)
		{
			icons[i] = icon.registerIcon(Base.modid + ":" + "bioBottle" + "_" + bottleNames[i]);
		}
	}
	
	public void getSubItems(int num, CreativeTabs creativeTab, List list)
	{
		for(int x = 0; x < bottleNames.length; x++)
		{
			list.add(new ItemStack(this, 1, x));
		}
	}
}
