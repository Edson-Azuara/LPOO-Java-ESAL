package com.gremio.service;

import com.gremio.model.Contacto;
import com.gremio.repository.ContactoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ContactoServiceTest {

    @Mock
    private ContactoRepository repository;

    @InjectMocks
    private ContactoService service;

    @Test
    void listarTodosDevuelveLosContactosDelRepositorio() {
        List<Contacto> contactos = List.of(new Contacto("Ana", "López", "ana@example.com", "8112345678"));
        when(repository.findAll()).thenReturn(contactos);

        assertSame(contactos, service.listarTodos());
    }

    @Test
    void guardarPersisteElContacto() {
        Contacto contacto = new Contacto("Ana", "López", "ana@example.com", "8112345678");

        service.guardar(contacto);

        verify(repository).save(contacto);
    }

    @Test
    void buscarPorIdDevuelveElResultadoDelRepositorio() {
        Contacto contacto = new Contacto("Ana", "López", "ana@example.com", "8112345678");
        when(repository.findById(7L)).thenReturn(Optional.of(contacto));

        assertEquals(Optional.of(contacto), service.buscarPorId(7L));
    }

    @Test
    void eliminarSolicitaAlRepositorioEliminarElContacto() {
        service.eliminar(7L);

        verify(repository).deleteById(7L);
    }
}
