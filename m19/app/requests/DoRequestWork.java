package m19.app.requests;

import m19.app.exception.RuleFailedException;
import m19.core.LibraryManager;
import m19.core.exception.BadEntrySpecificationException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
// FIXME import other core concepts
// FIXME import other ui concepts
import pt.tecnico.po.ui.Input;

/**
 * 4.4.1. Request work.
 */
public class DoRequestWork extends Command<LibraryManager> {

  // FIXME define input fields
  private Input<Integer> _userID;
  private Input<Integer> _workID;
  private Input<String> _decision;
  /**
   * @param receiver
   */
  public DoRequestWork(LibraryManager receiver) {
    super(Label.REQUEST_WORK, receiver);
    // FIXME initialize input fields
    _userID = _form.addIntegerInput(Message.requestUserId());
    _workID = _form.addIntegerInput(Message.requestWorkId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    int value;
    // FIXME implement command
    _form.parse();
    try {
    value = _receiver.requestWork(_userID.value(), _workID.value());
    } catch (BadEntrySpecificationException bese) {
      if (Integer.parseInt(bese.getMessage()) == 3) {
        _decision = _form.addStringInput(Message.requestReturnNotificationPreference());
      } else {
        throw new RuleFailedException(_userID.value(), _workID.value(), Integer.parseInt(bese.getMessage()));
      }
    }
    if(_decision.value().equals("s")) {
      _receiver.createNotification(_userID.value(), _workID.value(), 1);
      return;
    }
    _display.popup(Message.workReturnDay(_workID.value(), value));
  }
}
