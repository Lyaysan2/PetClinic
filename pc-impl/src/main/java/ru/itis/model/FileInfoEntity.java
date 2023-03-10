package ru.itis.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"doctor"}, callSuper = false)
@Table(name = "file_info")
public class FileInfoEntity extends AbstractEntity {

    @Column(name = "original_file_name")
    private String originalFileName;

    @Column(name = "file_mongo_id")
    private String fileMongoDb;

    private Long size;

    private String type;

    @OneToOne(mappedBy = "photo", fetch = FetchType.LAZY)
    private DoctorEntity doctor;
}
