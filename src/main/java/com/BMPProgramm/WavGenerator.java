package com.BMPProgramm;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.InputStream;
import java.io.SequenceInputStream;

public class WavGenerator {
    public static void save(String morse, String fileName) {
        try {
            File dir = new File("output");
            if (!dir.exists()) dir.mkdir();

            File outFile = new File(dir, fileName + ".wav");

            AudioInputStream result = null;

            for (char c : morse.toCharArray()) {
                String file = null;

                if (c == '.') file = "/sounds/dit.wav";
                else if (c == '-') file = "/sounds/dat.wav";
                else file = "/sounds/morse.wav";

                InputStream stream = WavGenerator.class.getResourceAsStream(file);

                if (stream == null) {
                    throw new RuntimeException("Файл не найден: " + file);
                }

                AudioInputStream next = AudioSystem.getAudioInputStream(stream);

                if (result == null) {
                    result = next;
                } else {
                    result = new AudioInputStream(
                            new SequenceInputStream(result, next),
                            result.getFormat(),
                            result.getFrameLength() + next.getFrameLength()
                    );
                }
            }

            AudioSystem.write(result, AudioFileFormat.Type.WAVE, outFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
