package org.scrum.domain.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.scrum.domain.project.Client;
import org.scrum.domain.repositories.ClientRepository;
import org.scrum.domain.services.servicesImpl.ClientServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindByUsername() {
        Client mockClient = new Client();
        mockClient.setUsername("testUser");
        when(clientRepository.findByUsername("testUser")).thenReturn(mockClient);

        Client result = clientService.findByUsername("testUser");

        assertEquals("testUser", result.getUsername());

        verify(clientRepository, times(1)).findByUsername("testUser");
    }

    @Test
    void testSaveClient() {
        Client clientToSave = new Client();
        clientToSave.setUsername("newUser");
        when(clientRepository.save(any())).thenReturn(clientToSave);

        Client result = clientService.saveClient(clientToSave);

        assertEquals("newUser", result.getUsername());

        verify(clientRepository, times(1)).save(clientToSave);
    }

    @Test
    void testGetAllClients() {
        List<Client> mockClients = Arrays.asList(
                new Client(), new Client()
        );
        when(clientRepository.findAll()).thenReturn(mockClients);

        List<Client> result = clientService.getAllClients();
        assertEquals(2, result.size());
        verify(clientRepository, times(1)).findAll();
    }
}
