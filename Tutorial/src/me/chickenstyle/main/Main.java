package me.chickenstyle.main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	private static MenuHandler menuHandler;
	
	@Override
	public void onEnable() {
		menuHandler = new MenuHandler();
		getServer().getPluginManager().registerEvents(menuHandler.getListeners(), this);
		getServer().getPluginManager().registerEvents(new InteractEvent(), this);
		System.out.println("Cool the plugin runs!");
	}
	
	@Override
	public void onDisable() {
		menuHandler.closeAll();
	}
	
	
	public static MenuHandler getMenuHandler() {
		return menuHandler;
	}
}
