package rezepte;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import templates.Kochbuch;
import templates.RezeptFile;
import templates.Rezept;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class TestsuiteRezept {


    @Test
    @DisplayName("Lade eine leere Rezept JSON Datei")
    public void ladeLeeresRezept() {
        final RezeptFile rezeptFile = RezeptFile.load().fromJsonFile(
                Paths.get("src/test/resources/", "kochbuch1/LeereDatei.rezept")
                        .toFile()
        );
        assertNull(rezeptFile.get("Kochbuch"));
    }

    @Test
    @DisplayName("Lade eine Kochbuch JSON Datei")
    public void ladeKochbuch() {
        final RezeptFile rezeptFile = RezeptFile.load().fromJsonFile(
                Paths.get("src/test/resources/", "/kochbuch1/Kochbuch.rezept")
                        .toFile()
        );
        final Kochbuch kochbuch = (Kochbuch) rezeptFile.get("Kochbuch");
        assertNotNull(kochbuch);
        assertEquals("Backen & Banken", kochbuch.get("Titel"));
        // rquired wirkt sich nur auf den Builder aus!!!
        // beim Laden kann der Wert optional sein
        assertNull(kochbuch.get("Version"));
    }


}
