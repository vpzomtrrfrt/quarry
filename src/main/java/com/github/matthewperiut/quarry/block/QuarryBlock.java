package com.github.matthewperiut.quarry.block;

import com.github.matthewperiut.quarry.functionality.QuarryEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class QuarryBlock extends Block implements BlockEntityProvider {

    public QuarryBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getStateManager().getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    // Directional Block properties
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager)
    {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }
    public BlockState getPlacementState(ItemPlacementContext ctx)
    {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }
    // -- end --

    // Create Block entity
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new QuarryEntity();
    }
    // -- end --
}
