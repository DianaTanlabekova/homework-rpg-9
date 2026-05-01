package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.artifact.visitor.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.memento.Caretaker;
import java.util.List;

public class ChronomancerEngine {

    public VaultRunResult runVault(List<Hero> party) {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     THE CHRONOMANCER'S VAULT         ║");
        System.out.println("╚══════════════════════════════════════╝");

        Inventory vault = new Inventory();
        vault.addArtifact(new Weapon("Blazing Longsword", 200, 5, 20));
        vault.addArtifact(new Potion("Venom Vial", 50, 1, -10));
        vault.addArtifact(new Scroll("Parchment of Ruin", 120, 1, "Death Drain"));
        vault.addArtifact(new Ring("Hollow Band", 180, 1, -5));
        vault.addArtifact(new Armor("Ironclad Plate", 300, 12, 25));

        System.out.println("\n>> Heroes step into the vault chamber:");
        for (Hero h : party) System.out.println("   " + h.status());

        System.out.println("\n-- PHASE 1: Gold Appraisal --");
        GoldAppraiser gold = new GoldAppraiser();
        vault.accept(gold);
        System.out.printf("   Combined appraised value: %dg%n", gold.getTotalValue());

        System.out.println("\n-- PHASE 2: Enchantment Scan --");
        EnchantmentScanner scanner = new EnchantmentScanner();
        vault.accept(scanner);

        System.out.println("\n-- PHASE 3: Curse Detection --");
        CurseDetector curse = new CurseDetector();
        vault.accept(curse);
        System.out.printf("   Items flagged as suspicious: %d%n", curse.getSuspiciousCount());

        System.out.println("\n-- PHASE 4: Weight Calculation (open/closed proof) --");
        WeightCalculator weight = new WeightCalculator();
        vault.accept(weight);
        System.out.printf("   Total inventory burden: %d kg%n", weight.getTotalWeight());

        Hero hero = party.get(0);
        Caretaker caretaker = new Caretaker();

        System.out.println("\n>> Imprinting time crystal for " + hero.getName() + "...");
        caretaker.save(hero.createMemento());
        System.out.printf("   Crystal sealed. Caretaker holds %d memento(s).%n", caretaker.size());
        System.out.println("   Before trap: " + hero.status());

        System.out.println("\n>> !! RUNE TRAP SPRINGS - arcane backlash hits the party !!");
        hero.takeDamage(45);
        hero.spendMana(30);
        hero.spendGold(80);
        System.out.println("   After trap:  " + hero.status());

        System.out.println("\n>> Crystal pulses - REWINDING " + hero.getName() + " to prior state...");
        hero.restoreFromMemento(caretaker.undo());
        System.out.println("   Restored:    " + hero.status());
        System.out.printf("   Caretaker now holds %d memento(s).%n", caretaker.size());

        return new VaultRunResult(vault.size(), 1, 1);
    }
}