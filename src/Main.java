import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<String> myArrList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean done = false;
        do
        {
            displayList(myArrList);
            menu();
            String menuChoice = SafeInput.getRegExString(in, "Enter your menu choice", "[AaDdIiPpQq]");
            menuChoice = menuChoice.toUpperCase();
            switch(menuChoice)
            {
                case "A":
                    System.out.print("Enter the item you would like to add to the end of the list: ");
                    String newItem = in.next();
                    myArrList.add(newItem);
                    in.nextLine();
                    break;
                case "D":
                    int delNum = SafeInput.getRangedInt(in, "Enter the number of the item you would like to delete from the list", 1, myArrList.size());
                    delNum = delNum - 1;
                    myArrList.remove(delNum);
                    break;
                case "I":
                    int insNum = SafeInput.getRangedInt(in, "Enter the number of the item you would like to replace", 1, myArrList.size());
                    System.out.print("Enter the item you would like to replace [" + insNum + "] with: ");
                    String insItem = in.next();
                    insNum = insNum - 1;
                    myArrList.set(insNum, insItem);
                    in.nextLine();
                    break;
                case "P":
                    break;
                case "Q":
                    boolean confirmYN = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
                    if(confirmYN)
                    {
                        done = true;
                    }
                    break;
            }
        }while(!done);

    }
    private static void displayList(ArrayList<String> myArrList)
    {
        for(int x = 0; x < myArrList.size(); x++)
        {
            int itemNum = x + 1;
            System.out.println("[" + itemNum + "] " + myArrList.get(x));
        }
    }
    private static void menu()
    {
        System.out.println("A - Add item  D - Delete item  I - Insert item  P - Print list  Q - Quit");
        System.out.println("------------------------------------------------------------------------");
    }
}