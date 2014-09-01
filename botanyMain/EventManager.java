package botanyMain;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class EventManager implements IWorldGenerator
{
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGen, IChunkProvider chunkProvider)
	{
		//Called for biome generation
		BiomeGen(rand, chunkX, chunkZ, world, chunkGen, chunkProvider);
		
		//Called for the instance of dimension given.
		switch(world.provider.dimensionId)
		{
		case -1: generateNether (world, rand, chunkX*16, chunkZ*16);
		case 0 : generateSurface(world, rand, chunkX*16, chunkZ*16);
		case 1 : generateEnd    (world, rand, chunkX*16, chunkZ*16);
		}
	}

	//Generation for Nether
	private void generateNether(World world, Random rand, int x, int z)
	{
		
	}
	
	//Generation for Overworld
	private void generateSurface(World world, Random rand, int x, int z)
	{
//		this.addOreSpawn(Base.blockLavaInfusedStone, world, rand, x, z, 16, 16, 4 + rand.nextInt(4), 5, 1, 100);
	}
	
	//Generation for End
	private void generateEnd(World world, Random rand, int x, int z)
	{
		
	}
	
	private void addOreSpawn(Block block, World world, Random rand, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{
		int maxPossY = minY + (maxY - 1);
		int diffBtwnMinMaxY = maxY - minY;
		
		assert maxY > minY : "The maximum Y must be greater than the minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The maximum X must be greater than 0 and less than 16.";
		assert minY > 0 : "addOreSpawn: The minimum Y must be greater than 0.";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The max Y value but must be between 0 and 256.";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The maximum Z must be greater than 0 and less than 16.";
		
		for(int i = 0; i < chancesToSpawn; i++)
		{
			int posX = blockXPos + rand.nextInt(maxX);
			int posY = minY + rand.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + rand.nextInt(maxZ);
			
			new WorldGenMinable(block, maxVeinSize).generate(world, rand, posX, posY, posZ);
		}
	}
	
	private void addFlowerSpawn(Block block, World world, Random rand, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{
		int diffBtwnMinMaxY = maxY - minY;
		
		assert maxY > minY : "The maximum Y must be greater than the minimum Y";
		assert maxX > 0 && maxX <= 16 : "addFlowerSpawn: The maximum X must be greater than 0 and less than 16.";
		assert minY > 0 : "addFlowerSpawn: The minimum Y must be greater than 0.";
		assert maxY < 256 && maxY > 0 : "addFlowerSpawn: The max Y value but must be between 0 and 256.";
		assert maxZ > 0 && maxZ <= 16 : "addFlowerSpawn: The maximum Z must be greater than 0 and less than 16.";
		
		for(int i = 0; i < chancesToSpawn; i++)
		{
			int posX = blockXPos + rand.nextInt(maxX);
			int posY = minY + rand.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + rand.nextInt(maxZ);
			
			new WorldGenFlowers(block).generate(world, rand, posX, posY, posZ);
		}
	}
	
	//Biome Specific Generation
	private void BiomeGen(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGen, IChunkProvider chunkProvider)
	{
		BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
		
		if(b.biomeName.equals("Ocean")) {}
		if(b.biomeName.equals("Plains")) {}
		if(b.biomeName.equals("Desert")) {}
		if(b.biomeName.equals("Extreme Hills")) {}
		if(b.biomeName.equals("Forest")) {}
		if(b.biomeName.equals("Tiaga")) {}
		if(b.biomeName.equals("Swampland")) 
		{
			this.addFlowerSpawn(Base.blockVileMushroom, world, rand, chunkX * 16, chunkZ * 16, 16, 16, 1 + rand.nextInt(2), 10, 10, 150);
		}
		if(b.biomeName.equals("River")) {}
		if(b.biomeName.equals("Hell")) {}
		if(b.biomeName.equals("Sky")) {}
		if(b.biomeName.equals("FrozenOcean")) {}
		if(b.biomeName.equals("FrozenRiver")) {}
		if(b.biomeName.equals("Ice Plains")) {}
		if(b.biomeName.equals("Ice Mountains")) {}
		if(b.biomeName.equals("MushroomIsland")) {}
		if(b.biomeName.equals("MushroomIslandShore")) {}
		if(b.biomeName.equals("Beach")) {}
		if(b.biomeName.equals("DesertHills")) {}
		if(b.biomeName.equals("ForestHills")) {}
		if(b.biomeName.equals("TiagaHills")) {}
		if(b.biomeName.equals("Extreme Hills Edge")) {}
		if(b.biomeName.equals("Jungle")) {}
		if(b.biomeName.equals("JungleHills")) {}
		
		if(b.biomeName.equals("Blight"))
		{
			this.addFlowerSpawn(Base.blockVileMushroom, world, rand, chunkX * 16, chunkZ * 16, 16, 16, 1 + rand.nextInt(2), 2, 40, 150);
			this.addFlowerSpawn(Base.blockGemRoot, world, rand, chunkX * 16, chunkZ * 16, 16, 16, 1 + rand.nextInt(2), 2, 40, 150);
		}
	}
}
