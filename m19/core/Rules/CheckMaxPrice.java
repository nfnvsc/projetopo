package m19.core.Rules;
import m19.core.Works.Work;
import m19.core.Users.*;

public class CheckMaxPrice implements Rule{
    int _id = 6;

    public int checkRule(RulesWraper wraper, User user, Work work){
        wraper.set_state(null);
        int maxRequestPrice = user.getUserBehavior().getMaxRequestPrice();
        return (maxRequestPrice == -1 || maxRequestPrice > work.getPrice()) ? 0 : this._id;
    }
}