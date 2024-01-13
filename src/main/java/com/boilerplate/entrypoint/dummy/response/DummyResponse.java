package com.boilerplate.entrypoint.dummy.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DummyResponse {
    private String id;
    private String name;
}
