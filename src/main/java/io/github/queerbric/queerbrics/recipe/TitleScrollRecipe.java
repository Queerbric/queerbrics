package io.github.queerbric.queerbrics.recipe;

import io.github.queerbric.queerbrics.datatypes.item.QueerBrickItem;
import io.github.queerbric.queerbrics.registry.QueerbricsRecipeSerializers;
import io.github.queerbric.queerbrics.registry.QueerbricsItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class TitleScrollRecipe extends SpecialCraftingRecipe {

	public TitleScrollRecipe(Identifier id) {
		super(id);
	}

	public boolean matches(CraftingInventory craftingInventory, World world) {
		int i = 0;
		int j = 0;

		for(int k = 0; k < craftingInventory.size(); ++k) {
			ItemStack itemStack = craftingInventory.getStack(k);
			if (!itemStack.isEmpty()) {
				if (Registry.ITEM.getKey(itemStack.getItem()).get().getValue().equals(new Identifier("titlescrolls", "title_scroll"))) {
					++i;
				} else {
					if (!(itemStack.getItem() instanceof QueerBrickItem)) {
						return false;
					}

					++j;
				}

				if (j > 1 || i > 1) {
					return false;
				}
			}
		}

		return i == 1 && j == 1;
	}

	public ItemStack craft(CraftingInventory craftingInventory) {
		ItemStack itemStack = ItemStack.EMPTY;
		QueerBrickItem bricItem = (QueerBrickItem) QueerbricsItems.rainbowBrick;

		for(int i = 0; i < craftingInventory.size(); ++i) {
			ItemStack itemStack2 = craftingInventory.getStack(i);
			if (!itemStack2.isEmpty()) {
				Item item = itemStack2.getItem();
				if (Registry.ITEM.getKey(itemStack.getItem()).get().getValue().equals(new Identifier("titlescrolls", "title_scroll"))) {
					itemStack = itemStack2;
				} else if (item instanceof QueerBrickItem) {
					bricItem = (QueerBrickItem) item;
				}
			}
		}

		ItemStack itemStack3 = new ItemStack(Registry.ITEM.get(new Identifier("titlescrolls", "uncommon_title_scroll")));
		CompoundTag tag = new CompoundTag();
		if (bricItem == QueerbricsItems.rainbowBrick) {
			tag.putString("Title", "queerbrics:rainbow");
		} else if (bricItem == QueerbricsItems.transBrick) {
			tag.putString("Title", "queerbrics:trans");
		} else if (bricItem == QueerbricsItems.panBrick) {
			tag.putString("Title", "queerbrics:pan");
		} else if (bricItem == QueerbricsItems.gayBrick) {
			tag.putString("Title", "queerbrics:gay");
		} else if (bricItem == QueerbricsItems.enbyBrick) {
			tag.putString("Title", "queerbrics:enby");
		} else if (bricItem == QueerbricsItems.biBrick) {
			tag.putString("Title", "queerbrics:bi");
		} else if (bricItem == QueerbricsItems.lesbianBrick) {
			tag.putString("Title", "queerbrics:lesbian");
		} else if (bricItem == QueerbricsItems.anarchyBrick) {
			tag.putString("Title", "queerbrics:ancom");
		} else {
			tag.putString("Title", "queerbrics:rainbow");
		}
		itemStack3.setTag(tag);

		return itemStack3;
	}

	@Environment(EnvType.CLIENT)
	public boolean fits(int width, int height) {
		return width * height >= 2;
	}

	public RecipeSerializer<?> getSerializer() {
		return QueerbricsRecipeSerializers.TITLE_SCROLL;
	}
}
