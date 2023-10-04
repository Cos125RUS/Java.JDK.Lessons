package org.example.circle;

import org.example.common.Background;
import org.example.common.CanvasRepaintListener;
import org.example.common.Interactable;
import org.example.common.MainCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainWindow extends JFrame implements CanvasRepaintListener, MouseListener, Thread.UncaughtExceptionHandler {
    private static final int POS_X = 50;
    private static final int POS_Y = 100;
    private static final int WINDOWS_WIDTH = 800;
    private static final int WINDOWS_HEIGHT = 600;
    private static final int MAX_COUNT = 11;
    private int count;
    private final Interactable[] interactables = new Interactable[MAX_COUNT];

    public MainWindow() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOWS_WIDTH, WINDOWS_HEIGHT);
        setTitle("Circles");
        count = 0;
        interactables[count++] = new Background();
        for (int i = count; i < MAX_COUNT; i++) {
            interactables[i] = new Ball();
        }
        MainCanvas canvas = new MainCanvas(this);
        canvas.addMouseListener(this);
        add(canvas);

        setVisible(true);
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < count; i++) {
            interactables[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < count; i++) {
            interactables[i].render(canvas, g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        System.out.println("Clicked");
        if (e.getButton() == 1) {
            if (count < MAX_COUNT)
                count++;
            else
                throw new RuntimeException("Лимит шаров вашего шарового фонда: " + MAX_COUNT);
        } else if (e.getButton() == 3) {
            if (count > 1)
                count--;
            else
                throw new RuntimeException("Нет больше шаров. Куда ты тыкаешь?!");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        JOptionPane.showMessageDialog(this, e.getMessage(),
                "Exception!", JOptionPane.ERROR_MESSAGE);
    }
}
