package m19.app.main;

import java.util.Scanner;

import m19.core.LibraryManager;

import pt.tecnico.po.ui.Command;
import java.util.Scanner;

// FIXME import other core concepts
// FIXME import other ui concepts

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
    Scanner scan = new Scanner(System.in);
    System.out.println(Message.openFile());
    _filename = scan.nextLine();
    scan.close();
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
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