package xyz.trainwreck.appeng.common.tileentity.tileentitybaces;

import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import xyz.trainwreck.Lib.common.tileentity.TileEntityBase;
import xyz.trainwreck.appeng.AppliedEnergistics3;
import xyz.trainwreck.appeng.api.util.AppliedNetwork;
import xyz.trainwreck.appeng.common.network.NetworkBulder;

public class TE_TileBace extends TileEntityBase implements AppliedNetwork, ITickable {
    NetworkBulder network;


    @Override
    public void upDateNetwork(IBlockAccess access, BlockPos pos) {
        network.addToNetwork(access,pos);
    }

    @Override
    public void update() {
        for (TileEntityBase tile : network.getNetwork()){
            AppliedEnergistics3.LOGGER.info(tile);
        }
    }
}
