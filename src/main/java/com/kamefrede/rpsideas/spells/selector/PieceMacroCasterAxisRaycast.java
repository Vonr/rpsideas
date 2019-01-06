package com.kamefrede.rpsideas.spells.selector;

import com.kamefrede.rpsideas.util.helpers.SpellHelpers;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.RayTraceResult;
import vazkii.psi.api.internal.Vector3;
import vazkii.psi.api.spell.*;
import vazkii.psi.api.spell.param.ParamNumber;

public class PieceMacroCasterAxisRaycast extends SpellPiece {
    private SpellParam maxDistance;

    public PieceMacroCasterAxisRaycast(Spell spell) {
        super(spell);
    }

    @Override
    public void initParams() {
        addParam(maxDistance = new ParamNumber(SpellParam.GENERIC_NAME_MAX, SpellParam.RED, true, false));
    }

    @Override
    public void addToMetadata(SpellMetadata meta) throws SpellCompilationException {
        meta.addStat(EnumSpellStat.COMPLEXITY, 4);
    }

    @Override
    public Object evaluate() {
        return null;
    }

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        Vector3 originVal = Vector3.fromEntity(context.caster).add(0, context.caster.getEyeHeight(), 0);
        Vector3 look = new Vector3(context.caster.getLook(1F));
        EnumFacing facing = EnumFacing.getFacingFromVector((float) look.x, (float) look.y, (float) look.z);
        Vector3 rayVal = new Vector3(facing.getXOffset(), facing.getYOffset(), facing.getZOffset());

        double maxLen = SpellHelpers.getBoundedNumber(this, context, maxDistance, SpellContext.MAX_DISTANCE);

        Vector3 end = originVal.copy().add(rayVal.copy().normalize().multiply(maxLen));

        RayTraceResult pos = context.caster.world.rayTraceBlocks(originVal.toVec3D(), end.toVec3D(), false, false, false);
        if (pos == null)
            throw new SpellRuntimeException(SpellRuntimeException.NULL_VECTOR);

        EnumFacing sideHit = pos.sideHit;
        return new Vector3(sideHit.getXOffset(), sideHit.getYOffset(), sideHit.getZOffset());
    }

    @Override
    public EnumPieceType getPieceType() {
        return EnumPieceType.SELECTOR;
    }

    @Override
    public Class<?> getEvaluationType() {
        return Vector3.class;
    }
}
