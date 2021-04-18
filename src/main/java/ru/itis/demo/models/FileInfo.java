package ru.itis.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class FileInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // имя файла у нас в хранилище
    private String storageFileName;
    // оригинальное название файла
    private String originalFileName;
    // тип файла (image/jpg, audio/mp3) - MIME
    private String type;
    // размер загружаемого файла
    private Long size;
    // URL для получения файла
    private String url;
}
