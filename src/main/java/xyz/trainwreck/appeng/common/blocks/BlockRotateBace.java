package xyz.trainwreck.appeng.common.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import xyz.trainwreck.Lib.common.blocks.BlockTileBase;
import xyz.trainwreck.Lib.common.tileentity.TileEntityBase;
import xyz.trainwreck.Lib.common.util.TileHelper;

import javax.annotation.Nullable;

public class BlockRotateBace extends BlockTileBase {

    protected static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public BlockRotateBace(Material blockMaterialIn, String resourcePath, String modid) {
        super(blockMaterialIn, resourcePath, modid);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        TileEntityBase tileEntity = TileHelper.getTileEntity(worldIn, pos, TileEntityBase.class);


        if (tileEntity.canBeRotated()) {
            //todo: make client side configuration for this option...
            if (placer.isSneaking()) {
                tileEntity.setOrientation(placer.getHorizontalFacing());
            } else {
                tileEntity.setOrientation(placer.getHorizontalFacing().getOpposite());
            }
        }
    }

    @Nullable
    @Override
    public EnumFacing[] getValidRotations(World world, BlockPos pos) {
        final TileEntityBase tileEntity = TileHelper.getTileEntity(world, pos, TileEntityBase.class);
        if (tileEntity != null && tileEntity.canBeRotated())
            return EnumFacing.HORIZONTALS;

        return super.getValidRotations(world, pos);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        TileEntityBase tileEntity = TileHelper.getTileEntity(worldIn, pos, TileEntityBase.class);
        if (tileEntity != null && tileEntity.canBeRotated()) {
            return state.withProperty(FACING, tileEntity.getForward());
        }
        return state.withProperty(FACING, EnumFacing.NORTH);
    }
}
