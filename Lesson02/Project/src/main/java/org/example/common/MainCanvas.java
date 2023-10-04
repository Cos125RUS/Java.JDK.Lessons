package org.example.common;

import org.example.circle.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainCanvas extends JPanel {
    private static Random rnd = new Random();
    private final CanvasRepaintListener controller;
    private long lastFrameTime;
    public MainCanvas(CanvasRepaintListener controller) {
        this.controller = controller;
        this.lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        float deltaTime = (System.nanoTime() - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = System.nanoTime();
        repaint();
    }

    public int getLeft() {return 0; }
    public int getRight() {return getWidth() - 1; }
    public int getTop() {return 0; }
    public int getBottom() {return getHeight() - 1; }
    public void setBackgroundColor() {
        setBackground(new Color(rnd.nextInt()));
    }
}
