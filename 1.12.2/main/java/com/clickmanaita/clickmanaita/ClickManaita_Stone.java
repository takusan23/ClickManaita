package com.clickmanaita.clickmanaita;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ClickManaita_Stone extends Item{

	 @SuppressWarnings("incomplete-switch")
	 public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	 {
	      	ItemStack itemstack = player.getHeldItem(hand);
           IBlockState iblockstate = worldIn.getBlockState(pos);
           Block block = iblockstate.getBlock();


			TileEntity tileEntity = null;
			block.harvestBlock(worldIn, player, pos, iblockstate, tileEntity, itemstack);
			block.harvestBlock(worldIn, player, pos, iblockstate, tileEntity, itemstack);
			block.harvestBlock(worldIn, player, pos, iblockstate, tileEntity, itemstack);
			block.harvestBlock(worldIn, player, pos, iblockstate, tileEntity, itemstack);

			return EnumActionResult.SUCCESS;

	 }

}
