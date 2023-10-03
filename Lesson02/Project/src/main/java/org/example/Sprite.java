package org.example;

import java.awt.*;

public class Sprite {
    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHeight;

    protected float getLeft() { return x - halfWidth; }
    protected void selfLeft(float left) {x = left + halfWidth; }
    protected float getRight() { return x + halfWidth; }
    protected void selfRight(float right) {x = right - halfWidth; }
    protected float getTop() { return y - halfHeight; }
    protected void selfTop(float top) {y = top + halfHeight; }
    protected float getBottom() { return y + halfHeight; }
    protected void selfBottom(float bottom) {y = bottom - halfHeight; }

    protected float getWidth() { return 2f*halfWidth;}
    protected float getHeight() { return 2f*halfHeight;}

    void update(MainCanvas canvas, float deltaTime) {}
    void render(MainCanvas canvas, Graphics g) {}
}
