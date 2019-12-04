package m19.core.Rules;
import m19.core.Works.Work;
import m19.core.User;

public class CheckUserIsSuspended implements Rule{
    int _id = 2;

    public int checkRule(RulesWraper wraper, User user, Work work){
        wraper.set_state(new CheckWorkAvailable());
        return (user.isActive()) ? 0 : this._id;
    }
}