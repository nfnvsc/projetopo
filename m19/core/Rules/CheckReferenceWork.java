package m19.core.Rules;
import m19.core.Works.*;
import m19.core.Users.*;

public class CheckReferenceWork implements Rule{
    int _id = 5;

    public int checkRule(RulesWraper wraper, User user, Work work){
        wraper.set_state(new CheckMaxPrice());
        return (work.getCategory() == Category.REFERENCE) ? this._id : 0;
    }
}