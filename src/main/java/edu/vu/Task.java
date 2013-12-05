package edu.vu;

public class Task {

    private final String mName;
    private final String mTime;
    private final Integer mLat;
    private final Integer mLon;

    public Task(final String name, final String time, final int lat, final int lon) {
        mName = name;
        mTime = time;
        mLat = lat;
        mLon = lon;
    }

    public Task(final String fromString) {
        final String[] temp = fromString.split(";");
        if (temp.length == 4) {
            mName = temp[0];
            mTime = temp[1];
            mLat = Integer.parseInt(temp[2]);
            mLon = Integer.parseInt(temp[3]);
        } else {
            mName = null;
            mTime = null;
            mLat = null;
            mLon = null;
        }

    }

    public String getName() {
        return mName;
    }

    public String getTime() {
        return mTime;
    }

    public int getLat() {
        return mLat;
    }

    public int getLon() {
        return mLon;
    }

    @Override
    public String toString() {
        return mName + ";" + mTime + ";" + mLat + ";" + mLon;
    }

}
