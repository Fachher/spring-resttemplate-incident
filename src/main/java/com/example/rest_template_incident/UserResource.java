package com.example.rest_template_incident;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Builder
@Getter
@Setter
public class UserResource extends RepresentationModel<UserResource> {

    private String loginId;

}
