package com.fanhehe.home;

import com.fanhehe.home.system.IServiceFacade;
import com.fanhehe.home.util.result.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Router {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    @Qualifier("ServiceFacadeIndex")
    private IServiceFacade serviceFacadeIndex;

    @ResponseBody
    @RequestMapping("/{system}/{service}/{action}")
    public IResult index(
            @PathVariable String system,
            @PathVariable String service,
            @PathVariable String action) {

        return serviceFacadeIndex.run(system, service, action, request);
    }
}
