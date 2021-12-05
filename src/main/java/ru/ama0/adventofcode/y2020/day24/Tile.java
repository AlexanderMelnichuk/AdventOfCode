package ru.ama0.adventofcode.y2020.day24;

import java.util.HashSet;
import java.util.Set;

public class Tile extends Pair<Integer> {
    public Tile(Integer x, Integer y) {
        super(x, y);
    }

    public Tile(Tile from) {
        this(from.getX(), from.getY());
    }

    public Set<Tile> adjacentTiles() {
        Set<Tile> tiles = new HashSet<>();
        tiles.add(new Tile(getX() - 2, getY()));
        tiles.add(new Tile(getX() + 2, getY()));
        tiles.add(new Tile(getX() - 1, getY() + 1));
        tiles.add(new Tile(getX() - 1, getY() - 1));
        tiles.add(new Tile(getX() + 1, getY() + 1));
        tiles.add(new Tile(getX() + 1, getY() - 1));
        return tiles;
    }

    public Set<Tile> tilesAround() {
        Set<Tile> tiles = adjacentTiles();
        tiles.add(new Tile(this));
        return tiles;
    }
}
