package botanyItems;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import botanyMain.Base;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMobPart extends Item
{
	public static final String[] partNames = new String [] {
		"cowUtter", "creeperMouth", "pigSnout", "sheepLeg", "skeletonRibcage", "plantGreens",
		"basiliskFang", "basiliskHide", "basiliskScale", "strangeBarb", "largeGreenScale"};
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	public ItemMobPart()
	{
		super();
		
		this.setUnlocalizedName(Base.modid + "_" + "mobPart");
		this.setTextureName(Base.modid + ":" + "mobPart");
		
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setCreativeTab(Base.tabSometimes);
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int damage)
	{
		return icons[damage];
	}
	
	public String getUnlocalizedName(ItemStack itemStack)
	{
		int i = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 15);
		
		return this.getUnlocalizedName() + "." + partNames[i];
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List list)
	{
        for (int i = 0; i < partNames.length; ++i)
        {
            list.add(new ItemStack(item, 1, i));
        }
	}
	
	@Override
	public void registerIcons(IIconRegister icon)
	{
		icons = new IIcon[partNames.length];
		
		for(int i =  0; i < icons.length; i++)
		{
			icons[i] = icon.registerIcon(Base.modid + ":" + "mobParts" + "/" + partNames[i]);
		}
	}
}
