package org.source.domain;

import lombok.Data;
import org.source.basic.domain.BaseDomain;

@Data
public class Login extends BaseDomain {
    private String username;
    private String password;
}
