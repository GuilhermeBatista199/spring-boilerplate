package com.boilerplate.entrypoint.dummy.controller;

import com.boilerplate.entrypoint.dummy.request.DummyRequest;
import com.boilerplate.entrypoint.dummy.response.DummyResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/boilerplate/dummy")
public class DummyController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DummyResponse> postInsertDummy(@RequestBody DummyRequest request) {
        log.info("[{}] - REQUEST RECEIVED AT /dummy", request.getName());

        DummyResponse response = DummyResponse.builder()
                .id(String.valueOf(UUID.randomUUID()))
                .name(request.getName())
                .build();
        log.info("[{}] - NEW DUMMY INSERTED - {}", response.getId(), response.getName());
        return new ResponseEntity<DummyResponse>(response, HttpStatus.OK);
    }
}
