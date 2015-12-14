package gameObjectsOrientedModel;

import gameObjectsOrientedModel.Objects.Men;

import java.util.ArrayList;

/**
 * 11.11.15.
 */
public class State {
    private static ArrayList<Object> objects = new ArrayList();
    public static Object object(int index) {
        return objects.get(index);
    }
    public static Men men(int index) {
        return (Men)objects.get(index);
    }
    public static int size() {
        return objects.size();
    }
    public static void addObject(Object object) {
        objects.add(object);
    }
}
