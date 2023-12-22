import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys = new ArrayList<>();
    private List<Toy> prizeList = new ArrayList<>();
    private static final String WINNERS_FILE = "winners.txt";

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateWeight(int id, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    public void drawPrize() {
        Random random = new Random();
        double totalWeight = 0.0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }
        double randomNumber = random.nextDouble() * totalWeight;

        for (Toy toy : toys) {
            randomNumber -= toy.getWeight();
            if (randomNumber <= 0) {
                prizeList.add(toy);
                toy.decreaseQuantity();
                break;
            }
        }
    }

    public void awardPrize() {
        if (!prizeList.isEmpty()) {
            Toy prizeToy = prizeList.remove(0);
            try (FileWriter writer = new FileWriter(WINNERS_FILE, true)) {
                writer.write(prizeToy.getName() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
