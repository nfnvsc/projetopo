package m19.core.Rules;
import m19.core.Works.Work;
import m19.core.Users.User;

public class CheckUserIsSuspended implements Rule{
    private final int _id = 2;

    public int checkRule(RulesWraper wraper, User user, Work work){
        wraper.set_state(new CheckWorkAvailable());
        return (user.isActive()) ? 0 : this._id;
    }
}