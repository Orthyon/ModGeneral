package fr.wonyu.orthyong.common.blocks.base;

import fr.wonyu.orthyong.client.utils.OrthyonTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class OrthyonOreBase extends Block {

	public OrthyonOreBase(Material mat) {
		super(mat);
		setCreativeTab(OrthyonTabs.orthyonores);
	}

}
