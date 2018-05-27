package com.takusan_23.clickmanaita;

import com.takusan_23.clickmanaita.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = clickmanaita.MOD_ID,
	name = clickmanaita.MOD_NAME,
	version = clickmanaita.MOD_VERSION,
	dependencies = clickmanaita.MOD_DEPENDENCIES,
	acceptedMinecraftVersions = clickmanaita.MOD_ACCEPTED_MC_VERSIONS,
	useMetadata = true)

@EventBusSubscriber
public class clickmanaita {
    public static final String MOD_ID = "clickmanaita";
    public static final String MOD_NAME = "ClickManaita";
    public static final String MOD_VERSION = "1.5";
    public static final String MOD_DEPENDENCIES ="required-after:forge@[1.12.2-14.23.2.2611,)";
    public static final String MOD_ACCEPTED_MC_VERSIONS = "[1.12.2]";
    public static final String CLIENT_PROXY_CLASS = "com.takusan_23.clickmanaita.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "com.takusan_23.clickmanaita.proxy.CommonProxy";
    public static final String SERVER_PROXY_CLASS = "com.takusan_23.clickmanaita.proxy.ServerProxy";

    public static CreativeTabs ClickManaitaTab = new ClickManaitaTab("ClickManaitaTab");

    @SidedProxy(clientSide = clickmanaita.CLIENT_PROXY_CLASS, serverSide = clickmanaita.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Instance(MOD_ID)
    public static clickmanaita Instance;

    @Mod.EventHandler

    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @EventHandler
    private void preInit(FMLPreInitializationEvent event){
    	ClickManaitaItems.init();
    	ClickManaitaItems.register();
    	ClickManaitaBlocks.init();
    	ClickManaitaBlocks.register();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	proxy.init(event);

    }


}
