/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.crackle.christmas.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.crackle.christmas.ChristmasMod;

public class ChristmasModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChristmasMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CHRISTMAS_TAB = REGISTRY.register("christmas_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.christmas.christmas_tab")).icon(() -> new ItemStack(ChristmasModItems.CANDY_CANE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ChristmasModItems.CANDY_CANE.get());
				tabData.accept(ChristmasModItems.PRESENT.get());
				tabData.accept(ChristmasModItems.SUSPICIOUS_PRESENT.get());
				tabData.accept(ChristmasModItems.MITHRIL_INGOT.get());
				tabData.accept(ChristmasModItems.RAW_MITHRIL.get());
				tabData.accept(ChristmasModBlocks.MITHRIL_ORE.get().asItem());
				tabData.accept(ChristmasModBlocks.MITHRIL_BLOCK.get().asItem());
			}).withSearchBar().build());
}