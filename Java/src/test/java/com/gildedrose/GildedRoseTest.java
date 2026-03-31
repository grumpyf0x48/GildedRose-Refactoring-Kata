package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void quand_une_journee_passe_le_sellIn_et_la_qualite_diminue_de_1() {
        // given
        Item item = new Item("foo", 6, 26);
        GildedRose app = new GildedRose(new Item[]{item});

        // when
        app.updateQuality();

        // then
        assertEquals(5, item.sellIn);
        assertEquals(25, item.quality);
    }

    @Test
    void quand_une_journee_passe_et_que_la_qualite_est_a_0_le_sellIn_diminue_et_la_qualite_est_inchangee() {
        // given
        Item item = new Item("foo", 6, 0);
        GildedRose app = new GildedRose(new Item[]{item});

        // when
        app.updateQuality();

        // then
        assertEquals(5, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    @DisplayName("Etant donné que le sellIn est à 0" +
        "quand une journée passe, alors le sellIn diminue de 1" +
        "et la qualité diminue de 2")
    void quand_une_journee_passe_et_que_le_sellIn_est_a_0_le_sellIn_diminue_de_1_et_la_qualite_diminue_de_2() {
        // given
        Item item = new Item("foo", 0, 26);
        GildedRose app = new GildedRose(new Item[]{item});

        // when
        app.updateQuality();

        // then
        assertEquals(-1, item.sellIn);
        assertEquals(24, item.quality);
    }

    @Test
    @DisplayName("Etant donné que le sellIn est à 0 et que la qualité est à 1" +
        "quand une journée passe, alors le sellIn diminue de 1" +
        "et la qualité tombe à 0")
    void quand_une_journee_passe_et_que_le_sellIn_est_a_0_et_que_qualite_est_a_1_le_sellIn_diminue_de_1_et_la_qualite_tombe_a_0() {
        // given
        Item item = new Item("foo", 0, 1);
        GildedRose app = new GildedRose(new Item[]{item});

        // when
        app.updateQuality();

        // then
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }
}
