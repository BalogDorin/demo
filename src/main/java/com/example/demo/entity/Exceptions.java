package com.example.demo.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class Exceptions {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public static class CourseNotFound extends RuntimeException {

        public CourseNotFound() {
        }

        public CourseNotFound(String message) {
            super(message);
        }
    }


}
