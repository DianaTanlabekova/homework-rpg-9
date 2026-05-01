package com.narxoz.rpg.artifact.visitor;

import com.narxoz.rpg.artifact.*;

public class CurseDetector implements ArtifactVisitor {

    private int suspiciousCount = 0;

    @Override
    public void visit(Weapon weapon) {
        if (weapon.getAttackBonus() < 0) {
            suspiciousCount++;
            System.out.printf("  [Curse] Weapon '%s' >> CORRUPTED | negative attack bonus detected%n", weapon.getName());
        } else {
            System.out.printf("  [Curse] Weapon '%s' >> clear%n", weapon.getName());
        }
    }

    @Override
    public void visit(Potion potion) {
        if (potion.getHealing() < 0) {
            suspiciousCount++;
            System.out.printf("  [Curse] Potion '%s' >> TAINTED | inflicts harm on consumption%n", potion.getName());
        } else {
            System.out.printf("  [Curse] Potion '%s' >> clear%n", potion.getName());
        }
    }

    @Override
    public void visit(Scroll scroll) {
        boolean dark = scroll.getSpellName().toLowerCase().contains("curse")
                    || scroll.getSpellName().toLowerCase().contains("death")
                    || scroll.getSpellName().toLowerCase().contains("drain");
        if (dark) {
            suspiciousCount++;
            System.out.printf("  [Curse] Scroll '%s' >> FORBIDDEN | dark inscription [%s] identified%n",
                scroll.getName(), scroll.getSpellName());
        } else {
            System.out.printf("  [Curse] Scroll '%s' >> inscription appears harmless%n", scroll.getName());
        }
    }

    @Override
    public void visit(Ring ring) {
        if (ring.getMagicBonus() < 0) {
            suspiciousCount++;
            System.out.printf("  [Curse] Ring '%s' >> HEXED | siphons magical reserves%n", ring.getName());
        } else {
            System.out.printf("  [Curse] Ring '%s' >> clear%n", ring.getName());
        }
    }

    @Override
    public void visit(Armor armor) {
        if (armor.getDefenseBonus() < 0) {
            suspiciousCount++;
            System.out.printf("  [Curse] Armor '%s' >> WEAKENED | protection is compromised%n", armor.getName());
        } else {
            System.out.printf("  [Curse] Armor '%s' >> clear%n", armor.getName());
        }
    }

    public int getSuspiciousCount() { return suspiciousCount; }
}