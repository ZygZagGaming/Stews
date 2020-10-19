package com.zygzag.stews.items;

import com.zygzag.stews.Stews;
import net.minecraft.item.Food;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SoupItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class EnchantedGoldenStewItem extends SoupItem {

    public EnchantedGoldenStewItem() {
        super(new Properties()
                .group(Stews.TAB)
                .food(new Food.Builder()
                        .hunger(20)
                        .saturation(20.0F)
                        .setAlwaysEdible()
                        .effect(() -> new EffectInstance(Effects.ABSORPTION, 5400, 2), 1.0f)
                        .effect(() -> new EffectInstance(Effects.REGENERATION, 80, 3), 1.0f)
                        .effect(() -> new EffectInstance(Effects.RESISTANCE, 5400, 1), 1.0f)
                        .effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 5400, 0), 1.0f)
                        .effect(() -> new EffectInstance(Effects.LUCK, 5400, 0, false, false), 1.0f)
                        .meat()
                        .build())
        );
    }

    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
