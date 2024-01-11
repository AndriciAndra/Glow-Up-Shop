package org.scrum.domain.services;

import org.scrum.domain.project.Client;
import java.util.List;

public interface ClientService {
    Client findByUsername(String username);
    Client saveClient(Client client);
    List<Client> getAllClients();
}
