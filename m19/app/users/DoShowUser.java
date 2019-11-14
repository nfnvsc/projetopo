package m19.app.users;

import m19.core.exception.BadEntrySpecificationException;
import m19.app.exception.NoSuchUserException;
import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;

// FIXME import other core concepts
import java.util.Scanner;
// FIXME import other ui concepts

/**
 * 4.2.2. Show specific user.
 */
public class DoShowUser extends Command<LibraryManager> {

  // FIXME define input fields
  private Input<Integer> _id;
  /**
   * @param receiver
   */
  public DoShowUser(LibraryManager receiver) {
    super(Label.SHOW_USER, receiver);
    // FIXME initialize input fields
    _id = _form.addIntegerInput(Message.requestUserId());
    
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    // FIXME implement command
    _form.parse();
    try {
      _display.popup(_receiver.printUser(_id.value()));
    } catch (BadEntrySpecificationException bese) {
      throw new NoSuchUserException(_id.value());
    }
  }
}
