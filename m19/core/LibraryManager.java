package m19.core;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;


import m19.core.exception.MissingFileAssociationException;
import pt.tecnico.po.ui.Display;
import m19.core.exception.BadEntrySpecificationException;
import m19.core.exception.ImportFileException;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.Comparator;
// FIXME import other system types
// FIXME import other project (core) types


/**
 * The façade class.
 */
public class LibraryManager {

  private Library _library;  // FIXME initialize this attribute

  // FIXME define other attributes
  private String _filename;

  // FIXME define contructor(s)
  public LibraryManager(){
    _library = new Library();
    _filename = null;
  }
  // FIXME define methods
  private void saveSerialize() throws MissingFileAssociationException, IOException{
    if (_filename == null) throw new MissingFileAssociationException();

    FileOutputStream fileOutputStream = new FileOutputStream(_filename);
		BufferedOutputStream bufferedInputStream = new BufferedOutputStream(fileOutputStream);
    ObjectOutputStream out = new ObjectOutputStream(bufferedInputStream);
    out.writeObject(_library);
    out.close();
  }
  /**
   * Serialize the persistent state of this application.
   * 
   * @throws MissingFileAssociationException if the name of the file to store the persistent
   *         state has not been set yet.
   * @throws IOException if some error happen during the serialization of the persistent state

   */
  public void save() throws MissingFileAssociationException, IOException {
    // FIXME implement method 
    saveSerialize();
  }

  /**
   * Serialize the persistent state of this application into the specified file.
   * 
   * @param filename the name of the target file
   *
   * @throws MissingFileAssociationException if the name of the file to store the persistent
   *         is not a valid one.
   * @throws IOException if some error happen during the serialization of the persistent state
   */
  public void saveAs(String filename) throws MissingFileAssociationException, IOException {
    // FIXME implement method 
    setFile(filename);
    saveSerialize();
  }

  public void setFile(String filename){
    _filename = filename;
  }

  /**
   * Recover the previously serialized persitent state of this application.
   * 
   * @param filename the name of the file containing the perssitente state to recover
   *
   * @throws IOException if there is a reading error while processing the file
   * @throws FileNotFoundException if the file does not exist
   * @throws ClassNotFoundException 
   */
  public void load(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
    // FIXME implement method
    File file = new File(filename);
    if (!file.exists()) throw new FileNotFoundException();

    setFile(filename);

    FileInputStream fileInputStream = new FileInputStream(filename);
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
		Object object = objectInputStream.readObject();
    objectInputStream.close();
    _library = (Library) object;
  }

  /**
   * Set the state of this application from a textual representation stored into a file.
   * 
   * @param datafile the filename of the file with the textual represntation of the state of this application.
   * @throws ImportFileException if it happens some error during the parsing of the textual representation.
   */
  public void importFile(String datafile) throws ImportFileException {
    try {
      _library.importFile(datafile);
    } catch (IOException | BadEntrySpecificationException e) {
      throw new ImportFileException(e);
    }
  }

  //Metodos Data
  public int getCurrentDate() {
    return _library.getDate();
  }

  public void advanceDays(int nDays) {
    _library.advanceDate(nDays);
  }

  public boolean hasAssociatedFile(){
    return _filename != null;
  }

  //Menu Gestao de Utentes Metodos
  public int registerUser(String name, String email) throws BadEntrySpecificationException {
    if (!name.matches(".*[a-zA-Z]+.*") || !email.matches(".*[a-zA-Z]+.*"))
      throw new BadEntrySpecificationException("Valid args");
    User user = new User(name, email);
    return _library.addUser(user);
  }

  public String printUser(int id) throws BadEntrySpecificationException {
    if (_library.getUser(id) == null) {
      throw new BadEntrySpecificationException("Id not found");
    }
    return _library.getUser(id).toString();
  }

  public String getUsers() {
    String output = "";
    Map <Integer, User> sorted = new TreeMap<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer key1, Integer key2) {
        User user1 = _library.getUser(key1);
        User user2 = _library.getUser(key2);
        int compare = user1.getName().compareTo(user2.getName());
        if (compare == 0)
          if (key1 > key2)
            return 1;
          else
            return -1;
        else
          return compare;
      }
    });
    sorted.putAll(_library.getAllUsers());
    for (Map.Entry<Integer, User> entry : sorted.entrySet())
      output += _library.getUser(entry.getKey()).toString() + "\n";
    return output;
  }  

  //Menu Gestao de Obras Metodos
  public String printWork(int id) throws BadEntrySpecificationException{
    if (id > _library.getNumberWorks()) 
      throw new BadEntrySpecificationException("Id not found");
    return _library.getWork(id).toString();
  }

  public String printAllWorks(){
    int i;
    String output = "";
    int numberWorks = _library.getNumberWorks();
    for (i = 0; i <= numberWorks; i++){
      output += _library.getWork(i).toString() + "\n";
    }
    return output;
  }

  public String printMatchingWorks(String searchTerm){
    int i;
    String output = "";
    Work aux_work;
    int numberWorks = _library.getNumberWorks();
    for(i = 0; i < numberWorks; i++){
      aux_work = _library.getWork(i);
      if (aux_work.searchTerm().toLowerCase().contains(searchTerm.toLowerCase())){
        output += aux_work.toString() + "\n"; 
      }
    }
    return output;
  }
}
