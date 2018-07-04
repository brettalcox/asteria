package com.bta.astro.asteria.entity;

import com.bta.astro.asteria.audit.Action;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "audit")
public class Audit extends AbstractEntity {

    @Column(name = "audit_timestamp")
    private Instant auditTimestamp;

    @Column(name = "actor")
    private String actor;

    @Column(name = "action")
    @Enumerated(value = EnumType.STRING)
    private Action action;

    @Column(name = "method")
    private String method;

    private Audit(Builder builder) {
        super(builder.guid);
        this.auditTimestamp = builder.auditTimestamp;
        this.actor = builder.actor;
        this.action = builder.action;
        this.method = builder.method;
    }

    public Instant getAuditTimestamp() {
        return auditTimestamp;
    }

    public String getActor() {
        return actor;
    }

    public Action getAction() {
        return action;
    }

    public String getMethod() {
        return method;
    }

    public static class Builder extends AbstractBuilder<Audit, Audit.Builder> {
        private Instant auditTimestamp;
        private String actor;
        private Action action;
        private String method;

        public Builder auditTimestamp(Instant auditTimestamp) {
            this.auditTimestamp = auditTimestamp;
            return this;
        }

        public Builder actor(String actor) {
            this.actor = actor;
            return this;
        }

        public Builder action(Action action) {
            this.action = action;
            return this;
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        @Override
        public Builder getThis() {
            return this;
        }

        @Override
        public Audit build() {
            return new Audit(this);
        }
    }
}
