
public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        toyStore.addToy(new Toy(1, "Машинка", 10, 20.0));
        toyStore.addToy(new Toy(2, "Мяч", 15, 30.0));
        toyStore.addToy(new Toy(3, "Lego", 5, 15.0));

        toyStore.updateWeight(1, 10.0);
        toyStore.updateWeight(2, 15.0);
        toyStore.updateWeight(3, 20.0);

        toyStore.drawPrize();

        toyStore.awardPrize();
    }
}