package com.zygzag.stews.items;

import com.zygzag.stews.Stews;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().group(Stews.TAB));
    }
}
