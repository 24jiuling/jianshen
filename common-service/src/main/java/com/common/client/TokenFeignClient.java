package com.common.client;

import com.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service")
public interface TokenFeignClient {
    @GetMapping("/token/validate")
    R validate(@RequestParam("token") String token);
}
