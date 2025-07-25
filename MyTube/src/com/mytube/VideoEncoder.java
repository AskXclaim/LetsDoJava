package com.mytube;

import com.mytube.interfaces.Encoder;

import static java.lang.System.*;

public class VideoEncoder implements Encoder {
    public void encode(Video video) {
        out.println("Encoding video...");
        out.println("Done!\n");
    }
}
