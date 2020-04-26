package com.example.android.controller;

import com.example.android.Result;
import com.example.android.entity.user;
import com.example.android.repository.ClothesRepository;
import com.example.android.repository.MatchRepository;
import com.example.android.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class FileController {

    @Autowired
    private userRepository userRepository;
    @Autowired
    private ClothesRepository clothesRepository;
    @Autowired
    private MatchRepository matchRepository;

    @PostMapping("/file/addClothes")
    public Result addClothesFile(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer id) {
        Result result = new Result();
        if (file.isEmpty()) {
            return result.error(1,"文件为空");
        }
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        String path = "";
        File folderFile = new File(".\\src\\main\\resources\\static\\files");
        String iconPath = null;
        try {
            iconPath = folderFile.getCanonicalPath();
            System.out.println(iconPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String randomPath = UUID.randomUUID().toString();
        String filePath = iconPath + "\\" + randomPath + fileName;
        System.out.println(filePath);
        File dest = new File(filePath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            clothesRepository.setFile(filePath,id);
            return result.success("文件上传成功");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//
        return result.error(2,"文件上传失败");
    }
    @PostMapping("/file/addMatch")
    public Result addMatchFile(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer id) {
        Result result = new Result();
        if (file.isEmpty()) {
            return result.error(1,"文件为空");
        }
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        String path = "";
        File folderFile = new File(".\\src\\main\\resources\\static\\files");
        String iconPath = null;
        try {
            iconPath = folderFile.getCanonicalPath();
            System.out.println(iconPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String randomPath = UUID.randomUUID().toString();
        String filePath = iconPath + "\\" + randomPath + fileName;
        System.out.println(filePath);
        File dest = new File(filePath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            matchRepository.setFile(filePath,id);
            return result.success("文件上传成功");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.error(2,"文件上传失败");
    }
    @PostMapping("/file/add")
    public Result addFile(@RequestParam("file") MultipartFile file, @RequestParam("name") String name) {
        Result result = new Result();
        if (file.isEmpty()) {
            return result.error(1,"文件为空");
        }
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        String path = "";
        File folderFile = new File(".\\src\\main\\resources\\static\\files");
        String iconPath = null;
        try {
            iconPath = folderFile.getCanonicalPath();
            System.out.println(iconPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String randomPath = UUID.randomUUID().toString();
        String filePath = iconPath + "\\" + randomPath + fileName;
        System.out.println(filePath);
        File dest = new File(filePath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            userRepository.setFile(filePath,name);
            return result.success("文件上传成功");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.error(2,"文件上传失败");
    }

    @PostMapping(value = "/file/find",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] findFile(@RequestParam("name")String name)throws IOException{
        Result result = new Result<>();
        user user = new user();
        File file;
        Object object = new Object();
        synchronized (object){
            user = userRepository.findByName(name);
        }
        synchronized (object){

            file = new File(user.getPhoto());
//            BufferedImage bufferedImage = ImageIO.read(new FileInputStream(file));
            FileInputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
            return bytes;
//            return bufferedImage;
        }
    }

    @PostMapping(value = "/file/findImg",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] findImg(@RequestParam("name")String fileName)throws IOException{
            File file = new File(fileName);
            FileInputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
            return bytes;
    }
}