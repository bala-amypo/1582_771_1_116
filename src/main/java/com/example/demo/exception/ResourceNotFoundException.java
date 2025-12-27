// package com.example.demo.exception;

// public class ResourceNotFoundException extends RuntimeException {
//     public ResourceNotFoundException(String message) {
//         super(message);
//     }
// }
package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    // Optional helper constructors
    public ResourceNotFoundException(String resource, String field, Object value) {
        super(resource + " not found with " + field + " : " + value);
    }
}
