package com.bta.astro.asteria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "astronomical_objects")
public class AstronomicalObject extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "otherNames")
    private String otherNames;

    @Column(name = "type")
    private String type;

    @Column(name = "constellation")
    private String constellation;

    @Column(name = "rightAscension")
    private String rightAscension;

    @Column(name = "declination")
    private String declination;

    @Column(name = "apparentMagnitude")
    private String apparentMagnitude;

    private AstronomicalObject(Builder builder) {
        super(builder.guid);
        this.name = builder.name;
        this.otherNames = builder.otherNames;
        this.type = builder.type;
        this.constellation = builder.constellation;
        this.rightAscension = builder.rightAscension;
        this.declination = builder.declination;
        this.apparentMagnitude = builder.apparentMagnitude;
    }

    protected AstronomicalObject() {
        super();
    }

    public String getName() {
        return name;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public String getType() {
        return type;
    }

    public String getConstellation() {
        return constellation;
    }

    public String getRightAscension() {
        return rightAscension;
    }

    public String getDeclination() {
        return declination;
    }

    public String getApparentMagnitude() {
        return apparentMagnitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AstronomicalObject object = (AstronomicalObject) o;
        return Objects.equals(name, object.name) &&
                Objects.equals(otherNames, object.otherNames) &&
                Objects.equals(type, object.type) &&
                Objects.equals(constellation, object.constellation) &&
                Objects.equals(rightAscension, object.rightAscension) &&
                Objects.equals(declination, object.declination) &&
                Objects.equals(apparentMagnitude, object.apparentMagnitude);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, otherNames, type, constellation, rightAscension, declination, apparentMagnitude);
    }

    @Override
    public String toString() {
        return "AstronomicalObject{" +
                "name='" + name + '\'' +
                ", otherNames='" + otherNames + '\'' +
                ", type='" + type + '\'' +
                ", constellation='" + constellation + '\'' +
                ", rightAscension='" + rightAscension + '\'' +
                ", declination='" + declination + '\'' +
                ", apparentMagnitude=" + apparentMagnitude +
                '}';
    }

    public static class Builder extends AbstractBuilder<AstronomicalObject, AstronomicalObject.Builder> {
        private String name;
        private String otherNames;
        private String type;
        private String constellation;
        private String rightAscension;
        private String declination;
        private String apparentMagnitude;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder otherNames(String otherNames) {
            this.otherNames = otherNames;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder constellation(String constellation) {
            this.constellation = constellation;
            return this;
        }

        public Builder rightAscension(String rightAscension) {
            this.rightAscension = rightAscension;
            return this;
        }

        public Builder declination(String declination) {
            this.declination = declination;
            return this;
        }

        public Builder apparentMagnitude(String apparentMagnitude) {
            this.apparentMagnitude = apparentMagnitude;
            return this;
        }

        @Override
        public Builder getThis() {
            return this;
        }

        @Override
        public AstronomicalObject build() {
            return new AstronomicalObject(this);
        }
    }
}
