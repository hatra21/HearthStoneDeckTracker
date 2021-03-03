public class Driver {

    public static void main(String[] args) {
        //URLReader hearthstoneURLReader = new URLReader("https://api.hearthstonejson.com/v1/25770/enUS/cards.json");

        CardParser cp = new CardParser("https://api.hearthstonejson.com/v1/25770/enUS/cards.json");
        cp.sortLowestCostToHighestCost();
        //cp.selectionSort();
        cp.showMinions();
        HearthStoneCard att5 = cp.binarySearch(5);
        att5.display();

    }






}
