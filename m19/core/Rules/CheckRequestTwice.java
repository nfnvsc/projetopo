package m19.core.Rules;
import m19.core.Works.Work;
import m19.core.User;

public class CheckRequestTwice extends Rule{
    public boolean checkRule(User user, Work work){
        //verificar requests dos users
        return true;
    }
}