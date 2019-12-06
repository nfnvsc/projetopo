package m19.app.users;

import pt.tecnico.po.ui.Input;
import m19.app.exception.UserIsActiveException;
import m19.core.LibraryManager;
import m19.core.exception.BadEntrySpecificationException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.2.5. Settle a fine.
 */
public class DoPayFine extends Command<LibraryManager> {

  // FIXME define input fields
  private Input<Integer> _id;

  /**
   * @param receiver
   */
  public DoPayFine(LibraryManager receiver) {
    super(Label.PAY_FINE, receiver);
    // FIXME initialize input fields
    _id = _form.addIntegerInput(Message.requestUserId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    // FIXME implement command
    _form.parse();
    try {
      _receiver.payFine(_id.value());
    } catch (BadEntrySpecificationException bese) {
      throw new UserIsActiveException(_id.value());
    }
  }
}
