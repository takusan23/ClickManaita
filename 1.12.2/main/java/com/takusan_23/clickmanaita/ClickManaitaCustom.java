package com.takusan_23.clickmanaita;

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
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ClickManaitaCustom extends Item {

    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();
        TileEntity tileEntity = null;

        int drop_count = 0;

        //try catch文
        //int→Stringに変換していますが
        //Stringに変換できなかったとき（数字を入れてない、値がおかしい）のためにtry catch文で
        //できなかった場合はメッセージを出すようにしてクラッシュを回避しています。

        try {
            String drop_count_start_string = itemstack.getDisplayName();
            int drop_count_start =  Integer.parseInt(drop_count_start_string.replaceAll("[^0-9]",""));

                while (drop_count < drop_count_start) {
                    block.harvestBlock(worldIn, player, pos, iblockstate, tileEntity, itemstack);
                    drop_count++;
                }


        }
        catch (NumberFormatException e){
            if (!worldIn.isRemote)
            {
                player.sendMessage(new TextComponentString("--------------------"));
                player.sendMessage(new TextComponentString("数字が正しくありません"));
                player.sendMessage(new TextComponentString("金床で名前を増やしたい量の数字に変更してください。"));
                player.sendMessage(new TextComponentString("上限はintの限界(2147483647)まで？整数のみ利用できます。"));
                player.sendMessage(new TextComponentString(""));
                player.sendMessage(new TextComponentString("The number is incorrect"));
                player.sendMessage(new TextComponentString("Please change the number of numbers you want to increase the name on the anvil."));
                player.sendMessage(new TextComponentString("Is the upper limit to the limit of int (2147483647)? Only integers are available."));
                player.sendMessage(new TextComponentString("--------------------"));
            }
        }

        return EnumActionResult.SUCCESS;

    }

}
