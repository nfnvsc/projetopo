package m19.core;

public class Date {

    private int _currentDate;

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