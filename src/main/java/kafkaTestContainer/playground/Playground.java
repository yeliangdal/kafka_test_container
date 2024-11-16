package kafkaTestContainer.playground;


public class Playground {
    void playground() {
        var num = 10;
        switch (num) {
            case 10:
                System.out.println("value is" + num);
                break;
            default:
                throw new AssertionError();
        }
    }
}
