package com.mytube;

import com.mytube.interfaces.Database;
import com.mytube.interfaces.Service;
import com.mytube.interfaces.Encoder;

public class VideoProcessor {
    private final Encoder encoder;
    private final Database database;
    private final Service emailService;

    public VideoProcessor(Encoder encoder, Database database, Service emailService) {
        this.encoder = encoder;
        this.database = database;
        this.emailService = emailService;
    }
    public void process(Video video) {
        encoder.encode(video);

        database.store(video);

        emailService.sendEmail(video.getUser());
    }
}

