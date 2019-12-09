package m19.app.requests;

import m19.app.exception.NoSuchUserException;
import m19.app.exception.NoSuchWorkException;
import m19.app.exception.WorkNotBorrowedByUserException;

import m19.core.LibraryManager;

import pt.tecnico.po.ui.Input;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Form;

/**
 * 4.4.2. Return a work.
 */
public class DoReturnWork extends Command<LibraryManager> {

  Input<Integer> _userID;
  Input<Integer> _workID;
  Input<String> _decision;
  Form _form2;
  
  /**
   * @param receiver
   */
  public DoReturnWork(LibraryManager receiver) {
    super(Label.RETURN_WORK, receiver);
    _form2 = new Form();

    _userID = _form.addIntegerInput(Message.requestUserId());
    _workID = _form.addIntegerInput(Message.requestWorkId());
    _decision = _form2.addStringInput(Message.requestFinePaymentChoice());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    int value;

    _form.parse();
    try {
      value = _receiver.returnWork(_userID.value(), _workID.value());
    } catch (WorkNotBorrowedByUserException wnkbbuse) {
        throw new WorkNotBorrowedByUserException(_workID.value(), _userID.value());
    } catch (NoSuchUserException nsue) {
        throw new NoSuchUserException(_userID.value());
    } catch (NoSuchWorkException nswe) {
        throw new NoSuchWorkException(_workID.value());
  }
    
    if (value != 0) {
      _display.popup(Message.showFine(_userID.value(), value));

      _form2.parse();
      if ("s".equals(_decision.value())) 
        _receiver.payFine(_userID.value());
      
    }

  }

}
