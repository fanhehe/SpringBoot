package com.fanhehe.home;

import java.util.Map;
import java.util.Optional;
import com.fanhehe.home.system.IService;
import java.util.concurrent.ConcurrentHashMap;

public interface Registry {
    Map<String, Map<String, IService>> registry = new ConcurrentHashMap<>();


    static void addService(String system, String service, IService serviceImpl) {
        if (!registry.containsKey(system)) {
            registry.put(system, new ConcurrentHashMap<>());
        }

        registry.get(system).put(service, serviceImpl);
    }

    static Optional<IService> getService(String system, String service) {

        if (!registry.containsKey(system)) {
            return Optional.empty();
        }

        return Optional.ofNullable(registry.get(system).get(service));
    }
}
