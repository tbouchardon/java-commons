package fr.ksuto.commons.awt;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

/**
 * Thème Swing des applications ksuto (FlatLaf). À appliquer avant de créer la première fenêtre :
 * <pre>Theme.apply();</pre>
 * Le thème se choisit au lancement avec {@code -Dksuto.theme=dark|light|intellij|darcula|none} (dark par défaut ;
 * none garde le thème Swing d'origine).
 */
public enum Theme {

    DARK,
    LIGHT,
    INTELLIJ,
    DARCULA,
    NONE;

    public static final String PROPERTY = "ksuto.theme";

    private static final Logger logger = LoggerFactory.getLogger(Theme.class);

    /**
     * Applique le thème choisi par la propriété système {@value #PROPERTY}.
     */
    public static Theme apply() {

        Theme theme = fromProperty();
        theme.install();
        return theme;
    }

    static Theme fromProperty() {

        String value = System.getProperty(PROPERTY, DARK.name());
        try {
            return valueOf(value.trim().toUpperCase(Locale.ROOT));
        }
        catch (IllegalArgumentException e) {
            logger.warn("Thème inconnu '{}' ({}), thème {} utilisé", value, PROPERTY, DARK);
            return DARK;
        }
    }

    public void install() {

        boolean installed = switch (this) {
            case DARK -> FlatDarkLaf.setup();
            case LIGHT -> FlatLightLaf.setup();
            case INTELLIJ -> FlatIntelliJLaf.setup();
            case DARCULA -> FlatDarculaLaf.setup();
            case NONE -> true;
        };
        if (!installed) {logger.warn("Impossible d'appliquer le thème {}", this);}
    }
}
