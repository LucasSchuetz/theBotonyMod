package botanyItems;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import botanyMain.Base;

public class ItemCrabMorsel extends ItemFood
{
    public ItemCrabMorsel(int healAmount, float saturationAmount, boolean wolfFood)
    {
        super(healAmount, saturationAmount, wolfFood); 
        this.setAlwaysEdible();
        
        this.setUnlocalizedName(Base.modid + "_" + "crabMorsel");
        this.setTextureName(Base.modid + ":" + "crabMorsel");
        
        this.setCreativeTab(Base.tabSometimes);
    }

    public void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
    {
    	Random rand = new Random();
    	
        super.onFoodEaten(stack, world, player);
        if (!world.isRemote)
        {
            if(rand.nextInt(10) > 3)
            {
            	player.addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 0));
            }
            player.addPotionEffect(new PotionEffect(Potion.hunger.id, 350, 0));
        }
    }
}
