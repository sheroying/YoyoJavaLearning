package com.yoyo.test.designpatterns.behavior.based.observer;

import java.awt.*;
import java.awt.event.*;

public class ObserverPattern {

    public static void main(String[] args) throws InterruptedException {
        Frame frame = new Frame();
        frame.addWindowListener(new FrameCloseLinstenser());
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setTitle("test");

        Button btnA = new Button("print");
        btnA.setSize(100,50);
        btnA.setBackground(Color.BLUE);
        ActionListener al = new OwnActionListener();
        btnA.addActionListener(al);
        frame.add(btnA);
        System.out.println("end of the test");
        while (true){
            System.out.println("bbb");
            Thread.sleep(3000l);
            System.out.println("thread name main " + Thread.currentThread().getName());
        }
    }
     public static class OwnActionListener implements ActionListener {
        public OwnActionListener() {
            System.out.println("load OwnActionListener");
        }

         @Override
         public void actionPerformed(ActionEvent e) {
             System.out.println("gan ying dao ren ti");
             System.out.println("thread name: btn " + Thread.currentThread().getName());
         }
     }

     public static class FrameCloseLinstenser implements WindowListener {

         @Override
         public void windowOpened(WindowEvent e) {

         }

         //         @Override
         public void windowClosing(WindowEvent e) {
//             super.windowClosed(e);
             System.out.println("thread name: Frame " + Thread.currentThread().getName());
             System.exit(0);

         }

         @Override
         public void windowClosed(WindowEvent e) {

         }

         @Override
         public void windowIconified(WindowEvent e) {

         }

         @Override
         public void windowDeiconified(WindowEvent e) {

         }

         @Override
         public void windowActivated(WindowEvent e) {

         }

         @Override
         public void windowDeactivated(WindowEvent e) {

         }
     }
}
