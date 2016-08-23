package ej.com.messenger.utils;

import ej.com.messenger.model.database.Pojo;

/**
 * @author Emil Jarosiewicz on 2015-05-11.
 */
public class DataHolder {

    private static DataHolder ourInstance = new DataHolder();

    private static Pojo pojo;

    public static DataHolder getInstance() {
        return ourInstance;
    }

    private DataHolder() {
    }

    public static Pojo getPojo() {
        return pojo;
    }

    public static void setPojo(Pojo pojo) {
        DataHolder.pojo = pojo;
    }



}
