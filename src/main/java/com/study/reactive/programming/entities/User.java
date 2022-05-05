package com.study.reactive.programming.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class User {

    Integer id;
    String firstName;
    String lastName;
    String address;
    String emailId;
}
