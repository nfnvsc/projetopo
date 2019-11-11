package m19.core;

import java.io.Serializable;
import java.io.IOException;

import m19.core.exception.MissingFileAssociationException;
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
  private ArrayList<User> _users;
  private ArrayList<Work> _works;
  // FIXME define contructor(s)

  public Library() {
    _nextUserId = 0;
    _nextWorkId = 0;
    _users = new ArrayList<User>();
    _works = new ArrayList<Work>();
  }
  // FIXME define methods

  public addUser(User user) {
    user.setUserId = _nextUserId;
    _users.add(user);
    _nextUserId++;
  }

  public addWork(Work work) {
    work.setWorkId = _nextWorkId;
    _works.add(work);
    _nextWorkId++;
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

  }

}
