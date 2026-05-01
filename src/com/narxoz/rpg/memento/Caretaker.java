package com.narxoz.rpg.memento;

import com.narxoz.rpg.combatant.HeroMemento;
import java.util.ArrayDeque;
import java.util.Deque;

public class Caretaker {

    private final Deque<HeroMemento> stack = new ArrayDeque<>();

    public void save(HeroMemento memento) {
        stack.push(memento);
    }

    public HeroMemento undo() {
        if (stack.isEmpty()) throw new IllegalStateException("No mementos to restore.");
        return stack.pop();
    }

    public HeroMemento peek() {
        if (stack.isEmpty()) throw new IllegalStateException("No mementos available.");
        return stack.peek();
    }

    public int size() {
        return stack.size();
    }
}
