package m19.core.Rules;

import m19.core.Works.Work;
import m19.core.Users.*;

public class CheckMaxPrice implements Rule{
    private final int _id = 6;
    private static final long serialVersionUID = 201901101348L;

    public int checkRule(RulesWraper wraper, User user, Work work){
        wraper.set_state(null);
        int maxRequestPrice = user.getUserBehavior().getMaxRequestPrice();
        return (maxRequestPrice == -1 || maxRequestPrice > work.getPrice()) ? 0 : this._id;
    }
}