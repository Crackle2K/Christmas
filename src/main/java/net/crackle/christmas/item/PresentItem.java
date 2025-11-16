package net.crackle.christmas.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import net.crackle.christmas.procedures.PresentRightclickedProcedure;

public class PresentItem extends Item {
	public PresentItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON));
	}

	@Override
	public boolean isPiglinCurrency(ItemStack stack) {
		return true;
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		PresentRightclickedProcedure.execute(entity);
		return ar;
	}
}