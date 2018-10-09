package fr.wonyu.orthyong.client.utils.generation.ores;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import fr.wonyu.orthyong.common.blocks.OrthyonBlocksList;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class OrthyonOreGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {

		switch (world.provider.dimensionId) {
		case -1:
			break;
		case 0:
			generateOverworld(world, chunkX, chunkZ, random);
			break;
		case 1:
			break;
		}

	}

	private void generateOverworld(World world, int x, int z, Random rand) {

		if (world.getBiomeGenForCoords(x, z).equals(BiomeGenBase.ocean)
				&& world.getBiomeGenForCoords(x, z).equals(BiomeGenBase.river)
				&& world.getBiomeGenForCoords(x, z).equals(BiomeGenBase.deepOcean)
				&& world.getBiomeGenForCoords(x, z).equals(BiomeGenBase.frozenOcean)
				&& world.getBiomeGenForCoords(x, z).equals(BiomeGenBase.frozenRiver)) {
			for (int i = 0; i < 20; i++) {
				(new WorldGenMinable(OrthyonBlocksList.WATER_ORE, 5, 12, Blocks.stone)).generate(world, rand, x + rand.nextInt(16), rand.nextInt(64), z + rand.nextInt(16));
			}
		}
	}

}
