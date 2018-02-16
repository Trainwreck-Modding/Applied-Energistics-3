package xyz.trainwreck.appeng.common.network;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import xyz.trainwreck.Lib.common.tileentity.TileEntityBase;
import xyz.trainwreck.Lib.common.util.TileHelper;
import xyz.trainwreck.appeng.common.tileentity.tileentitybases.TE_TileBase;

import java.util.ArrayList;
import java.util.List;

public class NetworkBulder{

    private List<TileEntity> networkTiles = new ArrayList<>();

    public NetworkBulder() {
    }


    public void addToNetwork(World access, BlockPos pos){
        networkTiles.add(access.getTileEntity(pos));
    }

    public List<TileEntity> getNetwork(){
        return networkTiles;
    }
}
