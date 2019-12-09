package m19.core.rules;

import m19.core.works.Category;

public class CheckReferenceWork implements Rule{
    private final int _id = 5;

    public int checkRule(RulesWraper wraper){
        wraper.set_state(new CheckMaxPrice());
        return (wraper.getWork().getCategory() == Category.REFERENCE) ? this._id : 0;
    }
}