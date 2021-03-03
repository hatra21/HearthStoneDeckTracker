import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.ArrayList;

public class CardParser {
    private String urlString;
    private ArrayList<HearthStoneCard> theMinions;

    public CardParser(String urlString) {
        //initial fields
        this.urlString = urlString;
        theMinions = new ArrayList<HearthStoneCard>();

        URLReader hearthstoneURLReader = new URLReader(this.urlString);
        Object obj = JSONValue.parse(hearthstoneURLReader.getTheURLContents());

        if (obj instanceof JSONArray) {
            //I am only in here if obj IS a JSONArray
            JSONArray array = (JSONArray) obj;

            for (int i = 0; i < array.size(); i++) {
                JSONObject cardData = (JSONObject) array.get(i);
                if (cardData.containsKey("cost") && cardData.containsKey("name")) {
                    if (cardData.containsKey("type") && cardData.get("type").equals("MINION")) {
                        //I am only here is this is a minion card!!!
                        //System.out.println(cardData.keySet().toString());
                        String name = (String) cardData.get("name");
                        int cost = Integer.parseInt(cardData.get("cost").toString());
                        int attack = Integer.parseInt(cardData.get("attack").toString());
                        int health = Integer.parseInt(cardData.get("health").toString());
                        HearthStoneCard temp = new HearthStoneCard(name, cost, attack, health);
                        theMinions.add(temp);
                    }
                }

            }
        }
    }

    public void showMinions() {
        for (int i = 0; i < this.theMinions.size(); i++) {
            this.theMinions.get(i).display();
        }
    }

    public void sortLowestCostToHighestCost() {
        //this methods job is to take our ArrayList of minions and re-arrange it so that
        //it is in the order of cards with the lowest cost first, and cards with the highest
        //cost last.
        //Note: this.theMinions.get(3).getCost() will give you the cost of card #3
        //Note: this.theMinions.remove(3) will remove the card that used to be at bucket 3
        //you will need to cobble together your own algorithm for getting this arraylist sorted
        for (int i = 0; i < this.theMinions.size() - 1; i++) {
            for (int j = 0; j < this.theMinions.size() - 1 - i; j++) {
                if (this.theMinions.get(j).getCost() > this.theMinions.get(j + 1).getCost()) {
                    HearthStoneCard temp = this.theMinions.get(j);
                    this.theMinions.set(j, theMinions.get(j + 1));
                    this.theMinions.set(j + 1, temp);

                }
            }


        }
    }

    public void selectionSort() {
        for (int j=0; j < this.theMinions.size() - 1; j++) {
            int maxIndex = j;

            for (int i = j+1; i < this.theMinions.size(); i++) {
                if (theMinions.get(i).getCost() > theMinions.get(maxIndex).getCost()) {
                    maxIndex = i;
                }
            }

            if (maxIndex != j) {
                this.theMinions.set(j, theMinions.get(maxIndex));
            }
        }
    }

    public HearthStoneCard binarySearch(int target) {
        int left = 0;
        int right = theMinions.size() - 1;

        while (left <= right) {
            int mid = (left+right) / 2;
            if (target < theMinions.get(mid).getAttack()) {
                right = mid - 1;
            }
            else if (target > theMinions.get(mid).getAttack()) {
                left = mid + 1;
            }
            else {
                return theMinions.get(mid);
            }
        }
        return theMinions.get(0);
    }
}
