package org.example.bricks;

import org.example.common.Background;
import org.example.common.CanvasRepaintListener;
import org.example.common.Interactable;
import org.example.common.MainCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame implements CanvasRepaintListener {
    private static final int POS_X = 700;
    private static final int POS_Y = 200;
    private static final int WINDOWS_WIDTH = 800;
    private static final int WINDOWS_HEIGHT = 600;
    private final Interactable[] interactables = new Interactable[11];

    public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOWS_WIDTH, WINDOWS_HEIGHT);
        setTitle("Bricks");
        for (int i = 0; i < interactables.length - 1; i++) {
            interactables[i] = new Brick();
        }
        interactables[10] = new Background();
        MainCanvas canvas = new MainCanvas(this);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }
        });
        add(canvas);

        setVisible(true);
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas,float deltaTime) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].update(canvas, deltaTime);
        }
    }
    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].render(canvas, g);
        }
    }

}
