package com.takusan_23.clickmanaita.proxy;

import com.takusan_23.clickmanaita.ClickManaitaBlocks;
import com.takusan_23.clickmanaita.ClickManaitaItems;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		ClickManaitaItems.init();
		ClickManaitaItems.register();
        ClickManaitaBlocks.init();
        ClickManaitaBlocks.register();
	}

	public void init(FMLInitializationEvent event) {
	}

	public void postInit(FMLPostInitializationEvent event) {

	}

}
