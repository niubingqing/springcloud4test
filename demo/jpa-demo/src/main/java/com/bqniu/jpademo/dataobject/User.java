package com.bqniu.jpademo.dataobject;

import lombok.Data;
import javax.persistence.Id;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
public class User implements Serializable {
    @Id
    private int id;
    private String name;
}
