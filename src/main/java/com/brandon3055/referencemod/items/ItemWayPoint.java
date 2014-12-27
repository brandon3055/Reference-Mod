package com.brandon3055.referencemod.items;

import com.brandon3055.referencemod.ModItems;
import com.brandon3055.referencemod.lib.References;
import com.brandon3055.referencemod.lib.Strings;
import com.brandon3055.referencemod.utills.ItemNBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by Brandon on 28/12/2014.
 */
public class ItemWayPoint extends Item {
	public ItemWayPoint() {
		this.setUnlocalizedName(References.RESOURCESPREFIX + Strings.ITEM_WAYPOINT_NAME);
		this.setMaxStackSize(1);
		ModItems.register(this);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if (playerIn.isSneaking())
		{
			ItemNBTHelper.setInteger(itemStackIn, "X", (int)playerIn.posX);
			ItemNBTHelper.setInteger(itemStackIn, "Y", (int)playerIn.posY);
			ItemNBTHelper.setInteger(itemStackIn, "Z", (int)playerIn.posZ);
			ItemNBTHelper.setBoolean(itemStackIn, "Bound", true);
		}
		else if (ItemNBTHelper.getBoolean(itemStackIn, "Bound", false))
		{
			int x = ItemNBTHelper.getInteger(itemStackIn, "X", 0);
			int y = ItemNBTHelper.getInteger(itemStackIn, "Y", 0);
			int z = ItemNBTHelper.getInteger(itemStackIn, "Z", 0);

			playerIn.setPosition(x, y, z);
		}
		else if (worldIn.isRemote)
		{
			playerIn.addChatComponentMessage(new ChatComponentText("Item is not bound to a location! Shift right click to bind to your location"));
		}
		return itemStackIn;
	}

	@SideOnly(Side.CLIENT)
	@SuppressWarnings("unchecked")
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		if (ItemNBTHelper.getBoolean(stack, "Bound", false))
		{
			tooltip.add("Bound to");
			tooltip.add("X: " + ItemNBTHelper.getInteger(stack, "X", 0));
			tooltip.add("Y: " + ItemNBTHelper.getInteger(stack, "Y", 0));
			tooltip.add("Z: " + ItemNBTHelper.getInteger(stack, "Z", 0));
		}
		else
		{
			tooltip.add("Shift Right click to bind to your location");
		}
	}
}
