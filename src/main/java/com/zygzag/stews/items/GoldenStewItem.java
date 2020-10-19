package com.zygzag.stews.items;

import com.zygzag.stews.Stews;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.SoupItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class GoldenStewItem extends SoupItem {

    public GoldenStewItem() {
        super(new Item.Properties()
                .group(Stews.TAB)
                .food(new Food.Builder()
                        .hunger(20)
                        .saturation(2.0F)
                        .setAlwaysEdible()
                        .effect(() -> new EffectInstance(Effects.ABSORPTION, 3600, 1), 1.0f)
                        .effect(() -> new EffectInstance(Effects.REGENERATION, 40, 2), 1.0f)
                        .meat()
                        .build())
        );
    }
}
