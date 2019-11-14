package m19.app.works;

import m19.core.LibraryManager;
// FIXME import other core concepts
// FIXME import ui concepts
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Display;
/**
 * 4.3.2. Display all works.
 */
public class DoDisplayWorks extends Command<LibraryManager> {

  /**
   * @param receiver
   */
  public DoDisplayWorks(LibraryManager receiver) {
    super(Label.SHOW_WORKS, receiver);
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    // FIXME implement command
    Display display = new Display();
    display.popup(_receiver.printAllWorks());
    //System.out.println();
  }
}
