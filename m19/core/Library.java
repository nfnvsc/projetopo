package m19.core;

import java.io.Serializable;
import java.io.IOException;

//import m19.core.exception.MissingFileAssociationException;
import m19.core.exception.BadEntrySpecificationException;

// FIXME import other system types
import java.util.TreeMap;
import java.util.Hashtable;
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
  private TreeMap<Integer, User> _users = new TreeMap<>();
  private Hashtable<Integer, Work> _works = new Hashtable<>();

  // FIXME define contructor(s)
  public Library() {
    _nextUserId = 0;
    _nextWorkId = 0;
    _date = new Date();
  }

  // FIXME define methods

  //Metodos User
  public void addUser(User user) {
    user.setUserId(_nextUserId);
    _users.put(user.getId(), user);
    _nextUserId++;
  }

  public void addWork(Work work) {
    work.setWorkId(_nextWorkId);
    _works.put(work.getId(), work);
    _nextWorkId++;
  }
  
  public User getUser(int id) {
    return _users.get(id);
  }

  protected TreeMap<Integer, User> getAllUsers(){
    return _users;
  }

  public int getDate(){
    return _date.getCurrentDate();
  }

  public void advanceDate(int nDays) {
    _date.advanceDays(nDays);
  }

  public Work getWork(int id){
    return _works.get(id);
  }

  public int getNumberWorks(){
    return _nextWorkId - 1;
  }

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
