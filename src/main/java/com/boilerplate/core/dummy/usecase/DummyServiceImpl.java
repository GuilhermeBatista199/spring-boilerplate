package com.boilerplate.core.dummy.usecase;

import com.boilerplate.core.dummy.contract.DummyService;
import com.boilerplate.core.dummy.entity.Dummy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_={@Autowired})
public class DummyServiceImpl implements DummyService {

    private final ModelMapper modelMapper;

    public Dummy createNewDummy(Dummy dummy) {
        log.info("[{}] - CREATING NEW DUMMY", dummy.getName());
        dummy.setId(String.valueOf(UUID.randomUUID()));
        return dummy;
    }
}
