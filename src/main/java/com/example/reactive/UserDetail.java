package com.example.reactive;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("userdetail")
public class UserDetail {

	@Id
    private Long id;
    private String name;
    private String email;

    public UserDetail (String name,String email){
        this.name = name;
        this.email = email;
    }
}
