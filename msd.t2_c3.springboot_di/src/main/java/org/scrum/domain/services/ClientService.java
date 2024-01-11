package org.scrum.domain.services;

import org.scrum.domain.project.Client;

public interface ClientService {
    Client findByUsername(String username);
}
