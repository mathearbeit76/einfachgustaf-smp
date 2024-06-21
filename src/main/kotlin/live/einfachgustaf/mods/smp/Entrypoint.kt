package live.einfachgustaf.mods.smp

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.DedicatedServerModInitializer
import net.fabricmc.api.ModInitializer
import org.apache.logging.log4j.LogManager

object Entrypoint: ModInitializer, DedicatedServerModInitializer, ClientModInitializer {

    val logger = LogManager.getLogger("smp")
    
    override fun onInitialize() {
        // Common initialization
    }

    override fun onInitializeClient() {
        // Client initialization
    }

    override fun onInitializeServer() {
        // Dedicated server initialization
    }
}