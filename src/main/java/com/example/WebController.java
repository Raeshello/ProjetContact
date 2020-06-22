package com.example;

import com.example.model.table.*;
import com.example.model.tableForm.contactForm;
import com.example.model.tableForm.utilisateurForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author Jason Mahdjoub
 * @version 1.0
 * @since SpringBoot
 */
@Controller
public class WebController implements WebMvcConfigurer {
	@Autowired
	private ContactRepository contactREP;
	@Autowired
	private UtilisateurRepository userREP;

	private static final Logger log = LoggerFactory.getLogger(ServingWebContentApplication.class);

	// 			Première page de login

	@GetMapping("/")
	public String login(utilisateurForm utilisateurForm){
		return "login";
	}

	@PostMapping("/")
	public String testConnexion(@Valid utilisateurForm utilisateurForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("TEST ERREUR");
			return "login";
		}
		String login = utilisateurForm.getLogin();
		String pwd = utilisateurForm.getPassword();

		System.out.println("Login : '" + login + "'\nPassword : '" + pwd + "'");

		try{
			Utilisateur logUser = userREP.findUtilisateursByLoginAndPassword(login, pwd);
			if(logUser != null){
				System.out.println("Connexion Réussi !");
				return "accueil";
			} else {
				System.out.println("Aucun utilisateur trouvé !");
				return "login";
			}
		} catch (NullPointerException e){
			System.out.println("ERREUR : Aucun utilisateur trouvé !");
			return "redirect:login";
		}
	}

	//			Accueil Après le login


	// 			Fin Accueil Après login
	@PostMapping("/deleteForm")
	public String deleteContactForm(){
		return "";
	}

	@RequestMapping("/go-Add")
	public String goToAdd(){
		return "addForm";
	}
	@RequestMapping("/go-Del")
	public String goToDel(){
		return "deleteForm";
	}
	@RequestMapping("/go-Mod")
	public String goToMod(){
		return "modifyForm";
	}

	@GetMapping("/results")
	public String beConnected(){
		return "accueil";
	}

	@RequestMapping("/listingContact")
	public String listContact(Model model){
		model.addAttribute("contacts", contactREP.findAll());
		return "accueil";
	}

	@RequestMapping("/editContact")
	public String editContact(Model model){
		model.addAttribute("listContact", contactREP.findAll());
		return "modifyForm";
	}

	@PostMapping("/updateContact")
	public String updateContact(@Valid contactForm contactForm, BindingResult bindingResult){

//		System.out.println("ID : " + id.toString());
		return "login";
	}

	@RequestMapping("/updateContactFail")
	public void updateContactFail(){
		System.out.println("ID : FAIL");
//		System.out.println("ID : " + id.toString());
	}

	@PostMapping("/addContact")
	public void addContact(contactForm contactForm, @RequestParam(value = "id", required = true, defaultValue = "-1") String x, @RequestParam(name = "postale") List<String> addresses, @RequestParam(name = "mail") List<String> emails){
		Contact contact = new Contact(contactForm.getName());
		contact.setNom(contactForm.getName());
		Collection<AdressePostale> listAdr = new Collection<AdressePostale>() {
			@Override
			public int size() {
				return 0;
			}

			@Override
			public boolean isEmpty() {
				return false;
			}

			@Override
			public boolean contains(Object o) {
				return false;
			}

			@Override
			public Iterator<AdressePostale> iterator() {
				return null;
			}

			@Override
			public Object[] toArray() {
				return new Object[0];
			}

			@Override
			public <T> T[] toArray(T[] a) {
				return null;
			}

			@Override
			public boolean add(AdressePostale adressePostale) {
				return false;
			}

			@Override
			public boolean remove(Object o) {
				return false;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				return false;
			}

			@Override
			public boolean addAll(Collection<? extends AdressePostale> c) {
				return false;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				return false;
			}

			@Override
			public boolean removeIf(Predicate<? super AdressePostale> filter) {
				return false;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				return false;
			}

			@Override
			public void clear() {

			}

			@Override
			public Spliterator<AdressePostale> spliterator() {
				return null;
			}

			@Override
			public Stream<AdressePostale> stream() {
				return null;
			}

			@Override
			public Stream<AdressePostale> parallelStream() {
				return null;
			}
		};
		Collection<AdresseMail> listMail = new Collection<AdresseMail>() {
			@Override
			public int size() {
				return 0;
			}

			@Override
			public boolean isEmpty() {
				return false;
			}

			@Override
			public boolean contains(Object o) {
				return false;
			}

			@Override
			public Iterator<AdresseMail> iterator() {
				return null;
			}

			@Override
			public Object[] toArray() {
				return new Object[0];
			}

			@Override
			public <T> T[] toArray(T[] a) {
				return null;
			}

			@Override
			public boolean add(AdresseMail adresseMail) {
				return false;
			}

			@Override
			public boolean remove(Object o) {
				return false;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				return false;
			}

			@Override
			public boolean addAll(Collection<? extends AdresseMail> c) {
				return false;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				return false;
			}

			@Override
			public boolean removeIf(Predicate<? super AdresseMail> filter) {
				return false;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				return false;
			}

			@Override
			public void clear() {

			}

			@Override
			public Spliterator<AdresseMail> spliterator() {
				return null;
			}

			@Override
			public Stream<AdresseMail> stream() {
				return null;
			}

			@Override
			public Stream<AdresseMail> parallelStream() {
				return null;
			}
		};

		contact.setListAdress(listAdr);
		contact.setListMail(listMail);
		contactREP.save(contact);
		}
	}