/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.crackle.christmas.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.crackle.christmas.item.SuspiciousPresentItem;
import net.crackle.christmas.item.RawMithrilItem;
import net.crackle.christmas.item.PresentItem;
import net.crackle.christmas.item.MithrilIngotItem;
import net.crackle.christmas.item.CandyCaneItem;
import net.crackle.christmas.ChristmasMod;

import java.util.function.Function;

public class ChristmasModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(ChristmasMod.MODID);
	public static final DeferredItem<Item> CANDY_CANE;
	public static final DeferredItem<Item> PRESENT;
	public static final DeferredItem<Item> SUSPICIOUS_PRESENT;
	public static final DeferredItem<Item> MITHRIL_INGOT;
	public static final DeferredItem<Item> RAW_MITHRIL;
	public static final DeferredItem<Item> MITHRIL_ORE;
	public static final DeferredItem<Item> MITHRIL_BLOCK;
	static {
		CANDY_CANE = register("candy_cane", CandyCaneItem::new);
		PRESENT = register("present", PresentItem::new);
		SUSPICIOUS_PRESENT = register("suspicious_present", SuspiciousPresentItem::new);
		MITHRIL_INGOT = register("mithril_ingot", MithrilIngotItem::new);
		RAW_MITHRIL = register("raw_mithril", RawMithrilItem::new);
		MITHRIL_ORE = block(ChristmasModBlocks.MITHRIL_ORE, new Item.Properties().fireResistant());
		MITHRIL_BLOCK = block(ChristmasModBlocks.MITHRIL_BLOCK, new Item.Properties().fireResistant());
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), properties);
	}
}