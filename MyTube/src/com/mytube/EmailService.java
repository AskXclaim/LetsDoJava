package com.mytube;

import com.mytube.interfaces.Service;

import static java.lang.System.*;

public class EmailService  implements Service {
    public void sendEmail(User user) {
        out.println("Notifying " + user.getEmail() + "...");
        out.println("Done!\n");
    }
}
