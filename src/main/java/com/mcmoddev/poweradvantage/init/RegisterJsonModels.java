package com.mcmoddev.poweradvantage.init;

import com.mcmoddev.lib.common.MMDLibRegistry;
import com.mcmoddev.poweradvantage.block.BlockScaffolding;
import com.mcmoddev.poweradvantage.item.ItemDynamite;
import com.mcmoddev.poweradvantage.misc.Crystal;
import com.mcmoddev.poweradvantage.misc.Material;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemColored;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RegisterJsonModels {

    public static void registerModels() {
        items();
        blocks();
    }

    private static void blocks() {
        for (BlockScaffolding.Type type : BlockScaffolding.Type.values())
            register(ModBlocks.SCAFFOLDING, type.ordinal(), "block/" + type.getName() + "_scaffolding");
    }

    public static void registerColor() {
        MMDLibRegistry.registerItemColour(ModItems.CASING, ModItems.CASING);
        MMDLibRegistry.registerItemColour(ModItems.DENSE_PLATE, ModItems.DENSE_PLATE);
        MMDLibRegistry.registerItemColour(ModItems.PLATE, ModItems.PLATE);
        MMDLibRegistry.registerItemColour(ModItems.SMALLDUST, ModItems.SMALLDUST);
        MMDLibRegistry.registerItemColour(ModItems.PURIFIED, ModItems.PURIFIED);
        MMDLibRegistry.registerItemColour(ModItems.CRUSHED, ModItems.CRUSHED);
        MMDLibRegistry.registerItemColour(ModItems.PAINTBRUSH, ModItems.PAINTBRUSH);
        MMDLibRegistry.registerItemColour(ModItems.PAINTCAN, ModItems.PAINTCAN);
    }

    private static void items() {
        register(ModItems.SCREWDRIVER, "tool/screwdriver");
        register(ModItems.MANUAL, "tool/manual");
        register(ModItems.WRENCH, "tool/wrench");
        for (Crystal material : Crystal.values())
            register(ModItems.CRYSTAL, material.ordinal(), "resource/crystal");
        for (Material material : Material.values())
            register(ModItems.CASING, material.ordinal(), "resource/casing");
        for (Material material : Material.values())
            register(ModItems.DENSE_PLATE, material.ordinal(), "resource/dense_plate");
        for (Material material : Material.values())
            register(ModItems.PLATE, material.ordinal(), "resource/plate");
        for (Material material : Material.values())
            register(ModItems.SMALLDUST, material.ordinal(), "resource/small_dust");
        for (Material material : Material.values())
            register(ModItems.CRUSHED, material.ordinal(), "resource/crushed");
        for (Material material : Material.values())
            register(ModItems.PURIFIED, material.ordinal(), "resource/purified");
        for (EnumDyeColor color : EnumDyeColor.values())
            register(ModItems.PAINTBRUSH, color.getMetadata(), "tool/paintbrush");
        for (EnumDyeColor color : EnumDyeColor.values())
            register(ModItems.PAINTCAN, color.getMetadata(), "tool/paintcan");
        for (ItemDynamite.Type type : ItemDynamite.Type.values())
            register(ModItems.DYNAMITE, type.ordinal(), "dynamite/" + type.name().toLowerCase());
    }

    private static void register(Item item, String name) {
        register(item, 0, name);
    }

    private static void register(Item item, int meta, String name) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation("poweradvantage:" + name, "inventory"));
    }

    private static void register(Block block, int meta, String name) {
        register(Item.getItemFromBlock(block), meta, name);
    }

    private static void register(Block block, String name) {
        register(block, 0, name);
    }
}