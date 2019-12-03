package m19.core.Rules;
import m19.core.Works.Work;
import m19.core.User;

abstract class Rule{
    private int _id;

    abstract public boolean checkRule(User user, Work work);
}