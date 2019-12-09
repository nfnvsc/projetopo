package m19.core.rules;

public class CheckMaxRequestedWorks implements Rule{
    private final int _id = 4;

    public int checkRule(RulesWraper wraper){
        wraper.set_state(new CheckReferenceWork());

        return (wraper.getUser().getUserBehavior().getMaxRequests() >= wraper.getUser().getNumberRequests()) ? 0 : this._id;
         
    }
}