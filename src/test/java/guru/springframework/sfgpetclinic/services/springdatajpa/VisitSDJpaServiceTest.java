package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    VisitSDJpaService service;

    @DisplayName("Test Find All")
    @Test
    void findAll() {
        Visit visit = new Visit();
        Set<Visit> visits = new HashSet<>();
        visits.add(visit);
        when(visitRepository.findAll()).thenReturn(visits);
        Set<Visit> foundVisits = service.findAll();
        verify(visitRepository).findAll();
        assertThat(foundVisits).hasSize(1);

    }

    @Test
    void deleteById() {
        service.deleteById(1l);
        verify(visitRepository).deleteById(1L);
    }

    @Test
    void testdeleteByObject () {
        Visit visit = new Visit();
        service.delete(visit);
        verify(visitRepository).delete(any(Visit.class));
    }

    @Test
    void testSave() {
        Visit visit = new Visit();
        service.save(visit);
        verify(visitRepository).save(any(Visit.class));

    }

    @Test
    void testFindById() {
        Visit visit = new Visit();
        when(visitRepository.findById(1l)).thenReturn(Optional.of(visit));
        Visit foundVisit = service.findById(1l);
        assertNotNull(foundVisit);
        verify(visitRepository).findById(1l);
        verify(visitRepository).findById(anyLong());
    }

}