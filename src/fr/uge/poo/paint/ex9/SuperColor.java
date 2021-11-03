package fr.uge.poo.paint.ex9;

import com.evilcorp.coolgraphics.CoolGraphics;

import java.awt.*;

public enum SuperColor {
    RED(Color.RED, CoolGraphics.ColorPlus.RED),
    BLUE(Color.BLUE, CoolGraphics.ColorPlus.BLUE),
    GREEN(Color.GREEN, CoolGraphics.ColorPlus.GREEN),
    ORANGE(Color.ORANGE, CoolGraphics.ColorPlus.ORANGE),
    BLACK(Color.BLACK, CoolGraphics.ColorPlus.BLACK),
    WHITE(Color.WHITE, CoolGraphics.ColorPlus.WHITE);

    private final Color color;
    private final CoolGraphics.ColorPlus colorPlus;

    SuperColor(Color color, CoolGraphics.ColorPlus colorPlus){
        this.color = color;
        this.colorPlus = colorPlus;
    }

    public Color getColor() {
        return color;
    }

    public CoolGraphics.ColorPlus getColorPlus() {
        return colorPlus;
    }
}
