package com.proyectoback.proyectoBack.entitys;


<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonManagedReference;

=======
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
>>>>>>> 11a3d1945c0b31b6e6a717beb720c676fd2bf18a
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(columnDefinition = "TEXT")
    private String description;

    private int points;

    @ManyToOne
    @JoinColumn(name = "watcher_id")
    @JsonManagedReference
    private Watcher watcher;

    @ManyToOne
    @JoinColumn(name = "player_id")
    @JsonManagedReference
    private Player player;

    @OneToOne(mappedBy = "challenge")
    @JsonManagedReference
    private Video videos;

}


