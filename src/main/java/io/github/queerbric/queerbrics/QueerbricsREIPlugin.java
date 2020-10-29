package io.github.queerbric.queerbrics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mojang.datafixers.util.Pair;

import org.jetbrains.annotations.NotNull;

import io.github.queerbric.queerbrics.datatypes.item.QueerBrickItem;
import io.github.queerbric.queerbrics.registry.QueerbricsItems;
import me.shedaniel.rei.api.EntryRegistry;
import me.shedaniel.rei.api.EntryStack;
import me.shedaniel.rei.api.RecipeHelper;
import me.shedaniel.rei.api.plugins.REIPluginV0;
import me.shedaniel.rei.plugin.crafting.DefaultCraftingDisplay;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.StringTag;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
public class QueerbricsREIPlugin implements REIPluginV0 {
	private static List<Pair<QueerBrickItem, EntryStack>> entries = new ArrayList<Pair<QueerBrickItem, EntryStack>>();

	static {
		if (FabricLoader.getInstance().isModLoaded("titlescrolls")) {
			addEntry(QueerbricsItems.rainbowBrick);
			addEntry(QueerbricsItems.transBrick);
			addEntry(QueerbricsItems.panBrick);
			addEntry(QueerbricsItems.gayBrick);
			addEntry(QueerbricsItems.enbyBrick);
			addEntry(QueerbricsItems.biBrick);
			addEntry(QueerbricsItems.lesbianBrick);
			addEntry(QueerbricsItems.anarchyBrick);
		}
	}

	private static void addEntry(Item item) {
		QueerBrickItem qItem = (QueerBrickItem) item;
		ItemStack stack = new ItemStack(Registry.ITEM.get(new Identifier("titlescrolls:uncommon_title_scroll")), 1);
		stack.putSubTag("Title", StringTag.of(qItem.getTitle()));
		entries.add(Pair.of(qItem, EntryStack.create(stack)));
	}

	@Override
	public Identifier getPluginIdentifier() {
		return new Identifier("queerbrics", "titlescroll");
	}

	@Override
	public void registerEntries(EntryRegistry entryRegistry) {
		if (FabricLoader.getInstance().isModLoaded("titlescrolls")) {
			EntryStack base = EntryStack.create(Registry.ITEM.get(new Identifier("titlescrolls:uncommon_title_scroll")));
			for (Pair<QueerBrickItem, EntryStack> pair : entries) {
				entryRegistry.registerEntriesAfter(base, pair.getSecond());
			}
		}
	}

	@Override
	public void registerRecipeDisplays(RecipeHelper recipeHelper) {
		if (FabricLoader.getInstance().isModLoaded("titlescrolls")) {
			for (Pair<QueerBrickItem, EntryStack> pair : entries) {
				recipeHelper.registerDisplay(new ScrollRecipeDisplay(pair));
			}
		}
	}

	class ScrollRecipeDisplay implements DefaultCraftingDisplay {
		public List<List<EntryStack>> input = new ArrayList<List<EntryStack>>();
		public List<List<EntryStack>> result = new ArrayList<List<EntryStack>>();

		public ScrollRecipeDisplay(Pair<QueerBrickItem, EntryStack> pair) {
			input.add(List.of(EntryStack.create(pair.getFirst())));
			input.add(List.of(EntryStack.create(Registry.ITEM.get(new Identifier("titlescrolls:title_scroll")))));
			result.add(List.of(pair.getSecond()));
		}

		@Override
		public @NotNull List<List<EntryStack>> getInputEntries() {
			return input;
		}

		@Override
		public @NotNull List<List<EntryStack>> getResultingEntries() {
			return result;
		}

		@Override
		public Optional<Recipe<?>> getOptionalRecipe() {
			return Optional.empty();
		}
		
	}
}
