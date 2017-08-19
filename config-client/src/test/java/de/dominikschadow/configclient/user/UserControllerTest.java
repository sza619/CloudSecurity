/*
 * Copyright (C) 2017 Dominik Schadow, dominikschadow@gmail.com
 *
 * This file is part of the Cloud Security project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.dominikschadow.configclient.user;

import de.dominikschadow.configclient.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;

/**
 * Tests the {@link UserController} class.
 *
 * @author Dominik Schadow
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllUsersReturnsOk() throws Exception {
        given(userRepository.findAll()).willReturn(new ArrayList<>());
        mvc.perform(MockMvcRequestBuilders.get("/users")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getSingleUserReturnsOk() throws Exception {
        given(userRepository.findOne(1L)).willReturn(new User());
        mvc.perform(MockMvcRequestBuilders.get("/users/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
