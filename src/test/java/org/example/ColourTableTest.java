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

        // Define VALID palette size (per specification)
        int validPaletteSize = 8;

        // Verification, w/o throwing an exception
        Assertions.assertDoesNotThrow(() -> {
            new ColourTable(validPaletteSize);
        });
    }

    /**
     * Tests CONSTRUCTOR of ColourTable with INVALID palette sizes, throws IllegalArgumentException.
     */
    @Test
    public void testInvalidPaletteSize() {

        // Array of INVALID palette sizes to TEST
        int[] invalidPaletteSizes = {3, 10, 1025};

        // LOOP ARRAY THROW EXCEPTION FOR EACH
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
        // Palette SIZE 2 -> VALID
        ColourTable colourTable = new ColourTable(2);

        // Adding colours to FILL palette CAPACITY
        colourTable.add(0xFF0000);
        colourTable.add(0x00FF00);

        // attempt to ADD ONE colour beyond the capacity -> throws EXCEPTION
        Assertions.assertThrows(IllegalStateException.class, () -> colourTable.add(0x0000FF));
    }

    /**
     * Tests adding a VALID RGB value to the ColourTable palette.
     *
     * Ensures the ColourTable ACCEPTS & STORES VALID RGB value.
     */
    @Test
    public void testValidRGBValue() {
        // Palette size 4 -> VALID
        ColourTable colourTable = new ColourTable(4);

        // ADD Red to ColourTable -> VALID
        colourTable.add(0xFF0000);

        // Verify SIZE after ADDITION of colour
        Assertions.assertEquals(1, colourTable.getSize());
    }

    /**
     * Tests adding an INVALID RGB value to the ColourTable palette.
     *
     * Ensures the ColourTable rejects INVALID RGB value.
     */
    @Test
    public void testInvalidRGBValue() {
        // Palette size 4 -> VALID
        ColourTable colourTable = new ColourTable(4);

        // ADD INVALID RGB colour, THROW EXCEPTION -> IllegalArgumentException
        Assertions.assertThrows(IllegalArgumentException.class, () -> colourTable.add(0x7654321));
    }
}


