package com.flab.collaboshoppingapi.service;

import com.flab.collaboshoppingapp.repository.BankRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BankServiceTest {

    @InjectMocks
    private BankService bookService;

    @Mock
    private BankRepository bookRepository;

    @Test
    void purchase_not_existing_book_throws_exception() {


        Assertions.assertThrows(EntityNotFoundException.class, () -> bookService.search("001"));
    }
}