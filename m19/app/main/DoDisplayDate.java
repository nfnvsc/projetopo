package m19.app.main;

import m19.core.LibraryManager;

import pt.tecnico.po.ui.Command;

// FIXME import other core concepts
// FIXME import other ui concepts
import pt.tecnico.po.ui.Display;
/**
 * 4.1.2. Display the current date.
 */
public class DoDisplayDate extends Command<LibraryManager> {

  /**
   * @param receiver
   */
  public DoDisplayDate(LibraryManager receiver) {
    super(Label.DISPLAY_DATE, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    // FIXME define method
    popup(Message.currentDate(_receiver.getCurrentDate()));
  }
  
}
