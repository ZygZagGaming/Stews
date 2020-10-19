package com.zygzag.stews.recipes;

import com.google.common.collect.Lists;
import com.zygzag.stews.init.ModItems;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ShulkerBowlRecipe extends SpecialRecipe {

    public ShulkerBowlRecipe(ResourceLocation idIn) {
        super(idIn);
    }


    /**
     * Used to check if a recipe matches current crafting inventory
     */
    public boolean matches(CraftingInventory inv, World worldIn) {

        List<Item> list = Lists.newArrayList();
        List<Item> duplicateList = Lists.newArrayList();
        int beetrootCount = 0;

        for(int i = 0; i < inv.getSizeInventory(); ++i) {
            ItemStack itemstack = inv.getStackInSlot(i);
            if (!itemstack.isEmpty()) {
                if (duplicateList.contains(itemstack.getItem())) {
                    return false;
                } else if (list.contains(itemstack.getItem())) {
                    duplicateList.add(itemstack.getItem());
                } else {
                    list.add(itemstack.getItem());
                }
                if (itemstack.getItem() == Items.BEETROOT) {
                    beetrootCount++;
                }
            }
        }

        if (list.contains(Items.SHULKER_SHELL) || list.contains(ModItems.SHULKER_BOWL.get())) {
            if (list.contains(Items.RED_MUSHROOM) && list.contains(Items.BROWN_MUSHROOM)) {
                return (list.size() == 3 && duplicateList.size() == 0)
                        || list.contains(Items.ALLIUM)
                        || list.contains(Items.AZURE_BLUET)
                        || list.contains(Items.BLUE_ORCHID)
                        || list.contains(Items.CORNFLOWER)
                        || list.contains(Items.LILY_OF_THE_VALLEY)
                        || list.contains(Items.OXEYE_DAISY)
                        || list.contains(Items.POPPY)
                        || list.contains(Items.WITHER_ROSE)
                        || list.contains(Items.WHITE_TULIP)
                        || list.contains(Items.ORANGE_TULIP)
                        || list.contains(Items.PINK_TULIP)
                        || list.contains(Items.RED_TULIP);
            } else if (beetrootCount == 6 && list.size() == 2 && duplicateList.size() == 1) {
                return true;
            } else if (
                    list.contains(Items.GOLD_INGOT)
                    && list.contains(Items.GOLDEN_APPLE)
                    && list.contains(Items.GOLDEN_CARROT)
                    && duplicateList.contains(Items.GOLD_INGOT)
                    && duplicateList.contains(Items.GOLDEN_CARROT)
                    && list.size() == 4
                    && duplicateList.size() == 2
            ) {
                return true;
            } else if (
                    list.contains(Items.COOKED_RABBIT)
                    && list.contains(Items.CARROT)
                    && list.contains(Items.BAKED_POTATO)
                    && (list.contains(Items.BROWN_MUSHROOM)
                    || list.contains(Items.RED_MUSHROOM))
                    && list.size() == 5
                    && duplicateList.size() == 0
            ) {
                return true;
            } else return (list.contains(Items.RABBIT_STEW)
                        || list.contains(Items.BEETROOT_SOUP)
                        || list.contains(Items.MUSHROOM_STEW)
                        || list.contains(Items.SUSPICIOUS_STEW)
                        || list.contains(ModItems.GOLDEN_STEW.get())
                        || list.contains(ModItems.ENCHANTED_GOLDEN_STEW.get())
                        && list.size() == 2
                        && duplicateList.size() == 0);
        } else {
            return false;
        }
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    public ItemStack getCraftingResult(CraftingInventory inv) {

        List<Item> list = Lists.newArrayList();
        List<ItemStack> listStack = Lists.newArrayList();
        int beetrootCount = 0;

        for(int i = 0; i < inv.getSizeInventory(); ++i) {
            ItemStack itemstack = inv.getStackInSlot(i);
            if (!itemstack.isEmpty()) {
                listStack.add(itemstack);
                if (!(list.contains(itemstack.getItem()))) {
                    list.add(itemstack.getItem());
                }
                if (itemstack.getItem() == Items.BEETROOT)
                    beetrootCount++;
            }
        }

        int hunger = 0;
        float saturation = 0.0F;
        int fireResTime = 0;
        int blindnessTime = 0;
        int saturationTime = 0;
        int jumpBoostTime = 0;
        int poisonTime = 0;
        int regenTime = 0;
        int nightVisTime = 0;
        int weaknessTime = 0;
        int witherTime = 0;
        int absorptionTime = 0;
        int resistanceTime = 0;
        int luckTime = 0;
        int fireResLevel = 0;
        int blindnessLevel = 0;
        int saturationLevel = 0;
        int jumpBoostLevel = 0;
        int poisonLevel = 0;
        int regenLevel = 0;
        int nightVisLevel = 0;
        int weaknessLevel = 0;
        int witherLevel = 0;
        int absorptionLevel = 0;
        int resistanceLevel = 0;
        int luckLevel = 0;
        int count = 0;

        if(list.contains(ModItems.SHULKER_BOWL.get())) {
            ItemStack result = listStack.get(list.indexOf(ModItems.SHULKER_BOWL.get()));
            if(result.getTag() != null) {
                if(result.getTag().contains("hunger"))
                    hunger = result.getTag().getInt("hunger");
                if(result.getTag().contains("saturation"))
                    saturation = result.getTag().getFloat("saturation");
                if(result.getTag().contains("fireResTime"))
                    fireResTime = result.getTag().getInt("fireResTime");
                if(result.getTag().contains("blindnessTime"))
                    blindnessTime = result.getTag().getInt("blindnessTime");
                if(result.getTag().contains("saturationTime"))
                    saturationTime = result.getTag().getInt("saturationTime");
                if(result.getTag().contains("jumpBoostTime"))
                    jumpBoostTime = result.getTag().getInt("jumpBoostTime");
                if(result.getTag().contains("poisonTime"))
                    poisonTime = result.getTag().getInt("poisonTime");
                if(result.getTag().contains("regenTime"))
                    regenTime = result.getTag().getInt("regenTime");
                if(result.getTag().contains("nightVisTime"))
                    nightVisTime = result.getTag().getInt("nightVisTime");
                if(result.getTag().contains("weaknessTime"))
                    weaknessTime = result.getTag().getInt("weaknessTime");
                if(result.getTag().contains("witherTime"))
                    witherTime = result.getTag().getInt("witherTime");
                if(result.getTag().contains("absorptionTime"))
                    absorptionTime = result.getTag().getInt("absorptionTime");
                if(result.getTag().contains("resistanceTime"))
                    resistanceTime = result.getTag().getInt("resistanceTime");
                if(result.getTag().contains("luckTime"))
                    luckTime = result.getTag().getInt("luckTime");
                if(result.getTag().contains("fireResLevel"))
                    fireResLevel = result.getTag().getInt("fireResLevel");
                if(result.getTag().contains("blindnessLevel"))
                    blindnessLevel = result.getTag().getInt("blindnessLevel");
                if(result.getTag().contains("saturationLevel"))
                    saturationLevel = result.getTag().getInt("saturationLevel");
                if(result.getTag().contains("jumpBoostLevel"))
                    jumpBoostLevel = result.getTag().getInt("jumpBoostLevel");
                if(result.getTag().contains("poisonLevel"))
                    poisonLevel = result.getTag().getInt("poisonLevel");
                if(result.getTag().contains("regenLevel"))
                    regenLevel = result.getTag().getInt("regenLevel");
                if(result.getTag().contains("nightVisLevel"))
                    nightVisLevel = result.getTag().getInt("nightVisLevel");
                if(result.getTag().contains("weaknessLevel"))
                    weaknessLevel = result.getTag().getInt("weaknessLevel");
                if(result.getTag().contains("witherLevel"))
                    witherLevel = result.getTag().getInt("witherLevel");
                if(result.getTag().contains("absorptionLevel"))
                    absorptionLevel = result.getTag().getInt("absorptionLevel");
                if(result.getTag().contains("resistanceLevel"))
                    resistanceLevel = result.getTag().getInt("resistanceLevel");
                if(result.getTag().contains("luckLevel"))
                    luckLevel = result.getTag().getInt("luckLevel");
                if(result.getTag().contains("count"))
                    count = result.getTag().getInt("count");
            }
        }

        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt("hunger", hunger);
        nbt.putFloat("saturation", saturation);
        nbt.putInt("fireResTime", fireResTime);
        nbt.putInt("blindnessTime", blindnessTime);
        nbt.putInt("saturationTime", saturationTime);
        nbt.putInt("jumpBoostTime", jumpBoostTime);
        nbt.putInt("poisonTime", poisonTime);
        nbt.putInt("regenTime", regenTime);
        nbt.putInt("nightVisTime", nightVisTime);
        nbt.putInt("weaknessTime", weaknessTime);
        nbt.putInt("witherTime", witherTime);
        nbt.putInt("absorptionTime", absorptionTime);
        nbt.putInt("resistanceTime", resistanceTime);
        nbt.putInt("luckTime", luckTime);
        nbt.putInt("fireResLevel", fireResLevel);
        nbt.putInt("blindnessLevel", blindnessLevel);
        nbt.putInt("saturationLevel", saturationLevel);
        nbt.putInt("jumpBoostLevel", jumpBoostLevel);
        nbt.putInt("poisonLevel", poisonLevel);
        nbt.putInt("regenLevel", regenLevel);
        nbt.putInt("nightVisLevel", nightVisLevel);
        nbt.putInt("weaknessLevel", weaknessLevel);
        nbt.putInt("witherLevel", witherLevel);
        nbt.putInt("absorptionLevel", absorptionLevel);
        nbt.putInt("resistanceLevel", resistanceLevel);
        nbt.putInt("luckLevel", luckLevel);
        nbt.putInt("count", count + 1);

        if ((list.contains(Items.RED_MUSHROOM) && list.contains(Items.BROWN_MUSHROOM)) || list.contains(Items.SUSPICIOUS_STEW) || list.contains(Items.MUSHROOM_STEW)) {
            nbt.putInt("hunger", nbt.getInt("hunger") + 6);
            nbt.putFloat("saturation", nbt.getFloat("saturation") + 7.2F);
            if (!(list.size() == 3)) {
                if (list.contains(Items.ALLIUM)) {
                    nbt.putInt("fireResTime", nbt.getInt("fireResTime") + 80);
                    nbt.putInt("fireResLevel", Math.max(nbt.getInt("fireResLevel"), 1));
                } else if (list.contains(Items.AZURE_BLUET)) {
                    nbt.putInt("blindnessTime", nbt.getInt("blindnessTime") + 160);
                    nbt.putInt("blindnessLevel", Math.max(nbt.getInt("blindnessLevel"), 1));
                } else if (list.contains(Items.BLUE_ORCHID)|| list.contains(Items.DANDELION)) {
                    nbt.putInt("saturationTime", nbt.getInt("saturation") + 7);
                    nbt.putInt("saturationLevel", Math.max(nbt.getInt("saturationLevel"), 1));
                } else if (list.contains(Items.CORNFLOWER)) {
                    nbt.putInt("jumpBoostTime", nbt.getInt("jumpBoostTime") + 120);
                    nbt.putInt("jumpBoostLevel", Math.max(nbt.getInt("jumpBoostLevel"), 1));
                } else if (list.contains(Items.LILY_OF_THE_VALLEY)) {
                    nbt.putInt("poisonTime", nbt.getInt("poisonTime") + 240);
                    nbt.putInt("poisonLevel", Math.max(nbt.getInt("poisonLevel"), 1));
                } else if (list.contains(Items.OXEYE_DAISY)) {
                    nbt.putInt("regenTime", nbt.getInt("regenTime") + 160);
                    nbt.putInt("regenLevel", Math.max(nbt.getInt("regenLevel"), 1));
                } else if (list.contains(Items.POPPY)) {
                    nbt.putInt("nightVisTime", nbt.getInt("nightVisTime") + 100);
                    nbt.putInt("nightVisLevel", Math.max(nbt.getInt("nightVisLevel"), 1));
                } else if (list.contains(Items.WHITE_TULIP) || list.contains(Items.ORANGE_TULIP) || list.contains(Items.PINK_TULIP) || list.contains(Items.RED_TULIP)) {
                    nbt.putInt("weaknessTime", nbt.getInt("weaknessTime") + 180);
                    nbt.putInt("weaknessLevel", Math.max(nbt.getInt("weaknessLevel"), 1));
                } else if (list.contains(Items.WITHER_ROSE)) {
                    nbt.putInt("witherTime", nbt.getInt("witherTime") + 160);
                    nbt.putInt("witherLevel", Math.max(nbt.getInt("witherLevel"), 1));
                }
            }
        }

        if (beetrootCount == 6 || list.contains(Items.BEETROOT_SOUP)) {
            nbt.putInt("hunger", nbt.getInt("hunger") + 6);
            nbt.putFloat("saturation", nbt.getFloat("saturation") + 7.2F);
        }
        if (list.contains(Items.COOKED_RABBIT) || list.contains(Items.RABBIT_STEW)) {
            nbt.putInt("hunger", nbt.getInt("hunger") + 10);
            nbt.putFloat("saturation", nbt.getFloat("saturation") + 12.0F);
        }
        if (list.contains(ModItems.GOLDEN_STEW.get()) || list.contains(ModItems.ENCHANTED_GOLDEN_STEW.get())) {
            nbt.putInt("hunger", nbt.getInt("hunger") + 20);
            nbt.putFloat("saturation", nbt.getFloat("saturation") + 20.0F);
            nbt.putInt("absorptionTime", nbt.getInt("absorptionTime") + 3600);
            nbt.putInt("absorptionLevel", Math.max(nbt.getInt("absorptionLevel"), 1));
            nbt.putInt("regenTime", nbt.getInt("regenTime") + 3600);
            nbt.putInt("regenLevel", Math.max(nbt.getInt("regenLevel"), 2));
        }
        if (list.contains(ModItems.ENCHANTED_GOLDEN_STEW.get())) {
            nbt.putInt("luckTime", nbt.getInt("luckTime") + 5400);
            nbt.putInt("luckLevel", Math.max(nbt.getInt("luckLevel"), 0));
            nbt.putInt("resistanceTime", nbt.getInt("resistanceTime") + 5400);
            nbt.putInt("resistanceLevel", Math.max(nbt.getInt("resistanceLevel"), 1));
            nbt.putInt("fireResTime", nbt.getInt("fireResTime") + 5400);
            nbt.putInt("fireResLevel", Math.max(nbt.getInt("fireResLevel"), 0));
        }
        ItemStack result = ModItems.SHULKER_BOWL.get().getDefaultInstance();
        result.setTag(nbt);
        return result;
    }

    /**
     * Used to determine if this recipe can fit in a grid of the given width/height
     */
    public boolean canFit(int width, int height) {
        return width * height >= 9;
    }

    public IRecipeSerializer<?> getSerializer() {
        return ModIRecipeSerializer.SHULKER_BOWL_RECIPE;
    }
}
