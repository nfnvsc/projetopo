package m19.app.main;

import m19.core.LibraryManager;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

// FIXME import other core concepts
// FIXME import ui concepts

/**
 * 4.1.3. Advance the current date.
 */
public class DoAdvanceDate extends Command<LibraryManager> {

  // FIXME define input fields
  private Input<Integer> _nDays;

  /**
   * @param receiver
   */
  public DoAdvanceDate(LibraryManager receiver) {
    super(Label.ADVANCE_DATE, receiver);
    // FIXME initialize input fields
    _nDays = _form.addIntegerInput(Message.requestDaysToAdvance());
    
    
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    // FIXME define method
    _form.parse();
    _receiver.advanceDays(_nDays.value());
  }
  
}
