package dev.arisu.gtcedyntree.dropcreators;

import com.ferreusveritas.dynamictrees.systems.dropcreators.DropCreator;
import com.ferreusveritas.dynamictrees.trees.Species;
import dev.arisu.gtcedyntree.GTCEDynTree;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class DropCreatorResin extends DropCreator {

    private final Item resin;
    private final int resinMeta;
    private final float dropCount;

    public DropCreatorResin(ItemStack resinStack, float dropCount) {
        super(new ResourceLocation(GTCEDynTree.MODID, Objects.requireNonNull(resinStack.getItem().getRegistryName()).getPath()));

        this.resin = resinStack.getItem();
        this.resinMeta = resinStack.getMetadata();
        this.dropCount = dropCount;
    }

    @Override
    public List<ItemStack> getLogsDrop(World world, Species species, BlockPos breakPos, Random random, List<ItemStack> dropList, float volume) {
        return getLogDrops(world, species, breakPos, random, dropList, volume);
    }

    protected List<ItemStack> getLogDrops(World world, Species species, BlockPos breakPos, Random random, List<ItemStack> dropList, float volume) {
        dropList.add(new ItemStack(resin, (int) (volume * dropCount), resinMeta));
        return dropList;
    }

}
