package com.brandon3055.referencemod;

import com.brandon3055.referencemod.lib.References;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MODID, version = References.VERSION)
public class ReferenceMod
{
	@SidedProxy(clientSide = References.CLIENTPROXYLOCATION, serverSide = References.COMMONPROXYLOCATION)
	public static ProxyCommon proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModItems.init();

	}

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		proxy.registerRendering();
    }
}
