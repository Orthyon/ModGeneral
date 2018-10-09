package fr.wonyu.orthyong;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import de.matthiasmann.twl.utils.PNGDecoder;
import fr.wonyu.orthyong.client.utils.References;
import fr.wonyu.orthyong.client.utils.generation.OrthyonGenList;
import fr.wonyu.orthyong.common.blocks.OrthyonBlocksList;
import fr.wonyu.orthyong.common.items.OrthyonItemsList;
import fr.wonyu.orthyong.proxy.OrthyonCommonProxy;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION, acceptedMinecraftVersions = "[1.7.10]")
public class OrthyonG {

	@Instance
	public static OrthyonG instance;
	public static Logger logger;

	@SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.SERVER_PROXY)
	public static OrthyonCommonProxy proxy;

	public String[] ICON_PATHS = { "/assets/orthyong/textures/gui/logo/icon_16x16.png",
			"/assets/orthyong/textures/gui/logo/icon_32x32.png" };

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		logger = e.getModLog();
		proxy.preInit(e.getSuggestedConfigurationFile());
		OrthyonItemsList.registerItems();
		OrthyonBlocksList.registerBlocks();

		if (e.getSide() == Side.CLIENT) {
			Display.setTitle("Orthyon - Game Launch");
			ByteBuffer[] icon_array = new ByteBuffer[ICON_PATHS.length];
			try {
				for (int i = 0; i < ICON_PATHS.length; i++) {
					icon_array[i] = ByteBuffer.allocateDirect(1);
					String path = ICON_PATHS[i];
					icon_array[i] = loadIcon(path);
				}
			} catch (IOException event) {
				event.printStackTrace();
			}
			Display.setIcon(icon_array);
		}
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init();
		OrthyonItemsList.gameRegistryItems();
		OrthyonBlocksList.gameRegistryBlocks();
		OrthyonGenList.registerGen();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit();
	}

	public ByteBuffer loadIcon(String path) throws IOException {
		InputStream inputStream = getClass().getResourceAsStream(path);
		try {
			PNGDecoder decoder = new PNGDecoder(inputStream);
			ByteBuffer buffer = ByteBuffer.allocate(decoder.getWidth() * decoder.getHeight() * 4);
			decoder.decode(buffer, decoder.getWidth() * 4, PNGDecoder.Format.RGBA);

			buffer.flip();
			return buffer;
		} finally {
			inputStream.close();
		}
	}
}
