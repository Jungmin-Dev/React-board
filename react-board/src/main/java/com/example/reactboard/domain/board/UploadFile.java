package com.example.reactboard.domain.board;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UploadFile {
    private String uploadFileName;
    private String storeFileName;
}
