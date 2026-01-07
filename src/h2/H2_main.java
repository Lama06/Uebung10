package h2;

public class H2_main {
    public static void main(String[] args) {
        char[][] beispiel1 = {
                {'U', 'R', 'L', 'L', 'D'},
                {'L', 'R', 'L', 'L', 'D'},
                {'U', 'L', 'L', 'L', 'R'},
                {'D', 'R', 'U', 'L', 'L'},
                {'U', 'R', 'L', 'D', 'D'}
        };
        Spielbrett b = new Spielbrett(5);
        Feld[][] b2 = new Feld[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                b2[i][j] = new Feld(false, beispiel1[i][j]);
            }
        }
        b.setBrett(b2);
        Spielstein s = new Spielstein(b, 3, 2);
        for (int i = 0; i < 10; i++) {
            //System.out.println(s.getCurrentRow() + " " + s.getCurrentCol());
            s.go(1);
        }
    }
}