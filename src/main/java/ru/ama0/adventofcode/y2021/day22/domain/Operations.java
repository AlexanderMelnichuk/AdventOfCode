package ru.ama0.adventofcode.y2021.day22.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Operations {

    public Collection<Cuboid> add(Cuboid a, Cuboid b) {
        if (a.isOn() ^ b.isOn()) {
            return a.isOn() ? sub(a, b) : sub(b, a);
        }

        if (!areIntersected(a, b)) {
            return List.of(a, b);
        }

        var result = new ArrayList<Cuboid>();
        // Vertical tiers:
        // Tier 1
        if (a.getZTo() != b.getZTo()) {
            if (a.getZTo() > b.getZTo()) {
                result.add(new Cuboid(a.isOn(), a.getXFrom(), a.getXTo(), a.getYFrom(), a.getYTo(), b.getZTo(), a.getZTo()));
            } else {
                result.add(new Cuboid(a.isOn(), b.getXFrom(), b.getXTo(), b.getYFrom(), b.getYTo(), a.getZTo(), b.getZTo()));
            }
        }
        // Tier 2

        // Tier 3
        if (a.getZFrom() != b.getZFrom()) {
            if (a.getZFrom() < b.getZFrom()) {
                result.add(new Cuboid(a.isOn(), a.getXFrom(), a.getXTo(), a.getYFrom(), a.getYTo(), a.getZFrom(), b.getZFrom()));
            } else {
                result.add(new Cuboid(a.isOn(), b.getXFrom(), b.getXTo(), b.getYFrom(), b.getYTo(), b.getZFrom(), a.getZFrom()));
            }
        }
        return result;
    }

    private Collection<Rectangle> add(Rectangle a, Rectangle b) {
        if (!areIntersected(a.getXLine(), b.getXLine()) ||
                !areIntersected(a.getYLine(), b.getYLine())) {
            return List.of(a, b);
        }
        var aXLine = a.getXLine();
        var bXLine = b.getXLine();
        var aYLine = a.getYLine();
        var bYLine = b.getYLine();
        if (isInside(aXLine, bXLine) || isInside(bXLine, aXLine)) {
            if (isInside(aXLine, bXLine) && isInside(aYLine, bYLine)) { // b covers a
                return List.of(b);
            }
            if (isInside(bXLine, aXLine) && isInside(bYLine, aYLine)) { // a covers b
                return List.of(a);
            }
            var wider = isInside(aXLine, bXLine) ? b : a;
            var narrower = (a == wider) ? b : a;
            var result = new ArrayList<Rectangle>();
            // Tier 1
            if (narrower.getYTo() > wider.getYTo()) {
                result.add(cutTop(narrower, wider.getYTo()));
            }
            // Tier 2
            result.add(wider);
            // Tier 3
            if (narrower.getYFrom() < wider.getYFrom()) {
                result.add(cutBottom(narrower, wider.getYFrom()));
            }
            return result;
        } else if (isInside(aYLine, bYLine) || isInside(bYLine, aYLine)) {
            var taller = isInside(aYLine, bYLine) ? b : a;
            var smaller = (taller == b) ? a : b;
            var result = new ArrayList<Rectangle>();
            // Left
            if (smaller.getXFrom() < taller.getXFrom()) {
                result.add(cutLeft(smaller, taller.getXFrom()));
            }
            // Middle
            result.add(taller);
            // Right
            if (smaller.getXTo() > taller.getXTo()) {
                result.add(cutRight(smaller, taller.getXTo()));
            }
            return result;
        } else {

        }
    }

    private Rectangle cutTop(Rectangle a, int y) {
        if (a.getYLine().contains(y)) {
            return new Rectangle(a.getXFrom(), a.getXTo(), y + 1, a.getYTo());
        } else {
            return a;
        }
    }

    private Rectangle cutBottom(Rectangle a, int y) {
        if (a.getYLine().contains(y)) {
            return new Rectangle(a.getXFrom(), a.getXTo(), a.getYFrom(), y - 1);
        } else {
            return a;
        }
    }

    private Rectangle cutLeft(Rectangle a, int x) {
        if (a.getXLine().contains(x)) {
            return new Rectangle(a.getXFrom(), x - 1, a.getYFrom(), a.getYTo());
        } else {
            return a;
        }
    }

    private Rectangle cutRight(Rectangle a, int x) {
        if (a.getXLine().contains(x)) {
            return new Rectangle(x + 1, a.getXTo(), a.getYFrom(), a.getYTo());
        } else {
            return a;
        }
    }

    private Cuboid cutTop(Cuboid a, int z) {
        if (z < a.getZFrom() || z > a.getZTo()) {
            return a;
        } else {
            return new Cuboid(a.isOn(), a.getXFrom(), a.getXTo(), a.getYFrom(), a.getYTo(), z + 1, a.getZTo());
        }
    }

    private Cuboid cutBottom(Cuboid a, int z) {
        if (z < a.getZFrom() || z > a.getZTo()) {
            return a;
        } else {
            return new Cuboid(a.isOn(), a.getXFrom(), a.getXTo(), a.getYFrom(), a.getYTo(), a.getZFrom(), z - 1);
        }
    }

    public Collection<Cuboid> sub(Cuboid a, Cuboid b) {
        return Collections.emptySet();
    }

    public boolean areIntersected(Cuboid a, Cuboid b) {
        return areIntersected(a.getXLine(), b.getXLine()) &&
                areIntersected(a.getYLine(), b.getYLine()) &&
                areIntersected(a.getZLine(), b.getZLine());
    }

    private boolean areIntersected(Line a, Line b) {
        return b.getFrom() <= a.getTo() && a.getFrom() <= b.getTo();
    }

    private boolean isInside(Line a, Line b) {
        return b.getFrom() <= a.getFrom() && a.getTo() <= b.getTo();
    }

}
