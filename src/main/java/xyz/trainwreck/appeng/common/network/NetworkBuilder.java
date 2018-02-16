package xyz.trainwreck.appeng.common.network;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import xyz.trainwreck.Lib.common.tileentity.TileEntityBase;
import xyz.trainwreck.Lib.common.util.TileHelper;
import xyz.trainwreck.appeng.common.tileentity.tileentitybases.TE_TileBase;

import java.util.ArrayList;
import java.util.List;

public class NetworkBuilder {

    private List<TileEntity> networkTiles = new ArrayList<>();
    private List<TileEntity> tileEntities = new ArrayList<>();

    public NetworkBuilder(TileEntity tileEntity) {
        networkTiles.add(tileEntity);
    }


    public void addToNetwork(IBlockAccess access, BlockPos pos){
        networkTiles.add(TileHelper.getTileEntity(access,pos, TE_TileBase.class));
    }

    public List<TileEntity> getNetwork(){
        return networkTiles;
    }
}
