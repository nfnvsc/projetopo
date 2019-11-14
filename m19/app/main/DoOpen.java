package m19.app.main;

import java.util.Scanner;

import m19.core.LibraryManager;
import m19.app.exception.FileOpenFailedException;
import pt.tecnico.po.ui.Command;
import java.io.FileNotFoundException;
import java.lang.ClassNotFoundException;
import java.io.IOException;
import pt.tecnico.po.ui.DialogException;
// FIXME import other core concepts
// FIXME import other ui concepts
import pt.tecnico.po.ui.Display;

/**
 * 4.1.1. Open existing document.
 */
public class DoOpen extends Command<LibraryManager> {

  // FIXME define input fields if needed
  private String _filename;
  /**
   * @param receiver
   */
  public DoOpen(LibraryManager receiver) {
    super(Label.OPEN, receiver);
    // FIXME initialize input fields if needed
    _filename = null;
    
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    Scanner scan = new Scanner(System.in);
    Display display = new Display();
    display.popup(Message.openFile());
    _filename = scan.nextLine();

    try {
        // FIXME implement command
      _receiver.load(_filename);
    } catch (FileNotFoundException fnfe) {
      throw new FileOpenFailedException(_filename);
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }

}
