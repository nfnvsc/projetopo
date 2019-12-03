package m19.core.Rules;
import m19.core.Works.Work;
import m19.core.User;
import m19.core.User.UserBehavior;

public class CheckMaxPrice extends Rule{
    public boolean checkRule(User user, Work work){
        return (user.getDescription() == UserBehavior.CUMPRIDOR) ? true : (work.getPrice() <= 25);
    }
}