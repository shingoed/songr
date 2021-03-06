package com.shingo.songr;

import com.shingo.songr.model.Album;
import com.shingo.songr.model.AlbumRepository;
import com.shingo.songr.model.Song;
import com.shingo.songr.model.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class RootController {

//    used to appear in db wiring interface
    @Autowired
    AlbumRepository repo;

    @Autowired
    SongRepository songRepo;


    @GetMapping("/")
    public String getHome(Model m) {
        m.addAttribute("username","Shingo");

        return "home";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String getHello(){
        return "hello world";
    }

    @GetMapping("/capitalize/{input}")
    @ResponseBody
    public String capitalize(@PathVariable String input){
        return input.toUpperCase();
    }

    @GetMapping("/albums")
    public String getAlbum(Model m){
    m.addAttribute("username","Shingo");

        List<Album> entries = repo.findAll();
        m.addAttribute("albums",entries);

        return "albums";
    }

    @PostMapping("/newalbums")
    public RedirectView addAlbum(String title, String artist, Integer songCount, Integer length, String imageUrl){
        Album newAlbum = new Album (title, artist, songCount, length, imageUrl);
        repo.save(newAlbum);
        return new RedirectView("/albums");
    }

    @GetMapping("/addsong")
    public String addSongs(){
        return "addsong";
    }

    @GetMapping("/songs")
    public String getSongs(Model m){

        List<Song> entries = songRepo.findAll();
        m.addAttribute("songs",entries);

        return "songs";
    }

    @PostMapping("/newsongs")
    public RedirectView addSong(String title,Integer songCount, Integer length){
        Song newSong = new Song (title, songCount, length);
        songRepo.save(newSong);
        return new RedirectView("/songs");
    }

    }

