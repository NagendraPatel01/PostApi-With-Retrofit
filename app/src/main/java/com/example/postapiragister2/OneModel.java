package com.example.postapiragister2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OneModel {


        @SerializedName("data")
        @Expose
        private List<Datum> data = null;

        public List<Datum> getData() {
            return data;
        }

        public void setData(List<Datum> data) {
            this.data = data;
        }

    @Override
    public String toString() {
        return "OneModel{" +
                "data=" + data +
                '}';
    }

    public class Datum {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("profilepicture")
        @Expose
        private String profilepicture;
        @SerializedName("location")
        @Expose
        private String location;

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

        public String getProfilepicture() {
            return profilepicture;
        }

        public void setProfilepicture(String profilepicture) {
            this.profilepicture = profilepicture;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        @Override
        public String toString() {
            return "Datum{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", profilepicture='" + profilepicture + '\'' +
                    ", location='" + location + '\'' +
                    '}';
        }
    }



}
