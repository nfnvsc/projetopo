package m19.core.Rules;
import m19.core.Works.Work;
import m19.core.User;

public class CheckUserIsSuspended extends Rule{
    public boolean checkRule(User user, Work work){
        return user.isActive();
    }
}