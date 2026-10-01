package vn.vtiacademy.training.model;

import java.time.LocalDate;

public record Customer(
    String name, String gender, LocalDate dob, String address, String city,
    String state, String pin, String telephone, String email, String password) {}