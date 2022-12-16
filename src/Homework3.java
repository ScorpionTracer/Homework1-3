import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Homework3 {

  public static void main(String[] args) {
    questsNumber();
    questsStr();
  }

  private static void questsStr() {
    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    Random random = new Random();
    var strChoose = words[random.nextInt(words.length)];
    Scanner scanner = new Scanner(System.in);
    System.out.println("Угадайте слово:");
    while (true) {
      var strInput = scanner.next();
      if (strChoose.equals(strInput)) {
        System.out.println("Вы выиграли");
        break;
      } else {
        StringBuilder strPrint = new StringBuilder();
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
  }

  public static void questsNumber() {
    gameQuestsNumber();

    while (true) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
      try {
        var choose = scanner.nextInt();
        if (choose == 1) {
          gameQuestsNumber();
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


  private static void gameQuestsNumber() {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    var numberGuess = random.nextInt(9);
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