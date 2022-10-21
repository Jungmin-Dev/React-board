package com.example.reactboard.controller;

import com.example.reactboard.domain.board.ItemForm;
import com.example.reactboard.domain.board.UploadFile;
import com.example.reactboard.mappers.FileMapper;
import com.example.reactboard.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/upload")
public class UploadController {

    private final FileRepository fileRepository;
    private final FileMapper fileMapper;
    @PostMapping()
    public String saveItem(@ModelAttribute ItemForm itemForm, RedirectAttributes redirectAttributes) throws IOException{
        UploadFile attachFile = fileRepository.storeFile(itemForm.getAttachFile());
        List<UploadFile> storeImageFiles = fileRepository.storeFiles(itemForm.getImageFiles());

        // 데이터 베이스에 저장

//        redirectAttributes.addAttribute("itemId", item.getId());

        return "redirect:/items/{itemId}";
    }

//    @GetMapping("items/{id}")
//    public String items(@PathVariable Long id, Model model){
//        // DB에서 찾아와서 뿌려주면 된다 ~
////        Item item = itemRepository.findById(id);
////        model.addAttribute("item", item);
//        return "item-view";
//    }
//
//    @ResponseBody
//    @GetMapping("images/{filename}")
//    public Resource downloadImage(@PathVariable String filename) throws MalformedURLException {
//        return new UrlResource("file:" + fileRepository.getFullPath(filename));
//    }
//
//    @GetMapping("attach/{itemId}")
//    public ResponseEntity<Resource> downloadAttach(@PathVariable Long itemId) throws MalformedURLException {
//        Item item = itemRepository.findById(itemId);
//        String storeFileName = item.getAttachFile().getStoreFileName();
//        String uploadFileName = item.getAttachFile().getUploadFileName();
//
//        UrlResource resource = new UrlResource("file:" + fileRepository.getFullPath(storeFileName));
//
//        String encodedUploadFileName = UriUtils.encode(uploadFileName, StandardCharsets.UTF_8);
//        String contentDisposition = "attachment; filename=\"" + encodedUploadFileName + "\"";
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
//                .body(resource);
//    }
}
