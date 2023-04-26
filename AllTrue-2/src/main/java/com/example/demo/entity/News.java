package com.example.demo.entity;


import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Transactional
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class News {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToMany(mappedBy = "news")
	private Collection<ImageNews> imageNews;
	@OneToMany(mappedBy = "news")
	private Collection<Resultat> resultat;

}