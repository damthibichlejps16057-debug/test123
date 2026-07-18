package vn.edu.vtiacademy.lesson1;

public class variables {

  public static void main(String[] args) {
    //khai báo biến
    int age = 20;
    String name = "John Doe";
    double height = 1.75;
    // một kiểu khai báo biến khác, ít dùng hơn, nhưng vẫn có thể sử dụng được
    int heightInCm;
    heightInCm = 175;
    boolean isStudent = true;
    char character = 'C';

    // In ra giá trị của các biến
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Height: " + height);
    System.out.println("Is Student: " + isStudent);
    for (int i = 65; i < 100; i++) {
      System.out.println("character = " + (char) i);
    }
    System.out.println("Character: " + character);

    age = 35;
    character = 70;
    System.out.println("Updated Age: " + age);
  }
}
// Tổ hợp phím Ctrl+ALt+Shift+L để mở pop-up làm code được format đẹp

// Ctrl+/ để đóng/ mở cmt

//Ctrl +C, Ctrl+V: copy/ paste code
//nếu là trường hợp dùng MacOS thì Ctrl thay bằng CMD

// Nếu 1 con ng (Person) = class
// Vậy trường = firstname, last name, email,...
// Trong class sẽ có các phương thức (HÀNH VI) mà đối tượng có thể sử dụng: Run (chạy với tốc độ x m/s), walk,...