package com.mytube;

import com.mytube.interfaces.Database;

import static java.lang.System.*;

public class VideoDatabase implements Database {
    public void store(Video video) {
        out.println("Storing video metadata in a SQL database...");
        out.println("Title: " + video.getTitle());
        out.println("File Name: " + video.getFileName());
        out.println("Done!\n");
    }
}
