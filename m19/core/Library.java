package m19.core;

import java.io.Serializable;
import java.io.IOException;

//import m19.core.exception.MissingFileAssociationException;
import m19.core.exception.BadEntrySpecificationException;

// FIXME import other system types
import java.util.ArrayList;
// FIXME import project (core) types if needed

/**
 * Class that represents the library as a whole.
 */
public class Library implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201901101348L;

  // FIXME define attributes
  private int _nextWorkId;
  private int _nextUserId;
  private Date _date;
  private ArrayList<User> _users = new ArrayList<>();
  private ArrayList<? super Work> _works = new ArrayList<>();

  // FIXME define contructor(s)
  public Library() {
    _nextUserId = 0;
    _nextWorkId = 0;
    _date = new Date();
  }

  // FIXME define methods
  public void addUser(User user) {
    user.setUserId(_nextUserId);
    _users.add(user);
    _nextUserId++;
  }

  public void addWork(Work work) {
    work.setWorkId(_nextWorkId);
    _works.add(work);
    _nextWorkId++;
  }

  public int getDate(){
    return _date.getCurrentDate();
  }

  public void advanceDate(int nDays) {
    _date.advanceDays(nDays);
  }
  /*
  public Work getWork(int id){
    //return work with id
  }

  public String showWork(int id){
    Work work = getWork(id);
    return work.toString();
  
  }
*/
  /**
   * Read the text input file at the beginning of the program and populates the
   * instances of the various possible types (books, DVDs, users).
   * 
   * @param filename
   *          name of the file to load
   * @throws BadEntrySpecificationException
   * @throws IOException
   */
  void importFile(String filename) throws BadEntrySpecificationException, IOException {
    // FIXME implement method
    Parser parser = new Parser(this);
    parser.parseFile(filename);
  }

}
