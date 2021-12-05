package ru.ama0.adventofcode.y2020.day24;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class Floor {
    private Set<Tile> tiles;

    public Set<Tile> nextTiles() {
        Set<Tile> nextTiles =  tiles.stream()
                .map(Tile::tilesAround)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
        nextTiles = nextTiles.stream()
                .filter(tile -> {
                    Set<Tile> adjacent = tile.adjacentTiles();
                    adjacent.retainAll(tiles);
                    return tiles.contains(tile)
                            // tile is black
                            ? !adjacent.isEmpty() && adjacent.size() <= 2
                            // tile is white
                            : adjacent.size() == 2;
                })
                .collect(Collectors.toSet());
        return nextTiles;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "tiles=" + tiles +
                '}';
    }
}
