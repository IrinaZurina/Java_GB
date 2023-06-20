import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        LotteryInterface.addNewToy("toys_in_stock.txt", Toy.getNewToyInfo());

        LotteryInterface.changeToyWeight();

        Toy.showAvailableToys("toys_in_stock.txt");

        LotteryInterface.getRandomToy();

        LotteryInterface.deliverToy();


    }
}
