package m19.app.works;

import m19.app.exception.NoSuchWorkException;
import m19.core.LibraryManager;

import pt.tecnico.po.ui.Command;

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

  /**
   * @throws NoSuchWorkException
   * @see pt.tecnico.po.ui.Command#execute()
   */
  @Override
  public final void execute() throws NoSuchWorkException {
    _display.addLine(_receiver.printAllWorks());
    _display.display();
  }
}
