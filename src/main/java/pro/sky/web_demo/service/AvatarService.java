package pro.sky.web_demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.web_demo.model.Avatar;
import pro.sky.web_demo.model.Student;
import pro.sky.web_demo.repository.AvatarRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;


import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
@Transactional

public class AvatarService {
    private static final Logger logger = LoggerFactory.getLogger(AvatarService.class);
    @Value("${path.to.avatars.folder}")
    private String avatarsDir;

    private final AvatarRepository avatarRepository;
    private final StudentService studentService;

    public AvatarService(AvatarRepository avatarRepository, StudentService studentService) {
        this.avatarRepository = avatarRepository;
        this.studentService = studentService;
    }
    public void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException {
        Student student = studentService.findStudent(studentId);

        Path filePath = Path.of(avatarsDir, student + "." + getExtensions(avatarFile.getOriginalFilename()));

        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        try (

                InputStream is = avatarFile.getInputStream();

                OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);

                BufferedInputStream bis = new BufferedInputStream(is, 1024);

                BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
        ) {

            bis.transferTo(bos);
        }
        Avatar avatar = new Avatar();
        avatar.setStudent(student);
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(avatarFile.getSize());
        avatar.setMediaType(avatarFile.getContentType());
        avatar.setData(avatarFile.getBytes());
        avatarRepository.save(avatar);
    }
    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
    public Avatar findAvatar(Long studentId) {
        return avatarRepository.findByStudentId(studentId).orElse(new Avatar());
    }

    public Collection<Avatar> readAvatarsByPages(Integer pageNumber, Integer pageSize) throws PageSettingsUnderZero {
        logger.info("readAvatarsByPages method has been invoked");
        if (pageNumber <= 0 || pageSize <= 0) {
            throw new PageSettingsUnderZero();
        }

        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        return avatarRepository.findAll(pageRequest).getContent();
    }
}



