package biomesoplenty.common.biomes.overworld.ocean;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import biomesoplenty.api.content.BOPCBlocks;
import biomesoplenty.common.biomes.BOPOceanBiome;

public class BiomeGenCoralReef extends BOPOceanBiome
{
    private static final Height biomeHeight = new Height(-0.6F, 0.1F);
	
	public BiomeGenCoralReef(int biomeID) 
	{
		super(biomeID);

        this.zoom = 0.25D;
		this.threshold = 0.25D;
		
        this.setHeight(biomeHeight);
        this.setColor(18285);
        this.setTemperatureRainfall(0.5F, 0.9F);
        
        this.bopWorldFeatures.setFeature("coralPerChunk", 300);
        this.bopWorldFeatures.setFeature("shortKelpPerChunk", 100);
        this.bopWorldFeatures.setFeature("generateSponge", true);
        this.bopWorldFeatures.setFeature("seaweedPerChunk", 20);
	}

	@Override
	public void decorate(World world, Random random, int chunkX, int chunkZ)
	{
		super.decorate(world, random, chunkX, chunkZ);
		int var5 = 12 + random.nextInt(6);

		for (int var6 = 0; var6 < var5; ++var6)
		{
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(28) + 4;
			int z = chunkZ + random.nextInt(16);

			Block block = world.getBlock(x, y, z);

			if (block != null && block.isReplaceableOreGen(world, x, y, z, Blocks.stone))
			{
				world.setBlock(x, y, z, BOPCBlocks.gemOre, 12, 2);
			}
		}
	}
}
