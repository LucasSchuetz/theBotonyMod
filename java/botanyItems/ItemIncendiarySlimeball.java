package botanyItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import botanyMain.Base;

public class ItemIncendiarySlimeball extends Item
{
	public ItemIncendiarySlimeball()
	{
		super();
		
		this.setUnlocalizedName(Base.modid + "_" + "incendiarySlimeball");
		this.setTextureName(Base.modid + ":" + "incendiarySlimeball");
		
		this.setMaxStackSize(16);
//		this.setCreativeTab(Base.tabSometimes);
	}
	
	//Throws Ghast-like Fireball
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if (!player.capabilities.isCreativeMode)
        {
            --itemStack.stackSize;
        }

        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
  
        if (!world.isRemote)
        {
            player.motionX = (double)(-MathHelper.sin(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI));
            player.motionZ = (double)(MathHelper.cos(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI));
            player.motionY = (double)(-MathHelper.sin(player.rotationPitch / 180.0F * (float)Math.PI));
        	
            world.spawnEntityInWorld(new EntityLargeFireball(world, player, player.motionX, player.motionY, player.motionZ));
        }

        return itemStack;
    }
}
