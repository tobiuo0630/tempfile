package com.example.examplemod;


import com.example.examplemod.item.ModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.minecraft.server.level.ServerPlayer;


@EventBusSubscriber(modid = ExampleMod.MODID)
public class WarpEventHandler {

    private static double X_now = 0;
    private static double Y_now = 0;
    private static double Z_now = 0;

    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event){
        Player player = event.getEntity();
        ItemStack stack = event.getItemStack();



        if(stack.getItem() == ModItems.MURATA_TICKET.get()){
            //現在の座標保存
            X_now = player.getX();
            Y_now = player.getY();
            Z_now = player.getZ();

            //指定の座標にワープ関数
            if(player instanceof ServerPlayer serverPlayer){
                serverPlayer.teleportTo(1.0,1.0,1.0);
            }

            //インベントリからMURATA_TICKETを消す
            removeOneItem(player, ModItems.MURATA_TICKET.get());

            //RETURNアイテムを入れる
            player.getInventory().add(new ItemStack(ModItems.RETURN_TICKET.get(),1));
        }

        if(stack.getItem() == ModItems.RETURN_TICKET.get()){
            if(player instanceof ServerPlayer serverPlayer){
                serverPlayer.teleportTo(X_now,Y_now,Z_now);
            }
            removeOneItem(player, ModItems.RETURN_TICKET.get());
            player.getInventory().add(new ItemStack(ModItems.MURATA_TICKET.get(),1));
        }



    }

    private static void removeOneItem(Player player, net.minecraft.world.item.Item item){
        for(int i=0;i<player.getInventory().getContainerSize();i++){
            ItemStack stackInSlot = player.getInventory().getItem(i);
            if(!stackInSlot.isEmpty() && stackInSlot.getItem()==item){
                player.getInventory().setItem(i,ItemStack.EMPTY);
                break;
            }
        }
    }


}

