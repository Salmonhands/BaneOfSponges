package salmonhands.minecraft.baneofsponges;

import java.util.logging.Level;
import java.util.logging.Logger;

import openblocks.OpenBlocks;

import salmonhands.minecraft.baneofsponges.utilities.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=ModInfo.ID, name=ModInfo.NAME, version=ModInfo.VERSION, dependencies=ModInfo.DEPENDENCIES)
//@NetworkMod(clientSideRequired=true) // not used in 1.7
public class BaneOfSponges {

        // The instance of your mod that Forge uses.
        @Instance(value = ModInfo.ID)
        public static BaneOfSponges instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="salmonhands.minecraft.baneofsponges.client.ClientProxy", serverSide="salmonhands.minecraft.baneofsponges.CommonProxy")
        public static CommonProxy proxy;
        
    	public static Logger logger;

        @EventHandler // used in 1.6.2
        //@PreInit    // used in 1.5.2
        public void preInit(FMLPreInitializationEvent event) {
            // Stub Method
    		logger = event.getModLog();
    		logger.setParent(FMLLog.getLogger());
    		       	
    		MinecraftForge.setBlockHarvestLevel(OpenBlocks.Blocks.sponge, "shovel", 0);
        }
        
        @EventHandler // used in 1.6.2
        //@Init       // used in 1.5.2
        public void load(FMLInitializationEvent event) {
        	proxy.registerRenderers();      

        }
        
        @EventHandler // used in 1.6.2
        //@PostInit   // used in 1.5.2
        public void postInit(FMLPostInitializationEvent event) {
        }
}