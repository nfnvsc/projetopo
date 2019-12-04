package m19.core.Rules;
import m19.core.Works.Work;
import m19.core.User;

public class CheckWorkAvailable implements Rule{
    int _id = 3;

    public int checkRule(RulesWraper wraper, User user, Work work){
        wraper.set_state(new CheckMaxRequestedWorks());
        return (work.getAvaliableCopies() != 0) ? 0 : this._id;
    }
}