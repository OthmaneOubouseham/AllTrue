package com.example.demo.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Resultat;
import com.example.demo.entity.Utilisateur;
import com.example.demo.service.AllTrueInitServiceImp;
import com.example.demo.vo.User;

@CrossOrigin("*")
@RestController


public class AllTrueRestControleur {
	
	@Autowired
	public AllTrueInitServiceImp service;
	
	@PostMapping("/inscription")
	public Utilisateur inscrire(@RequestBody User user) {
		System.out.println(1);
		String nom = user.getNom();
		String prenom = user.getPrenom();
		String email = user.getEmail();
		String numTel = user.getNumTel();
		String sexe = user.getSexe();
		String adresse = user.getAdresse();
		Date dateInscription = user.getDateInscription();
		String password = user.getPassword();
		
		return service.inscription(nom, prenom, email, numTel, sexe, password, adresse, dateInscription);
		
	}
	@PostMapping("/cherche")
	public void Chercher(@RequestBody String titre) {
		this.service.lancerRecher(titre);
	}
	@GetMapping("/historiques")
	public List<Resultat> getHistoriques(){
		return this.service.historique();
	}

}
