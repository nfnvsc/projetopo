package m19.core.rules;

public class CheckUserIsSuspended implements Rule{
    private final int _id = 2;

    public int checkRule(RulesWraper wraper){
        wraper.set_state(new CheckWorkAvailable());
        return (wraper.getUser().isActive()) ? 0 : this._id;
    }
}