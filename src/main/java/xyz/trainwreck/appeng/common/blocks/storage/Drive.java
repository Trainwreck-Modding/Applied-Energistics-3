package xyz.trainwreck.appeng.common.blocks.storage;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import xyz.trainwreck.Lib.common.blocks.BlockTileBase;
import xyz.trainwreck.Lib.common.tileentity.TileEntityBase;
import xyz.trainwreck.Lib.common.util.TileHelper;
import xyz.trainwreck.appeng.Reference;
import xyz.trainwreck.appeng.common.blocks.BlockRotateBace;
import xyz.trainwreck.appeng.common.tileentity.DriveTileEntity;

public class Drive extends BlockRotateBace {

    private static String name = "drive";

    public Drive() {
        super(Material.CIRCUITS, name, Reference.MODID);
        setDefaultState(blockState.getBaseState().withProperty(FACING,EnumFacing.NORTH));
        setTileEntity(DriveTileEntity.class);
        setCreativeTab(CreativeTabs.TRANSPORTATION);
        setInternalName(name);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        DriveTileEntity tileEntity = TileHelper.getTileEntity(worldIn, pos, DriveTileEntity.class);
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
}
