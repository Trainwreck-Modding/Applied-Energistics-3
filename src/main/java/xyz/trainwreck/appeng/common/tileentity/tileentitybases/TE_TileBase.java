package xyz.trainwreck.appeng.common.tileentity.tileentitybases;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import xyz.trainwreck.Lib.common.tileentity.TileEntityBase;
import xyz.trainwreck.appeng.AppliedEnergistics3;
import xyz.trainwreck.appeng.api.util.AppliedNetwork;
import xyz.trainwreck.appeng.common.network.NetworkBuilder;

public class TE_TileBase extends TileEntityBase implements AppliedNetwork, ITickable {
    protected NetworkBuilder network = new NetworkBuilder(this);

    @Override
    public boolean canBeRotated() {
        return true;
    }

    @Override
    public void upDateNetwork(IBlockAccess access, BlockPos pos) {
        network.addToNetwork(access,pos);


    }

    @Override
    public NetworkBuilder getNetworkBulder() {
        return network;
    }

    @Override
    public void setNetworkBulder(NetworkBuilder networkBulder) {
        this.network = networkBulder;
    }


    @Override
    public void update() {
        /*for (TileEntity tile : network.getNetwork()){
            AppliedEnergistics3.LOGGER.info(tile.getPos());
        }*/
    }
}
