package io.github.queerbric.queerbrics.registry;

import io.github.queerbric.queerbrics.QueerbricsMain;
import io.github.queerbric.queerbrics.datatypes.item.QueerBrickItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class QueerbricsItems {
	// Yes I know that this is a silly way to name colours, but it's consistent! - Caroline
	public static Item // Color Bricks
			BlackBrick, WhiteBrick, // Black, White
			DarkGreyBrick, LightGreyBrick, // Grey, Light Grey
			DarkBlueBrick, LightBlueBrick, // Blue, Light Blue
			DarkRedBrick, LightRedBrick, // Red, Pink
			DarkGreenBrick, LightGreenBrick, // Green, Lime Green
			DarkPurpleBrick, LightPurpleBrick, // Purple, Magenta
			DarkBrownBrick, YellowBrick, CyanBrick, OrangeBrick; // Yellow, Cyan, Orange, Brown
	public static Item // Pride Bricks
			RainbowBrick, // Poly-flag (Not to be confused with the Poly Flag)
			TransBrick, // Transgender Pride
			PanBrick, // Pansexual Pride
			GayBrick, // Gay Pride (Not to be confused with the Poly-flag)
			EnbyBrick, // Non-binary Pride
			BiBrick, // Bisexual Pride
			LesbianBrick, // Lesbian Pride
			AnarchyBrick; // Anarchist Pride
	
	public static void registerAll() {
		BlackBrick = registerItem("black_brick", new QueerBrickItem());
		WhiteBrick = registerItem("white_brick", new QueerBrickItem());
		DarkGreyBrick = registerItem("dark_grey_brick", new QueerBrickItem());
		LightGreyBrick = registerItem("light_grey_brick", new QueerBrickItem());
		DarkBlueBrick = registerItem("dark_blue_brick", new QueerBrickItem());
		LightBlueBrick = registerItem("light_blue_brick", new QueerBrickItem());
		DarkRedBrick = registerItem("dark_red_brick", new QueerBrickItem());
		LightRedBrick = registerItem("light_red_brick", new QueerBrickItem());
		DarkGreenBrick = registerItem("dark_green_brick", new QueerBrickItem());
		LightGreenBrick = registerItem("light_green_brick", new QueerBrickItem());
		DarkPurpleBrick = registerItem("dark_purple_brick", new QueerBrickItem());
		LightPurpleBrick = registerItem("light_purple_brick", new QueerBrickItem());
		DarkBrownBrick = registerItem("brown_brick", new QueerBrickItem());
		YellowBrick = registerItem("yellow_brick", new QueerBrickItem());
		CyanBrick = registerItem("cyan_brick", new QueerBrickItem());
		OrangeBrick = registerItem("orange_brick", new QueerBrickItem());
		
		RainbowBrick = registerItem("rainbow_brick", new QueerBrickItem());
		TransBrick = registerItem("trans_brick", new QueerBrickItem());
		PanBrick = registerItem("pan_brick", new QueerBrickItem());
		GayBrick = registerItem("gay_brick", new QueerBrickItem());
		EnbyBrick = registerItem("enby_brick", new QueerBrickItem());
		BiBrick = registerItem("bi_brick", new QueerBrickItem());
		LesbianBrick = registerItem("lesbian_brick", new QueerBrickItem());
		AnarchyBrick = registerItem("anarchy_brick", new QueerBrickItem());
//
//		RainbowFabric = registerItem("rainbow_fabric", new QueerFabricItem(new Item.Settings()));
//		TransFabric = registerItem("trans_fabric", new QueerFabricItem(new Item.Settings()));
//		PanFabric = registerItem("pan_fabric", new QueerFabricItem(new Item.Settings()));
//		GayFabric = registerItem("gay_fabric", new QueerFabricItem(new Item.Settings()));
//		EnbyFabric = registerItem("enby_fabric", new QueerFabricItem(new Item.Settings()));
//		BiFabric = registerItem("bi_fabric", new QueerFabricItem(new Item.Settings()));
//		LesbianFabric = registerItem("lesbian_fabric", new QueerFabricItem(new Item.Settings()));
//		AnarchyFabric = registerItem("anarchy_fabric", new QueerFabricItem(new Item.Settings()));
	}
	
	private static Item registerItem(String key, Item item) {
		return Registry.register(Registry.ITEM, QueerbricsMain.getId(key), item);
	}
}
