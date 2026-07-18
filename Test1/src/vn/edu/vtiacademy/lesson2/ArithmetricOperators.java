package vn.edu.vtiacademy.lesson2;

import java.util.Scanner;

public class ArithmetricOperators{

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); //Create a Scanner object to read input from console
    System.out.println("Enter the first number: ");
    int a = scanner.nextInt(); //Read an integer from consolde and store it in variable a
    System.out.println("Enter the second number: ");
    int b = scanner.nextInt(); //Read an integer frome console and store it in variable v

    // Phép cộng (Addition)
    int sum = a + b;
    System.out.println("a + b =  " + a + " + " + b + " = " + sum);

    // Phép trừ  (Subtraction)
    int sub = a - b;
    System.out.println(" a - b = " + a + " - " + b + " = "+ sub);

    // Phép nhân (Multiplication)
    int mul = a * b;
    System.out.println("a * b = " + a + " * " + b + " = " + mul);

    // Phép chia (Division)
    int div = a/b;
    System.out.println(" a / b = " + a + " / " + b + " = " + div);

    // Phép chia lấy dư (Modulus)
    int remainder = a % b;
    System.out.println(" a % b = " + a + " % " + b + " = "+ remainder);

    // Toán tử tăng/giảm
    a++; // Tăng a lên 1 đơn vị
    System.out.println("a sau khi tăng: " + a);

    b--; // Giảm b xuống 1 đơn vị
    System.out.println("b sau khi giảm: " + b);

    System.out.println("Before incrementing a = " + a);
    System.out.println("After incrementing a = " + a++); // Increment a by 1 => a = a + 1
    System.out.println("Current value  of a = " + a);
    System.out.println("Before decrementing a = " + a);
    System.out.println("After  incrementing a = " + ++a); // Increment a by 1 => a = a + 1
    System.out.println("Current value  of a = " + a);

    System.out.println("Before decrementing b = " + b);
    System.out.println("After decrementing b = " + b--); // Decrement b by 1 => b = b - 1
    System.out.println("Current value of b = " + b);
    System.out.println("Before decrementing b = " + b);
    System.out.println("After decrementing b = " + --b); // Decrement b by 1 => b = b - 1
    System.out.println("Current value of b = " + b);
  }

}
// a++ > chỉ hiển thị kết quả ở câu lệnh sau, chứ ở câu lệnh a++ thì nó chưa phản ánh
// ++a thì nó phản ánh ngay chỗ dòng lệnh đó.
// dấu ở trước: phản ánh ngay giá trị mới nhất vào biến
// dấu ở sau: phải thêm 1 lần câu lệnh nữa thì mới thấy được giá trị mới nhất ở biến đó