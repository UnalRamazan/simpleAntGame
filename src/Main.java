import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        //input.csv dosyasındaki verileri tutmak için
        GameApplication moveNumber = new DoublyLinkedLists();
        GameApplication moveOperation = new DoublyLinkedLists();

        //input.csv dosyasından veri çekme
        final String fileName = "input.csv";
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                String[] arraySplit = line.split(",");

                moveOperation.addNode(arraySplit[0]);
                moveNumber.addNode(arraySplit[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Oyun haritası için
        GameApplication map = new DoublyLinkedLists();
        int height = 0, weight = 0, antHeight = 1, antWeight = 1;
        int value = 0;//hareket miktarını tutmak için

        Node walk = moveOperation.getHead();
        Node walkNumber = moveNumber.getHead();
        while (walk != null) {
            value = Integer.parseInt(walkNumber.getData());//value değer ataması yapar

            switch (walk.getData()) {
                case "move up":
                    if((value + antHeight) == height){
                        antHeight = height;
                    }
                    else if ((value + antHeight) > height) {
                        //antHeight = height - antHeight;
                        height = (value + antHeight);
                        antHeight = height;
                    }else{
                        antHeight += value;
                    }
                    break;
                case "move down":
                    if((value + (height - antHeight + 1)) == height){
                        antHeight = 1;
                    }
                    else if ((value + (height - antHeight + 1)) > height) {
                        height = (value + (height - antHeight) + 1);
                        antHeight = 1;
                    } else {
                        antHeight -= value;
                    }
                    break;
                case "move right":
                    if((value + antWeight) == weight){
                        antWeight = weight;
                    }else if ((value + antWeight) > weight) {
                        weight = (value + antWeight);
                        antWeight = weight;
                    }else{
                        antWeight += value;
                    }
                    break;
                case "move left":
                    if((value + (weight - antWeight) + 1) == weight){
                        antWeight = 1;
                    }
                    else if ((value + (weight - antWeight) + 1) > weight) {
                        weight = (value + (weight - antWeight) + 1);
                        antWeight = 1;
                    } else {
                        antWeight -= value;
                    }
                    break;
                default:
                    System.out.println("Warning...");
                    break;
            }
            walk = walk.getNext();
            walkNumber = walkNumber.getNext();
        }

        for (int i = 0; i < height * weight; i++) {
            if ((((height - (antHeight)) * weight) + antWeight) == (i+1)) {
                map.addNode("*");
            } else {
                map.addNode("X");
            }
        }

        //System.out.println(map.print(height, weight));
        Writer writer = new Writer(map.print(height, weight));
    }
}

