package net.crackle.christmas.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class MithrilBlockBlock extends Block {
	public MithrilBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.AMETHYST).strength(1f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}