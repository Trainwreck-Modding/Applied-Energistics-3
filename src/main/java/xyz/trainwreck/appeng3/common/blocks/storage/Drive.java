package xyz.trainwreck.appeng3.common.blocks.storage;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import xyz.trainwreck.Lib.common.blocks.BlockTileBase;
import xyz.trainwreck.appeng3.Reference;
import xyz.trainwreck.appeng3.common.tileentity.DriveTileEntity;

public class Drive extends BlockTileBase {
    public Drive() {
        super(Material.CIRCUITS, "drive", Reference.MODID);
        setTileEntity(DriveTileEntity.class);
        setCreativeTab(CreativeTabs.TRANSPORTATION);
        setInternalName("drive");
    }
}
