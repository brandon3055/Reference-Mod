package com.brandon3055.referencemod;

import com.brandon3055.referencemod.items.ItemWayPoint;
import com.brandon3055.referencemod.lib.References;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Brandon on 28/12/2014.
 */
@GameRegistry.ObjectHolder(References.MODID)
public class ModItems {

	public static Item itemWayPoint;

	public static void init() {
		itemWayPoint = new ItemWayPoint();
	}

	public static void register(Item item) {
		String name = getUnwrappedUnlocalizedName(item.getUnlocalizedName());
		GameRegistry.registerItem(item, name.substring(name.indexOf(":") + 1));
	}

	public static String getUnwrappedUnlocalizedName(String unlocalizedName){
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
}