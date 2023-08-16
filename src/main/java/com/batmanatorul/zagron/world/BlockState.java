package com.batmanatorul.zagron.world;

import net.minecraft.world.level.block.Block;
import org.bukkit.craftbukkit.v1_18_R2.block.CraftBlock;

public class BlockState {
    private final Block block;

    public BlockState(org.bukkit.block.Block block) {
        this(((CraftBlock) block).getNMS().getBlock());
    }

    public BlockState(Block block) {
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }
}
