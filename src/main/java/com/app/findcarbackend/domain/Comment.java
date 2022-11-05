package com.app.findcarbackend.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor()
@Data
@Entity(name = "COMMENTS")
public class Comment {

    @NotNull
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID", unique = true)
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "CONTENT")
    private String content;
}
