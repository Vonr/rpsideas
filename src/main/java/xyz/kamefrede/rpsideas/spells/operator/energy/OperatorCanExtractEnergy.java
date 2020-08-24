package xyz.kamefrede.rpsideas.spells.operator.energy;

import xyz.kamefrede.rpsideas.spells.base.OperatorEnergy;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.energy.IEnergyStorage;
import vazkii.psi.api.spell.Spell;

public class OperatorCanExtractEnergy extends OperatorEnergy {
    public OperatorCanExtractEnergy(Spell spell) {
        super(spell);
    }

    @Override
    protected double result(World world, BlockPos pos, TileEntity tile, IEnergyStorage storage) {
        return storage.canExtract() ? 1.0 : 0.0;
    }
}