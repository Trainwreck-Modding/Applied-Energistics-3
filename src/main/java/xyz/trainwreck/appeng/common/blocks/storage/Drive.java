package xyz.trainwreck.appeng.common.blocks.storage;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import xyz.trainwreck.Lib.common.blocks.BlockTileBase;
import xyz.trainwreck.appeng.Reference;
import xyz.trainwreck.appeng.common.tileentity.DriveTileEntity;

public class Drive extends BlockTileBase {

    private static String name = "drive";

    public Drive() {
        super(Material.CIRCUITS, name, Reference.MODID);
        setTileEntity(DriveTileEntity.class);
        setCreativeTab(CreativeTabs.TRANSPORTATION);
        setInternalName(name);
    }
}
