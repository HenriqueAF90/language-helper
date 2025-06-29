package controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import repository.AudioRepository;
import service.Audioservice;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/audio")

public class AudioController {
         private final Audioservice audioService;

    public AudioController(Audioservice audioService) {
        this.audioService = audioService;
    }
    @PostMapping("/upload")
    public ResponseEntity<String> uploadAudio(
        @RequestParam("file") MultipartFile file,
        @RequestParam("userId") String userId,
        @RequestParam("title") String title,
        @RequestParam(value = "description", required = false) String description,
        @RequestParam("recordingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime recordingDate
    ) {
        audioService.processUpload(file, userId, title, description, recordingDate);
        return ResponseEntity.ok("Upload realizado com sucesso!");
    }

}
