
package com.example.schoolmanagement.model;
public enum Role {
    OGRENCI(1),
    OGRETMEN(2),
    ADMIN(0);

    private final int value;

    Role(int value) {
        this.value = value;
    }
}