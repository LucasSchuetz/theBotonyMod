package botanyMain;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

/** Crafting Recipe Skeletons **
 * Shapeless Recipe:
 * 	GameRegistry.addShapelessRecipe(new ItemStack(Base.Blocks/Items, X, Y), new Object[]{
 * 		new ItemStack(Items.whatever), new ItemStack(Blocks.whatever)
 * 
 * 		-- Can use as many as necessary (up to 9 obviously), X = quantity, Y = metadata is needed. First
 * parameter is what Items is returned (can return more than one!) and second is new object that contains
 * whatever Blockss are used to make the output, can take more then one and use metadatas.
 * 
 * Shaped Recipe:
 * 	GameRegistry.addRecipe(new ItemStack(Base.Blocks/Items), new Object[]{
 * 		"CRC",
 * 		"RZR",
 *		"CRC",
 *	'C', Items.whatever, 'R', Blocks.whatever, 'Z', new ItemStack(Base.whatever, X, Y)});
 *
 *		-- Can use up to 9 as well, X = quantity, Y = metadata. Clearly laid out for easy to read. Shows
 * the crafting table in a 3x3. First parameter is output, amount and metas CAN be included but are not 
 * required, second parameter is the crafting table part. 
 * 
 */

public class Crafting
{
	public static void addRecipes()
	{
		GameRegistry.addShapedRecipe(new ItemStack(Base.itemThornedBranch), new Object[]{
			"ZXZ",
			"YXY",
			"ZXZ",
			'Z', new ItemStack(Blocks.vine), 'Y', new ItemStack(Blocks.cactus), 'X', new ItemStack(Items.stick)});
		GameRegistry.addShapedRecipe(new ItemStack(Base.itemVileFlesh), new Object[]{
			"Z",
			"Y",
			"X",
			'Z', new ItemStack(Items.potionitem, 1, 0), 'Y', new ItemStack(Base.itemMatter, 1, 3), 'X', new ItemStack(Items.rotten_flesh)});
		GameRegistry.addShapedRecipe(new ItemStack(Base.blockSalvagedPlanks, 2), new Object[]{
			"XX",
			"XX",
			'X', new ItemStack(Base.blockRottenPlanks)});
		GameRegistry.addShapedRecipe(new ItemStack(Base.blockGemGlass, 2), new Object[]{
			"XX",
			"XX",
			'X', new ItemStack(Base.itemMobPart, 1, 12)});
		GameRegistry.addShapedRecipe(new ItemStack(Base.itemFangBlade, 2), new Object[]{
			"X",
			"X",
			"Y",
			'X', new ItemStack(Base.itemMobPart, 1, 7), 'Y', new ItemStack(Items.stick)});
		GameRegistry.addShapedRecipe(new ItemStack(Base.blockGemGlass, 2), new Object[]{
			"XX",
			"XX",
			'X', new ItemStack(Base.itemGemRootShard)});
		GameRegistry.addShapelessRecipe(new ItemStack(Base.blockRottenPlanks, 4), new Object[]{
			new ItemStack(Base.blockInfectedLog)});
		GameRegistry.addShapelessRecipe(new ItemStack(Base.blockShroomWood, 4), new Object[]{
			new ItemStack(Base.blockBlueMushroomStem)});
		GameRegistry.addShapelessRecipe(new ItemStack(Base.itemMatter, 1, 3), new Object[]{
			new ItemStack(Base.blockVileMushroom)});
		GameRegistry.addShapelessRecipe(new ItemStack(Base.itemGemRootShard, 2), new Object[]{
			new ItemStack(Base.blockGemRoot)});
		
		BiologyCrafting();
		SmeltingRecipes();
	}
	
	//Recipes for Photo mod module
	public static void BiologyCrafting()
	{		
		//Compost recipe loop for each metadata'ed mobPart
		// 3 Paper, 3 Plant Greens, and 3 of any other mob part
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				for(int k = 0; k < 6; k++)
				{
					ItemStack iMobPart = new ItemStack(Base.itemMobPart, 1, i);
					ItemStack jMobPart = new ItemStack(Base.itemMobPart, 1, j);
					ItemStack kMobPart = new ItemStack(Base.itemMobPart, 1, k);
					
					GameRegistry.addShapelessRecipe(new ItemStack(Base.itemCompost), new Object[]{
						new ItemStack(Items.paper), new ItemStack(Items.paper), new ItemStack(Items.paper), 
						iMobPart, jMobPart, kMobPart, 
						new ItemStack(Base.itemMobPart, 1, 6), new ItemStack(Base.itemMobPart, 1, 5), new ItemStack(Base.itemMobPart, 1, 6)});
				}
			}
		}
		
		GameRegistry.addShapedRecipe(new ItemStack(Base.itemThornedBranch), new Object[]{
			"ZXZ",
			"YXY",
			"ZXZ",
			'Z', new ItemStack(Blocks.vine), 'Y', new ItemStack(Blocks.cactus), 'X', new ItemStack(Items.stick)});
		GameRegistry.addShapedRecipe(new ItemStack(Base.itemStoneCrown), new Object[]{
			"XYX",
			"XZX", 
			"XXX",
			'Y', new ItemStack(Blocks.soul_sand), 'Z', new ItemStack(Blocks.enchanting_table), 'X', new ItemStack(Blocks.stonebrick)});
		GameRegistry.addShapedRecipe(new ItemStack(Base.blockCropStaff), new Object[]{
			"  Z",
			" Y ",
			"X  ",
			'X', new ItemStack(Base.itemThornedBranch), 'Y', new ItemStack(Items.slime_ball), 'Z', new ItemStack(Base.itemStoneCrown)});
		GameRegistry.addShapedRecipe(new ItemStack(Base.blockLifeBasin), new Object[]{
			"XWX",
			"ZYZ",
			"XVX",
			'X', new ItemStack(Items.bone), 'Y', new ItemStack(Blocks.glass), 'Z', new ItemStack(Blocks.soul_sand),
			'V', new ItemStack(Blocks.hopper), 'W', new ItemStack(Blocks.daylight_detector)});
		GameRegistry.addShapelessRecipe(new ItemStack(Base.blockFungleGrass, 4), new Object[]{
			new ItemStack(Blocks.dirt), new ItemStack(Blocks.dirt), new ItemStack(Blocks.dirt),
			new ItemStack(Blocks.red_mushroom), new ItemStack(Blocks.red_mushroom), new ItemStack(Blocks.red_mushroom),
			new ItemStack(Blocks.brown_mushroom), new ItemStack(Blocks.brown_mushroom), new ItemStack(Blocks.brown_mushroom)});
	}
	
	/**
	 * Smelting Recipe:
	 * 	GameRegistry.addSmelting(input, new ItemStack(output), exp);
	 * 
	 * 	--- OTHER NOTES --- 
	 *  /-\Recipes also may allow for enchants in output and input but declaring it as a new variable (shown below)/-\
	 *  
	 *		-- ItemStack enchanted = new ItemStack(Items.pickaxeStone);
	 * 		-- enchanted.addEnchantment(Enchantment.sharpness, 2);
	 * 
	 * 2 being the level of the enchant and sharpness being the enchant type. Enchants the Items declared about it.
	 * The Items, enchant, and level may be changed! These are only examples!
	 **/
	
	public static void SmeltingRecipes()
	{
		GameRegistry.addSmelting(Base.itemCrabMorsel, new ItemStack(Base.itemCookedCrabMorsel), 0.2F);
	}
}