package com.bankingsystem.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimitInterceptor implements HandlerInterceptor {
    private static final int MAX_REQUESTS = 100;
    private final Map<String, Integer> requestCounts = new ConcurrentHashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {

        String ip = request.getRemoteAddr();
        requestCounts.putIfAbsent(ip, 0);

        if (requestCounts.get(ip) >= MAX_REQUESTS) {
            response.setStatus(429);
            return false;
        }

        requestCounts.put(ip, requestCounts.get(ip) + 1);
        return true;
    }

}
