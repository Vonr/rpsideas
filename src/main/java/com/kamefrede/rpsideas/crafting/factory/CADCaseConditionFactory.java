package com.kamefrede.rpsideas.crafting.factory;

import com.google.gson.JsonObject;
import com.kamefrede.rpsideas.proxy.ConfigHandler;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

import java.util.function.BooleanSupplier;

public class CADCaseConditionFactory implements IConditionFactory {// TODO: 12/15/18 look at

    @Override
    public BooleanSupplier parse(JsonContext context, JsonObject json) {
        boolean value = JsonUtils.getBoolean(json, "value", true);
        return () -> ConfigHandler.enableCase == value;
    }
}