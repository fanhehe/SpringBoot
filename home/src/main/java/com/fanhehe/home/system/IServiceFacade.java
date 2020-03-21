package com.fanhehe.home.system;

import com.fanhehe.home.Registry;
import com.fanhehe.home.util.result.IResult;
import javax.servlet.http.HttpServletRequest;

public interface IServiceFacade extends IService {

    default IService getService(String system, String service) {
        return Registry.getService(system, service).orElse(null);
    }

    default IResult run(String system, String service, String action, HttpServletRequest request) {
        return null;
    }
}
