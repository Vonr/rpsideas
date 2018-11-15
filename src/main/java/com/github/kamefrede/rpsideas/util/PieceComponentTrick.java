package com.github.kamefrede.rpsideas.util;

import com.github.kamefrede.rpsideas.util.botania.EnumManaTier;
import com.github.kamefrede.rpsideas.util.botania.IManaTrick;
import vazkii.psi.api.spell.Spell;
import vazkii.psi.api.spell.SpellContext;
import vazkii.psi.api.spell.SpellRuntimeException;
import vazkii.psi.api.spell.piece.PieceTrick;

import java.util.List;

public abstract class PieceComponentTrick extends PieceTrick implements IManaTrick {
    public PieceComponentTrick(Spell spell) {
        super(spell);
    }



    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        return IComponentPiece.execute(this, context);
    }

    @Override
    public void addToTooltipAfterShift(List<String> tooltip) {
        IComponentPiece.addToTooltip(this, tooltip);
    }
}
