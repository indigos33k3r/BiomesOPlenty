/*******************************************************************************
 * Copyright 2015-2016, the Biomes O' Plenty Team
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package biomesoplenty.common.biome.overworld;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.api.block.BlockQueries;
import biomesoplenty.api.enums.BOPClimates;
import biomesoplenty.api.enums.BOPFlowers;
import biomesoplenty.api.enums.BOPFoliage;
import biomesoplenty.api.enums.BOPTrees;
import biomesoplenty.api.enums.BOPWoods;
import biomesoplenty.api.generation.GeneratorStage;
import biomesoplenty.common.block.BlockBOPDirt;
import biomesoplenty.common.block.BlockBOPDoublePlant;
import biomesoplenty.common.block.BlockBOPFlatPlant;
import biomesoplenty.common.block.BlockBOPGrass;
import biomesoplenty.common.world.generator.GeneratorDoubleFlora;
import biomesoplenty.common.world.generator.GeneratorFlora;
import biomesoplenty.common.world.generator.GeneratorGrass;
import biomesoplenty.common.world.generator.GeneratorWeighted;
import biomesoplenty.common.world.generator.tree.GeneratorBasicTree;
import biomesoplenty.common.world.generator.tree.GeneratorBigTree;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
 
public class BiomeGenCherryBlossomGrove extends BOPOverworldBiome
{
    public BiomeGenCherryBlossomGrove()
    {
        super("cherry_blossom_grove", new PropsBuilder("Cherry Blossom Grove").withGuiColour(0xF88F8F).withTemperature(0.55F).withRainfall(0.8F));
        
        // terrain
        this.terrainSettings.avgHeight(63).heightVariation(5, 25).sidewaysNoise(0.8F);
        
        this.topBlock = BOPBlocks.grass.getDefaultState().withProperty(BlockBOPGrass.VARIANT, BlockBOPGrass.BOPGrassType.SILTY);
        this.fillerBlock = BOPBlocks.dirt.getDefaultState().withProperty(BlockBOPDirt.VARIANT, BlockBOPDirt.BOPDirtType.SILTY);
        
        this.canSpawnInBiome = false;
        this.canGenerateVillages = false;
    
        this.addWeight(BOPClimates.COOL_TEMPERATE, 2);
        
        // flowers
        GeneratorWeighted flowerGenerator = new GeneratorWeighted(2.5F);
        this.addGenerator("flowers", GeneratorStage.FLOWERS, flowerGenerator);
        flowerGenerator.add("pink_daffodil", 6, (new GeneratorFlora.Builder().with(BOPFlowers.PINK_DAFFODIL).create()));
        flowerGenerator.add("syringa", 4, (new GeneratorDoubleFlora.Builder().with(BlockDoublePlant.EnumPlantType.SYRINGA).create()));
        flowerGenerator.add("houstonia", 3, (new GeneratorFlora.Builder().with(BlockFlower.EnumFlowerType.HOUSTONIA).create()));
        flowerGenerator.add("oxeye_daisy", 3, (new GeneratorFlora.Builder().with(BlockFlower.EnumFlowerType.OXEYE_DAISY).create()));
        flowerGenerator.add("dandelion", 1, (new GeneratorFlora.Builder().with(BlockFlower.EnumFlowerType.DANDELION).create()));
        flowerGenerator.add("poppy", 1, (new GeneratorFlora.Builder().with(BlockFlower.EnumFlowerType.POPPY).create()));
        
        // trees
        GeneratorWeighted treeGenerator = new GeneratorWeighted(3.0F);
        this.addGenerator("trees", GeneratorStage.TREE, treeGenerator);
        treeGenerator.add("pink_cherry", 2, (new GeneratorBasicTree.Builder()).log(BOPWoods.CHERRY).leaves(BOPTrees.PINK_CHERRY).create());
        treeGenerator.add("white_cherry", 1, (new GeneratorBasicTree.Builder()).log(BOPWoods.CHERRY).leaves(BOPTrees.WHITE_CHERRY).create());
        treeGenerator.add("large_pink_cherry", 4, (new GeneratorBigTree.Builder()).log(BOPWoods.CHERRY).leaves(BOPTrees.PINK_CHERRY).create());
        treeGenerator.add("large_white_cherry", 2, (new GeneratorBigTree.Builder()).log(BOPWoods.CHERRY).leaves(BOPTrees.WHITE_CHERRY).create());
        
        // other plants
        this.addGenerator("flax", GeneratorStage.FLOWERS,(new GeneratorDoubleFlora.Builder()).amountPerChunk(0.2F).with(BlockBOPDoublePlant.DoublePlantType.FLAX).generationAttempts(6).create());
        
        // water plants
        this.addGenerator("lily", GeneratorStage.LILYPAD, (new GeneratorFlora.Builder()).amountPerChunk(0.1F).with(Blocks.WATERLILY.getDefaultState()).create());
        
        // grasses
        GeneratorWeighted grassGenerator = new GeneratorWeighted(3.0F);
        this.addGenerator("grass", GeneratorStage.GRASS, grassGenerator);
        grassGenerator.add("shortgrass", 1, (new GeneratorGrass.Builder()).with(BOPFoliage.SHORTGRASS).create());
        grassGenerator.add("tallgrass", 2, (new GeneratorGrass.Builder()).with(BlockTallGrass.EnumType.GRASS).create());
    }
    
    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        return getModdedBiomeGrassColor(0x96EA9B);
    }

    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        return getModdedBiomeFoliageColor(0xA3FFAA);
    }
}
