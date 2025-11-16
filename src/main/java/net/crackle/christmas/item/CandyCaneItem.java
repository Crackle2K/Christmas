package net.crackle.christmas.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import net.crackle.christmas.procedures.CandyCanePlayerFinishesUsingItemProcedure;

public class CandyCaneItem extends Item {
	public CandyCaneItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.3f).alwaysEdible().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		CandyCanePlayerFinishesUsingItemProcedure.execute(entity);
		return retval;
	}
}