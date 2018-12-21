package com.example.mysql.entity.secondary;

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
@Table(name = "application2")
@NoArgsConstructor
@AllArgsConstructor
public class Application2 implements Serializable {
    private static final long serialVersionUID = -2513682087341337944L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

}