package m19.app.users;

import m19.app.exception.UserRegistrationFailedException;
import m19.core.LibraryManager;
import m19.core.exception.BadEntrySpecificationException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Display;

// FIXME import other core concepts
import java.util.Scanner;
// FIXME import other ui concepts

/**
 * 4.2.1. Register new user.
 */
public class DoRegisterUser extends Command<LibraryManager> {

  // FIXME define input fields
  private String _nome;
  private String _email;
  private int _id;
  /**
   * @param receiver
   */
  public DoRegisterUser(LibraryManager receiver) {
    super(Label.REGISTER_USER, receiver);
    // FIXME initialize input fields
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    // FIXME implement command
    Scanner scan = new Scanner(System.in);
    Display display = new Display();
    display.popup(Message.requestUserName());
    _nome = scan.nextLine();
    display.clear();
    display.popup(Message.requestUserEMail());
    display.clear();
    _email = scan.nextLine();
    try {
      _id = _receiver.registerUser(_nome, _email); // Falta verificar sucesso ou insucesso;  
    } catch (BadEntrySpecificationException bese) {
      throw new UserRegistrationFailedException(_nome, _email);
    }
    display.popup(Message.userRegistrationSuccessful(_id));      
  }
}
