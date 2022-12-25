package com.sommelier.wine4you.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Long create(MultipartFile multipartImage);

    byte[] getById(Long wineId, Long imageId);

    void deleteById(Long wineId, Long imageId);
}
