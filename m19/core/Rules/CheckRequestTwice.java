package m19.core.Rules;
import m19.core.Works.Work;
import m19.core.Users.User;

public class CheckRequestTwice implements Rule{
    int _id = 1;

    public int checkRule(RulesWraper wraper, User user, Work work){
        //verificar requests dos users
        wraper.set_state(new CheckUserIsSuspended());
        return 1;
    }
}