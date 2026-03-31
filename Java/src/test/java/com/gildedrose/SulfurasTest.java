package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
