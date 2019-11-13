package m19.app.works;

import m19.core.LibraryManager;
// FIXME import other core concepts
// FIXME import ui concepts
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import java.util.Scanner;

/**
 * 4.3.1. Display work.
 */
public class DoDisplayWork extends Command<LibraryManager> {

  // FIXME define input fields
  int _workId;
  /**
   * @param receiver
   */
  public DoDisplayWork(LibraryManager receiver) {
    super(Label.SHOW_WORK, receiver);
    // FIXME initialize input fields
    _workId = -1;
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    // FIXME implement command
    Scanner scan = new Scanner(System.in);
    System.out.println(Message.requestWorkId());
    _workId = scan.nextInt();
    System.out.println(_receiver.printWork(_workId));
    
  }
  
}
