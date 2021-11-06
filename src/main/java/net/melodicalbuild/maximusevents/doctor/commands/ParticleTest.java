package net.melodicalbuild.maximusevents.doctor.commands;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class ParticleTest implements CommandExecutor {

    public int i = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        NPC wagner = CitizensAPI.getNPCRegistry().getById(0);
        Location location = wagner.getEntity().getLocation();
        Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());

        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("MaximusEvents");
        assert plugin != null;

        BukkitRunnable run2 = new BukkitRunnable() {
            @Override
            public void run() {
                if(i <= 5) {
                    for(double ls = 0; ls <= 3; ls += 0.1) {
                        particleLoc.setY(location.getY() + ls);
                        for (int d = 0; d <= 90; d += 1) {
                            particleLoc.setX(location.getX() + Math.cos(d));
                            particleLoc.setZ(location.getZ() + Math.sin(d));
                            Objects.requireNonNull(location.getWorld()).spawnParticle(Particle.REDSTONE, particleLoc, 1, 0, 0, 0, new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1.0F));
                        }
                    }
                    i++;
                } else {
                    for(double ls = 0; ls <= 3; ls += 0.1) {
                        particleLoc.setY(location.getY() + ls);
                        for (int d = 0; d <= 90; d += 1) {
                            particleLoc.setX(location.getX() + Math.cos(d));
                            particleLoc.setZ(location.getZ() + Math.sin(d));
                            Objects.requireNonNull(location.getWorld()).spawnParticle(Particle.REDSTONE, particleLoc, 1, 0, 0, 0, new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1.0F));
                        }
                    }
                    wagner.despawn();
                    this.cancel();
                }
            }
        };

        new BukkitRunnable() {

            @Override
            public void run() {
                if(i <= 5) {
                    for(double ls = 0; ls <= 3; ls += 0.1) {
                        particleLoc.setY(location.getY() + ls);
                        for (int d = 0; d <= 90; d += 1) {
                            particleLoc.setX(location.getX() + Math.cos(d));
                            particleLoc.setZ(location.getZ() + Math.sin(d));
                            Objects.requireNonNull(location.getWorld()).spawnParticle(Particle.REDSTONE, particleLoc, 1, 0, 0, 0, new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1.0F));
                        }
                    }
                    i++;
                } else {
                    i = 0;
                    run2.runTaskTimer(plugin, 0, 5);
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 20);
//        new ParticleBuilder(ParticleEffect.FLAME, location)
//                .setOffsetY(1f)
//                .setSpeed(0.1f)
//                .display();
        return true;
    }
}
