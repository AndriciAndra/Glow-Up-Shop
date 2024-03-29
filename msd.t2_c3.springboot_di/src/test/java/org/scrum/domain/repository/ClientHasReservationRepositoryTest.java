package org.scrum.domain.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.scrum.domain.project.ClientHasReservation;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientHasReservationRepositoryTest {

    @Mock
    private ClientHasReservationRepository clientHasReservationRepository;

    @InjectMocks
    private ClientHasReservationRepositoryTest clientHasReservationRepositoryTest;

    @Test
    void testFindById() {
        ClientHasReservation clientHasReservation = new ClientHasReservation();
        clientHasReservation.setId(1);

        when(clientHasReservationRepository.findById(1)).thenReturn(Optional.of(clientHasReservation));

        Optional<ClientHasReservation> result = clientHasReservationRepositoryTest.clientHasReservationRepository.findById(1);

        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(1);

        verify(clientHasReservationRepository, times(1)).findById(1);
    }


}
