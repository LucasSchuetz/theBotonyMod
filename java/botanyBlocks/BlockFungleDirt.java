package botanyBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import botanyMain.Base;

public class BlockFungleDirt extends Block
{
	public BlockFungleDirt()
	{
		super(Material.ground);
		
		this.setBlockName(Base.modid + "_" + "fungleDirt");
		this.setBlockTextureName(Base.modid + ":" + "fungleSoil");
		
		this.setStepSound(Block.soundTypeSnow);
		this.setCreativeTab(Base.tabSometimes);
		this.setHarvestLevel("shovel", 0);
		this.setHardness(0.5F);
	}
}
