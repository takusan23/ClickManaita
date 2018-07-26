package com.takusan_23.clickmanaita;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ClickManaitaBlock_Gold extends Block {

    public ClickManaitaBlock_Gold(Material material) {
        super(Material.IRON,MapColor.GOLD);
        setCreativeTab(clickmanaita.ClickManaitaTab);
        setHardness(3.0F);
        setSoundType(SoundType.METAL);
        setUnlocalizedName("ClickManaitaBlock Gold");
        setRegistryName("clickmanaitablock_gold");
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        //Ver2.0仕様、エンチャとかのNBTタグも行けるっぽいけど挙動がアレ
        //beta1、実用レベルまでに成長した
        ItemStack item_drop = playerIn.inventory.getCurrentItem().copy().splitStack(1);

        int drop_count = 0;

        while (drop_count < 5)
        {
            playerIn.dropItem(item_drop,true);
            drop_count ++;
        }

        /*  旧仕様
        //ItemStackを使えるように
        ItemStack itemStack = playerIn.getHeldItem(hand);
        //メタデータを取得。これで花崗岩や苗木のドロップが正常に動作する。
        int i = itemStack.getItem().getMetadata(itemStack);

        //メタデータのあるアイテムも複製可能に！！！
        //NBT Tagはしらね
        //dropItemの個数指定出来るの忘れてた（）
        playerIn.dropItem(new ItemStack(itemStack.getItem(),16, i),true);

*/

        return true;
    }
}


