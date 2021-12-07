import domain.Menu;
import domain.PosMachine;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        PosMachine pos = new PosMachine();
        pos.start();
    }
}
