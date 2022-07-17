package com.moseswilliamsiii.dockerapi.repos;

import Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
}
