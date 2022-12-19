import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Homework3 {
  public static Scanner scanner = new Scanner(System.in);
  public static Random random = new Random();

  public static void main(String[] args) {
    questsNumber();
    questsStr();
  }

  private static void questsStr() {
    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    var strChoose = words[random.nextInt(words.length)];
    System.out.println("Угадайте слово:");
    while (true) {
      var strInput = scanner.next();
      if (strChoose.equals(strInput)) {
        System.out.println("Вы выиграли");
        break;
      } else {
        var strPrint = new StringBuilder();
        for (var i = 0; i < strInput.length(); i++) {
          if (strInput.charAt(i) == strChoose.charAt(i)) {
            strPrint.append(strInput.charAt(i));
          } else {
            break;
          }
        }
        while (strPrint.length() < 15) {
          strPrint.append("#");
        }
        System.out.println(strPrint);
      }
    }
    scanner.close();
  }

  public static void questsNumber() {
    gameQuestsNumber(random.nextInt(9));
    while (true) {
      System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
      try {
        var choose = scanner.nextInt();
        if (choose == 1) {
          gameQuestsNumber(random.nextInt(9));
        } else if (choose == 0) {
          break;
        } else {
          System.out.println("Введен не правильный код. Повторить игру еще раз? 1 – да / 0 – нет ");
        }
      } catch (InputMismatchException inputMismatchException) {
        System.out.println("Введите числовое значение.");
      }
    }
  }

  private static void gameQuestsNumber(int numberGuess) {
    var numberInput = 0;
    for (var i = 1; i <= 3; i++) {
      System.out.println("Угадайте число от 0 до 9:");
      numberInput = scanner.nextInt();
      if (numberInput > numberGuess) {
        System.out.printf("Загаданное число меньше %s\n", numberInput);
      } else if (numberInput < numberGuess) {
        System.out.printf("Загаданное число больше %s\n", numberInput);
      } else {
        System.out.printf("Вы угадали число %s\n", numberInput);
        break;
      }
    }
  }
}