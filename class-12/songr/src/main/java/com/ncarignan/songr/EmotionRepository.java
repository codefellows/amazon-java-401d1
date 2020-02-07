package com.ncarignan.songr;

import org.springframework.data.jpa.repository.JpaRepository;

// <name of class, type of id>
// I think this needs no annotation because it extends a class with the annotation
public interface EmotionRepository extends JpaRepository<Emotion, Long> {

}
