package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExampleMod.MODID);

    // ブロック → BlockItem として登録
    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM =
            ITEMS.registerSimpleBlockItem("example_block", ExampleMod.EXAMPLE_BLOCK);

    // 食べ物アイテム
    public static final DeferredItem<Item> EXAMPLE_ITEM =
            ITEMS.registerSimpleItem("example_item", new Item.Properties().food(
                    new FoodProperties.Builder()
                            .alwaysEdible()
                            .nutrition(1)
                            .saturationModifier(2f)
                            .build()
            ));

    // ここから通常アイテム群
    public static final DeferredItem<Item> A   = ITEMS.registerSimpleItem("a",   new Item.Properties());
    public static final DeferredItem<Item> KI  = ITEMS.registerSimpleItem("ki",  new Item.Properties());
    public static final DeferredItem<Item> SU  = ITEMS.registerSimpleItem("su",  new Item.Properties());
    public static final DeferredItem<Item> SE  = ITEMS.registerSimpleItem("se",  new Item.Properties());
    public static final DeferredItem<Item> SO  = ITEMS.registerSimpleItem("so",  new Item.Properties());
    public static final DeferredItem<Item> GI  = ITEMS.registerSimpleItem("gi",  new Item.Properties());
    public static final DeferredItem<Item> KYA = ITEMS.registerSimpleItem("kya", new Item.Properties());
    public static final DeferredItem<Item> SHI = ITEMS.registerSimpleItem("shi", new Item.Properties());
    public static final DeferredItem<Item> GA  = ITEMS.registerSimpleItem("ga",  new Item.Properties());
    public static final DeferredItem<Item> U   = ITEMS.registerSimpleItem("u",   new Item.Properties());
    public static final DeferredItem<Item> ME  = ITEMS.registerSimpleItem("me",  new Item.Properties());
    public static final DeferredItem<Item> NA  = ITEMS.registerSimpleItem("na",  new Item.Properties());
    public static final DeferredItem<Item> SA  = ITEMS.registerSimpleItem("sa",  new Item.Properties());
    public static final DeferredItem<Item> TA  = ITEMS.registerSimpleItem("ta",  new Item.Properties());
    public static final DeferredItem<Item> RE  = ITEMS.registerSimpleItem("re",  new Item.Properties());
    public static final DeferredItem<Item> BYU = ITEMS.registerSimpleItem("byu", new Item.Properties());
    public static final DeferredItem<Item> O   = ITEMS.registerSimpleItem("o",   new Item.Properties());
    public static final DeferredItem<Item> HA  = ITEMS.registerSimpleItem("ha",  new Item.Properties());
    public static final DeferredItem<Item> PO  = ITEMS.registerSimpleItem("po",  new Item.Properties());
    public static final DeferredItem<Item> DA  = ITEMS.registerSimpleItem("da",  new Item.Properties());
    public static final DeferredItem<Item> PA  = ITEMS.registerSimpleItem("pa",  new Item.Properties());
    public static final DeferredItem<Item> JI  = ITEMS.registerSimpleItem("ji",  new Item.Properties());
    public static final DeferredItem<Item> KYU = ITEMS.registerSimpleItem("kyu", new Item.Properties());
    public static final DeferredItem<Item> KYO = ITEMS.registerSimpleItem("kyo", new Item.Properties());
    public static final DeferredItem<Item> RYU = ITEMS.registerSimpleItem("ryu", new Item.Properties());
    public static final DeferredItem<Item> RA  = ITEMS.registerSimpleItem("ra",  new Item.Properties());
    public static final DeferredItem<Item> BE  = ITEMS.registerSimpleItem("be",  new Item.Properties());
    public static final DeferredItem<Item> HO  = ITEMS.registerSimpleItem("ho",  new Item.Properties());
    public static final DeferredItem<Item> TO  = ITEMS.registerSimpleItem("to",  new Item.Properties());
    public static final DeferredItem<Item> CHU = ITEMS.registerSimpleItem("chu", new Item.Properties());
    public static final DeferredItem<Item> PU  = ITEMS.registerSimpleItem("pu",  new Item.Properties());
    public static final DeferredItem<Item> HI  = ITEMS.registerSimpleItem("hi",  new Item.Properties());
    public static final DeferredItem<Item> DU  = ITEMS.registerSimpleItem("du",  new Item.Properties());
    public static final DeferredItem<Item> TE  = ITEMS.registerSimpleItem("te",  new Item.Properties());
    public static final DeferredItem<Item> I   = ITEMS.registerSimpleItem("i",   new Item.Properties());
    public static final DeferredItem<Item> YO  = ITEMS.registerSimpleItem("yo",  new Item.Properties());
    public static final DeferredItem<Item> KA  = ITEMS.registerSimpleItem("ka",  new Item.Properties());
    public static final DeferredItem<Item> KU  = ITEMS.registerSimpleItem("ku",  new Item.Properties());
    public static final DeferredItem<Item> HE  = ITEMS.registerSimpleItem("he",  new Item.Properties());
    public static final DeferredItem<Item> SHA = ITEMS.registerSimpleItem("sha", new Item.Properties());
    public static final DeferredItem<Item> SHO = ITEMS.registerSimpleItem("sho", new Item.Properties());
    public static final DeferredItem<Item> RI  = ITEMS.registerSimpleItem("ri",  new Item.Properties());
    public static final DeferredItem<Item> NYA = ITEMS.registerSimpleItem("nya", new Item.Properties());
    public static final DeferredItem<Item> PE  = ITEMS.registerSimpleItem("pe",  new Item.Properties());
    public static final DeferredItem<Item> GYO = ITEMS.registerSimpleItem("gyo", new Item.Properties());
    public static final DeferredItem<Item> E   = ITEMS.registerSimpleItem("e",   new Item.Properties());
    public static final DeferredItem<Item> KE  = ITEMS.registerSimpleItem("ke",  new Item.Properties());
    public static final DeferredItem<Item> KO  = ITEMS.registerSimpleItem("ko",  new Item.Properties());
    public static final DeferredItem<Item> TSU = ITEMS.registerSimpleItem("tsu", new Item.Properties());
    public static final DeferredItem<Item> NE  = ITEMS.registerSimpleItem("ne",  new Item.Properties());
    public static final DeferredItem<Item> MA  = ITEMS.registerSimpleItem("ma",  new Item.Properties());
    public static final DeferredItem<Item> YU  = ITEMS.registerSimpleItem("yu",  new Item.Properties());
    public static final DeferredItem<Item> YA  = ITEMS.registerSimpleItem("ya",  new Item.Properties());
    public static final DeferredItem<Item> N   = ITEMS.registerSimpleItem("n",   new Item.Properties());

    // ワープアイテム
    public static final DeferredItem<Item> MURATA_TICKET =
            ITEMS.registerSimpleItem("murata_ticket", new Item.Properties());
    public static final DeferredItem<Item> RETURN_TICKET =
            ITEMS.registerSimpleItem("return_ticket", new Item.Properties());

    public static final DeferredItem<Item> GYOGYOUKEN = ITEMS.registerSimpleItem("gyogyouken",new Item.Properties());
    public static final DeferredItem<Item> ZOO_TOPASS = ITEMS.registerSimpleItem("zoo_topass",new Item.Properties());
    public static final DeferredItem<Item> KAJU100_KEY = ITEMS.registerSimpleItem("kaju100_key",new Item.Properties());
    public static final DeferredItem<Item> GURUMEKARD = ITEMS.registerSimpleItem("gurumekard",new Item.Properties());

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
