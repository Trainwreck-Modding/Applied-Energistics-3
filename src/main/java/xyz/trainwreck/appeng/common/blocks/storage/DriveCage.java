package xyz.trainwreck.appeng.common.blocks.storage;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import xyz.trainwreck.Lib.common.tileentity.TileEntityBase;
import xyz.trainwreck.Lib.common.util.TileHelper;
import xyz.trainwreck.appeng.AppliedEnergistics3;
import xyz.trainwreck.appeng.Reference;
import xyz.trainwreck.appeng.api.util.AppliedNetwork;
import xyz.trainwreck.appeng.common.blocks.BlockRotateBase;
import xyz.trainwreck.appeng.common.network.NetworkBuilder;
import xyz.trainwreck.appeng.common.tileentity.TE_DriveCage;
import xyz.trainwreck.appeng.common.tileentity.tileentitybases.TE_TileBase;

public class DriveCage extends BlockRotateBase {

    private static String name = "drive_cage";


    public DriveCage() {
        super(Material.CIRCUITS, name, Reference.MODID);
        setDefaultState(blockState.getBaseState().withProperty(FACING,EnumFacing.NORTH));
        setTileEntity(TE_TileBase.class);
        setCreativeTab(AppliedEnergistics3.tabAppEng);
        setInternalName(name);
    }


    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        TileEntityBase tileEntity = TileHelper.getTileEntity(worldIn, pos, TileEntityBase.class);
        if (tileEntity != null && tileEntity.canBeRotated()) {
            return state.withProperty(FACING, tileEntity.getForward());
        }
        return state.withProperty(FACING, EnumFacing.NORTH);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this,FACING);
    }
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING,EnumFacing.NORTH);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        EnumFacing tier = state.getValue(FACING);
        return tier.getIndex();
    }

    @Override
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor) {
        TileEntity tileBase = TileHelper.getTileEntity(world,pos,TileEntity.class);

        if(tileBase instanceof AppliedNetwork){
            ((AppliedNetwork) tileBase).upDateNetwork(world,pos);
        }
        if(tileBase instanceof AppliedNetwork&&world.isAirBlock(neighbor)){
            NetworkBuilder network = ((AppliedNetwork) tileBase).getNetworkBulder();
            for(TileEntity tileEntity : network.getNetwork()){
                if(tileEntity == world.getTileEntity(pos)){
                    network.removeFromNetwork(tileEntity);
                }
            }
        }

    }
}
