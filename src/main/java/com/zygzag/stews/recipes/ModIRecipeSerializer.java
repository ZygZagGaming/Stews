package com.zygzag.stews.recipes;

import com.google.gson.JsonObject;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public interface ModIRecipeSerializer<T extends IRecipe<?>> extends net.minecraftforge.registries.IForgeRegistryEntry<IRecipeSerializer<?>> {
    final SpecialRecipeSerializer<ShulkerBowlRecipe> SHULKER_BOWL_RECIPE = IRecipeSerializer.register("crafting_special_shulker_bowl", new SpecialRecipeSerializer<>(ShulkerBowlRecipe::new));


    T read(ResourceLocation recipeId, JsonObject json);

    @javax.annotation.Nullable
    T read(ResourceLocation recipeId, PacketBuffer buffer);

    void write(PacketBuffer buffer, T recipe);

    static <S extends IRecipeSerializer<T>, T extends IRecipe<?>> S register(String key, S recipeSerializer) {
        return Registry.register(Registry.RECIPE_SERIALIZER, key, recipeSerializer);
    }
}
