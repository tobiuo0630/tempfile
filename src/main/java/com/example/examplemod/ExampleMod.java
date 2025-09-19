package com.example.examplemod;

import com.example.examplemod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

@Mod(ExampleMod.MODID)
public class ExampleMod {
    public static final String MODID = "examplemod";
    public static final Logger LOGGER = LogUtils.getLogger();

    // Block と CreativeTab の登録
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // ブロック定義
    public static final DeferredBlock<Block> EXAMPLE_BLOCK =
            BLOCKS.registerSimpleBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));

    // クリエイティブタブ
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB =
            CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.examplemod"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> ModItems.EXAMPLE_ITEM.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        // ModItems に移したアイテムを全て表示
                        output.accept(ModItems.EXAMPLE_ITEM.get());
                        output.accept(ModItems.A.get());
                        output.accept(ModItems.KI.get());
                        output.accept(ModItems.SU.get());
                        output.accept(ModItems.SE.get());
                        output.accept(ModItems.SO.get());
                        output.accept(ModItems.GI.get());
                        output.accept(ModItems.KYA.get());
                        output.accept(ModItems.SHI.get());
                        output.accept(ModItems.GA.get());
                        output.accept(ModItems.U.get());
                        output.accept(ModItems.ME.get());
                        output.accept(ModItems.NA.get());
                        output.accept(ModItems.SA.get());
                        output.accept(ModItems.TA.get());
                        output.accept(ModItems.RE.get());
                        output.accept(ModItems.BYU.get());
                        output.accept(ModItems.O.get());
                        output.accept(ModItems.HA.get());
                        output.accept(ModItems.PO.get());
                        output.accept(ModItems.DA.get());
                        output.accept(ModItems.PA.get());
                        output.accept(ModItems.JI.get());
                        output.accept(ModItems.KYU.get());
                        output.accept(ModItems.KYO.get());
                        output.accept(ModItems.RYU.get());
                        output.accept(ModItems.RA.get());
                        output.accept(ModItems.BE.get());
                        output.accept(ModItems.HO.get());
                        output.accept(ModItems.TO.get());
                        output.accept(ModItems.CHU.get());
                        output.accept(ModItems.PU.get());
                        output.accept(ModItems.HI.get());
                        output.accept(ModItems.DU.get());
                        output.accept(ModItems.TE.get());
                        output.accept(ModItems.I.get());
                        output.accept(ModItems.YO.get());
                        output.accept(ModItems.KA.get());
                        output.accept(ModItems.KU.get());
                        output.accept(ModItems.HE.get());
                        output.accept(ModItems.SHA.get());
                        output.accept(ModItems.SHO.get());
                        output.accept(ModItems.RI.get());
                        output.accept(ModItems.NYA.get());
                        output.accept(ModItems.PE.get());
                        output.accept(ModItems.GYO.get());
                        output.accept(ModItems.E.get());
                        output.accept(ModItems.KE.get());
                        output.accept(ModItems.KO.get());
                        output.accept(ModItems.TSU.get());
                        output.accept(ModItems.NE.get());
                        output.accept(ModItems.MA.get());
                        output.accept(ModItems.YU.get());
                        output.accept(ModItems.YA.get());
                        output.accept(ModItems.N.get());

                        output.accept(ModItems.MURATA_TICKET.get());
                        output.accept(ModItems.RETURN_TICKET.get());
                    }).build());

    public ExampleMod(IEventBus modEventBus, ModContainer modContainer) {
        // setup イベント
        modEventBus.addListener(this::commonSetup);

        // アイテム登録
        ModItems.register(modEventBus);

        // ブロック & タブ登録
        BLOCKS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        // サーバー & Forge イベント登録
        NeoForge.EVENT_BUS.register(this);

        // クリエイティブタブ追加
        modEventBus.addListener(this::addCreative);

        // Config 登録
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    // Building Blocks タブに追加
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModItems.EXAMPLE_BLOCK_ITEM);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }
}
