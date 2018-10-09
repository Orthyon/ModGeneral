package fr.wonyu.orthyong.client.utils.generation;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.wonyu.orthyong.client.utils.generation.ores.OrthyonOreGen;

public class OrthyonGenList {
	
	public static void registerGen() {
		GameRegistry.registerWorldGenerator(new OrthyonOreGen(), 0);
	}

}
