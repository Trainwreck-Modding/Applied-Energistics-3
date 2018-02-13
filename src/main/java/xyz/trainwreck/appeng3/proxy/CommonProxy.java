package xyz.trainwreck.appeng3.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xyz.trainwreck.Lib.Reference;
import xyz.trainwreck.Lib.common.registry.RegistryHelper;
import xyz.trainwreck.appeng3.AppliedEnergistics3;


@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event){
        //RegistryHelper.addBlockToRegistry(Reference.MODID, TestBlock.class, TestItemBlock.class);
    }
    public void init(FMLInitializationEvent event){

    }
    public void postInit(FMLPostInitializationEvent event){

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        AppliedEnergistics3.LOGGER.info(RegistryHelper.getBlocks());

        for (Block block : RegistryHelper.getBlocks()){
            event.getRegistry().register(block);
        }

    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (ItemBlock itemBlock : RegistryHelper.getItems())
            event.getRegistry().register(itemBlock);
    }

}