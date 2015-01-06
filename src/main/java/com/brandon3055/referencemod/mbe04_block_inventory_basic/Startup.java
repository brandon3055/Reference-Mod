package com.brandon3055.referencemod.mbe04_block_inventory_basic;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * User: brandon3055
 * Date: 06/01/2015
 *
 * The Startup class for this example is called during startup, in the following order:
 *  preInitCommon
 *  preInitClientOnly
 *  initCommon
 *  initClientOnly
 *  postInitCommon
 *  postInitClientOnly
 *  See MinecraftByExample class for more information
 */
public class Startup
{
	public static Block blockInventoryBasic;  // this holds the unique instance of your block

	public static void preInitCommon()
	{
		// each instance of your block should have a name that is unique within your mod.  use lower case.
		blockInventoryBasic = new BlockInventoryBasic().setUnlocalizedName("mbe04_block_inventory_basic");
		GameRegistry.registerBlock(blockInventoryBasic, "mbe04_block_inventory_basic");
		// Each of your tile entities needs to be registered with a name that is unique to your mod.
		GameRegistry.registerTileEntity(TileInventoryBasic.class, "mbe04_tile_inventory_basic");
		// you don't need to register an item corresponding to the block, GameRegistry.registerBlock does this automatically.
	}

	public static void preInitClientOnly()
	{

	}

	public static void initCommon()
	{

	}

	public static void initClientOnly()
	{
		// This is currently necessary in order to make your block render properly when it is an item (i.e. in the inventory
		//   or in your hand or thrown on the ground).
		// Minecraft knows to look for the item model based on the GameRegistry.registerBlock.  However the registration of
		//  the model for each item is normally done by RenderItem.registerItems(), and this is not currently aware
		//   of any extra items you have created.  Hence you have to do it manually.  This will probably change in future.
		// It must be done in the init phase, not preinit, and must be done on client only.
//		Item itemBlockSimple = GameRegistry.findItem("minecraftbyexample", "mbe01_block_simple");
//		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("minecraftbyexample:mbe01_block_simple", "inventory");
//		final int DEFAULT_ITEM_SUBTYPE = 0;
//		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockSimple, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
	}

	public static void postInitCommon()
	{

	}

	public static void postInitClientOnly()
	{

	}

}
