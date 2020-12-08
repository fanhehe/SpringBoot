package com.fanhehe.user.business.doll.wave.pojo.cond;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/8 15:19
 */
public class WaveCond implements Serializable {

    @NotNull
    @NotBlank
    private String userToken;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}
