import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Driver {

    public static void main(String[] args) {

        URLReader hearthstoneURLReader= new URLReader("https://api.hearthstonejson.com/v1/25770/enUS/cards.json");
        //hearthstoneURLReader.display();

        Object obj = JSONValue.parse(hearthstoneURLReader.getTheURLContents());
        HearthStoneCard[] theMinions = new HearthStoneCard[1924];


        if (obj instanceof JSONArray) {
            JSONArray array = (JSONArray) obj;
            int count = 0;

            for (int i=0; i< theMinions.length; i++) {
                JSONObject cardData =(JSONObject) array.get(i);
                //System.out.println(cardData.get("name"));
                if (cardData.containsKey("cost") && cardData.containsKey("name")) {
                    if (cardData.containsKey("type") && cardData.get("type").equals("MINION")) {
                        //theMinions[i].setName((String) cardData.get("name"));
                        //theMinions[i] = new HearthStoneCard(cardData.get("name"), cardData.get("cost"), cardData.get("attack"), cardData.get("defense"));

                        String name_converted = cardData.get("name").toString();
                        int cost_converted = Integer.parseInt(cardData.get("cost").toString());
                        int att_converted = Integer.parseInt(cardData.get("attack").toString());
                        int def_converted = Integer.parseInt(cardData.get("health").toString());
                        theMinions[i] = new HearthStoneCard(name_converted,cost_converted,att_converted,def_converted);


                        //System.out.println(theMinions[i].toString());
//                        System.out.println();

//
//                        System.out.println(cardData.get("name"));
//                        System.out.println(cardData.get("type"));
//                        System.out.println(cardData.get("cost"));
//                        System.out.println(cardData.get("attack"));
//                        System.out.println(cardData.get("defense"));
//                        System.out.println(cardData.get("health"));
                        count++;

                    }
                }


            }

            System.out.println(count);


        }




    }


}
