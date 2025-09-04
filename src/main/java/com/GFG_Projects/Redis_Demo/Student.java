package com.GFG_Projects.Redis_Demo;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student implements Serializable {
    String ID;
    String name;
    String department;
    boolean isHosteller;
}
