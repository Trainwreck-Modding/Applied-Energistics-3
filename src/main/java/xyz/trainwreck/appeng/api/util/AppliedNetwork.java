package xyz.trainwreck.appeng.api.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import xyz.trainwreck.appeng.common.network.NetworkBuilder;

public interface AppliedNetwork {
    void upDateNetwork(IBlockAccess access, BlockPos pos);

    NetworkBuilder getNetworkBulder();

    void setNetworkBulder(NetworkBuilder networkBulder);
}
