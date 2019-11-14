package m19.app.works;

import m19.core.LibraryManager;
// FIXME import other core concepts
// FIXME import ui concepts
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;

import java.util.Scanner;
/**
 * 4.3.3. Perform search according to miscellaneous criteria.
 */
public class DoPerformSearch extends Command<LibraryManager> {

  // FIXME define input fields
  String _searchTerm;
  /**
   * @param m
   */
  public DoPerformSearch(LibraryManager m) {
    super(Label.PERFORM_SEARCH, m);
    // FIXME initialize input fields
    _searchTerm = null;
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    // FIXME implement command
    Display display = new Display();
    Scanner scan = new Scanner(System.in);
    display.popup(Message.requestSearchTerm());
    _searchTerm = scan.nextLine();
    display.clear();

    display.popup(_receiver.printMatchingWorks(_searchTerm));




  }
  
}
