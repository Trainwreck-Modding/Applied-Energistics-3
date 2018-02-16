package xyz.trainwreck.appeng.common.tileentity.tileentitybases;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import xyz.trainwreck.Lib.common.tileentity.TileEntityBase;
import xyz.trainwreck.appeng.AppliedEnergistics3;
import xyz.trainwreck.appeng.api.util.AppliedNetwork;
import xyz.trainwreck.appeng.common.network.NetworkBulder;

public class TE_TileBase extends TileEntityBase implements AppliedNetwork, ITickable {
    NetworkBulder network = new NetworkBulder();


    @Override
    public void upDateNetwork() {
        network.addToNetwork(getWorld(),getPos());
    }

    @Override
    public void update() {
        for (TileEntity tile : network.getNetwork()){
            AppliedEnergistics3.LOGGER.info(tile);
        }
    }
}
