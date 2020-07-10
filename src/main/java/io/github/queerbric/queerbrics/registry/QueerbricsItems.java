package io.github.queerbric.queerbrics.registry;

import io.github.queerbric.queerbrics.QueerbricsMain;
import io.github.queerbric.queerbrics.datatypes.item.QueerBrickItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class QueerbricsItems {
	// Yes I know that this is a silly way to name colours, but it's consistent! - Caroline
	public static Item // Color Bricks
			blackBrick, whiteBrick, // Black, White
			darkGreyBrick, lightGreyBrick, // Grey, Light Grey
			darkBlueBrick, lightBlueBrick, // Blue, Light Blue
			darkRedBrick, lightRedBrick, // Red, Pink
			darkGreenBrick, lightGreenBrick, // Green, Lime Green
			darkPurpleBrick, lightPurpleBrick, // Purple, Magenta
			darkBrownBrick, yellowBrick, cyanBrick, orangeBrick; // Yellow, Cyan, Orange, Brown
	public static Item // Pride Bricks
			rainbowBrick, // Poly-flag (Not to be confused with the Poly Flag)
			transBrick, // Transgender Pride
			panBrick, // Pansexual Pride
			gayBrick, // Gay Pride (Not to be confused with the Poly-flag)
			enbyBrick, // Non-binary Pride
			biBrick, // Bisexual Pride
			lesbianBrick, // Lesbian Pride
			anarchyBrick; // Anarchist Pride
	
	public static void registerAll() {
		blackBrick = registerItem("black_brick", new QueerBrickItem());
		whiteBrick = registerItem("white_brick", new QueerBrickItem());
		darkGreyBrick = registerItem("dark_grey_brick", new QueerBrickItem());
		lightGreyBrick = registerItem("light_grey_brick", new QueerBrickItem());
		darkBlueBrick = registerItem("dark_blue_brick", new QueerBrickItem());
		lightBlueBrick = registerItem("light_blue_brick", new QueerBrickItem());
		darkRedBrick = registerItem("dark_red_brick", new QueerBrickItem());
		lightRedBrick = registerItem("light_red_brick", new QueerBrickItem());
		darkGreenBrick = registerItem("dark_green_brick", new QueerBrickItem());
		lightGreenBrick = registerItem("light_green_brick", new QueerBrickItem());
		darkPurpleBrick = registerItem("dark_purple_brick", new QueerBrickItem());
		lightPurpleBrick = registerItem("light_purple_brick", new QueerBrickItem());
		darkBrownBrick = registerItem("brown_brick", new QueerBrickItem());
		yellowBrick = registerItem("yellow_brick", new QueerBrickItem());
		cyanBrick = registerItem("cyan_brick", new QueerBrickItem());
		orangeBrick = registerItem("orange_brick", new QueerBrickItem());
		
		rainbowBrick = registerItem("rainbow_brick", new QueerBrickItem());
		transBrick = registerItem("trans_brick", new QueerBrickItem());
		panBrick = registerItem("pan_brick", new QueerBrickItem());
		gayBrick = registerItem("gay_brick", new QueerBrickItem());
		enbyBrick = registerItem("enby_brick", new QueerBrickItem());
		biBrick = registerItem("bi_brick", new QueerBrickItem());
		lesbianBrick = registerItem("lesbian_brick", new QueerBrickItem());
		anarchyBrick = registerItem("anarchy_brick", new QueerBrickItem());
//
//		rainbowFabric = registerItem("rainbow_fabric", new QueerFabricItem(new Item.Settings()));
//		transFabric = registerItem("trans_fabric", new QueerFabricItem(new Item.Settings()));
//		panFabric = registerItem("pan_fabric", new QueerFabricItem(new Item.Settings()));
//		gayFabric = registerItem("gay_fabric", new QueerFabricItem(new Item.Settings()));
//		enbyFabric = registerItem("enby_fabric", new QueerFabricItem(new Item.Settings()));
//		biFabric = registerItem("bi_fabric", new QueerFabricItem(new Item.Settings()));
//		lesbianFabric = registerItem("lesbian_fabric", new QueerFabricItem(new Item.Settings()));
//		anarchyFabric = registerItem("anarchy_fabric", new QueerFabricItem(new Item.Settings()));
	}
	
	private static Item registerItem(String key, Item item) {
		return Registry.register(Registry.ITEM, QueerbricsMain.getId(key), item);
	}
}
