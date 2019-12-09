package m19.core.rules;

public class CheckMaxPrice implements Rule{
    private final int _id = 6;

    public int checkRule(RulesWraper wraper){
        wraper.set_state(null);
        int maxRequestPrice = wraper.getUser().getUserBehavior().getMaxRequestPrice();
        return (maxRequestPrice == -1 || maxRequestPrice > wraper.getWork().getPrice()) ? 0 : this._id;
    }
}