package net.crackle.christmas.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import net.crackle.christmas.procedures.SuspiciousPresentRightclickedProcedure;

public class SuspiciousPresentItem extends Item {
	public SuspiciousPresentItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).stacksTo(16));
	}

	@Override
	public boolean isPiglinCurrency(ItemStack stack) {
		return true;
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		SuspiciousPresentRightclickedProcedure.execute(entity);
		return ar;
	}
}