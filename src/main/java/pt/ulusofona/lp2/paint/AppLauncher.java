package pt.ulusofona.lp2.paint;

import pt.ulusofona.lp2.paint.provided.Screen;

import javax.swing.*;
import java.awt.*;

public class AppLauncher {

    static final int WIDTH = 800;  // largura da área pintável
    static final int HEIGHT = 600;  // altura da área pintável

    static int x, y;  // coordenadas do Ponto

    static void createAndShowGUI() {

        // inicializa a janela do Paint
        JFrame frame = new JFrame("Paint (Episódio 1)");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setLayout(new BorderLayout());

        // inicializa a área "pintável" do Paint
        Screen screen = new Screen(WIDTH, HEIGHT);
        if (WIDTH > 800){
            screen.reset();
        }
        if (HEIGHT > 600 || HEIGHT < 0) {
            screen.reset();
        }
        screen.reset();
        frame.getContentPane().add(screen, BorderLayout.CENTER);

        // inicializa a barra de ferramentas
        JToolBar barraFerramentas = criaBarraFerramentas(frame);
        JButton moveEsquerdaBtn = new JButton(getIcon("icon_left.png"));
        barraFerramentas.add(moveEsquerdaBtn);
        JButton moveDireitaBtn = new JButton(getIcon("icon_right.png"));
        barraFerramentas.add(moveDireitaBtn);
        JButton moveCimaBtn = new JButton(getIcon("icon_up.png"));
        barraFerramentas.add(moveCimaBtn);
        JButton moveBaixoBtn = new JButton(getIcon("icon_down.png"));
        barraFerramentas.add(moveBaixoBtn);

        // mostra no écran o Paint
        frame.pack();
        frame.setVisible(true);

        // obtém as coordenadas iniciais do início da linha, de forma a ficarem no meio do écran;
        x = WIDTH / 2;
        y = HEIGHT / 2;

        // desenha o pixel nessa posição usando a classe auxiliar Screen
        screen.drawPixel(x, y, Color.RED);

        // define o que acontece quando se carrega no botão "moveEsquerdaBtn"
        moveEsquerdaBtn.addActionListener(event -> {
            x-= 1;
            screen.drawPixel(x, y, Color.red);
        });

        // define o que acontece quando se carrega no botão "moveDireitaBtn""
        moveDireitaBtn.addActionListener(event -> {
            x+= 2;
            screen.drawPixel(x, y, Color.red);
        });

        // define o que acontece quando se carrega no botão "moveCimaBtn"
        moveCimaBtn.addActionListener(event -> {
            y-= 1;
            screen.drawPixel(x, y, Color.green);
        });


        // define o que acontece quando se carrega no botão "moveBaixoBtn"
        moveBaixoBtn.addActionListener(event -> {
            y+= 1;
            screen.drawPixel(x, y, Color.green);
        });
    }

    static JToolBar criaBarraFerramentas(JFrame frame) {
        JToolBar toolBar = new JToolBar();
        frame.getContentPane().add(toolBar, BorderLayout.WEST);
        toolBar.setLayout(new GridLayout(10, 1, 0, 5));
        toolBar.setFloatable(false);
        toolBar.setBorderPainted(true);
        toolBar.setMargin(new Insets(10, 5, 10, 5));
        return toolBar;
    }

    static ImageIcon getIcon(String iconName) {
        return new ImageIcon(AppLauncher.class.getResource("/" +
                iconName));
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
