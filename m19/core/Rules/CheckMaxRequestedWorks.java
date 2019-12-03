package m19.core.Rules;
import m19.core.Works.Work;
import m19.core.User;

public class CheckMaxRequestedWorks extends Rule{
    public boolean checkRule(User user, Work work){
        switch(user.getDescription()){
            case FALTOSO:
                return true;
            case CUMPRIDOR:
                return true;
            default:
                return true;

        } 
    }
}