package com.github.kamefrede.rpsideas.proxy;

import com.github.kamefrede.rpsideas.blocks.ModBlocks;
import com.github.kamefrede.rpsideas.blocks.PsionicBlocksCompat;
import com.github.kamefrede.rpsideas.items.ModItems;
import com.github.kamefrede.rpsideas.network.RPSPacketHandler;
import com.github.kamefrede.rpsideas.spells.base.SpellPieces;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber
public class CommonProxy {

    //Config instance
    public static Configuration config;

    public void preInit(FMLPreInitializationEvent e){
        SpellPieces.init();
        RPSPacketHandler.initPackets();


    }

    public void init(FMLInitializationEvent e){

    }

    public void postInit(FMLPostInitializationEvent e){
        }



    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){
        ModBlocks.preInit();


    }








}