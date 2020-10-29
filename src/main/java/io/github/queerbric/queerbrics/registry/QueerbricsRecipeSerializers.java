package io.github.queerbric.queerbrics.registry;

import io.github.queerbric.queerbrics.recipe.TitleScrollRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class QueerbricsRecipeSerializers {
	public static final RecipeSerializer<TitleScrollRecipe> TITLE_SCROLL = 
			register("title_scroll", new SpecialRecipeSerializer<TitleScrollRecipe>(TitleScrollRecipe::new)); 

	public static void init() {
	}
	
	static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String id, S serializer) {
		return Registry.register(Registry.RECIPE_SERIALIZER, new Identifier("queerbrics", id), serializer);
	}
}
