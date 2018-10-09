package fr.wonyu.orthyong.client.utils;

import fr.wonyu.orthyong.common.items.OrthyonItemsList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class OrthyonTabs {
	
	  public static CreativeTabs orthyonitems = new CreativeTabs("orthyonitems")
	  {
	    public Item getTabIconItem()
	    {
	      return new OrthyonItemsList().BASE;
	    }
	  };
	  
	  public static CreativeTabs orthyonores = new CreativeTabs("orthyonores")
	  {
	    public Item getTabIconItem()
	    {
	      return Item.getItemFromBlock(Blocks.diamond_ore);
	    }
	  };


}
