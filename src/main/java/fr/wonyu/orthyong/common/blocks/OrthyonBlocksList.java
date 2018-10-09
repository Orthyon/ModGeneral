package fr.wonyu.orthyong.common.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.wonyu.orthyong.client.utils.References;
import fr.wonyu.orthyong.common.blocks.base.OrthyonOreBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class OrthyonBlocksList {
	
	// VARIABLE
	public static Material mat;
	
	// ORES
	public static Block WATER_ORE;
	
	public static void registerBlocks() {
		
		// ORES
		WATER_ORE = new OrthyonOreBase(mat.rock).setBlockName("water_ore").setBlockTextureName(References.MODID + ":water_ore");
	}
	
	public static void gameRegistryBlocks() {
		
		// ORES
		GameRegistry.registerBlock(WATER_ORE, "water_ore");
		
	}

}
