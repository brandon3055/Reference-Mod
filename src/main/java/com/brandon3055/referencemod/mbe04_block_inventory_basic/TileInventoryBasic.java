package com.brandon3055.referencemod.mbe04_block_inventory_basic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;

/**
 * User: brandon3055
 * Date: 06/01/2015
 *
 * This is a simple tile entity implementing IInventory that can store 9 item stacks
 */
public class TileInventoryBasic extends TileEntity implements IInventory {
	// Create and initialize the items variable that will store store the items
	ItemStack[] items = new ItemStack[9];




	/* The following are some IInventory methods you are required to override */

	// Gets the number of slots in the inventory
	@Override
	public int getSizeInventory() {
		return items.length;
	}

	// Gets the stack in the given slot
	@Override
	public ItemStack getStackInSlot(int i) {
		return items[i];
	}

	// Reduces the size of the stack in the given slot
	@Override
	public ItemStack decrStackSize(int slot, int count) {
		ItemStack itemstack = getStackInSlot(slot);

		if (itemstack != null) {
			if (itemstack.stackSize <= count) {
				setInventorySlotContents(slot, null);
			} else {
				itemstack = itemstack.splitStack(count);
				if (itemstack.stackSize == 0) {
					setInventorySlotContents(slot, null);
				}
			}
		}
		return itemstack;
	}

	// @TGG I dont recall what this is for
	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		ItemStack item = getStackInSlot(i);
		if (item != null) setInventorySlotContents(i, null);
		return item;
	}

	// Sets the stack in the given slot
	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		items[i] = itemstack;
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
	}

	// This is the maximum number if items allowed in each slot
	// This only affects things such as hoppers trying to insert items you need to use the container to enforce this for players
	// inserting items via the gui
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	// Return true if the given player is able to use this block. In this case it checks that the player isn't too far away
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return player.getDistanceSq(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.4) < 64;
	}

	// Return true if the given stack is allowed to go in the given slot
	// This only affects things such as hoppers trying to insert items you need to use the container to enforce this for players
	// inserting items via the gui
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
	}

	// This is where you save any data that you don't want to loose when the tile entity unloads
	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound); // The super call is required to save and load the tiles location

		// Save the stored item stacks
		NBTTagCompound[] tag = new NBTTagCompound[items.length];

		for (int i = 0; i < items.length; i++)
		{
			tag[i] = new NBTTagCompound();

			if (items[i] != null)
			{
				tag[i] = items[i].writeToNBT(tag[i]);
			}

			compound.setTag("Item" + i, tag[i]);
		}
	}

	// This is where you load the data that you saved in writeToNBT
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound); // The super call is required to save and load the tiles location

		// Load the stored item stacks
		NBTTagCompound[] tag = new NBTTagCompound[items.length];

		for (int i = 0; i < items.length; i++)
		{
			tag[i] = compound.getCompoundTag("Item" + i);
			items[i] = ItemStack.loadItemStackFromNBT(tag[i]);
		}
	}


	// The following methods are not used in this example but are part of IInventory so they must be implemented

	@Override
	public void openInventory(EntityPlayer player) {}

	@Override
	public void closeInventory(EntityPlayer player) {}


	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {
		ItemStack[] items = new ItemStack[9];
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public IChatComponent getDisplayName() {
		return null;
	}
}
