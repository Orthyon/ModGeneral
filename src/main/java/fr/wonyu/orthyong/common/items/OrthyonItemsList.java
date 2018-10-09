package fr.wonyu.orthyong.common.items;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.wonyu.orthyong.client.utils.References;
import fr.wonyu.orthyong.common.items.base.OrthyonItemBase;
import net.minecraft.item.Item;

public class OrthyonItemsList {
	
	// INGOTS
	public static Item WATER_INGOT;
	
	// ITEMS
	public static Item BASE;
	
	public static void registerItems() {
		
		// ORES
		WATER_INGOT = new OrthyonItemBase().setUnlocalizedName("water_ingot").setTextureName(References.MODID + ":water_ingot");
		
		// ITEMS
		BASE = new OrthyonItemBase().setUnlocalizedName("icon").setTextureName(References.MODID + ":icon");
	}
	
	public static void gameRegistryItems() {
		
		// ORES
		GameRegistry.registerItem(WATER_INGOT, "water_ingot");
		
		// ITEMS
		GameRegistry.registerItem(BASE, "icon");
	}
}
