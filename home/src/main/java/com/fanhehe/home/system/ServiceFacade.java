package com.fanhehe.home.system;

import lombok.SneakyThrows;
import com.fanhehe.home.util.result.Result;
import com.fanhehe.home.util.result.IResult;
import org.springframework.stereotype.Service;
import com.fanhehe.home.system.user.model.IUser;
import com.fanhehe.home.system.user.model.User;
import javax.servlet.http.HttpServletRequest;

@Service("ServiceFacadeIndex")
public class ServiceFacade extends com.fanhehe.home.system.common.service.ServiceFacade {

    @Override
    @SneakyThrows
    public IResult run(String system, String service, String action, HttpServletRequest request) {
        IService serviceImpl = getService(system, service);

        if (serviceImpl == null) {
            return Result.failure();
        }

        IUser user = new User();

        return Result.success(serviceImpl.getClass().getMethod(action, IUser.class).invoke(serviceImpl, user));
    }
}
