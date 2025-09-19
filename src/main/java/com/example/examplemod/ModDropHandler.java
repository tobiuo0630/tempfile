package com.example.examplemod;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.Random;

@EventBusSubscriber(modid = ExampleMod.MODID)
public class ModDropHandler {
    private static final Random RANDOM = new Random();

    // ==== ブロック破壊時 ====
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        ServerLevel level = (ServerLevel) event.getLevel();
        BlockState state = event.getState();
        BlockPos pos = event.getPos();

        ItemStack dropItem = null;

        // 全ての葉っぱブロック → "りゅ"
        if (state.is(BlockTags.LEAVES)) {
            dropItem = new ItemStack(ModItems.RYU.get());
        }

        // 雑草 (確率30%) → "きょ"
        else if (state.is(Blocks.TALL_GRASS)) {
            if (RANDOM.nextFloat() < 0.3f) {
                dropItem = new ItemStack(ModItems.KYO.get());
            }
        }


        // 以下、必ず追加ドロップするブロック
        else if (state.is(Blocks.OAK_LOG)) dropItem = new ItemStack(ModItems.A.get());
        else if (state.is(Blocks.BIRCH_LOG)) dropItem = new ItemStack(ModItems.KI.get());
        else if (state.is(Blocks.SPRUCE_LOG)) dropItem = new ItemStack(ModItems.SU.get());
        else if (state.is(Blocks.DARK_OAK_LOG)) dropItem = new ItemStack(ModItems.SE.get());
        else if (state.is(Blocks.ACACIA_LOG)) dropItem = new ItemStack(ModItems.SO.get());
        else if (state.is(Blocks.JUNGLE_LOG)) dropItem = new ItemStack(ModItems.GI.get());
        else if (state.is(Blocks.MANGROVE_LOG)) dropItem = new ItemStack(ModItems.KYA.get());
        else if (state.is(Blocks.CHERRY_LOG)) dropItem = new ItemStack(ModItems.SHI.get());

        else if (state.is(Blocks.COAL_ORE)) dropItem = new ItemStack(ModItems.GA.get());
        else if (state.is(Blocks.IRON_ORE)) dropItem = new ItemStack(ModItems.U.get());
        else if (state.is(Blocks.COPPER_ORE)) dropItem = new ItemStack(ModItems.ME.get());
        else if (state.is(Blocks.GOLD_ORE)) dropItem = new ItemStack(ModItems.NA.get());
        else if (state.is(Blocks.LAPIS_ORE)) dropItem = new ItemStack(ModItems.SA.get());
        else if (state.is(Blocks.REDSTONE_ORE)) dropItem = new ItemStack(ModItems.TA.get());
        else if (state.is(Blocks.DIAMOND_ORE)) dropItem = new ItemStack(ModItems.RE.get());
        else if (state.is(Blocks.EMERALD_ORE)) dropItem = new ItemStack(ModItems.BYU.get());

        else if (state.is(Blocks.STONE)) dropItem = new ItemStack(ModItems.O.get());
        else if (state.is(Blocks.GRASS_BLOCK)) dropItem = new ItemStack(ModItems.HA.get());
        else if (state.is(Blocks.DIRT)) dropItem = new ItemStack(ModItems.PO.get());
        else if (state.is(Blocks.GRAVEL)) dropItem = new ItemStack(ModItems.DA.get());
        else if (state.is(Blocks.SAND)) dropItem = new ItemStack(ModItems.PA.get());

        else if (state.is(Blocks.CRAFTING_TABLE)) dropItem = new ItemStack(ModItems.JI.get());
        else if (state.is(Blocks.FURNACE)) dropItem = new ItemStack(ModItems.KYU.get());

        else if (state.is(Blocks.DANDELION)) dropItem = new ItemStack(ModItems.RA.get());
        else if (state.is(Blocks.POPPY)) dropItem = new ItemStack(ModItems.BE.get());
        else if (state.is(Blocks.CORNFLOWER)) dropItem = new ItemStack(ModItems.HO.get());
        else if (state.is(Blocks.OXEYE_DAISY)) dropItem = new ItemStack(ModItems.TO.get());
        else if (state.is(Blocks.RED_TULIP)) dropItem = new ItemStack(ModItems.CHU.get());
        else if (state.is(Blocks.WHITE_TULIP)) dropItem = new ItemStack(ModItems.PU.get());
        else if (state.is(Blocks.BLUE_ORCHID)) dropItem = new ItemStack(ModItems.HI.get());
        else if (state.is(Blocks.ALLIUM)) dropItem = new ItemStack(ModItems.DU.get());
        else if (state.is(Blocks.LILY_OF_THE_VALLEY)) dropItem = new ItemStack(ModItems.TE.get());

        if (dropItem != null) {
            level.addFreshEntity(new ItemEntity(level,
                    pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    dropItem));
        }
    }

    // ==== モブドロップ ====
    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        LivingEntity entity = event.getEntity();
        ServerLevel level = (ServerLevel) entity.level();

        ItemStack dropItem = null;

        // スライムは30%の確率で "く"
        if (entity.getType() == EntityType.SLIME) {
            if (RANDOM.nextFloat() < 0.3f) {
                dropItem = new ItemStack(ModItems.KU.get());
            }
        }

        // その他モブは必ず追加ドロップ
        else if (entity.getType() == EntityType.ZOMBIE) dropItem = new ItemStack(ModItems.I.get());
        else if (entity.getType() == EntityType.ZOMBIE_VILLAGER) dropItem = new ItemStack(ModItems.YO.get());
        else if (entity.getType() == EntityType.SPIDER) dropItem = new ItemStack(ModItems.KA.get());
        else if (entity.getType() == EntityType.HUSK) dropItem = new ItemStack(ModItems.HE.get());
        else if (entity.getType() == EntityType.DROWNED) dropItem = new ItemStack(ModItems.SHA.get());
        else if (entity.getType() == EntityType.SKELETON) dropItem = new ItemStack(ModItems.SHO.get());
        else if (entity.getType() == EntityType.CREEPER) dropItem = new ItemStack(ModItems.RI.get());
        else if (entity.getType() == EntityType.WITCH) dropItem = new ItemStack(ModItems.NYA.get());
        else if (entity.getType() == EntityType.PILLAGER) dropItem = new ItemStack(ModItems.PE.get());
        else if (entity.getType() == EntityType.ENDERMAN) dropItem = new ItemStack(ModItems.GYO.get());
        else if (entity.getType() == EntityType.COW) dropItem = new ItemStack(ModItems.E.get());
        else if (entity.getType() == EntityType.SHEEP) dropItem = new ItemStack(ModItems.KE.get());
        else if (entity.getType() == EntityType.PIG) dropItem = new ItemStack(ModItems.KO.get());
        else if (entity.getType() == EntityType.CHICKEN) dropItem = new ItemStack(ModItems.TSU.get());
        else if (entity.getType() == EntityType.SQUID) dropItem = new ItemStack(ModItems.NE.get());
        else if (entity.getType() == EntityType.HORSE) dropItem = new ItemStack(ModItems.MA.get());
        else if (entity.getType() == EntityType.COD) dropItem = new ItemStack(ModItems.YU.get());
        else if (entity.getType() == EntityType.BEE) dropItem = new ItemStack(ModItems.YA.get());
        else if (entity.getType() == EntityType.IRON_GOLEM) dropItem = new ItemStack(ModItems.N.get());

        if (dropItem != null) {
            event.getDrops().add(new ItemEntity(level,
                    entity.getX(), entity.getY(), entity.getZ(),
                    dropItem));
        }
    }
}
