package net.crackle.christmas.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.crackle.christmas.init.ChristmasModItems;

public class PresentRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entLootTbl && _entLootTbl.getServer() != null) {
			DamageSource _dsLootTbl = _entLootTbl.getLastDamageSource();
			if (_dsLootTbl == null)
				_dsLootTbl = _entLootTbl.damageSources().generic();
			for (ItemStack itemstackiterator : _entLootTbl.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.parse("christmas:chests/christmas_bundle")))
					.getRandomItems(new LootParams.Builder((ServerLevel) _entLootTbl.level()).withParameter(LootContextParams.THIS_ENTITY, _entLootTbl)
							.withOptionalParameter(LootContextParams.LAST_DAMAGE_PLAYER, _entLootTbl.getLastHurtByMob() instanceof Player _player ? _player : null).withParameter(LootContextParams.DAMAGE_SOURCE, _dsLootTbl)
							.withOptionalParameter(LootContextParams.ATTACKING_ENTITY, _dsLootTbl.getEntity()).withOptionalParameter(LootContextParams.DIRECT_ATTACKING_ENTITY, _dsLootTbl.getDirectEntity())
							.withParameter(LootContextParams.ORIGIN, _entLootTbl.position()).withParameter(LootContextParams.BLOCK_STATE, _entLootTbl.level().getBlockState(_entLootTbl.blockPosition()))
							.withOptionalParameter(LootContextParams.BLOCK_ENTITY, _entLootTbl.level().getBlockEntity(_entLootTbl.blockPosition()))
							.withParameter(LootContextParams.TOOL, _entLootTbl instanceof Player _player ? _player.getInventory().getSelectedItem() : _entLootTbl.getUseItem()).withParameter(LootContextParams.EXPLOSION_RADIUS, 0f)
							.withLuck(_entLootTbl instanceof Player _player ? _player.getLuck() : 0).create(LootContextParamSets.EMPTY))) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = itemstackiterator.copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
		}
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(ChristmasModItems.PRESENT.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		if (entity instanceof ServerPlayer _player && _player.level() instanceof ServerLevel _level) {
			AdvancementHolder _adv = _level.getServer().getAdvancements().get(ResourceLocation.parse("christmas:nice_list"));
			if (_adv != null) {
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
	}
}