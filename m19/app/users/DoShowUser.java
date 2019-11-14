package m19.app.users;

import m19.core.exception.BadEntrySpecificationException;
import m19.app.exception.NoSuchUserException;
import m19.core.LibraryManager;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;
import pt.tecnico.po.ui.DialogException;

// FIXME import other core concepts
import java.util.Scanner;
// FIXME import other ui concepts

/**
 * 4.2.2. Show specific user.
 */
public class DoShowUser extends Command<LibraryManager> {

  // FIXME define input fields
  private int _id;
  /**
   * @param receiver
   */
  public DoShowUser(LibraryManager receiver) {
    super(Label.SHOW_USER, receiver);
    // FIXME initialize input fields
    _id = -1;
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    // FIXME implement command
    Scanner scan = new Scanner(System.in);
    Display display = new Display();
    display.popup((Message.requestUserId()));
    display.clear();
    _id = scan.nextInt();
    try {
      display.popup(_receiver.printUser(_id));
    } catch (BadEntrySpecificationException bese) {
      throw new NoSuchUserException(_id);
    }
  }
}
