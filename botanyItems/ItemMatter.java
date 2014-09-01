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

public class ItemMatter extends Item
{
	public static final String[] matterNames = new String [] {
		"decomposing", "gelatinous", "proteinBall",
		"vileMatter"};
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	public ItemMatter()
	{
		super();
		
		this.setUnlocalizedName(Base.modid + "_" + "matter");
		this.setTextureName(Base.modid + ":" + "matter");
		
		this.setHasSubtypes(true);
		this.setCreativeTab(Base.tabSometimes);
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
		
		return super.getUnlocalizedName() + "." + matterNames[i];
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List list)
	{
		for(int x = 0; x < matterNames.length; x++)
		{
			list.add(new ItemStack(this, 1, x));
		}
	}
	
	@Override
	public void registerIcons(IIconRegister icon)
	{
		icons = new IIcon[matterNames.length];
		
		for(int i =  0; i < icons.length; i++)
		{
			icons[i] = icon.registerIcon(Base.modid + ":" + "matter" + "/" + matterNames[i]);
		}
	}
}
