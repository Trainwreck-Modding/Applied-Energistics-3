package xyz.trainwreck.appeng.api.util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public interface AppliedNetwork {
    void upDateNetwork(IBlockAccess access, BlockPos pos);
}
