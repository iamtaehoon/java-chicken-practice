package pos;

import pos.domain.PosMachine;

public class Application {
    public static void main(String[] args) {
        PosMachine pos = new PosMachine();
        pos.start();
    }
}
