import java.util.Hashtable;
import java.util.Set;
import java.util.Map.Entry;

public class Library extends Building implements LibraryRequirements {

  //Attributes
  private Hashtable<String, Boolean> collection;

  /**
   * @param name string name of library
   * @param address string address of library
   * @param nFloors int number of floors
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * @param title string title of a book to add to collection (can repeat titles to have several books)
   */
  public void addTitle(String title) {
    collection.put(title, true);
  }

  /**
   * @param title string title to remove from collection
   * @return title that was removed
   * @throws exception if the title is not in the collection
   */
  public String removeTitle(String title) {
    if (!containsTitle(title)) {
      throw new RuntimeException("Title not found");
    } else {
      collection.remove(title);
      return title;
    }
  }

  /**
   * @param title string title to check out
   * @throws exception if the title is not found in the collection
   * @throws exception if the title is not available
   */
  public void checkOut(String title) {
    if (!containsTitle(title)) {
      throw new RuntimeException("Title not found");
    } if (!isAvailable(title)) {
        throw new RuntimeException("Title not available");
    } else {
      collection.replace(title, false);
    }
  }

  /**
   * @param title to return 
   * @throws exception if title is not found in the collection
   * @throws exception if title is already available so it can't be returned
   */
  public void returnBook(String title) {
    if (!containsTitle(title)) {
      throw new RuntimeException("Title not found");
    } if(isAvailable(title)) {
      throw new RuntimeException("Title is not checked out");
    } else {
      collection.replace(title, true);
    }
  }

  /**
   * @param title string title
   * @returns boolean of whether the title is in the collection
   */
  public boolean containsTitle(String title) {
    if (collection.contains(title)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * @param title string title
   * @return boolean of whether the book is available
   */
  public boolean isAvailable(String title) {
    if (collection.get(title) == true) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * prints every book in the collection and its availability
   */
  public void printCollection() {
    Set<Entry<String, Boolean> > entrySet = collection.entrySet();
    for (Entry<String, Boolean> entry : entrySet) {
      String status;
      if (entry.getValue().equals(true)) {
        status = "Currently Available";
      } else {
        status = "Currently Checked Out";
      }
      System.out.println("Title: " + entry.getKey() + " ~ Availability: " + status);
    }
  }
  
  public static void main(String[] args) {
    Library myLibrary = new Library("Nielson", "99 Green St", 4);
    myLibrary.addTitle("Little Women");
    myLibrary.checkOut("Little Women");
    myLibrary.printCollection();
    myLibrary.returnBook("Little Women");
    myLibrary.printCollection();
    myLibrary.checkOut("Pride & Prejudice");
  }
  
  }