//package com.JWT.Sample.Model;
//
//import lombok.Builder;
//
//@Builder
//public class JWTResponse {
//
//    private String jwtToken;
//    private String username;
//
//    // Private constructor to enforce the use of the builder
//    private JWTResponse(Builder builder) {
//        this.jwtToken = builder.jwtToken;
//        this.username = builder.username;
//    }
//
//    // Static nested Builder class
//    public static class Builder {
//        private String jwtToken;
//        private String username;
//
//        // Setter method for jwtToken
//        public Builder jwtToken(String jwtToken) {
//            this.jwtToken = jwtToken;
//            return this;
//        }
//
//        // Setter method for username
//        public Builder username(String username) {
//            this.username = username;
//            return this;
//        }
//
//        // Build method to create a JWTResponse instance
//        public JWTResponse build() {
//            return new JWTResponse(this);
//        }
//    }
//
//    public JWTResponse(String jwtToken, String username) {
//        this.jwtToken = jwtToken;
//        this.username = username;
//    }
//
//    public JWTResponse() {
//    }
//
//    public String getJwtToken() {
//        return jwtToken;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setJwtToken(String jwtToken) {
//        this.jwtToken = jwtToken;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    @Override
//    public String toString() {
//        return "JWTResponse{\n" +
//                "jwtToken : " + jwtToken + ",\n" +
//                "username : " + username + "\n}\n";
//    }
//
//}


package com.JWT.Sample.Model;

public class JWTResponse {
    private String jwtToken;
    private String username;

    // Private constructor to enforce the use of the builder
    private JWTResponse(Builder builder) {
        this.jwtToken = builder.jwtToken;
        this.username = builder.username;
    }

    // Getters
    public String getJwtToken() {
        return jwtToken;
    }

    public String getUsername() {
        return username;
    }

    // Static nested Builder class
    public static class Builder {
        private String jwtToken;
        private String username;

        // Setter method for jwtToken
        public Builder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        // Setter method for username
        public Builder username(String username) {
            this.username = username;
            return this;
        }

        // Build method to create a JWTResponse instance
        public JWTResponse build() {
            return new JWTResponse(this);
        }
    }

    @Override
    public String toString() {
        return "JWTResponse{\n" +
                "jwtToken: " + jwtToken + ",\n" +
                "username: " + username + "\n}\n";
    }
}
