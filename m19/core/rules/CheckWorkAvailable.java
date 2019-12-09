package m19.core.rules;

public class CheckWorkAvailable implements Rule{
    private final int _id = 3;

    public int checkRule(RulesWraper wraper){
        wraper.set_state(new CheckMaxRequestedWorks());
        return (wraper.getWork().getAvaliableCopies() != 0) ? 0 : this._id;
    }
}