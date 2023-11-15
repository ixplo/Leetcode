package org.example;

import org.example.audit.AuditService;
import org.example.audit.UserAction;
import org.example.audit.UserActionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuditServiceTest {

    @Mock
    private UserActionRepository userActionRepository;

    @InjectMocks
    private AuditService auditService;

    @Captor
    private ArgumentCaptor<UserAction> userActionCaptor;

    @Test
    void reportAuditTest() {
        auditService.reportAudit();
        verify(userActionRepository).save(userActionCaptor.capture());

        assertEquals("test", userActionCaptor.getValue().getRequestId());
    }
}
