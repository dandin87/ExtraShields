package dandin87.extrashields;

import dandin87.extrashields.object.Reflect;
import dandin87.extrashields.object.NightShield;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import dandin87.extrashields.object.ExampleShield;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ExtraShields implements ModInitializer
{
	public static final String MOD_ID = "extrashields";
	
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	
	@Override
	public void onInitialize()
	{
		//Register the new shield item
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "example_shield"), new ExampleShield(new Item.Settings().group(ItemGroup.COMBAT), 100, 337, ItemTags.PLANKS));

		//Register the new shield item
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "night_shield"), new NightShield(new Item.Settings().group(ItemGroup.COMBAT), 100, 337, ItemTags.PLANKS));


		//Register the new shield enchantment
		Registry.register(Registry.ENCHANTMENT, new Identifier(MOD_ID, "reflect"), new Reflect(Rarity.COMMON));
		
		LOGGER.info("\"" + MOD_ID + "\" Initialized... Extra Shields");
	}
}
