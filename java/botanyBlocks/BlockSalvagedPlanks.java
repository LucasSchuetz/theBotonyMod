package botanyBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import botanyMain.Base;

public class BlockSalvagedPlanks extends Block
{
	public BlockSalvagedPlanks()
	{
		super(Material.wood);
		
		this.setBlockName(Base.modid + "_" + "salvagedPlanks");
		this.setBlockTextureName(Base.modid + ":" + "salvagedPlanks");
		
		this.setHardness(2.5F);
		this.setCreativeTab(Base.tabSometimes);
	}
}
