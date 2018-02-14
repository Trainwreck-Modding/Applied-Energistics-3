package xyz.trainwreck.appeng3.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import xyz.trainwreck.Lib.common.blocks.BlockBase;
import xyz.trainwreck.Lib.common.registry.RegistryHelper;
import xyz.trainwreck.appeng3.AppliedEnergistics3;
import xyz.trainwreck.appeng3.Reference;
import xyz.trainwreck.appeng3.common.blocks.storage.Drive;
import xyz.trainwreck.appeng3.common.items.ItemBlocks.DriveItem;

public enum Blocks {
    DRIVE(Drive.class, DriveItem.class);

    private final Class<? extends BlockBase> blockClass;
    private final Class<? extends ItemBlock> itemBlockClass;
    private Block block;

    Blocks(Class<? extends BlockBase> blockClass, Class<? extends ItemBlock> itemBlockClass) {
        this.blockClass = blockClass;
        this.itemBlockClass = itemBlockClass;
    }

    public static void registerBlocks() {
        for (Blocks blocks : Blocks.values()) {
            blocks.registerBlock();
        }
    }

    public ItemStack getStack() {
        return new ItemStack(block);
    }


    public ItemStack getStack(int size, int meta) {
        return new ItemStack(block, size, meta);
    }

    public Block getBlocks() {
        return this.block;
    }

    private void registerBlock() {
        block = RegistryHelper.addBlockToRegistry(Reference.MODID, blockClass, itemBlockClass);
    }

}
