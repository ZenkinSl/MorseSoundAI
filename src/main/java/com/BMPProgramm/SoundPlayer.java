package com.BMPProgramm;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundPlayer {

    private static void play(String file) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(
                    SoundPlayer.class.getResource("/sounds/" + file)
            ));
            clip.start();

            Thread.sleep(clip.getMicrosecondLength() / 200);
            clip.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void playMorse(String morse) {
        new Thread(() -> {
            try {
                for (char c : morse.toCharArray()) {
                    if (c == '.') play("dit.wav");
                    else if (c == '-') play("dat.wav");
                    else Thread.sleep(300);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
