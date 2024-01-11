package org.scrum.domain.services.servicesImpl;

import lombok.RequiredArgsConstructor;
import org.scrum.domain.project.Client;
import org.scrum.domain.repositories.ClientRepository;
import org.scrum.domain.services.ClientService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    @Override
    public Client findByUsername(String username) {
        return clientRepository.findByUsername(username);
    }
}
