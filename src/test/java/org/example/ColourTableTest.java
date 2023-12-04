package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for ColourTable, verifying FUNCTIONALITY.
 */
public class ColourTableTest {

    /**
     * Tests CONSTRUCTOR of ColourTable with a VALID palette size.
     */
    @Test
    public void testValidPaletteSize() {
        int validPaletteSize = 8;
        Assertions.assertDoesNotThrow(() -> {
            new ColourTable(validPaletteSize);
        });
    }

    /**
     * Tests CONSTRUCTOR of ColourTable with INVALID palette sizes, throws IllegalArgumentException.
     */
    @Test
    public void testInvalidPaletteSize() {
        int[] invalidPaletteSizes = {3, 10, 1025};
        for (int paletteSize : invalidPaletteSizes) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> new ColourTable(paletteSize));
        }
    }

    /**
     * Tests ADD colors to ColourTable, checks if size MATCHES expected count.
     */
    @Test
    public void testAddColour() {
        ColourTable colourTable = new ColourTable(4);

        // ADD colours to palette
        colourTable.add(0xFF0000);
        colourTable.add(0x00FF00);
        colourTable.add(0x0000FF);

        // Verify size of the ColourTable after ADD colours
        Assertions.assertEquals(3, colourTable.getSize());
    }

    /**
     * Tests EXCEEDING capacity of the ColourTable, ensuring it throws IllegalStateException.
     */
    @Test
    public void testExceedingPaletteCapacity() {
        ColourTable colourTable = new ColourTable(2); // Palette size of 2

        // Adding colours to FILL palette CAPACITY
        colourTable.add(0xFF0000);
        colourTable.add(0x00FF00);

        // attempt to ADD ONE colour beyond the capacity -> throws EXCEPTION
        Assertions.assertThrows(IllegalStateException.class, () -> colourTable.add(0x0000FF));
    }
}


