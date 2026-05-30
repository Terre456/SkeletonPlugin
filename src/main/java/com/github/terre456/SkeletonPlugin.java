package com.github.terre456;

import org.bukkit.plugin.java.JavaPlugin;

public class SkeletonPlugin extends JavaPlugin{
  @Override
  public void onEnable(){
    getServer().getPluginManager().registerEvents(new SkeletonBehaviorListener(), this);
  }

}
