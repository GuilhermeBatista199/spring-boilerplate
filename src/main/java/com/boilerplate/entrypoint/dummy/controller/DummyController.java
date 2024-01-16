package com.boilerplate.entrypoint.dummy.controller;

import com.boilerplate.core.dummy.contract.DummyService;
import com.boilerplate.core.dummy.entity.Dummy;
import com.boilerplate.entrypoint.dummy.request.DummyRequest;
import com.boilerplate.entrypoint.dummy.response.DummyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/boilerplate/dummy")
@RequiredArgsConstructor(onConstructor_= {@Autowired})
public class DummyController {

    private final ModelMapper modelMapper;
    private final DummyService dummyService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DummyResponse> postInsertDummy(@RequestBody DummyRequest request) {
        log.info("[{}] - REQUEST RECEIVED AT /dummy", request.getName());

        Dummy dummy = dummyService.createNewDummy(modelMapper.map(request, Dummy.class));

        DummyResponse response = modelMapper.map(dummy, DummyResponse.class);
        log.info("[{}] - NEW DUMMY CREATED - {}", response.getId(), response.getName());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
