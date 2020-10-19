package com.zygzag.stews.items;

import com.zygzag.stews.Stews;
import com.zygzag.stews.init.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Stews.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ShulkerBowlItem extends Item {
    public ShulkerBowlItem() {
        super(new Item.Properties()
                .group(Stews.TAB)
                .food(new Food.Builder()
                        .build()
                )
        );
    }

    @SubscribeEvent
    public static void onEatFood(LivingEntityUseItemEvent.Finish event) {
        ItemStack item = event.getItem();
        if (item.getItem() == ModItems.SHULKER_BOWL.get() && item.getTag() != null && !(event.getEntityLiving().getEntityWorld().isRemote())) {
            CompoundNBT nbt = item.getTag();
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
            if (nbt.contains("hunger")) {
                hunger = nbt.getInt("hunger") / nbt.getInt("count");
                nbt.putInt("hunger", hunger * nbt.getInt("count"));
            }
            if (nbt.contains("saturation")) {
                saturation = nbt.getFloat("saturation") /  nbt.getInt("count");
                nbt.putFloat("saturation", saturation * nbt.getInt("count"));
            }
            if (nbt.contains("fireResTime")) {
                fireResTime = nbt.getInt("fireResTime") / nbt.getInt("count");
                nbt.putInt("fireResTime", fireResTime * nbt.getInt("count"));
            }
            if (nbt.contains("blindnessTime")) {
                blindnessTime = nbt.getInt("blindnessTime") / nbt.getInt("count");
                nbt.putInt("blindnessTime", blindnessTime * nbt.getInt("count"));
            }
            if (nbt.contains("saturationTime")) {
                saturationTime = nbt.getInt("saturationTime") / nbt.getInt("count");
                nbt.putInt("saturationTime", saturationTime * nbt.getInt("count"));
            }
            if (nbt.contains("jumpBoostTime")) {
                jumpBoostTime = nbt.getInt("hunger") / nbt.getInt("count");
                nbt.putInt("hunger", jumpBoostTime * nbt.getInt("count"));
            }
            if (nbt.contains("poisonTime")) {
                poisonTime = nbt.getInt("poisonTime") / nbt.getInt("count");
                nbt.putInt("poisonTime", poisonTime * nbt.getInt("count"));
            }
            if (nbt.contains("regenTime")) {
                regenTime = nbt.getInt("regenTime") / nbt.getInt("count");
                nbt.putInt("regenTime", regenTime * nbt.getInt("count"));
            }
            if (nbt.contains("nightVisTime")) {
                nightVisTime = nbt.getInt("nightVisTime") / nbt.getInt("count");
                nbt.putInt("nightVisTime", nightVisTime * nbt.getInt("count"));
            }
            if (nbt.contains("weaknessTime")) {
                weaknessTime = nbt.getInt("weaknessTime") / nbt.getInt("count");
                nbt.putInt("weaknessTime", weaknessTime * nbt.getInt("count"));
            }
            if (nbt.contains("absorptionTime")) {
                absorptionTime = nbt.getInt("absorptionTime") / nbt.getInt("count");
                nbt.putInt("absorptionTime", absorptionTime * nbt.getInt("count"));
            }
            if (nbt.contains("witherTime")) {
                witherTime = nbt.getInt("witherTime") / nbt.getInt("count");
                nbt.putInt("witherTime", witherTime * nbt.getInt("count"));
            }
            if (nbt.contains("resistanceTime")) {
                resistanceTime = nbt.getInt("resistanceTime") / nbt.getInt("count");
                nbt.putInt("resistanceTime", resistanceTime * nbt.getInt("count"));
            }
            if (nbt.contains("luckTime")) {
                luckTime = nbt.getInt("luckTime") / nbt.getInt("count");
                nbt.putInt("luckTime", luckTime * nbt.getInt("count"));
            }
            if (nbt.contains("fireResLevel")) {
                fireResLevel = nbt.getInt("fireResLevel");
            }
            if (nbt.contains("blindnessLevel")) {
                blindnessLevel = nbt.getInt("blindnessLevel");
            }
            if (nbt.contains("saturationLevel")) {
                saturationLevel = nbt.getInt("saturationLevel");
            }
            if (nbt.contains("jumpBoostLevel")) {
                jumpBoostLevel = nbt.getInt("jumpBoostLevel");
            }
            if (nbt.contains("poisonLevel")) {
                poisonLevel = nbt.getInt("poisonLevel");
            }
            if (nbt.contains("regenLevel")) {
                regenLevel = nbt.getInt("regenLevel");
            }
            if (nbt.contains("nightVisLevel")) {
                nightVisLevel = nbt.getInt("nightVisLevel");
            }
            if (nbt.contains("weaknessLevel")) {
                weaknessLevel = nbt.getInt("weaknessLevel");
            }
            if (nbt.contains("absorptionLevel")) {
                absorptionLevel = nbt.getInt("absorptionLevel");
            }
            if (nbt.contains("witherLevel")) {
                witherLevel = nbt.getInt("witherLevel");
            }
            if (nbt.contains("resistanceLevel")) {
                resistanceLevel = nbt.getInt("resistanceLevel");
            }
            if (nbt.contains("luckLevel")) {
                luckLevel = nbt.getInt("luckLevel");
            }
            ItemStack bowl = ModItems.SHULKER_BOWL.get().getDefaultInstance();
            bowl.setTag(nbt);
            LivingEntity player = event.getEntityLiving();
            ServerWorld world = (ServerWorld) player.getEntityWorld();
            ItemEntity i = new ItemEntity(world, player.getPosX(), player.getPosY(), player.getPosZ());
            i.setItem(bowl);
            world.summonEntity(i);
            if (player.getType() == EntityType.PLAYER) {
                PlayerEntity p = (PlayerEntity) player;
                p.getFoodStats().addStats(hunger, saturation);
            }
            if (nbt.contains("fireResTime")) {
                EffectInstance fireRes = new EffectInstance(Effects.FIRE_RESISTANCE, fireResTime, fireResLevel);
                player.addPotionEffect(fireRes);
            }
            if (nbt.contains("blindnessTime")) {
                EffectInstance blindness = new EffectInstance(Effects.BLINDNESS, blindnessTime, blindnessLevel);
                player.addPotionEffect(blindness);
            }
            if (nbt.contains("saturationTime")) {
                EffectInstance saturationEffect = new EffectInstance(Effects.SATURATION, saturationTime, saturationLevel);
                player.addPotionEffect(saturationEffect);
            }
            if (nbt.contains("jumpBoostTime")) {
                EffectInstance jumpBoost = new EffectInstance(Effects.JUMP_BOOST, jumpBoostTime, jumpBoostLevel);
                player.addPotionEffect(jumpBoost);
            }
            if (nbt.contains("poisonTime")) {
                EffectInstance poison = new EffectInstance(Effects.POISON, poisonTime, poisonLevel);
                player.addPotionEffect(poison);
            }
            if (nbt.contains("regenTime")) {
                EffectInstance regen = new EffectInstance(Effects.REGENERATION, regenTime, regenLevel);
                player.addPotionEffect(regen);
            }
            if (nbt.contains("nightVisTime")) {
                EffectInstance nightVis = new EffectInstance(Effects.NIGHT_VISION, nightVisTime, nightVisLevel);
                player.addPotionEffect(nightVis);
            }
            if (nbt.contains("weaknessTime")) {
                EffectInstance weakness = new EffectInstance(Effects.WEAKNESS, weaknessTime, weaknessLevel);
                player.addPotionEffect(weakness);
            }
            if (nbt.contains("absorptionTime")) {
                EffectInstance absorption = new EffectInstance(Effects.ABSORPTION, absorptionTime, absorptionLevel);
                player.addPotionEffect(absorption);
            }
            if (nbt.contains("witherTime")) {
                EffectInstance wither = new EffectInstance(Effects.WITHER, witherTime, witherLevel);
                player.addPotionEffect(wither);
            }
            if (nbt.contains("resistanceTime")) {
                EffectInstance resistance = new EffectInstance(Effects.RESISTANCE, resistanceTime, resistanceLevel);
                player.addPotionEffect(resistance);
            }
            if (nbt.contains("luckTime")) {
                EffectInstance luck = new EffectInstance(Effects.LUCK, luckTime, luckLevel);
                player.addPotionEffect(luck);
            }
        }
    }
}

