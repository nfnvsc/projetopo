package m19.app.users;

import m19.app.exception.UserRegistrationFailedException;
import m19.core.LibraryManager;
import m19.core.exception.BadEntrySpecificationException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;

/**
 * 4.2.1. Register new user.
 */
public class DoRegisterUser extends Command<LibraryManager> {

  private Input<String> _nome;
  private Input<String> _email;
  /**
   * @param receiver
   */
  public DoRegisterUser(LibraryManager receiver) {
    super(Label.REGISTER_USER, receiver);

    _nome = _form.addStringInput(Message.requestUserName());
    _email = _form.addStringInput(Message.requestUserEMail());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    int _id;
    _form.parse();
    try {
      _id = _receiver.registerUser(_nome.value(), _email.value()); // Falta verificar sucesso ou insucesso;  
    } catch (BadEntrySpecificationException bese) {
      throw new UserRegistrationFailedException(_nome.value(), _email.value());
    }
    _display.popup(Message.userRegistrationSuccessful(_id));      
  }
}
