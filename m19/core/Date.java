package m19.core;

import java.io.Serializable;

public class Date implements Serializable{

    private int _currentDate;
    private static final long serialVersionUID = 201901101349L;

    public Date() {
        _currentDate = 0;
    }
    protected int getCurrentDate() {
        return _currentDate;
    }

    protected void advanceDays(int nDays) {
        _currentDate += nDays;
    }
}