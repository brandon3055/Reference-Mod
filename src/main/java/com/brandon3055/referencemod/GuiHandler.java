package com.brandon3055.referencemod;


import com.brandon3055.referencemod.mbe04_block_inventory_basic.ContainerBasic;
import com.brandon3055.referencemod.mbe04_block_inventory_basic.GuiInventoryBasic;
import com.brandon3055.referencemod.mbe04_block_inventory_basic.TileInventoryBasic;
import com.brandon3055.referencemod.mbe05_block_inventory_advanced.ContainerAdvanced;
import com.brandon3055.referencemod.mbe05_block_inventory_advanced.GuiInventoryAdvanced;
import com.brandon3055.referencemod.mbe05_block_inventory_advanced.TileInventoryAdvanced;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * User: brandon3055
 * Date: 06/01/2015
 *
 *This class is used to get the client and server gui elements when a player opens a gui. There can only be one gui handler per mod
 */
public class GuiHandler implements IGuiHandler {

	public static final int GUIID_EXAMPLE_BASIC = 0;
	public static final int GUIID_EXAMPLE_ADVANCED = 1;


	// Gets the server side element for the given gui id this should return a container
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case GUIID_EXAMPLE_BASIC : {
				TileInventoryBasic tileInventoryBasic = world.getTileEntity(new BlockPos(x, y, z)) instanceof TileInventoryBasic ? (TileInventoryBasic) world.getTileEntity(new BlockPos(x, y, z)) : null;
				if (tileInventoryBasic != null) return new ContainerBasic(player.inventory, tileInventoryBasic);
			}
			case GUIID_EXAMPLE_ADVANCED : {
				TileInventoryAdvanced tileInventoryAdvanced = world.getTileEntity(new BlockPos(x, y, z)) instanceof TileInventoryAdvanced ? (TileInventoryAdvanced) world.getTileEntity(new BlockPos(x, y, z)) : null;
				if (tileInventoryAdvanced != null) return new ContainerAdvanced(player.inventory, tileInventoryAdvanced);
			}
		}

		return null;
	}

	// Gets the server side element for the given gui id this should return a gui
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case GUIID_EXAMPLE_BASIC : {
				TileInventoryBasic tileInventoryBasic = world.getTileEntity(new BlockPos(x, y, z)) instanceof TileInventoryBasic ? (TileInventoryBasic) world.getTileEntity(new BlockPos(x, y, z)) : null;
				if (tileInventoryBasic != null) return new GuiInventoryBasic(player.inventory, tileInventoryBasic);
			}
			case GUIID_EXAMPLE_ADVANCED : {
				TileInventoryAdvanced tileInventoryAdvanced = world.getTileEntity(new BlockPos(x, y, z)) instanceof TileInventoryAdvanced ? (TileInventoryAdvanced) world.getTileEntity(new BlockPos(x, y, z)) : null;
				if (tileInventoryAdvanced != null) return new GuiInventoryAdvanced(player.inventory, tileInventoryAdvanced);
			}
		}

		return null;
	}

}
