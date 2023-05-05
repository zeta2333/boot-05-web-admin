package usts.pycro.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Pycro
 * @version 1.0
 * 2023-05-05 1:22 PM
 * 文件上传测试
 */
@Slf4j
@Controller
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layouts() {
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(
            @RequestParam("email") String email,
            @RequestParam("username") String username,
            @RequestPart("avatar") MultipartFile avatar,
            @RequestPart("photos") MultipartFile[] photos
    ) throws IOException {
        log.info("上传的信息：email={},\nusername={},\navatar.size={},photos.length={}",
                email, username, avatar.getSize(), photos.length);
        //保存头像
        if (!avatar.isEmpty()) {
            String avatarOriginalFilename = avatar.getOriginalFilename();
            avatar.transferTo(new File("E:\\cache\\" + avatarOriginalFilename));
        }
        //保存照片
        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String photoOriginalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("E:\\cache\\" + photoOriginalFilename));
                }
            }
        }
        return "main";
    }
}
