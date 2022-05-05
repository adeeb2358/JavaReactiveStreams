package com.study.reactive.programming.repos;

import static com.study.reactive.programming.utils.StreamUtils.faker;

import com.study.reactive.programming.entities.User;
import reactor.core.publisher.Mono;

public class UserRepository {

    public Mono<User> getLastUser(Integer id) {

        if (id.equals(1)) {
            return Mono.just(User.builder()
                .address(faker().address().fullAddress())
                .emailId(faker().internet().safeEmailAddress())
                .id(id)
                .lastName(faker().name().lastName())
                .firstName(faker().name().firstName())
                .build());
        } else if (id.equals(2)) {
            return Mono.empty();
        } else {
            return Mono.error(new RuntimeException("Not  in the range allowed range"));
        }
    }
}
