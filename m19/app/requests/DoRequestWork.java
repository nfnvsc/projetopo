package m19.app.requests;

import m19.app.exception.NoSuchUserException;
import m19.app.exception.NoSuchWorkException;
import m19.app.exception.RuleFailedException;

import m19.core.LibraryManager;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Form;
import pt.tecnico.po.ui.Input;

/**
 * 4.4.1. Request work.
 */
public class DoRequestWork extends Command<LibraryManager> {
  /**
   * @param receiver
   */
  Input<Integer> _userID;
  Input<Integer> _workID;
  Input<String> _decision;
  Form _form2;

  public DoRequestWork(LibraryManager receiver) {
    super(Label.REQUEST_WORK, receiver);
    _form2 = new Form();
    
    _userID = _form.addIntegerInput(Message.requestUserId());
    _workID = _form.addIntegerInput(Message.requestWorkId());
    _decision = _form2.addStringInput(Message.requestReturnNotificationPreference());
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

        if (rfe.getRuleIndex() == 3) {
          _form2.parse();
          if ("s".equals(_decision.value())) {
            _receiver.createDevolucaoNotification(_userID.value(), _workID.value());
            return;
          }
        } else {
            throw rfe;
      }
    }

  }
}
