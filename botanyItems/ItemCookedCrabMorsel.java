package botanyItems;

import net.minecraft.item.ItemFood;
import botanyMain.Base;

public class ItemCookedCrabMorsel extends ItemFood
{
    public ItemCookedCrabMorsel(int healAmount, float saturationAmount, boolean wolfFood)
    {
        super(healAmount, saturationAmount, wolfFood); 
        this.setAlwaysEdible();
        
        this.setUnlocalizedName(Base.modid + "_" + "cookedCrabMorsel");
        this.setTextureName(Base.modid + ":" + "cookedCrabMorsel");
        
        this.setCreativeTab(Base.tabSometimes);
    }
}
