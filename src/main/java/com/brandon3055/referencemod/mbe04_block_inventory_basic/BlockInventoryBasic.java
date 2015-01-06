package com.brandon3055.referencemod.mbe04_block_inventory_basic;

import com.brandon3055.referencemod.GuiHandler;
import com.brandon3055.referencemod.ReferenceMod;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;


/**
 * User: brandon3055
 * Date: 06/01/2015
 *
 * BlockInventoryBasic is a simple inventory capable of storing 9 item stacks. The block itself doesn't actually store anything
 * the storage is handles by the associated tile entity. The block itself just creates said tile entity and opens the gui when right clicked.
 */
public class BlockInventoryBasic extends BlockContainer
{
	public BlockInventoryBasic()
	{
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	// Called when the block is placed or loaded client side to get the tile entity for the block
	// Should return a new instance of the tile entity for the block
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileInventoryBasic();
	}

	// Called when the block is right clicked
	// In this block it is used to open the blocks gui when right clicked by a player
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		// Uses the gui handler registered to your mod to open the gui for the given gui id
		playerIn.openGui(ReferenceMod.instance, GuiHandler.GUIID_EXAMPLE_BASIC, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
}
