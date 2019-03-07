package rezepte;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import templates.Kochbuch;
import templates.Rezept;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class TestsuiteRezept {


    @Test
    @DisplayName("Lade eine leere Rezept JSON Datei")
    public void ladeLeeresRezept() {
        final Rezept rezept = Rezept.load().fromJsonFile(
                Paths.get("src/test/resources/", "kochbuch1/LeereDatei.rezept")
                        .toFile()
        );
        assertNull(rezept.get("Kochbuch"));
    }

    @Test
    @DisplayName("Lade eine Kochbuch JSON Datei")
    public void ladeKochbuch() {
        final Rezept rezept = Rezept.load().fromJsonFile(
                Paths.get("src/test/resources/", "/kochbuch1/Kochbuch.rezept")
                        .toFile()
        );
        final Kochbuch buch = (Kochbuch) rezept.get("Kochbuch");
        assertNotNull(buch);
        assertEquals("Backen & Banken", buch.get("Titel"));
    }


}
