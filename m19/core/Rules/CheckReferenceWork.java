package m19.core.Rules;

import m19.core.Works.Work;
import m19.core.Works.Category;
import m19.core.Users.User;

public class CheckReferenceWork implements Rule{
    private final int _id = 5;

    public int checkRule(RulesWraper wraper, User user, Work work){
        wraper.set_state(new CheckMaxPrice());
        return (work.getCategory() == Category.REFERENCE) ? this._id : 0;
    }
}