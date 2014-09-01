package botanyBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import botanyMain.Base;

public class BlockRottenPlanks extends Block
{
	public BlockRottenPlanks()
	{
		super(Material.wood);
		
		this.setBlockName(Base.modid + "_" + "rottenPlanks");
		this.setBlockTextureName(Base.modid + ":" + "rottenPlanks");
		
		this.setHardness(2.5F);
		this.setCreativeTab(Base.tabSometimes);
	}
}
