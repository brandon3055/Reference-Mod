package com.brandon3055.referencemod;

import com.brandon3055.referencemod.lib.References;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = References.MODID, version = References.VERSION)
public class ReferenceMod
{
	@Mod.Instance(References.MODID)
	public static ReferenceMod instance;

	@SidedProxy(clientSide = References.CLIENTPROXYLOCATION, serverSide = References.COMMONPROXYLOCATION)
	public static ProxyCommon proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModItems.init();

		com.brandon3055.referencemod.mbe04_block_inventory_basic.Startup.preInitCommon();
		com.brandon3055.referencemod.mbe05_block_inventory_advanced.Startup.preInitCommon();

		NetworkRegistry.INSTANCE.registerGuiHandler(ReferenceMod.instance, new GuiHandler());
	}

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		proxy.registerRendering();
    }
}
