package com.example.examplemod;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = NoCoolTimeSword.MODID, name = NoCoolTimeSword.NAME, version = NoCoolTimeSword.VERSION, dependencies = NoCoolTimeSword.MOD_DEPENDENCIES, acceptedMinecraftVersions = NoCoolTimeSword.MOD_ACCEPTED_MC_VERSIONS, useMetadata = true)
public class NoCoolTimeSword
{
    public static final String MODID = "no_cooltime_sword";
    public static final String NAME = "NoCoolTime Sword";
    public static final String VERSION = "1.0";
    public static final String MOD_DEPENDENCIES ="required-after:forge@[1.12.2-14.23.2.2611,)";
    public static final String MOD_ACCEPTED_MC_VERSIONS = "[1.12.2]";
    public static final String CLIENT_PROXY_CLASS = "com.clickmanaita.clickmanaita.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "com.clickmanaita.clickmanaita.proxy.CommonProxy";
    public static final String SERVER_PROXY_CLASS = "com.clickmanaita.clickmanaita.proxy.ServerProxy";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
