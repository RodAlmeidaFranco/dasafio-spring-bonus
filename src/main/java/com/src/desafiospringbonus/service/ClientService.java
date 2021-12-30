package com.src.desafiospringbonus.service;

import com.src.desafiospringbonus.entity.Client;
import com.src.desafiospringbonus.exception.RepositoryException;
import com.src.desafiospringbonus.repositories.ClientRepository;
import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public void createClient(Client client){
        if( !isFullClient(client))
            throw new RepositoryException("Incomplete Registration");

        clientRepository.saveClient(client);
    }

    public List<Client> findAll( ){
        return clientRepository.findAllClients();
    }

    public List<Client> findAllByState( String state ){
        return clientRepository.findAllClients()
                .stream()
                .filter( client -> client.getState().equals(state) )
                .collect(Collectors.toList());
    }

    public boolean existClient(Client client ){
         return clientRepository.findAllClients().contains(client);
    }

    public boolean isFullClient(Client client ){

        if(client.getCpf() == null )
            return false;
        if(client.getEmail()== null )
            return false;
        if(client.getBirthDate() == null )
            return false;
        if(client.getAddress() == null )
            return false;
        if(client.getState()== null )
            return false;
        if(client.getName() == null )
            return false;


        return true;
    }
}
