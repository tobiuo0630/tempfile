package com.example.examplemod.event;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.item.ModItems;
import com.example.examplemod.villager.ModVillager;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

import java.util.List;

@EventBusSubscriber(modid = ExampleMod.MODID)
public class TradeEvent {


    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        if(event.getType().equals(ModVillager.HIRAGANAER.getKey())){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(ModItems.GYOGYOUKEN,1),
                    new ItemStack(ModItems.A.get(),1),6,3,0.05f
            ));
        }
    }
}

