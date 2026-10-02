package fr.ksuto.commons.awt;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThemeTest {

    @AfterEach
    void clearProperty() {

        System.clearProperty(Theme.PROPERTY);
    }

    @Test
    void defaultsToDark() {

        assertEquals(Theme.DARK, Theme.fromProperty());
    }

    @Test
    void readsThemeFromSystemPropertyIgnoringCase() {

        System.setProperty(Theme.PROPERTY, " IntelliJ ");

        assertEquals(Theme.INTELLIJ, Theme.fromProperty());
    }

    @Test
    void fallsBackToDarkOnUnknownTheme() {

        System.setProperty(Theme.PROPERTY, "windows98");

        assertEquals(Theme.DARK, Theme.fromProperty());
    }
}
