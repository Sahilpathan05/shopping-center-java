import java.util.Scanner;

class shoppingCenter {
public static final int m = 50;
public int[] itemCode = new int[m];
public float[] itemPrice = new float[m];
private int count;
private Scanner sc = new Scanner(System.in);
public void CNT() {
    count = 0;
}

public void getItem() {
    System.out.print("Enter item code: ");
    int newCode = sc.nextInt();

    for (int i = 0; i < count; i++) {
        if (itemCode[i] == newCode) {
            System.out.println("Duplicate item code. Please re-enter the code.");
            return;
        }
    }

    itemCode[count] = newCode;
    System.out.print("Enter item cost: ");
    itemPrice[count] = sc.nextFloat();
    count++;
}

public void displaySum() {
    float sum = 0;
    for (int i = 0; i < count; i++) {
        sum += itemPrice[i];
    }
    System.out.println("\n***************************** TOTAL AMOUNT *****************************");
    System.out.println("\n\tTotal Amount: " + sum);
}

public void remove() {
    System.out.print("\nEnter item code to remove: ");
    int a = sc.nextInt();
    boolean found = false;
    for (int i = 0; i < count; i++) {
        if (itemCode[i] == a) {
            itemPrice[i] = 0;
            System.out.println("Item removed successfully.");
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("Item code not found.");
    }
}

public void editPrice() {
    System.out.print("\nEnter item code to edit price: ");
    int a = sc.nextInt();
    boolean found = false;
    for (int i = 0; i < count; i++) {
        if (itemCode[i] == a) {
            System.out.println("Item code matched.");
            System.out.println("Previous Amount: " + itemPrice[i]);
            System.out.print("Re-enter new amount: ");
            itemPrice[i] = sc.nextFloat();
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("Item code does not exist.");
    }
}

public void clearCart() {
    for (int i = 0; i < count; i++) {
        itemPrice[i] = 0;
        itemCode[i] = 0;
    }
    System.out.println("\t\tAll items have been deleted successfully.");
}

public void displayItems() {
    System.out.println("\n\n\t\t\t*** Items in your Cart ***");
    for (int i = 0; i < count; i++) {
        if (itemCode[i] != 0) {
            System.out.println("\n\tItem Code: " + itemCode[i] + "\tItem Price: " + itemPrice[i]);
        }
    }
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("\t\t\t* WELCOME TO OUR SHOPPING CENTER *");

    ITEMS2 order = new ITEMS2();
    order.CNT();
    int x;

    try {
        do {
            System.out.println("\n\n\nYou can do the following; Enter the appropriate number:\n");
            System.out.println("1) Add an item");
            System.out.println("2) Display total value");
            System.out.println("3) Delete an item");
            System.out.println("4) Display all items");
            System.out.println("5) Edit price");
            System.out.println("6) Quit");
            System.out.println("7) Clear Cart");
            System.out.print("\n\nWhich option do you want:  ");
            x = sc.nextInt();

            switch (x) {
                case 1 -> order.getItem();
                case 2 -> order.displaySum();
                case 3 -> order.remove();
                case 4 -> order.displayItems();
                case 5 -> order.editPrice();
                case 6 -> System.out.println("\t\t\tThank you for coming!\n\t\t\tCome back soon!");
                case 7 -> order.clearCart();
                default -> System.out.println("Invalid option; please try again.\n");
            }
        } while (x != 6);
    } catch (Exception e) {
        System.out.println("\n\nPlease choose from the given options and enter the correct number.");
    }
}
