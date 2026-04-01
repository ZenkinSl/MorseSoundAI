package com.BMPProgramm;

import javax.swing.*;
import java.awt.*;

public class Main {
        public static void main(String[] args) {

            JFrame frame = new JFrame("Morse App");

            // размер = половина экрана
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            int width = screen.width / 2;
            int height = screen.height / 2;

            frame.setSize(width, height);
            frame.setLocationRelativeTo(null); // центр

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTextField input = new JTextField();

            JButton playBtn = new JButton("Проиграть");
            JButton saveBtn = new JButton("Сохранить");

            frame.setLayout(new BorderLayout());

            frame.add(new JLabel("Введите текст:"), BorderLayout.NORTH);
            frame.add(input, BorderLayout.CENTER);

            JPanel panel = new JPanel();
            panel.add(playBtn);
            panel.add(saveBtn);

            frame.add(panel, BorderLayout.SOUTH);

            playBtn.addActionListener(e -> {
                String morse = MorseConverter.toMorse(input.getText());
                SoundPlayer.playMorse(morse);
            });

            saveBtn.addActionListener(e -> {
                String name = JOptionPane.showInputDialog("Имя файла:");

                if (name != null && !name.isEmpty()) {
                    String morse = MorseConverter.toMorse(input.getText());
                    WavGenerator.save(morse, name);

                    JOptionPane.showMessageDialog(null, "Сохранено!");
                }
            });

            frame.setVisible(true);
        }

}