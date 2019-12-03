package m19.core.Rules;
import m19.core.Works.Work;
import m19.core.User;

public class CheckWorkAvailable extends Rule{
    public boolean checkRule(User user, Work work){
        return work.getAvaliableCopies() == 0;
    }
}