package tiger;

import java.util.*;

import org.bukkit.*;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.plugin.java.*;

public class RandomFireworks extends JavaPlugin {
	private final String ENABLE_MESSAGE = "RandomFirework v1 by Tiger";
	private final String DISABLE_MESSAGE = "RandomFirework sucessfully shut down!";
	@Override
	public void onEnable() {
		getLogger().info(ENABLE_MESSAGE);
	}
	
	//The real code begins here
	
	public boolean randomFireworkCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("randomfirework")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage("[RandFirework]This command can only be used by a player.");
			} else {
				Player player = (Player) sender;
				ItemStack rocket = player.getItemInHand();
				if(rocket.equals(Material.FIREWORK)) {
					FireworkMeta meta = (FireworkMeta)rocket.getItemMeta();
					meta.clearEffects();
					Random metagen = new Random();
					int howmanystars = metagen.nextInt(3) + 1;
					Builder builder;
					int slot2int;
					String slot2 = new String();
					int[] restofslotsint = new int[7];
					String[] restofslots = new String[7];
					for(int i=0; i<howmanystars; i++) {
						slot2int = metagen.nextInt(16) + 1;
						switch(slot2int) {
						case 1:	 slot2 = "INK_SAC";
								 break;
						case 2:  slot2 = "ROSE_RED";
								 break;
						case 3:  slot2 = "CACTUS_GREEN";
								 break;
						case 4:  slot2 = "COCOA_BEANS";
								 break;
						case 5:  slot2 = "LAPIS_LAZULI";
								 break;
						case 6:  slot2 = "PURPLE_DYE";
								 break;
						case 7:  slot2 = "CYAN_DYE";
								 break;
						case 8:  slot2 = "LIGHT_GRAY_DYE";
								 break;
						case 9:  slot2 = "GRAY_DYE";
								 break;
						case 10: slot2 = "PINK_DYE";
								 break;
						case 11: slot2 = "LIME_DYE";
								 break;
						case 12: slot2 = "DANDELION_YELLOW";
								 break;
						case 13: slot2 = "LIGHT_BLUE_DYE";
								 break;
						case 14: slot2 = "MAGENTA_DYE";
								 break;
						case 15: slot2 = "ORANGE_DYE";
								 break;
						case 16: slot2 = "BONE_MEAL";
								 break;
						}
						
					}
				}
				else {
					sender.sendMessage("[RandFirework]You must be holding a Firework Rocket to use this command.");
				}
			}
			return true;
		}
		return false;
	}
	
	//End of real code
	
	@Override
	public void onDisable() {
		getLogger().info(DISABLE_MESSAGE);
	}
}
