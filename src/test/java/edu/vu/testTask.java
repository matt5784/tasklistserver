package edu.vu;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

public class testTask {

    private static final String NAME = "fbgai178dasde";
    private static final String TIME = "dhsjauf89uhbf";
    private static final int LAT = 12647;
    private static final int LON = 71943;
    private static final String CONCAT = NAME + ";" + TIME + ";" + LAT + ";" + LON;

    @Test
    public void testTaskStringStringIntInt() {
        final Task test = new Task(NAME, TIME, LAT, LON);
        final String name = getField("mName", test);
        final String time = getField("mTime", test);
        final int lat = getField("mLat", test);
        final int lon = getField("mLon", test);

        assertEquals("Fields must match", NAME, name);
        assertEquals("Fields must match", TIME, time);
        assertEquals("Fields must match", LAT, lat);
        assertEquals("Fields must match", LON, lon);
    }

    @Test
    public void testTaskString() {
        final Task test = new Task(CONCAT);
        final String name = getField("mName", test);
        final String time = getField("mTime", test);
        final int lat = getField("mLat", test);
        final int lon = getField("mLon", test);

        assertEquals("Fields must match", NAME, name);
        assertEquals("Fields must match", TIME, time);
        assertEquals("Fields must match", LAT, lat);
        assertEquals("Fields must match", LON, lon);
    }

    @Test
    public void testGetName() {
        final Task test = new Task(NAME, TIME, LAT, LON);
        assertEquals("Fields must match", NAME, test.getName());
    }

    @Test
    public void testGetTime() {
        final Task test = new Task(NAME, TIME, LAT, LON);
        assertEquals("Fields must match", TIME, test.getTime());
    }

    @Test
    public void testGetLat() {
        final Task test = new Task(NAME, TIME, LAT, LON);
        assertEquals("Fields must match", LAT, test.getLat());
    }

    @Test
    public void testGetLon() {
        final Task test = new Task(NAME, TIME, LAT, LON);
        assertEquals("Fields must match", LON, test.getLon());
    }

    @Test
    public void testToString() {
        final Task test = new Task(NAME, TIME, LAT, LON);
        final String testString = test.toString();

        assertEquals("Fields must match", CONCAT, testString);
    }

    private <T> T getField(final String name, final Task test) {
        Field f;
        try {
            f = test.getClass().getDeclaredField(name);
            f.setAccessible(true);
            return (T) f.get(test);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

}
