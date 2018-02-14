package xyz.trainwreck.appeng3.common.blocks.storage;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import xyz.trainwreck.Lib.Reference;
import xyz.trainwreck.Lib.common.blocks.BlockTileBase;
import xyz.trainwreck.appeng3.common.tileentity.DriveTileEntity;

public class Drive extends BlockTileBase {
    public Drive() {
        super(Material.CIRCUITS, "drivedad", Reference.MODID);
        setTileEntity(DriveTileEntity.class);
        setCreativeTab(CreativeTabs.TRANSPORTATION);
        setInternalName("drive");
    }
}
