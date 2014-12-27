package com.brandon3055.referencemod;

import com.brandon3055.referencemod.lib.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;

/**
 * Created by Brandon on 28/12/2014.
 */
public class ProxyClient extends ProxyCommon {
	@Override
	public void registerRendering() {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

		renderItem.getItemModelMesher().register(ModItems.itemWayPoint, 0, new ModelResourceLocation(References.MODID + ":" + "itemWayPoint", "inventory"));
	}
}
