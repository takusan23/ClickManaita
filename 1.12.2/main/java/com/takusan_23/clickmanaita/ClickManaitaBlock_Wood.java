package com.takusan_23.clickmanaita;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ClickManaitaBlock_Wood extends Block {

    public ClickManaitaBlock_Wood(Material material) {
        super(Material.WOOD);
        setCreativeTab(clickmanaita.ClickManaitaTab);
        setHardness(2.5F);
        setSoundType(SoundType.WOOD);
        setUnlocalizedName("ClickManaitaBlock Wood");
        setRegistryName("clickmanaitablock_wood");
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        //ItemStackを使えるように
        ItemStack itemStack = playerIn.getHeldItem(hand);
        //メタデータを取得。これで花崗岩や苗木のドロップが正常に動作する。
        int i = itemStack.getItem().getMetadata(itemStack);

        //メタデータのあるアイテムも複製可能に！！！
        //NBT Tagはしらね
        //dropItemの個数指定出来るの忘れてた（）
        playerIn.dropItem(new ItemStack(itemStack.getItem(),2, i),true);

/*
        playerIn.dropItem(new ItemStack(itemStack.getItem()),true);
        playerIn.dropItem(new ItemStack(itemStack.getItem()),true);
*/


        return true;
    }
}
