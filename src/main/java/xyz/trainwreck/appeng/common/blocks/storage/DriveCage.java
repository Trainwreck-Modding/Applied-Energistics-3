package xyz.trainwreck.appeng.common.blocks.storage;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import xyz.trainwreck.Lib.common.util.TileHelper;
import xyz.trainwreck.appeng.AppliedEnergistics3;
import xyz.trainwreck.appeng.Reference;
import xyz.trainwreck.appeng.common.blocks.BlockRotateBase;
import xyz.trainwreck.appeng.common.tileentity.TE_DriveCage;

public class DriveCage extends BlockRotateBase {

    private static String name = "drive_cage";

    public DriveCage() {
        super(Material.CIRCUITS, name, Reference.MODID);
        setDefaultState(blockState.getBaseState().withProperty(FACING,EnumFacing.NORTH));
        setTileEntity(TE_DriveCage.class);
        setCreativeTab(AppliedEnergistics3.tabAppEng);
        setInternalName(name);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        TE_DriveCage tileEntity = TileHelper.getTileEntity(worldIn, pos, TE_DriveCage.class);
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
