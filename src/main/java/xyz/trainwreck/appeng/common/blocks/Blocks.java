package xyz.trainwreck.appeng.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import xyz.trainwreck.Lib.common.blocks.BlockBase;
import xyz.trainwreck.Lib.common.registry.RegistryHelper;
import xyz.trainwreck.appeng.Reference;
import xyz.trainwreck.appeng.common.blocks.storage.DriveCage;

public enum Blocks {
    DRIVECAGE(DriveCage.class);

    private final Class<? extends BlockBase> blockClass;
    private Block block;

    Blocks(Class<? extends BlockBase> blockClass) {
        this.blockClass = blockClass;
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
        block = RegistryHelper.addBlockToRegistry(Reference.MODID, blockClass);
    }

    public String getName() {
        return blockClass.getSimpleName();
    }
}
