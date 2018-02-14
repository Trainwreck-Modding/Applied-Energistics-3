package xyz.trainwreck.appeng3;

import com.google.common.base.Stopwatch;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.SystemUtils;
import xyz.trainwreck.Lib.common.exception.OutdatedJavaException;
import xyz.trainwreck.Lib.common.util.Logger;
import xyz.trainwreck.appeng3.proxy.CommonProxy;

import java.util.concurrent.TimeUnit;
@Mod(modid = Reference.MODID, version = Reference.VERSION, name = Reference.MOD_NAME,dependencies = Reference.DEPENDENCIES)
public class AppliedEnergistics3 {

    @SidedProxy(clientSide = "xyz.trainwreck.appeng3.proxy.ClientProxy", serverSide = "xyz.trainwreck.appeng3.proxy.ServerProxy")
    public static CommonProxy proxy;


    public static Logger LOGGER = new Logger(Reference.MOD_NAME);
    public static Stopwatch STOPWATCH = Stopwatch.createUnstarted();




    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        STOPWATCH.start();
        LOGGER.info("[Pre-Init] Started");

        if (!SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_8)) {
            throw new OutdatedJavaException(String.format("%s requires Java 8 or newer, Please update your java", Reference.MOD_NAME));
        }

        proxy.preInit(event);
        LOGGER.info("[Pre-Init] Finished <" + STOPWATCH.elapsed(TimeUnit.MILLISECONDS) + "ms>");
        STOPWATCH.reset();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        STOPWATCH.start();
        LOGGER.info("[Init] Started");

        proxy.init(event);
        LOGGER.info("[Init] Finished <" + STOPWATCH.elapsed(TimeUnit.MILLISECONDS) + "ms>");
        STOPWATCH.reset();
    }

    @Mod.EventHandler
    public void preInit(FMLPostInitializationEvent event) {
        STOPWATCH.start();
        LOGGER.info("[Post-Init] Started");

        proxy.postInit(event);
        LOGGER.info("[Post-Init] Finished <" + STOPWATCH.elapsed(TimeUnit.MILLISECONDS) + "ms>");
        STOPWATCH.reset();
    }
}
