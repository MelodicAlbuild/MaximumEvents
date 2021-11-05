package net.melodicalbuild.maximusevents.doctor;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.trait.trait.Equipment;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class FirstEncounter {
    public static void Begin(Player player) {
        NPC npc = CitizensAPI.getNPCRegistry().getById(1);
        npc.setName("&6[&1Head Scientist&6] &fDr.Wagner");
        npc.setProtected(true);
        npc.getOrAddTrait(Equipment.class).set(Equipment.EquipmentSlot.HAND, new ItemStack(Material.DIAMOND_SWORD, 1));
    }
}
