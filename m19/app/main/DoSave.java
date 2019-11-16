package m19.app.main;

import java.io.IOException;

import m19.core.LibraryManager;
import m19.core.exception.MissingFileAssociationException;
import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.Display;
import pt.tecnico.po.ui.Input;


// FIXME import other core concepts
// FIXME import other ui concepts

/**
 * 4.1.1. Save to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<LibraryManager> {
  
  // FIXME define input fields
  private Input<String> _filename;

  /**
   * @param receiver
   */
  public DoSave(LibraryManager receiver) {
    super(Label.SAVE, receiver);
    // FIXME initialize input fields
    _filename = _form.addStringInput(Message.newSaveAs());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    // FIXME implement command
    try{
      if (_receiver.hasAssociatedFile()){
        _receiver.save();
      }
      else{
        _form.parse();
        _receiver.saveAs(_filename.value());
      }
    }catch(MissingFileAssociationException fnfe){
      //nao faz sentido pq a library tem smp um ficheiro associado neste ponto (so se o ficheiro for invalido)
    }catch(IOException e){
      e.printStackTrace();
    }
    

  }
}
