package org.iMage.plugins;

import org.jis.Main;

public class TestPlugin extends PluginForJmjrst {

    @Override
    public String getName() {
        return "abc";
    }

    @Override
    public int getNumberOfParameters() {
        return 0;
    }

    @Override
    public void init(Main main) {
        // what ever
    }

    @Override
    public void run() {
        // what ever
    }

    @Override
    public boolean isConfigurable() {
        return false;
    }

    @Override
    public void configure() {
      // what ever
    }

    @Override
    public String toString() {
        return this.getName() + " paraAmount: " + this.getNumberOfParameters();
    }
}