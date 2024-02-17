package com.flab.collaboshoppingapi.service;

import com.flab.collaboshoppingapi.TestConfiguration;
import com.flab.collaboshoppingapp.repository.BankRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.ArgumentMatchers.anyString;

@ContextConfiguration(classes = TestConfiguration.class)
@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class BankServiceTest {

    @InjectMocks
    private BankService bookService;

    @Mock
    private BankRepository bookRepository;

    @Test
    public void purchase_not_existing_book_throws_exception() {
        Mockito.when(bookRepository.findByCode(anyString())).thenReturn(null);

        Assertions.assertThrows(EntityNotFoundException.class, () -> bookService.search("001"));
    }
}