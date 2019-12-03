package m19.core.Rules;
import m19.core.Works.Category;
import m19.core.Works.Work;
import m19.core.User;

public class CheckReferenceWork extends Rule{
    public boolean checkRule(User user, Work work){
        return !(work.getCategory() == Category.REFERENCE);
    }
}