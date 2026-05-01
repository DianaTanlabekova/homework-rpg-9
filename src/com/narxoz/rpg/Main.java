package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 9 — Chronomancer's Vault: Visitor + Memento ===");

        Hero theron = new Hero("Kazuha", 120, 60, 25, 15, 300, null);
        Hero sylara = new Hero("Raiden", 80, 200, 10, 8, 150, null);

        System.out.println("\n=== PARTY ROSTER ===");
        System.out.println("  " + theron.status());
        System.out.println("  " + sylara.status());

        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(List.of(theron, sylara));

        System.out.println("\n=== RUN COMPLETE ===");
        System.out.println(result);
    }
}