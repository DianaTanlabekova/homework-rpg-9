package com.narxoz.rpg.artifact.visitor;

import com.narxoz.rpg.artifact.*;

public class WeightCalculator implements ArtifactVisitor {

    private int totalWeight = 0;

    @Override
    public void visit(Weapon weapon) {
        totalWeight += weapon.getWeight();
        System.out.printf("  [Weight] Weapon '%s' carries %d kg%n", weapon.getName(), weapon.getWeight());
    }

    @Override
    public void visit(Potion potion) {
        totalWeight += potion.getWeight();
        System.out.printf("  [Weight] Potion '%s' carries %d kg%n", potion.getName(), potion.getWeight());
    }

    @Override
    public void visit(Scroll scroll) {
        totalWeight += scroll.getWeight();
        System.out.printf("  [Weight] Scroll '%s' carries %d kg%n", scroll.getName(), scroll.getWeight());
    }

    @Override
    public void visit(Ring ring) {
        totalWeight += ring.getWeight();
        System.out.printf("  [Weight] Ring '%s' carries %d kg%n", ring.getName(), ring.getWeight());
    }

    @Override
    public void visit(Armor armor) {
        totalWeight += armor.getWeight();
        System.out.printf("  [Weight] Armor '%s' carries %d kg%n", armor.getName(), armor.getWeight());
    }

    public int getTotalWeight() { return totalWeight; }
}