package org.iMage.tiler.listeners;

import org.iMage.tiler.Tiler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates action to create the mosaique
 */
public class RunAction implements ActionListener {
    private final Tiler tiler;

    public RunAction(Tiler tiler) {
        this.tiler = tiler;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // Tiler handels everything
        tiler.createMosaique();
    }
}
