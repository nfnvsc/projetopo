package m19.core.rules;

public class CheckRequestTwice implements Rule{
    private final int _id = 1;

    public int checkRule(RulesWraper wraper){
        wraper.set_state(new CheckUserIsSuspended());
        return wraper.getUser().checkRequest(wraper.getWork().getId()) == null ? 0 : this._id;
    }
}