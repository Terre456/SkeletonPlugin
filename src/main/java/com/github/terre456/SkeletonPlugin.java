package com.github.terre456;

import org.bukkit.plugin.java.JavaPlugin;

public class SkeletonPlugin extends JavaPlugin{
  @Override
  public void onEnable(){
    getServer().getPluginManager().registerEvents(new SkeletonBehaviorListener(), this);
    getLogger().info("on enable called");
    System.out.println("starting PLugin for skeleton");
  }

  @Override
  public void onDisable(){
    getLogger().info("on disable called");
    System.out.println("stop plugin for Skeleton");
  }
}
