package m19.app.users;

import m19.core.LibraryManager;
import m19.core.exception.BadEntrySpecificationException;
import m19.app.exception.NoSuchUserException;

import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;

/**
 * 4.2.3. Show notifications of a specific user.
 */
public class DoShowUserNotifications extends Command<LibraryManager> {

  private Input<Integer> _id;

  /**
   * @param receiver
   */
  public DoShowUserNotifications(LibraryManager receiver) {
    super(Label.SHOW_USER_NOTIFICATIONS, receiver);
    _id = _form.addIntegerInput(Message.requestUserId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try {
      _display.popup(_receiver.printUserNotifications(_id.value()));
    } catch (NoSuchUserException userID) {
      throw new NoSuchUserException(_id.value());
    }

  }

}
