package org.example.view;
import lombok.Setter;

import org.example.controller.Controller;
import org.example.model.factory.ShapeState;

import javax.swing.*;
public class MenuCreator {

    private static MenuCreator instanse;
    @Setter
    private ShapeState shapeState;
    @Setter
    private Controller controller;

    private MenuCreator() {

    }

    public static MenuCreator getInstanse() {
        synchronized (MenuCreator.class) {
            if (instanse == null) {
                instanse = new MenuCreator();
            }
            return instanse;
        }
    }
    public JMenuBar createMenu() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu shapeMenu = createShapeMenu();
        return jMenuBar;
    }
    private JMenu createShapeMenu() {
        ButtonGroup group = new ButtonGroup();
        JMenu shapeMenu = new JMenu("фигура");
        return null;
    }
}
