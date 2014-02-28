package tiger;

import java.util.*;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.plugin.java.*;

public class RandomFirework extends JavaPlugin {
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
					((FireworkMeta) rocket).clearEffects();
					//finding out that you needed to put FireworkMeta instead of something like ItemStack took forever :\
					Random metagen = new Random();
					int howmanystars = metagen.nextInt(3) + 1;
					//decides how many Firework Stars there will be.
					int dumpnum = 1;
					int[] dump1 = new int[9];
					if(howmanystars == 2) {
						int[] dump2 = new int[9];
					}
					if(howmanystars == 3) {
						int[] dump3 = new int[9];
					}
					//Haha DUMPS get it? Grow up -_-
					int slotnum[] = new int[9];
					//slotnum is a temporary holding place for generations.
					//the 9th index (aka [8]) is the power level.
					for(int i=0; i<howmanystars; i++) {
						int hmo = 22;
						//hmo = HowManyOptions
						slotnum[0] = metagen.nextInt(16) + 1;
						//There has to be at least one color, therefore this one forces one of the 16 "dye" options to be selected.
						do {
							slotnum[1] = metagen.nextInt(22);
						} while(slotnum[0] == slotnum[1]);
						if(slotnum[1] != 0) {
							hmo--;
						}
						do {
							slotnum[2] = metagen.nextInt(hmo);
						} while(slotnum[0] == slotnum[2] || (slotnum[1] == slotnum[2] && slotnum[1] != 0));
						//using || is inclusive, right? Meaning that if either --> or both <--  equal slotnum[2], it will re-generate?
						//also, does this mean that only the "1==2" part needs the AND or do both? If it's both then we have a problem.
						if(slotnum[2] != 0) {
							hmo--;
						}
						do {
							slotnum[3] = metagen.nextInt(hmo);
						} while(slotnum[0] == slotnum[3] || (slotnum[1] == slotnum[3] && slotnum[1] != 0) || (slotnum[2] == slotnum[3] && slotnum[2] != 0));
						//oh god these are going to get long. Also I think using brackets between ||s solve the possibility of &&s conflicting (if there ever was one).
						if(slotnum[3] != 0) {
							hmo--;
						}
						do {
							slotnum[4] = metagen.nextInt(hmo);
						} while(slotnum[0] == slotnum[4] || (slotnum[1] == slotnum[4] && slotnum[1] != 0) || (slotnum[2] == slotnum[4] && slotnum[2] != 0) || (slotnum[3] == slotnum[4] && slotnum[3] != 0));
						//haha thank god for copy and paste. Now I just have to add the previous array index to each line. Also I can copy the code for the if() statement in between and change the array index.
						if(slotnum[4] != 0) {
							hmo--;
						}
						do {
							slotnum[5] = metagen.nextInt(hmo);
						} while(slotnum[0] == slotnum[5] || (slotnum[1] == slotnum[5] && slotnum[1] != 0) || (slotnum[2] == slotnum[5] && slotnum[2] != 0) || (slotnum[3] == slotnum[5] && slotnum[3] != 0) || (slotnum[4] == slotnum[5] && slotnum[4] != 0));
						//holy crap. I know it's more than half way done but boy is it looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong.
						if(slotnum[5] != 0) {
							hmo--;
						}
						do {
							slotnum[6] = metagen.nextInt(hmo);
						} while(slotnum[0] == slotnum[6] || (slotnum[1] == slotnum[6] && slotnum[1] != 0) || (slotnum[2] == slotnum[6] && slotnum[2] != 0) || (slotnum[3] == slotnum[6] && slotnum[3] != 0) || (slotnum[4] == slotnum[6] && slotnum[4] != 0) || (slotnum[5] == slotnum[6] && slotnum[5] != 0));
						//I'm done writing these. Only thing left now is *Ctrl+c* *Ctrl+v* *type type type type type* and repeat.
						if(slotnum[6] != 0) {
							hmo--;
						}
						do {
							slotnum[7] = metagen.nextInt(hmo);
						} while(slotnum[0] == slotnum[7] || (slotnum[1] == slotnum[7] && slotnum[1] != 0) || (slotnum[2] == slotnum[7] && slotnum[2] != 0) || (slotnum[3] == slotnum[7] && slotnum[3] != 0) || (slotnum[4] == slotnum[7] && slotnum[4] != 0) || (slotnum[5] == slotnum[7] && slotnum[5] != 0) || (slotnum[6] == slotnum[7] && slotnum[6] != 0));
						if(slotnum[7] != 0) {
							hmo--;
						}
						//almost done! only one more! The longest one... uh oh. *COPY AND PASTE TO THE RESCUUUUUEEEEE!!!*
						//EDIT: wait, 8 indexes = 0-7... YAY I'M DONE!!! :D
						//EDIT 2: Forgot about power. -.- Hey, at least it's easier than the rest!
						//EDIT 3: except [0], which it's technically as easy as.
						slotnum[8] = metagen.nextInt(3) + 1;
						if(dumpnum == 1) {
							dump1 = slotnum.clone();
						}
						else if(dumpnum == 2) {
							dump2 = slotnum.clone();
						}
						else {
							dump3 = slotnum.clone();
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
