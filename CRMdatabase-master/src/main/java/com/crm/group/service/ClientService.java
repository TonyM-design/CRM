package com.crm.group.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.group.model.Client;
import com.crm.group.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	/**
	 * 
	 * @return all clients in database
	 */
	public List<Client> getAllClients() {
		return clientRepository.findAll();

	}

	/**
	 * 
	 * @param id
	 * @return the client associated with "id"
	 */
	public Optional<Client> getClientById(Integer id) {
		return clientRepository.findById(id);
	}

	/**
	 * 
	 * @param client
	 * @return the client saved in the database
	 */
	public Client addClient(Client client) {
		return clientRepository.save(client);
	}

	/**
	 * 
	 * @param id
	 * @param client
	 * @return true if a client with id existed and was correctly modified
	 */
	public Boolean modifyClient(Integer id, Client client) {
		Optional<Client> optClient = clientRepository.findById(id);
		if (optClient.isPresent()) {
			clientRepository.save(client);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 
	 * @param id
	 * @return true if a client with "id" existed and was correctly deleted
	 */
	public Boolean deleteById(Integer id) {
		Optional<Client> clientToDelete = clientRepository.findById(id);
		if (clientToDelete.isPresent()) {
			clientRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
