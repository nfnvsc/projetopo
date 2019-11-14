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
    System.out.println(Message.requestUserName());
    _nome = scan.nextLine();
    System.out.println(Message.requestUserEMail());
    _email = scan.nextLine();
    try {
      _id = _receiver.registerUser(_nome, _email); // Falta verificar sucesso ou insucesso;  
    } catch (BadEntrySpecificationException bese) {
      throw UserRegistrationFailedException(_nome, _email);
    }
    Message.userRegistrationSuccessful(_id);      
  }
}
