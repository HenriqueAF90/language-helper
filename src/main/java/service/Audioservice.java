package service;

import model.AudioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import repository.AudioRepository;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class Audioservice {
    @Autowired
    private AudioRepository audiorepository;

    public AudioEntity save(AudioEntity audio){
        return audiorepository.save(audio);
    }
    public void processUpload(MultipartFile file, String userId, String title, String description, LocalDateTime recordingDate) {
        try {
            // Salva o arquivo em memória
            byte[] audioBytes = file.getBytes();
            // Aqui você pode enviar audioBytes para a IA
            // Exemplo: String texto = iaService.transcreverAudio(audioBytes);
            // Você pode salvar os metadados se necessário
        } catch (IOException e) {
            throw new RuntimeException("Erro ao processar o arquivo de áudio", e);
        }
    }

}
