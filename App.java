import board.Board;
import game.Game;
public class App {
    public static void main(String[] args) throws Exception {
        Board bd = new Board(5);
        Game gm = new Game(bd);
        gm.play();

    }
}
