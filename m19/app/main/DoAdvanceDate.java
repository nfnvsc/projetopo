package m19.app.main;

import m19.core.LibraryManager;

import pt.tecnico.po.ui.Command;

import java.util.Scanner;
// FIXME import other core concepts
// FIXME import ui concepts

/**
 * 4.1.3. Advance the current date.
 */
public class DoAdvanceDate extends Command<LibraryManager> {

  // FIXME define input fields
  private int _nDays;

  /**
   * @param receiver
   */
  public DoAdvanceDate(LibraryManager receiver) {
    super(Label.ADVANCE_DATE, receiver);
    // FIXME initialize input fields
    Scanner scan = new Scanner(System.in);
    System.out.println(Message.requestDaysToAdvance());
    _nDays = scan.nextInt();
    
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    // FIXME define method
    _receiver.advanceDays(_nDays);
  }
  
}
