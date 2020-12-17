package com.fanhehe.neckpets.business.wave.pojo.cond;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author fanhehe
 * @version 0.0.1
 * @date 2020/12/16 17:17
 */
public class WaveCond {
    @NotBlank
    private String userToken;
    @NotNull
    private String platform;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
