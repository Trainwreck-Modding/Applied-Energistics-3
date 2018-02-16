package xyz.trainwreck.appeng.common.tileentity.tileentitybases;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import xyz.trainwreck.Lib.common.tileentity.TileEntityBase;
import xyz.trainwreck.appeng.AppliedEnergistics3;
import xyz.trainwreck.appeng.api.util.AppliedNetwork;
import xyz.trainwreck.appeng.common.network.NetworkBuilder;

public class TE_TileBase extends TileEntityBase implements AppliedNetwork, ITickable {
    NetworkBulder network = new NetworkBulder(this);




    @Override
    public void upDateNetwork(IBlockAccess access, BlockPos pos) {
        network.addToNetwork(access,pos);

        for (TileEntity tile : network.getNetwork()){
            AppliedEnergistics3.LOGGER.info(tile);
        }
    }

    @Override
    public void update() {

    }
}
