package com.example.examplemod;


import com.example.examplemod.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.minecraft.server.level.ServerPlayer;

import java.util.Set;


@EventBusSubscriber(modid = ExampleMod.MODID)
public class WarpEventHandler {

    private static double X_murata = -158.300;
    private static double Y_murata = 90.000;
    private static double Z_murata = 114.529;
    static float yaw_murata = 90.0f;
    static float pitch_murata = 0.0f;

    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event){

        Player player = event.getEntity();

        ItemStack stack = event.getItemStack();

        if (!(player instanceof ServerPlayer)) return;
        ServerPlayer serverPlayer = (ServerPlayer) player;
        ServerLevel level = serverPlayer.level();




        if(stack.getItem() == ModItems.MURATA_TICKET.get()){
            CompoundTag data = player.getPersistentData();

            data.putDouble("x_now",player.getX());
            data.putDouble("y_now",player.getY());
            data.putDouble("z_now",player.getZ());
            data.putFloat("yaw_now",player.getYRot());
            data.putFloat("pitch_now",player.getXRot());

            //現在の座標取得
            //X_now = player.getX();
            //Y_now = player.getY();
            //Z_now = player.getZ();
            //yaw_now = player.getYRot();
            //pitch_now = player.getXRot();

            // 秘密基地にワープ
            //serverPlayer.teleportTo(X_murata, Y_murata, Z_murata);
            serverPlayer.teleportTo(level,X_murata,Y_murata,Z_murata, Set.of(),yaw_murata,pitch_murata,true);



            //インベントリからMURATA_TICKETを消す
            removeOneItem(player, ModItems.MURATA_TICKET.get());

            //RETURNアイテムを入れる
            player.getInventory().add(new ItemStack(ModItems.RETURN_TICKET.get(),1));
        }

        if(stack.getItem() == ModItems.RETURN_TICKET.get()){
            //チャット送信処理：serverPlayer.sendSystemMessage(Component.literal("aaa"+X_now+Y_now+Z_now));

            CompoundTag data = player.getPersistentData();
            double warp_x = data.getDouble("x_now").orElse(0.0);
            double warp_y = data.getDouble("y_now").orElse(0.0);
            double warp_z = data.getDouble("z_now").orElse(0.0);
            float warp_yaw = data.getFloat("yaw_now").orElse(0.0f);
            float warp_pitch = data.getFloat("pitch_now").orElse(0.0f);

            //テレポート処理
            serverPlayer.teleportTo(level,warp_x,warp_y,warp_z,Set.of(),warp_yaw,warp_pitch,true);

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

