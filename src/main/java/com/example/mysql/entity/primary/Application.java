package com.example.mysql.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author g1335333249
 */
@Data
@Builder
@Accessors(chain = true)
@Entity
@Table(name = "application")
@NoArgsConstructor
@AllArgsConstructor
public class Application implements Serializable {
    private static final long serialVersionUID = -703654527922548727L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
