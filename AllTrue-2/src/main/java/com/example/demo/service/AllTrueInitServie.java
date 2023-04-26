package com.example.demo.service;

import java.util.Date;

import com.example.demo.entity.Role;
import com.example.demo.entity.Utilisateur;

public interface AllTrueInitServie {
	public Utilisateur inscription(String nom, String prenom, String email, String numTel, String sexe, String password, String adresse, Date dateInscription);
	public Role save(Role role);
	public Utilisateur loadUserByUsername(String username);
	public void addRoleToUser(String email, String rolename);

}
