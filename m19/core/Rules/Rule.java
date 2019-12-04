package m19.core.Rules;
import m19.core.Works.Work;
import m19.core.User;

public interface Rule{
    public int checkRule(RulesWraper wraper, User user, Work work);
}