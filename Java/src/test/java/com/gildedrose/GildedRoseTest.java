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

    @Nested
    public final class SulfurasTest {

        @DisplayName("Etant donné un item Sulfuras" +
            "quand une journée passe, alors le sellIn reste inchangé" +
            "et la qualité reste inchangé")
        @Test
        void quand_une_journee_passe_le_sellIn_reste_inchange_et_la_qualite_reste_inchange() {
            // given
            Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
            GildedRose app = new GildedRose(new Item[]{item});

            // when
            app.updateQuality();

            // then
            assertEquals(0, item.sellIn);
            assertEquals(80, item.quality);
        }

        @DisplayName("Etant donné un item Sulfuras, avec sellIn negatif" +
            "quand une journée passe, alors le sellIn reste inchangé" +
            "et la qualité reste inchangé")
        @Test
        void quand_une_journee_passe_avec_sellIn_negatif_le_sellIn_reste_inchange_et_la_qualite_reste_inchange() {
            // given
            Item item = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
            GildedRose app = new GildedRose(new Item[]{item});

            // when
            app.updateQuality();

            // then
            assertEquals(-1, item.sellIn);
            assertEquals(80, item.quality);
        }
    }

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
}
