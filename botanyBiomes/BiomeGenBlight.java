package botanyBiomes;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import botanyMain.Base;
import botanyWorldGen.WorldGenInfectedTree;
import botanyWorldGen.WorldGenMushroomGiant;

public class BiomeGenBlight extends BiomeGenBase
{	
	public BiomeGenBlight(int id)
	{
		super(id);
		
		this.setBiomeName("Blight");
		
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.waterColorMultiplier = 0x00CC33;
        this.setTemperatureRainfall(1.0F, 1.0F);
        this.theBiomeDecorator.treesPerChunk = -100; //removes vanilla trees from spawning
		
		this.topBlock = Base.blockFungleGrass; //sets top block for biome
		this.fillerBlock = Base.blockFungleDirt; //sets filler (2-5 deep) block, below top but above stone
	}
	
//    @SideOnly(Side.CLIENT)
//    public int getBiomeGrassColor()
//    {
//        double d0 = (double)this.getFloatTemperature(0, 0, 0); //Newly added arguments
//        double d1 = (double)this.getFloatRainfall();
//        return ((ColorizerGrass.getGrassColor(d0, d1) & 16711422) + 5115470) / 2;
//    }
	
    public void decorate(World world, Random rand, int x, int z)
    {
        super.decorate(world, rand, x, z);

        int k = x + rand.nextInt(16) + 8;
        int l = z + rand.nextInt(16) + 8;
        WorldGenInfectedTree worldgeninfectedtree = new WorldGenInfectedTree(false);
        worldgeninfectedtree.generate(world, rand, k, world.getHeightValue(k, l), l);

        k = x + rand.nextInt(16) + 8;
        l = z + rand.nextInt(16) + 8;
        WorldGenMushroomGiant worldgenmushroomgiant = new WorldGenMushroomGiant(false);
        worldgenmushroomgiant.generate(world, rand, k, world.getHeightValue(k, l), l);
    }
}
