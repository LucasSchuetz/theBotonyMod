package botanyItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import botanyMain.Base;

public class ItemCleansingPowder extends Item
{
    public ItemCleansingPowder()
    {
        super();
        
        this.setUnlocalizedName(Base.modid + "_" + "cleansingPowder");
        this.setTextureName(Base.modid + ":" + "cleansingPowder");
        
        this.setCreativeTab(Base.tabSometimes);
    }

    
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
    {
        if (!player.capabilities.isCreativeMode)
        {
            --stack.stackSize;
        }
    	
        if (!world.isRemote)
        {
        	//removes following potion effects: Hunger, Poison, Weakness
        	for(int i = 17; i < 20; i++)
        		player.removePotionEffect(i);
        }
        
        return stack;
    }
    
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 32;
    }

    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.drink;
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        return stack;
    }
}