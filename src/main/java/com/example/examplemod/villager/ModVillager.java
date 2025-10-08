package com.example.examplemod.villager;

import com.example.examplemod.ExampleMod;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModVillager {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, ExampleMod.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION,ExampleMod.MODID);

    public static final Holder<PoiType> HIRAGANA_POI = POI_TYPES.register("hiragana_poi",
            () -> new PoiType(ImmutableSet.copyOf(ExampleMod.EXAMPLE_BLOCK.get().getStateDefinition().getPossibleStates()),1,1));

    public static final Holder<VillagerProfession> HIRAGANAER = VILLAGER_PROFESSIONS.register("hiraganaer",
            () -> new VillagerProfession(Component.literal("hiraganaer"), holder -> holder.value() == HIRAGANA_POI.value(),
                    poiTypeHolder -> poiTypeHolder.value() == HIRAGANA_POI.value(),ImmutableSet.of(),ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_LIBRARIAN));

    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
