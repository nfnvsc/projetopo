package m19.app.works;

import m19.app.exception.NoSuchWorkException;
import m19.core.LibraryManager;
import m19.core.exception.BadEntrySpecificationException;
// FIXME import other core concepts
// FIXME import ui concepts
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;


/**
 * 4.3.1. Display work.
 */
public class DoDisplayWork extends Command<LibraryManager> {

  // FIXME define input fields
  private Input<Integer> _workId;
  /**
   * @param receiver
   */
  public DoDisplayWork(LibraryManager receiver) {
    super(Label.SHOW_WORK, receiver);
    // FIXME initialize input fields
    _workId = _form.addIntegerInput(Message.requestWorkId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    // FIXME implement command
    _form.parse();
    try{
      _display.popup(_receiver.printWork(_workId.value()));
    } catch(BadEntrySpecificationException f){
      throw new NoSuchWorkException(_workId.value());
    }
    
  }
  
}
