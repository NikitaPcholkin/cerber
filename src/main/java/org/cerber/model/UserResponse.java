package org.cerber.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserResponse {

    private int id;
    private String uuid;
    private boolean subscribed;

}
