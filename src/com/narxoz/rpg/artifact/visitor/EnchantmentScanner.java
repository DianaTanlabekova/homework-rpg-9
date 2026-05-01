package com.narxoz.rpg.artifact.visitor;

import com.narxoz.rpg.artifact.*;

public class EnchantmentScanner implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        String level = weapon.getAttackBonus() >= 15 ? "HIGHLY ENCHANTED"
                     : weapon.getAttackBonus() >= 5  ? "mildly enchanted"
                     : "unenchanted";
        System.out.printf("  [Scan] Weapon '%s' | ATK+%d | verdict: %s%n",
            weapon.getName(), weapon.getAttackBonus(), level);
    }

    @Override
    public void visit(Potion potion) {
        System.out.printf("  [Scan] Potion '%s' | restores %d HP%n",
            potion.getName(), potion.getHealing());
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.printf("  [Scan] Scroll '%s' | bound spell: [%s]%n",
            scroll.getName(), scroll.getSpellName());
    }

    @Override
    public void visit(Ring ring) {
        String level = ring.getMagicBonus() >= 10 ? "STRONG aura"
                     : ring.getMagicBonus() >= 3  ? "weak aura"
                     : "no aura";
        System.out.printf("  [Scan] Ring '%s' | magic+%d | verdict: %s%n",
            ring.getName(), ring.getMagicBonus(), level);
    }

    @Override
    public void visit(Armor armor) {
        System.out.printf("  [Scan] Armor '%s' | DEF+%d | bulk: %d kg%n",
            armor.getName(), armor.getDefenseBonus(), armor.getWeight());
    }
}