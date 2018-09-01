package com.github.kamefrede.psiaddon.capability.stasis.time;

import com.github.kamefrede.psiaddon.capability.stasis.damage.IStasisDamage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityMinecart;

import static com.github.kamefrede.psiaddon.capability.stasis.damage.StasisDamageStorage.CAPABILITY_STASIS_DAMAGE;
import static com.github.kamefrede.psiaddon.capability.stasis.time.StasisTimeStorage.CAPABILITY_STASIS_TIME;

public class LibTime {

    public static IStasisTime remTimeFromEvent(EntityLiving entityLiving, double time){
        IStasisTime stasisTime = entityLiving.getCapability(CAPABILITY_STASIS_TIME, null);
        if (stasisTime != null){
            stasisTime.remStasisTime(time);
            System.out.println("removed" + " " + time + " ticks");
        }
        return null;
    }

    public static IStasisTime remTimeMiscEnt(Entity entity, double time){
        if(entity instanceof EntityMinecart || entity instanceof EntityFallingBlock || entity instanceof EntityBoat){

            IStasisTime stasisTime = entity.getCapability(CAPABILITY_STASIS_TIME, null);
            if (stasisTime != null){
                stasisTime.remStasisTime(time);
                System.out.println("removed" + " " + time + " ticks");
            }
        }

        return null;
    }

    public static IStasisTime addTimeFromEvent(Entity entity, double time) {
        IStasisTime stasisTime = entity.getCapability(CAPABILITY_STASIS_TIME, null);
        if (stasisTime != null){
            stasisTime.addStasisTime(time);
            System.out.println("added" + " " + time);
        }
        return  null;
    }
    public static IStasisTime addTimeMiscEnt(Entity entity, double time) {
        if(entity instanceof EntityMinecart || entity instanceof EntityFallingBlock || entity instanceof EntityBoat){
            IStasisTime stasisTime = entity.getCapability(CAPABILITY_STASIS_TIME, null);
            if (stasisTime != null){
                stasisTime.addStasisTime(time);
                System.out.println("added" + " " + time);
            }

        }
        return  null;
    }


    public static IStasisTime getTimeHandler(Entity entity) {

        if (entity.hasCapability(CAPABILITY_STASIS_TIME, null))
            return entity.getCapability(CAPABILITY_STASIS_TIME, null);
        System.out.println("no capability");
        return null;
    }

    public static IStasisTime requireMiscStasisTime(Entity entity) {
        if(entity instanceof EntityMinecart || entity instanceof EntityFallingBlock || entity instanceof EntityBoat){
            IStasisTime instance = entity.getCapability(CAPABILITY_STASIS_TIME, null);
            if (instance == null) {
                throw new IllegalStateException(String.format(
                        "Missing Capability (%s): %s - \"%s\"",
                        CAPABILITY_STASIS_TIME.getName(),
                        entity.getClass().getName(),
                        entity
                ));
            }
            return instance;
        }
        return null;
    }

    public static IStasisTime requireStasisTime(EntityLiving living) {
        IStasisTime instance = living.getCapability(CAPABILITY_STASIS_TIME, null);
        if (instance == null) {
            throw new IllegalStateException(String.format(
                    "Missing Capability (%s): %s - \"%s\"",
                    CAPABILITY_STASIS_TIME.getName(),
                    living.getClass().getName(),
                    living
            ));
        }
        return instance;
    }
}
