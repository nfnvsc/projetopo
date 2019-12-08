package m19.app.works;

import m19.app.exception.NoSuchWorkException;
import m19.core.LibraryManager;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Input;

/**
 * 4.3.3. Perform search according to miscellaneous criteria.
 */
public class DoPerformSearch extends Command<LibraryManager> {

  private Input<String> _searchTerm;

  /**
   * @param m
   */
  public DoPerformSearch(LibraryManager m) {
    super(Label.PERFORM_SEARCH, m);
    _searchTerm = _form.addStringInput(Message.requestSearchTerm());
  }

  /**
   * @throws NoSuchWorkException
   * @see pt.tecnico.po.ui.Command#execute()
   */
  @Override
  public final void execute() throws NoSuchWorkException {
    _form.parse();
    _display.popup(_receiver.printMatchingWorks(_searchTerm.value()));




  }
  
}
