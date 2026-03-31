package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Nested
public final class BackstageTest {

    @DisplayName("Etant donné un item Backstage avec un sellIn à 11 et une qualité de 10" +
        "quand une journée passe, alors le sellIn diminue de 1" +
        "et la qualité augmente de 1")
    @Test
    void quand_une_journee_passe_le_sellIn_diminue_de_1_et_la_qualite_augmente_de_1() {
        // given
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10);
        GildedRose app = new GildedRose(new Item[]{item});

        // when
        app.updateQuality();

        // then
        assertEquals(10, item.sellIn);
        assertEquals(11, item.quality);
    }

    @DisplayName("Etant donné un item Backstage avec un sellIn à 7 et une qualité de 49" +
        "quand une journée passe, alors le sellIn diminue de 1" +
        "et la qualité reste à 50")
    @Test
    void quand_une_journee_passe_avec_sellIn_6_quality_49_le_sellIn_diminue_de_1_et_la_qualite_reste_50() {
        // given
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 7, 49);
        GildedRose app = new GildedRose(new Item[]{item});

        // when
        app.updateQuality();

        // then
        assertEquals(6, item.sellIn);
        assertEquals(50, item.quality);
    }

    @DisplayName("Etant donné un item Backstage avec un sellIn à 11 et une qualité de 50" +
        "quand une journée passe, alors le sellIn diminue de 1" +
        "et la qualité reste à 50")
    @Test
    void _quand_une_journee_passe_avec_sellIn_11_quality_50_le_sellIn_diminue_de_1_et_la_qualite_reste_50() {
        // given
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50);
        GildedRose app = new GildedRose(new Item[]{item});

        // when
        app.updateQuality();

        // then
        assertEquals(10, item.sellIn);
        assertEquals(50, item.quality);
    }

    @DisplayName("Etant donné un item Backstage avec un sellIn à 3 et une qualité de 48" +
        "quand une journée passe, alors le sellIn diminue de 1" +
        "et la qualité passe à 50")
    @Test
    void quand_une_journee_passe_avec_sellIn_3_quality_48_le_sellIn_diminue_de_1_et_la_qualite_passe_50() {
        // given
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 48);
        GildedRose app = new GildedRose(new Item[]{item});

        // when
        app.updateQuality();

        // then
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 2, 50", item.toString());
        assertEquals(2, item.sellIn);
        assertEquals(50, item.quality);
    }

    @DisplayName("Etant donné un item Backstage avec un sellIn à 6 et une qualité de 10" +
        "quand une journée passe, alors le sellIn diminue de 1" +
        "et la qualité augmente de 2")
    @Test
    void quand_une_journee_passe_le_sellIn_diminue_de_1_et_la_qualite_augmente_de_2() {
        // given
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 10);
        GildedRose app = new GildedRose(new Item[]{item});

        // when
        app.updateQuality();

        // then
        assertEquals(5, item.sellIn);
        assertEquals(12, item.quality);
    }

    @DisplayName("Etant donné un item Backstage avec un sellIn à 5 et une qualité de 10" +
        "quand une journée passe, alors le sellIn diminue de 1" +
        "et la qualité augmente de 3")
    @Test
    void quand_une_journee_passe_le_sellIn_diminue_de_1_et_la_qualite_augmente_de_3() {
        // given
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10);
        GildedRose app = new GildedRose(new Item[]{item});

        // when
        app.updateQuality();

        // then
        assertEquals(4, item.sellIn);
        assertEquals(13, item.quality);
    }

    @DisplayName("Etant donné un item Backstage avec un sellIn à 0 et une qualité de 10" +
        "quand une journée passe, alors le sellIn diminue de 1" +
        "et la qualité tombe à 0")
    @Test
    void quand_une_journee_passe_le_sellIn_diminue_de_1_et_la_qualite_tombe_a_0() {
        // given
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        GildedRose app = new GildedRose(new Item[]{item});

        // when
        app.updateQuality();

        // then
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }
}
