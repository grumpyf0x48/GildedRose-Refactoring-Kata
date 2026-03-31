package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Nested
public final class AgedBrieTest {

    @DisplayName("Etant donné un item AgedBrie avec un sellIn positif" +
        "quand une journée passe, alors le sellIn diminue de 1" +
        "et la qualité augmente de 1")
    @Test
    void quand_une_journee_passe_le_sellIn_diminue_de_1_et_la_qualité_augmente_de_1() {
        // given
        Item item = new Item("Aged Brie", 6, 26);
        GildedRose app = new GildedRose(new Item[]{item});

        // when
        app.updateQuality();

        // then
        assertEquals(5, item.sellIn);
        assertEquals(27, item.quality);
    }

    @DisplayName("Etant donné un item AgedBrie avec un sellIn positif et une qualité de 50" +
        "quand une journée passe, alors le sellIn diminue de 1" +
        "et la qualité reste à 50")
    @Test
    @Disabled
    void quand_une_journee_passe_le_sellIn_diminue_de_1_et_la_qualité_reste_a_50() {
        // given
        Item item = new Item("Aged Brie", 6, 50);
        GildedRose app = new GildedRose(new Item[]{item});

        // when
        app.updateQuality();

        // then
        assertEquals(5, item.sellIn);
        assertEquals(50, item.quality);
    }

    @DisplayName("Etant donné un item AgedBrie avec un sellIn à 0 et une qualité de 49" +
        "quand une journée passe, alors le sellIn diminue de 1" +
        "et la qualité passe à 50")
    @Test
    void quand_une_journee_passe__sellIn_0_qualite_49_le_sellIn_diminue_de_1_et_la_qualité_reste_a_50() {
        // given
        Item item = new Item("Aged Brie", 0, 50);
        GildedRose app = new GildedRose(new Item[]{item});

        // when
        app.updateQuality();

        // then
        assertEquals(-1, item.sellIn);
        assertEquals(50, item.quality);
    }

    @DisplayName("Etant donné un item AgedBrie avec un sellIn à 0 et une qualité de 40" +
        "quand une journée passe, alors le sellIn diminue de 1" +
        "et la qualité augmente de 2")
    @Test
    void quand_une_journee_passe_le_sellIn_diminue_de_1_et_la_qualite_augmente_de_2() {
        // given
        Item item = new Item("Aged Brie", 0, 40);
        GildedRose app = new GildedRose(new Item[]{item});

        // when
        app.updateQuality();

        // then
        assertEquals(-1, item.sellIn);
        assertEquals(42, item.quality);
    }
}
