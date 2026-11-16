package org.example.controller;

import org.example.controller.action.ActionDraw;
import org.example.controller.action.AppAction;
import org.example.model.Model;
import org.example.view.MyFrame;
import org.example.view.MyPanel;

import java.awt.*;

// TODO: Сделать singleton класс
public class Controller {

    private static Controller instance;
    private final Model model;
    private final MyFrame frame;
    private final MyPanel panel;
    private AppAction action;

    private Controller() {
        model = new Model();
        action = new ActionDraw(model);

        panel = new MyPanel(this);
        // TODO: Поменять наблюдатель на более современную реализацию
        model.addObserver(panel);

        frame = new MyFrame();
        frame.setPanel(panel);
        panel.revalidate();
        panel.repaint();
    }

    public static synchronized Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    public void mousePressed(Point point){
        action.mousePressed(point);
    }
    public void mouseDragged(Point point){
        action.mouseDragged(point);
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }
    public void switchActionDraw(){
        action = new ActionDraw(model);
    }
}
