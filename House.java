import java.util.ArrayList;

public class House extends Building implements HouseRequirements {
  
  // Attributes
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;

  /**
   * 
   * @param name string house name
   * @param address strin ghouse address
   * @param nFloors int number of floors in house
   * @param hasDiningRoom boolean if the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * @return boolean of whether the house has a dining room
   */

  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  /**
   * @return int number of residents in the house
   */
  public int nResidents() {
    return residents.size();
  }

  /**
   * @param student to move in to the house
   * @throws exception if student has already been added to the house
   */
  public void moveIn(Student s) {
    if (isResident(s)) {
      throw new RuntimeException("Student already lives here!");
    } else {
      residents.add(s);
    }
    
  }
  
  /**
   * @param student to remove from the house
   * @return student that was removed
   * @throws exception if student is not already in the house
   */
  public Student moveOut(Student s) {
    if (!isResident(s)) {
      throw new RuntimeException("Student not found");
    } else {
      residents.remove(s);
      return s;
    }
  }

  /**
   * @param student to check if they are a resident
   * @return boolean if the student is a resident or not
   */
  public boolean isResident(Student s) {
    if (residents.contains(s)) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    House myHouse = new House("home", "6047 28th", 3, true);
    System.out.println(myHouse.hasDiningRoom);
    Student kate = new Student("Kate", "987055", 2028);
    Student naomi = new Student("Kate", "987056", 2028);
    myHouse.moveIn(kate);
    // myHouse.moveIn(kate);
    System.out.println(myHouse.isResident(kate));
    // System.out.println(myHouse.moveOut(naomi));
    System.out.println(myHouse.isResident(kate));
  }

}