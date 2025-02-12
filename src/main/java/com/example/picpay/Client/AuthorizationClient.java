package com.example.picpay.Client;

import com.example.picpay.DTO.AuthorizationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(
    name = "AuthorizationClient",
    url = "${client.authorization-service.url}"
)

public interface AuthorizationClient {  
    @GetMapping
    ResponseEntity<AuthorizationDTO> isAuthorized();
}
