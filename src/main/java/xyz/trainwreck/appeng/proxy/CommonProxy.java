package xyz.trainwreck.appeng.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xyz.trainwreck.Lib.common.registry.RegistryHelper;
import xyz.trainwreck.appeng.AppliedEnergistics3;
import xyz.trainwreck.appeng.common.blocks.Blocks;

@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        Blocks.registerBlocks();
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        for (Block block : RegistryHelper.getBlocks()) {
            AppliedEnergistics3.LOGGER.info(block.getUnlocalizedName());
            event.getRegistry().register(block);
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (Item item : RegistryHelper.getItems()) {
            AppliedEnergistics3.LOGGER.info(item.getUnlocalizedName());
            event.getRegistry().register(item);
        }
    }
}
