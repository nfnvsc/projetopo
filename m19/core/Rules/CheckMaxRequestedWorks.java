package m19.core.Rules;
import m19.core.Works.Work;
import m19.core.Users.*;

public class CheckMaxRequestedWorks implements Rule{
    int _id = 4;

    public int checkRule(RulesWraper wraper, User user, Work work){
        wraper.set_state(new CheckReferenceWork());

        return (user.getUserBehavior().getMaxRequests() >= user.getNumberRequests()) ? 0 : this._id;
         
    }
}