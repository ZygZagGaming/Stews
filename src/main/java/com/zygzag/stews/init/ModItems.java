package com.zygzag.stews.init;

import com.zygzag.stews.Stews;
import com.zygzag.stews.items.EnchantedGoldenStewItem;
import com.zygzag.stews.items.GoldenStewItem;
import com.zygzag.stews.items.ShulkerBowlItem;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Stews.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<GoldenStewItem> GOLDEN_STEW = ITEMS.register("golden_stew", GoldenStewItem::new);
    public static final RegistryObject<EnchantedGoldenStewItem> ENCHANTED_GOLDEN_STEW = ITEMS.register("enchanted_golden_stew", EnchantedGoldenStewItem::new);
    public static final RegistryObject<Item> SHULKER_BOWL = ITEMS.register("shulker_bowl", ShulkerBowlItem::new);


}
