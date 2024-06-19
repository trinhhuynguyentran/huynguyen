package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String MaNV;
    private String TenNV;
    private String Phai;
    private String NoiSinh;
    private Integer Luong;
    @ManyToOne
    @JoinColumn(name = "Ma_Phong")
    private Department department;
}
