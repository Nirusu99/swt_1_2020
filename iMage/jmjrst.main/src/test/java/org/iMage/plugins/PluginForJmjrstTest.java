package org.iMage.plugins;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class PluginForJmjrstTest {
    LinkedList<PluginForJmjrst> list;

    /**
     * Creates a {@link LinkedList} of objects that are extending {@link PluginForJmjrst}.
     */
    @Before
    public final void buildUp() {
        list = new LinkedList<>();
        list.addAll(Arrays.asList(new TestPlugin(), new TestPlugin2(),
                new TestPlugin3(), new TestPlugin4()));
    }

    /**
     * Tests {@link PluginForJmjrst#compareTo(PluginForJmjrst)}
     * and {@link PluginForJmjrst#hashCode()} by sorting the list
     * and comparing the output with the expected output.
     */
    @Test
    public final void sortTest() {
        StringBuilder output = new StringBuilder();
        list.stream().sorted().collect(Collectors.toList()).forEach(output::append);
        Assert.assertEquals(output.toString(), "abc paraAmount: -2987074"
                + "abc paraAmount: 0"
                + "abc paraAmount: 2987074"
                + "abcd paraAmount: 0");
    }

    /**
     * Removes {@link PluginForJmjrstTest#list}.
     */
    @After
    public final void cleanUp() {
        this.list = null;
    }

}