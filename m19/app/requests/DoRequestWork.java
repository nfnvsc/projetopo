package m19.app.requests;

import m19.app.exception.NoSuchUserException;
import m19.app.exception.NoSuchWorkException;
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
    _userID = _form.addIntegerInput(Message.requestUserId());
    _workID = _form.addIntegerInput(Message.requestWorkId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    int value = 0;
    _form.parse();
    try {
      value = _receiver.requestWork(_userID.value(), _workID.value());
      _display.popup(Message.workReturnDay(_workID.value(), value));
    } catch (NoSuchUserException nsue) {
      throw new NoSuchUserException(_userID.value());
    } catch (NoSuchWorkException nswe) {
      throw new NoSuchWorkException(_workID.value());
    } catch (RuleFailedException rfe) {
        if (Integer.parseInt(rfe.getMessage()) == 3) {
          _decision = _form.addStringInput(Message.requestReturnNotificationPreference());
          _form.parse();
          if(_decision.value().equals("s")) {
            _receiver.createDevolucaoNotification(_userID.value(), _workID.value());
            return;
          }
        } else {
        throw new RuleFailedException(_userID.value(), _workID.value(), Integer.parseInt(rfe.getMessage()));
      }
    }
  }
}
