package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UtilisateurRepository;
import com.example.demo.entity.Client;
import com.example.demo.entity.Role;
import com.example.demo.entity.Utilisateur;

@CrossOrigin("*")
@Service
@Transactional
public class AllTrueInitServiceImp implements AllTrueInitServie{
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	public BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	public RoleRepository roleRepository;


	@Override
	public Utilisateur inscription(String nom, String prenom, String email, String numTel, String sexe, String password,
			String adresse, Date dateInscription) {
		Utilisateur user = utilisateurRepository.findUtilisateurByEmail(email);
		if(user!= null) throw new RuntimeException("user existe déja!") ;
		
		String password1 = bCryptPasswordEncoder.encode(password);
		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setAdresse(adresse);
		client.setNumTel(numTel);
		client.setEmail(email);
		client.setSexe(sexe);
		client.setDateInscription(dateInscription);
		client.setPassword(password1);
		clientRepository.save(client);
		addRoleToUser(email, "Client");
		
		
		return client;
	}
	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
//		return null;
		
	}
	@Override
	public Utilisateur loadUserByUsername(String email) {
		
		return utilisateurRepository.findUtilisateurByEmail(email);
//		return null;
	}
	@Override
	public void addRoleToUser(String email, String rolename) {
		Utilisateur user = utilisateurRepository.findUtilisateurByEmail(email);
		Role role = roleRepository.findByRole(rolename);
		user.getRoles().add(role);
	}

}
