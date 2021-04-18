package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.demo.models.FileInfo;

public interface FilesInfoRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findByStorageFileName(String fileName);

    FileInfo findByUrl(String url);
}
