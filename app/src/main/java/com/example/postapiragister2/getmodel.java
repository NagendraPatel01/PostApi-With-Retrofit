package com.example.postapiragister2;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class getmodel {



        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("data")
        @Expose
        private Data data;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

    @Override
    public String toString() {
        return "getmodel{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public class Data {

        @SerializedName("Name")
        @Expose
        private String name;
        @SerializedName("Email")
        @Expose
        private String email;
        @SerializedName("Token")
        @Expose
        private String token;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", token='" + token + '\'' +
                    '}';
        }
    }




}
