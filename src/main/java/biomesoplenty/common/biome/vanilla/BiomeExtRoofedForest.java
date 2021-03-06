package biomesoplenty.common.biome.vanilla;

import biomesoplenty.api.enums.BOPFoliage;
import biomesoplenty.api.generation.GeneratorStage;
import biomesoplenty.common.block.BlockBOPMushroom;
import biomesoplenty.common.world.generator.GeneratorFlora;
import biomesoplenty.common.world.generator.GeneratorGrass;
import biomesoplenty.common.world.generator.GeneratorWeighted;
import net.minecraft.init.Biomes;

public class BiomeExtRoofedForest extends ExtendedBiomeWrapper
{
    public BiomeExtRoofedForest()
    {
        super(Biomes.ROOFED_FOREST);
        
        // grasses
        GeneratorWeighted grassGenerator = new GeneratorWeighted(0.3F);
        this.addGenerator("grass", GeneratorStage.GRASS, grassGenerator);
        grassGenerator.add("shortgrass", 2, (new GeneratorGrass.Builder()).with(BOPFoliage.SHORTGRASS).create());
        
        // shrooms
        this.addGenerator("toadstools", GeneratorStage.SHROOM,(new GeneratorFlora.Builder()).amountPerChunk(0.1F).generationAttempts(16).with(BlockBOPMushroom.MushroomType.TOADSTOOL).create());
    }
}
