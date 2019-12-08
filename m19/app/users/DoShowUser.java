package m19.app.users;

import m19.core.exception.BadEntrySpecificationException;
import m19.app.exception.NoSuchUserException;
import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;

/**
 * 4.2.2. Show specific user.
 */
public class DoShowUser extends Command<LibraryManager> {

  private Input<Integer> _id;
  /**
   * @param receiver
   */
  public DoShowUser(LibraryManager receiver) {
    super(Label.SHOW_USER, receiver);
    _id = _form.addIntegerInput(Message.requestUserId());
    
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try {
      _display.popup(_receiver.printUser(_id.value()));
    } catch (NoSuchUserException bese) {
      throw new NoSuchUserException(_id.value());
    }
  }
}
