package org.example.audit;

public class AuditService {

    private UserActionRepository userActionRepository;

    public void reportAudit() {
        UserAction userAction = new UserAction();
        userAction.setRequestId("test");
        userActionRepository.save(userAction);
    }
}
