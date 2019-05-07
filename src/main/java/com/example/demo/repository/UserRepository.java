/*
 * Copyright 2019 allen.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User Repository
 * @author allen
 */
public interface UserRepository extends JpaRepository<User, Long>{
    
    /**
     * 根据用户名查询用户
     *    jpa会根据函数名规则,自动实现具体SQL查询功能
     * @param username 用户名
     * @return 
     */
    User findByUsername(String username);
    
    /**
     * 更加用户名或邮箱查询用户
     *    jpa会根据函数名规则,自动实现具体SQL查询功能
     * @param username 用户名
     * @param email 邮箱
     * @return 
     */
    User findByUsernameOrEmail(String username, String email);
}
