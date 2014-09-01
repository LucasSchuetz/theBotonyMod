package botanyBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import botanyMain.Base;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFungleGrass extends Block implements IGrowable
{
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	@SideOnly(Side.CLIENT)
	private IIcon iconSnowSide;
	@SideOnly(Side.CLIENT)
	private IIcon iconSide;
	
	public BlockFungleGrass()
	{
		super(Material.grass);
		
		this.setBlockName(Base.modid + "_" + "fungleGrass");
		this.setBlockTextureName(Base.modid + ":" + "fungleGrass");
		
		this.setStepSound(Block.soundTypeGrass);
		this.setTickRandomly(true);
		this.setCreativeTab(Base.tabSometimes);
		this.setHarvestLevel("shovel", 0);
		this.setHardness(0.5F);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return side == 1 ? this.iconTop : (side == 0 ? Base.blockFungleDirt.getBlockTextureFromSide(side) : this.blockIcon);
	}
	
	@Override
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
        if (!world.isRemote)
        {
            if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2)
            {
                world.setBlock(x, y, z, Blocks.dirt);
            }
            else if (world.getBlockLightValue(x, y + 1, z) >= 9)
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = x + rand.nextInt(3) - 1;
                    int j1 = y + rand.nextInt(5) - 3;
                    int k1 = z + rand.nextInt(3) - 1;
//                    Block block = world.getBlock(i1, j1 + 1, k1); <-- Unused apparently

                    if (world.getBlock(i1, j1, k1) == Base.blockFungleDirt && world.getBlockMetadata(i1, j1, k1) == 0 && world.getBlockLightValue(i1, j1 + 1, k1) >= 4 && world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                        world.setBlock(i1, j1, k1, Base.blockFungleGrass);
                    }
                }
            }
        }
    }
	
	@Override
    public Item getItemDropped(int num, Random rand, int num1)
    {
        return Base.blockFungleDirt.getItemDropped(0, rand, num1);
    }

	//Used by vanilla grass, no idea what they do...seem to only return true
	@Override
    public boolean func_149851_a(World world, int x, int y, int z, boolean bool)
    {
        return true;
    }

	//Used by vanilla grass, no idea what they do...seem to only return true
    @Override
    public boolean func_149852_a(World world, Random rand, int x, int y, int z)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(IBlockAccess block, int x, int y, int z, int num)
    {
        if (num == 1)
        {
            return this.iconTop;
        }
        else if (num == 0)
        {
            return Blocks.dirt.getBlockTextureFromSide(num);
        }
        else
        {
            Material material = block.getBlock(x, y + 1, z).getMaterial();
            return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.iconSnowSide;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(this.getTextureName() + "_side");
        this.iconTop = p_149651_1_.registerIcon(this.getTextureName() + "_top");
        this.iconSnowSide = p_149651_1_.registerIcon(this.getTextureName() + "_snow");
    }

    //Checks for block above, not allowed to change method name, required for IGrowable
	@Override
	public void func_149853_b(World world, Random rand, int x, int y, int z)
	{
        int l = 0;

        while (l < 128)
        {
            int i1 = x;
            int j1 = y + 1;
            int k1 = z;
            int l1 = 0;

            while (true)
            {
                if (l1 < l / 16)
                {
                    i1 += rand.nextInt(3) - 1;
                    j1 += (rand.nextInt(3) - 1) * rand.nextInt(3) / 2;
                    k1 += rand.nextInt(3) - 1;

                    if (world.getBlock(i1, j1 - 1, k1) == Blocks.grass && !world.getBlock(i1, j1, k1).isNormalCube())
                    {
                        ++l1;
                        continue;
                    }
                }
                else if (world.getBlock(i1, j1, k1).getMaterial() == Material.air)
                {
                    if (rand.nextInt(8) != 0)
                    {
                        if (Blocks.tallgrass.canBlockStay(world, i1, j1, k1))
                        {
                            world.setBlock(i1, j1, k1, Blocks.tallgrass, 1, 3);
                        }
                    }
                    else
                    {
                        world.getBiomeGenForCoords(i1, k1).plantFlower(world, rand, i1, j1, k1);
                    }
                }

                ++l;
                break;
            }
        }
	}
}
