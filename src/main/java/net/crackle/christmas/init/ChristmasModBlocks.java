/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.crackle.christmas.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.crackle.christmas.block.MithrilOreBlock;
import net.crackle.christmas.block.MithrilBlockBlock;
import net.crackle.christmas.ChristmasMod;

import java.util.function.Function;

public class ChristmasModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(ChristmasMod.MODID);
	public static final DeferredBlock<Block> MITHRIL_ORE;
	public static final DeferredBlock<Block> MITHRIL_BLOCK;
	static {
		MITHRIL_ORE = register("mithril_ore", MithrilOreBlock::new);
		MITHRIL_BLOCK = register("mithril_block", MithrilBlockBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}