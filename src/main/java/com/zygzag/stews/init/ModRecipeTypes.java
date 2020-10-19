package com.zygzag.stews.init;

import com.zygzag.stews.recipes.ShulkerBowlRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipeSerializer;

public class ModRecipeTypes {

    public static void init() {
        final SpecialRecipeSerializer<ShulkerBowlRecipe> SHULKER_BOWL_RECIPE = IRecipeSerializer.register("crafting_special_shulker_bowl", new SpecialRecipeSerializer<>(ShulkerBowlRecipe::new));
    }

}