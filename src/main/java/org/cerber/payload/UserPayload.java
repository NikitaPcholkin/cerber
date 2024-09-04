package org.cerber.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPayload {
    private String uuid;
    private int id;

    public UserPayload() {
    }
}
