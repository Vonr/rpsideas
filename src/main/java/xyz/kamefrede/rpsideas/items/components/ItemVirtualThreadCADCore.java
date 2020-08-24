package xyz.kamefrede.rpsideas.items.components;

import xyz.kamefrede.rpsideas.items.base.ItemComponent;
import xyz.kamefrede.rpsideas.util.libs.RPSItemNames;
import net.minecraft.item.ItemStack;
import vazkii.psi.api.cad.EnumCADComponent;
import vazkii.psi.api.cad.EnumCADStat;

public class ItemVirtualThreadCADCore extends ItemComponent {
    public ItemVirtualThreadCADCore() {
        super(RPSItemNames.VIRTUAL_THREAD_CAD_CORE);
    }

    @Override
    public EnumCADComponent getComponentType(ItemStack stack) {
        return EnumCADComponent.CORE;
    }

    @Override
    protected void registerStats() {
        addStat(EnumCADStat.COMPLEXITY, 32);
        addStat(EnumCADStat.PROJECTION, 2);
    }
}