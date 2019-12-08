package m19.app.works;

import m19.app.exception.NoSuchWorkException;
import m19.core.LibraryManager;
import m19.core.exception.BadEntrySpecificationException;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;


/**
 * 4.3.1. Display work.
 */
public class DoDisplayWork extends Command<LibraryManager> {

  private Input<Integer> _workId;
  /**
   * @param receiver
   */
  public DoDisplayWork(LibraryManager receiver) {
    super(Label.SHOW_WORK, receiver);
    _workId = _form.addIntegerInput(Message.requestWorkId());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try{
      _display.popup(_receiver.printWork(_workId.value()));
    } catch(NoSuchWorkException f){
      throw new NoSuchWorkException(_workId.value());
    }
    
  }
  
}
