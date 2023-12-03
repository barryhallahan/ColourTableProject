package org.example.colourtable;

import java.util.HashSet;
import java.util.Set;

public class ColourTable {
    private final int[] palette;
    private int size;
    private final Set<Integer> colors;

    public ColourTable(int paletteSize) {
        if (!isValidPaletteSize(paletteSize)) {
            throw new IllegalArgumentException("Invalid palette size");
        }
        this.palette = new int[paletteSize];
        this.size = 0;
        this.colors = new HashSet<>();
    }

    public void add(int colour) {
        if (size == palette.length) {
            throw new IllegalStateException("Exceeding capacity of the ColourTable");
        }
        if (colors.contains(colour)) {
            return;
        }
        palette[size] = colour;
        size++;
        colors.add(colour);
    }

    public int getSize() {
        return size;
    }

    private boolean isValidPaletteSize(int paletteSize) {
        return (paletteSize > 1 && paletteSize < 1025 && (paletteSize & (paletteSize - 1)) == 0);
    }
}


