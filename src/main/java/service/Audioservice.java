package service;

import model.AudioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AudioRepository;

@Service
public class Audioservice {
    @Autowired
    private AudioRepository audiorepository;

    public AudioEntity save(AudioEntity audio){
        return audiorepository.save(audio);
    }
    public void processUpload(){

    }

}
