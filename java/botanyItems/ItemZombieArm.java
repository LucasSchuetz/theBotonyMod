package botanyItems;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import botanyMain.Base;

public class ItemZombieArm extends ItemFood
{
    public ItemZombieArm(int healAmount, float saturationAmount, boolean wolfFood)
    {
        super(healAmount, saturationAmount, wolfFood); 
        this.setAlwaysEdible();
        
        this.setUnlocalizedName(Base.modid + "_" + "zombieArm");
        this.setTextureName(Base.modid + ":" + "zombieArm");
        
        this.setCreativeTab(Base.tabSometimes);
    }

    public void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
    {
    	Random rand = new Random();
    	
        super.onFoodEaten(stack, world, player);
        if (!world.isRemote)
        { 
        	//Gives a 40% chance to get effect
            if(rand.nextInt(2) == 0)
            {
            	player.addPotionEffect(new PotionEffect(Potion.poison.id, 30, 0));
            }
        }
    }
}