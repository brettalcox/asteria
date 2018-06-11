package com.bta.astro.asteria.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "guid", columnDefinition = "VARCHAR(36)")
    private String guid;

    public String getGuid() {
        return guid;
    }

    public abstract static class AbstractBuilder<T extends AbstractEntity, B extends AbstractBuilder<T, B>> {
        private String guid;

        public B guid(String guid) {
            this.guid = guid;
            return getThis();
        }

        public abstract B getThis();
        public abstract T build();
    }
}
