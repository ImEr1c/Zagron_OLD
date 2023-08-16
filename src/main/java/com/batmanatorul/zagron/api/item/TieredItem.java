package com.batmanatorul.zagron.api.item;

public class TieredItem extends Item {
    protected final Tier tier;

    public TieredItem(Tier tier, SpigotItemProperties spigotItemProperties) {
        super(spigotItemProperties);
        this.tier = tier;
    }
}
