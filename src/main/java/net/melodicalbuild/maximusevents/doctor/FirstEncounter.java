package net.melodicalbuild.maximusevents.doctor;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.trait.trait.Equipment;
import net.melodicalbuild.maximusevents.doctor.messagelines.BeginningLine;
import net.melodicalbuild.maximusevents.titles.Titles;
import org.bukkit.*;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import xyz.xenondevs.particle.ParticleBuilder;
import xyz.xenondevs.particle.ParticleEffect;

import java.util.Objects;

public class FirstEncounter {

    static NPC wagner;
    static int i = 0;

    public static void Begin(Player player) {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("MaximusEvents");
        assert plugin != null;
        wagner = CitizensAPI.getNPCRegistry().getById(0);
        wagner.setName("&6[&1Head Scientist&6] &fDr.Wagner");
        wagner.setProtected(true);

        Server server = Bukkit.getServer();
        Titles.Doctor.Default.Beginning(server);

        new BukkitRunnable() {
            @Override
            public void run() {
                BeginningLine.Start();
            }
        }.runTaskLater(plugin, 180);
    }

    public static void Return() {
        wagner.getOrAddTrait(Equipment.class).set(Equipment.EquipmentSlot.HAND, new ItemStack(Material.SPLASH_POTION, 1));
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
    }
}
