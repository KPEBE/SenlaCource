package hotel.views;

import hotel.config.InputUtils;
import java.util.HashMap;

public class View {
    protected HashMap<Integer, Runnable> actions = new HashMap();

    protected void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    protected void clearActions() { actions.clear(); }
    protected void clear() { clearActions(); clearScreen(); }

    protected void print(String text) {
        System.out.println(text);
    }

    protected void gap() {
        System.out.println("");
    }

    protected void addAction(int index, Runnable action) { actions.put(index, action); }

    protected void runAction() {
        int action = InputUtils.readInt("Choose action: ");
        Runnable nav = actions.get(action);
        if (nav == null) return;
        nav.run();
    }
}