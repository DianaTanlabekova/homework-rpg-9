package com.narxoz.rpg.artifact.visitor;

import com.narxoz.rpg.artifact.*;

public class GoldAppraiser implements ArtifactVisitor {

    private int totalValue = 0;

    @Override
    public void visit(Weapon weapon) {
        int v = weapon.getValue() + weapon.getAttackBonus() * 8;
        totalValue += v;
        System.out.printf("  [Gold] Weapon '%s' estimated worth: %dg%n", weapon.getName(), v);
    }

    @Override
    public void visit(Potion potion) {
        int v = potion.getValue() + potion.getHealing() * 2;
        totalValue += v;
        System.out.printf("  [Gold] Potion '%s' estimated worth: %dg%n", potion.getName(), v);
    }

    @Override
    public void visit(Scroll scroll) {
        int v = scroll.getValue();
        totalValue += v;
        System.out.printf("  [Gold] Scroll '%s' spell=[%s] estimated worth: %dg%n", scroll.getName(), scroll.getSpellName(), v);
    }

    @Override
    public void visit(Ring ring) {
        int v = ring.getValue() + ring.getMagicBonus() * 10;
        totalValue += v;
        System.out.printf("  [Gold] Ring '%s' estimated worth: %dg%n", ring.getName(), v);
    }

    @Override
    public void visit(Armor armor) {
        int v = armor.getValue() + armor.getDefenseBonus() * 6;
        totalValue += v;
        System.out.printf("  [Gold] Armor '%s' estimated worth: %dg%n", armor.getName(), v);
    }

    public int getTotalValue() { return totalValue; }
}
