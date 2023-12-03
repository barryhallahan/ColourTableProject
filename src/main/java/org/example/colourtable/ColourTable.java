package org.example.colourtable;

import java.util.HashSet;
import java.util.Set;

/**
 * A representation of a ColourTable with a fixed palette size for storing RGB colors.
 */
public class ColourTable {
    private final int[] palette;
    private int size;
    private final Set<Integer> colors;

    /**
     * Constructs a ColourTable with a specified palette size.
     *
     * @param paletteSize The number of colors allowed in the palette.
     *
     * @throws IllegalArgumentException if the palette size is invalid.
     */
    public ColourTable(int paletteSize) {
        if (!isValidPaletteSize(paletteSize)) {
            throw new IllegalArgumentException("Invalid palette size");
        }
        this.palette = new int[paletteSize];
        this.size = 0;
        this.colors = new HashSet<>();
    }

    /**
     * Adds a new color to the ColourTable if it's not already present and the palette is not full.
     *
     * @param colour The RGB color to add.
     *
     * @throws IllegalStateException if the ColourTable has reached its capacity.
     */
    public void add(int colour) {
        if (size == palette.length) {
            throw new IllegalStateException("Exceeding capacity of the ColourTable");
        }
        if (colors.contains(colour)) {
            return; // Colour EXISTS in palette
        }
        palette[size] = colour;
        size++;
        colors.add(colour);
    }

    /**
     * Retrieves the current size of the ColourTable.
     *
     * @return The number of colors stored in the ColourTable.
     */
    public int getSize() {
        return size;
    }

    /**
     * Checks if the specified palette size is valid.
     *
     * @param paletteSize The palette size to validate.
     *
     * @return True if the palette size is a power of two, greater than 1, and less than 1025.
     */
    private boolean isValidPaletteSize(int paletteSize) {
        return (paletteSize > 1 && paletteSize < 1025 && (paletteSize & (paletteSize - 1)) == 0);
    }
}



