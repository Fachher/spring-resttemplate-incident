package com.example.rest_template_incident;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/current-user", produces = "application/json")
@RequiredArgsConstructor
public class CurrentUserRestController {

    @GetMapping
    public ResponseEntity<UserResource> getCurrentUser() {
        return ResponseEntity.ok(buildUserResource());
    }

    private UserResource buildUserResource() {

        final UserResource userResource = UserResource.builder().loginId("max.mustermann")
                .build();
        userResource
                .add(Link.of("http://www.google.de"));

        return userResource;
    }

}
