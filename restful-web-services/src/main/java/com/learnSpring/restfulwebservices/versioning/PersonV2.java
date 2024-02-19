package com.learnSpring.restfulwebservices.versioning;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonV2 {
   String name;
   int age;
}
