package org.example;

import java.util.HashSet;
import java.util.Set;

/**
 * A representation of a ColourTable with a fixed palette size for storing RGB colors.
 * <p>
 * A constructor for a ColourTable object with a single parameter, specifying the number
 * of colours present in the palette
 * <p>
 * The number of colours in the palette MUST be a power of two, > 1 AND less than 1025
 * <p>
 * Creating a ColourTable object without the specification of a valid palette size will
 * throw an exception
 * <p>
 * Method 'add' that enables a developer to ADD 24-bit RGB colour value to the palette
 * <p>
 * Exceeding the capacity of the ColourTable results in the throwing of an exception
 */
public class ColourTable {

    // ARRAY, storing palette of colours
    private final int[] palette;

    // CURRENT storage size of the palette
    private int size;

    // Set, tracking palette UNIQUE colours
    private final Set<Integer> colors;

    /**
     * Constructs a ColourTable with a specified palette size.
     *
     * @param paletteSize The number of colors allowed in the palette.
     *
     * @throws IllegalArgumentException if the palette size is invalid.
     */
    public ColourTable(int paletteSize) {

        // VALID palette size CHECK
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
     *
     * @throws IllegalArgumentException if the provided colour is not a valid 24-bit RGB value.
     */
    public void add(int colour) {

        // EXCEED palette capacity CHECK
        if (size == palette.length) {
            throw new IllegalStateException("Exceeding capacity of the ColourTable");
        }

        // ENSURE colour validity prior to entering the palette
        if (!valid24BitRGB(colour)) {
            throw new IllegalArgumentException("Invalid 24-bit RGB value");
        }

        if (colors.contains(colour)) {
            // Colour EXISTS in palette
            return;
        }
        palette[size] = colour;
        size++;
        colors.add(colour);
    }

    /**
     * Checks if the provided integer ACTUALLY represents a valid 24-bit RGB colour value.
     *
     * @param colour The integer value awaiting validation
     *
     * @return True IF the provided value is VALID, else, FALSE
     */
    private boolean valid24BitRGB(int colour) {

        // CHECK is colour resides within 24-bit RGB range
        return (colour >= 0 && colour <= 0xFFFFFF);
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




