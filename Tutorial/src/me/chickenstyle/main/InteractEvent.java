package me.chickenstyle.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InteractEvent implements Listener{
	@EventHandler
	public void onInteractEvent(PlayerInteractEvent e) {
		
		if (e.getClickedBlock() == null) return;
		if (e.getClickedBlock().getType().equals(Material.GRASS)) {
			//Creating default gui.
			Menu menu = new Menu(Bukkit.createInventory(null, 54, "Cool GUI!"));
			
			
			//Creating an arrow button
			menu.setButton(5, new Button(Material.ARROW) {

				@Override
				public void onClick(Menu menu, InventoryClickEvent event) {
					event.getWhoClicked().sendMessage("This is a working button!");
					event.setCancelled(true);
				}	
				
			});
			
			// Creating a paper button that sends a message to the player
			ItemStack item = new ItemStack(Material.PAPER);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("Cool paper button");
			item.setItemMeta(meta);
			
			menu.setButton(30, new Button(item) {

				@Override
				public void onClick(Menu menu, InventoryClickEvent event) {
					event.getWhoClicked().sendMessage("You clicked on " + getType().toString() + " with the name " + getItemMeta().getDisplayName());
					event.setCancelled(true);
				}
				
			});
			
			
			//Opens the menu for the player
			Main.getMenuHandler().openMenu(e.getPlayer(), menu);
			
		}
	}

}
