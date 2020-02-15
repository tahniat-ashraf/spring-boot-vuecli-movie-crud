package com.bkash.se.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Tahniat Ashraf Priyam
 * @since 2/15/20
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Movie {

    @Id
    @NotNull
    private String name;
    @NotNull
    private String genre;
}
