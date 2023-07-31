package com.crm.group.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crm.group.model.Client;
import com.crm.group.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientService clientService;

	@GetMapping("/clients")
	@ResponseBody
	public ResponseEntity getAllClients() {
		List<Client> listClients = clientService.getAllClients();
		return ResponseEntity.ok().body(listClients.toString());
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity getClientById(@PathVariable("id") Integer id) {
		Optional<Client> optionalClient = clientService.getClientById(id);
		if (optionalClient.isPresent()) {
			Client clientFound = optionalClient.get();
			return ResponseEntity.ok().body(clientFound);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addClient(@RequestBody Client client) {
		Client clientAdded = clientService.addClient(client);
		return ResponseEntity.ok().body(clientAdded);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteClient(@PathVariable("id") Integer id) {
		Boolean hasBeenDeleted = clientService.deleteById(id);

		if (hasBeenDeleted) {
			return ResponseEntity.ok().body("Votre client a bien été supprimé");
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/update/{id}")
	@ResponseBody
	public ResponseEntity modifyClient(@PathVariable("id") Integer id, @RequestBody Client client) {
		System.out.println("Démarrage update" + id + " " + client.toString());
		Boolean hasBeenModified = clientService.modifyClient(id, client);

		if (hasBeenModified) {
			return ResponseEntity.ok().body("Votre client a bien été modifié en : " + client.toString());
		}
		return ResponseEntity.notFound().build();
	}
}
