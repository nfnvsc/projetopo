package m19.core;

import m19.core.works.Work;
import m19.core.users.User;
import m19.core.notifications.*;
import m19.core.rules.RulesWraper;

import java.io.Serializable;
import java.io.IOException;

import m19.core.exception.BadEntrySpecificationException;
import m19.app.exception.NoSuchUserException;
import m19.app.exception.NoSuchWorkException;
import m19.app.exception.WorkNotBorrowedByUserException;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;


/**
 * Class that represents the library as a whole.
 */
public class Library implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201901101348L;

  /**
   * The Id to be assigned to the next Work
   */
  private int _nextWorkId;

  /**
   * The Id to be assigned to the next User
   */
  private int _nextUserId;

  /**
   * The current date
   * @see Date
   */
  private Date _date;

  /**
   * A map of all the users in the Library (indexed by UserId)
   * 
   * @see User#getId()
   */
  private Map<Integer, User> _users;

  /**
   * A map of all the works in the Library (indexed by WorkId)
   * 
   * @see Work#getId()
   */
  private Map<Integer, Work> _works;

  /**
   * A list of all the requests in the Library
   * 
   * @see Request
   */
  private List<Request> _requests;

   /**
   * Stores all the notifications
   */
  private NotificationManager _notificationManager;

  /**
   * Makes a {@code Library} instace 
   */
  public Library() {
    _nextUserId = 0;
    _nextWorkId = 0;
    _date = new Date();
    _users = new TreeMap<>();
    _works = new HashMap<>();
    _requests = new ArrayList<>();
    _notificationManager = new NotificationManager();
  }

  //Metodos User
  /**
   * Add User to the Library TreeMap
   * 
   * @param user  the user that is meant to be add to the Library database
   * @return      the user identification in the database
   * @see         User
   * 
   */ 
  public int addUser(User user) throws BadEntrySpecificationException {
    user.setUserId(_nextUserId);
    _users.put(user.getId(), user);
    _nextUserId++;
    return user.getId();
  }

  /**
   * Add Work to the Library TreeMap
   * 
   * @param Work  the work that is meant to be add to the Library database
   * @see         Work
   * 
   */
  public void addWork(Work work) {
    work.setWorkId(_nextWorkId);
    _works.put(work.getId(), work);
    _nextWorkId++;
  }
  
  /**
   * Gets a user of associated to the given User Id
   * 
   * @param id    the id of a User 
   * @return      the user associated to that id
   */
  public User getUser(int id) throws NoSuchUserException {
    User user;
    if ((user = _users.get(id)) != null) return user;
    throw new NoSuchUserException(id);
  }

  /**
   * Gets a map of all the users
   * 
   * @return      a Map of all the users
   */
  protected Map<Integer, User> getAllUsers(){
    return _users;
  }

  /**
   * Gets current date
   * 
   * @return      Current date
   */
  public int getDate(){
    return _date.getCurrentDate();
  }

  /**
   * Adds to the current date the number of days to advance
   * 
   * @param nDays Number of days to advance the current date
   */
  public void advanceDate(int nDays) {
    _date.advanceDays(nDays);
  }

  /**
   * Gets a Work of associated to the given Work Id
   * 
   * @param id    the id of a Work
   * @return      the Work associated to that Id
   */
  public Work getWork(int id) throws NoSuchWorkException { //throw NoSuchUserWork
    Work work; 
    if ((work = _works.get(id)) != null) return work;
    throw new NoSuchWorkException(id);
  }

  /**
   * Gets the number of different Works in the library
   * 
   * @return      the number of Works
   */
  public int getNumberWorks() {
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
    Parser parser = new Parser(this);
    parser.parseFile(filename);
  }

  public void addNotification(User user, Notification notification){
    _notificationManager.registerNotificationObserver(new NotificationObserver(user, notification));
  }

  public void registerRequest(Request request) {
    User user = request.getUser();
    Work work = request.getWork();

    request.setDeadline(user.getUserBehavior().getDeadline(work.getNumberOfCopies()), getDate());

    _requests.add(request);
    _notificationManager.notifyObservers(new Requisicao(request.getWork()));

    user.addUserRequest(request);

    work.decrementCopiesAvaliable();
  }

  public int registerReturn(Request request) throws WorkNotBorrowedByUserException {
    User user = request.getUser();
    Work work = request.getWork();

    int deadline = user.removeUserRequest(request, getDate());

    work.incrementCopiesAvaliable();

    _requests.remove(request);
    _notificationManager.notifyObservers(new Devolucao(request.getWork()));

    return deadline;
  }

  public int checkRules(int userId, int workId) throws NoSuchUserException, NoSuchWorkException {
    int value;

    RulesWraper rulesWraper = new RulesWraper(getUser(userId), getWork(workId));    

    while((value = rulesWraper.checkRule()) == 0);

    return value;
  }
  
  public List<Request> getRequests() {
    return _requests;
  }
}
