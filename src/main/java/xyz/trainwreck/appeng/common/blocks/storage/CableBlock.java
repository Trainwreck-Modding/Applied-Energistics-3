package xyz.trainwreck.appeng.common.blocks.storage;

import net.minecraft.block.material.Material;
import xyz.trainwreck.Lib.common.blocks.BlockTileBase;
import xyz.trainwreck.appeng.AppliedEnergistics3;
import xyz.trainwreck.appeng.Reference;
import xyz.trainwreck.appeng.common.tileentity.tileentitybases.TE_TileBace;

/**
 * Created by kylekovalchick on 2/16/18.
 */
public class CableBlock extends BlockTileBase {
    public CableBlock() {
        super(Material.CACTUS, "", Reference.MODID);
        setInternalName("cableblock");
        setCreativeTab(AppliedEnergistics3.tabAppEng);
        setTileEntity(TE_TileBace.class);
    }
}
