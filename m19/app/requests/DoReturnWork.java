package m19.app.requests;

import pt.tecnico.po.ui.Input;
import m19.app.exception.NoSuchUserException;
import m19.app.exception.WorkNotBorrowedByUserException;
import m19.core.LibraryManager;
import m19.core.exception.BadEntrySpecificationException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.4.2. Return a work.
 */
public class DoReturnWork extends Command<LibraryManager> {

  // FIXME define input fields
  private Input<Integer> _userID;
  private Input<Integer> _workID;
  private Input<String> _decision;
  /**
   * @param receiver
   */
  public DoReturnWork(LibraryManager receiver) {
    super(Label.RETURN_WORK, receiver);
    // FIXME initialize input fields
    _userID = _form.addIntegerInput(Message.requestUserId());
    _workID = _form.addIntegerInput(Message.requestWorkId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    int value;
    try {
      value = _receiver.returnWork(_userID.value(), _workID.value());
    } catch (WorkNotBorrowedByUserException wnkbbuse) {
        throw new WorkNotBorrowedByUserException(_workID.value(), _userID.value());
    }
    if (value != 0) {
      _display.popup(Message.showFine(_userID.value(), value));
      _decision = _form.addStringInput(Message.requestFinePaymentChoice());
      _form.parse();
      if (_decision.value().equals("s"))
        try {
          _receiver.payFine(_userID.value());
        } catch (NoSuchUserException e) {
          throw new NoSuchUserException(_userID.value());
        }
    }

  }

}
