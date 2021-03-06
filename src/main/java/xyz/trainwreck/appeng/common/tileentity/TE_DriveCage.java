package xyz.trainwreck.appeng.common.tileentity;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import xyz.trainwreck.Lib.common.inventory.InternalInventory;
import xyz.trainwreck.Lib.common.inventory.InventoryOperation;
import xyz.trainwreck.Lib.common.tileentity.TileInventoryBase;

public class TE_DriveCage extends TileInventoryBase implements ITickable {

    private InternalInventory inventory = new InternalInventory(this, 3);

    @Override
    public boolean canBeRotated() {
        return true;
    }

    @Override
    public IInventory getInternalInventory() {
        return inventory;
    }

    @Override
    public void onChangeInventory(IInventory inv, int slot, InventoryOperation inventoryOperation, ItemStack removedStack, ItemStack newStack) {

    }

    @Override
    public int[] getSlotsForFace(EnumFacing side) {
        int[] slots = new int[1];
        slots[0] = 0;
        return slots;
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
        return true;
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
        return true;
    }

    @Override
    public void update() {
    }
}
