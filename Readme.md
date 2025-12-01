# Minimal Reproducible Example (MRE)

Different name for hypermedia links attribute in json response after using RestTemplateBuilder for the first time (links vs _links).

We have adopted a legacy application which has several rest endpoints. The project uses spring-starter-hateoas as well as spring-starter-web.
Multiple application consuming our rest endpoints and expect the response contains a field called "links" (So we have a commitment to keep api consistent).
Until we configured a RestTemplate bean with RestTemplateBuilder the rest endpoints matched the expectation.
After we configured a RestTemplate bean with RestTemplateBuilder this behavior has changed. The field is now called "_links" (HAL style).
To preserve the old behavior we assumed that setting `spring.hateoas.use-hal-as-default-json-media-type: false` would fix it but without any luck.  
I have crafted to two test to demonstrate the issue `com.example.rest_template_incident.WithoutRestConfigurationTest` and `com.example.rest_template_incident.WithRestConfigurationTest`. 
I compared logs with and without the RestTemplate bean and see one additional bean which has been added HypermediaRestTemplateConfigurer. 
Actually, I don't expect that configuring a RestTemplate bean has such an impact on the rest endpoints.