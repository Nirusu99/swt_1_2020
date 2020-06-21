package org.iMage.tiler.panels;

import org.iMage.tiler.Tiler;
import org.iMage.tiler.listeners.LoadAction;
import org.iMage.tiler.listeners.RunAction;
import org.iMage.tiler.listeners.ShowAction;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ArtisticPanel extends JPanel {
    private final Tiler tiler;
    private DigitTextField width;
    private DigitTextField height;

    public ArtisticPanel(final Tiler tiler) {
        this.tiler = tiler;
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800, 80));
        setLayout(new GridLayout(1, 2));
        setOpaque(false);

        createTilesOptions();

        createArtistsOptions();

        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), "Artistic",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, Color.LIGHT_GRAY));
    }

    private void createTilesOptions() {
        JPanel tilesOptions = new JPanel();
        GridBagConstraints l = new GridBagConstraints();
        GridBagConstraints textLeft = new GridBagConstraints();
        GridBagConstraints textRight = new GridBagConstraints();
        JLabel tileSize = new JLabel("Tile Size");
        JLabel x = new JLabel(" ⨯ ");
        JButton load = new JButton("Load Tiles");
        JButton show = new JButton("Show Tiles");
        width = new DigitTextField("100", tiler);
        height = new DigitTextField("100", tiler);

        tilesOptions.setLayout(new GridBagLayout());

        l.insets = new Insets(0, 5, 0, 5);
        textLeft.insets = new Insets(0, 5, 0, 0);
        textRight.insets = new Insets(0, 0, 0, 5);

        width.setMinimumSize(new Dimension(30, 20));
        width.setPreferredSize(new Dimension(30, 20));
        height.setPreferredSize(new Dimension(30, 20));
        height.setMinimumSize(new Dimension(30, 20));

        x.setOpaque(false);
        x.setForeground(Color.LIGHT_GRAY);
        x.setBackground(Color.LIGHT_GRAY);

        tileSize.setForeground(Color.LIGHT_GRAY);
        tileSize.setBackground(Color.LIGHT_GRAY);
        tileSize.setOpaque(false);

        load.setBackground(Color.LIGHT_GRAY);
        load.addActionListener(new LoadAction(tiler));
        show.setBackground(Color.LIGHT_GRAY);
        show.addActionListener(new ShowAction(tiler));

        tilesOptions.setOpaque(false);
        tilesOptions.add(tileSize, l);
        tilesOptions.add(width, textLeft);
        tilesOptions.add(x);
        tilesOptions.add(height, textRight);
        tilesOptions.add(load, l);
        tilesOptions.add(show, l);

        add(tilesOptions);
    }

    private void createArtistsOptions() {
        JPanel artistsOptions = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints l = new GridBagConstraints();
        JLabel artist = new JLabel("Artist");
        JComboBox<String> artistMenu = new JComboBox<>(new String[]{ "Rectangle", "Triangle" });
        JButton run = new JButton("Run");

        l.insets = new Insets(0, 5, 0, 5);

        artistsOptions.setLayout(layout);
        artistsOptions.setOpaque(false);

        artist.setForeground(Color.LIGHT_GRAY);
        artistMenu.setBackground(Color.LIGHT_GRAY);

        run.setBackground(Color.LIGHT_GRAY);
        run.addActionListener(new RunAction(tiler));

        artistsOptions.add(artist, l);
        artistsOptions.add(artistMenu, l);
        artistsOptions.add(run, l);

        add(artistsOptions);
    }

    public int getW() throws NumberFormatException {
        return width.getNumber();
    }

    public int getH() throws NumberFormatException {
        return height.getNumber();
    }
}