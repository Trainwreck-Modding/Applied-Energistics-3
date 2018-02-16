package xyz.trainwreck.appeng.common.network;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import xyz.trainwreck.Lib.common.util.TileHelper;
import xyz.trainwreck.appeng.common.tileentity.TE_TileController;

import java.util.ArrayList;
import java.util.List;

public class NetworkBuilder {

    private List<TileEntity> networkTiles = new ArrayList<>();
    private List<TileEntity> tileEntities = new ArrayList<>();

    public NetworkBuilder(TileEntity tileEntity) {
        networkTiles.add(tileEntity);
    }


    public void addToNetwork(IBlockAccess access, BlockPos pos){
        networkTiles.add(TileHelper.getTileEntity(access,pos, TE_TileController.class));
    }
    public void removeFromNetwork(TileEntity tileEntity){
        networkTiles.remove(tileEntity);
    }

    public List<TileEntity> getNetwork(){
        return networkTiles;
    }
}
