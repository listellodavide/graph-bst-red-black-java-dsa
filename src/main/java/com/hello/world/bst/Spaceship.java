package com.hello.world.bst;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.UUID;

public final class Spaceship extends BasicDataType {

    Double numberOfAliensOnboard;

    BigDecimal trustPower;

    BigDecimal thoriumFuelLevel;

    BigDecimal speedTickets;

    BigDecimal distanceFromEarth;

    BigDecimal distanceFromSolarSystem;

    BigInteger oxygenLevel;

    BigInteger pressureLevel;

    BigInteger gravityLevel;

    Boolean vitalSignsAreOK;

    public Spaceship(Double numberOfAliensOnboard, BigDecimal trustPower, BigDecimal thoriumFuelLevel, BigDecimal speedTickets, BigDecimal distanceFromEarth, BigDecimal distanceFromSolarSystem, BigInteger oxygenLevel, BigInteger pressureLevel, BigInteger gravityLevel, Boolean vitalSignsAreOK) {
        super();
        this.numberOfAliensOnboard = numberOfAliensOnboard;
        this.trustPower = trustPower;
        this.thoriumFuelLevel = thoriumFuelLevel;
        this.speedTickets = speedTickets;
        this.distanceFromEarth = distanceFromEarth;
        this.distanceFromSolarSystem = distanceFromSolarSystem;
        this.oxygenLevel = oxygenLevel;
        this.pressureLevel = pressureLevel;
        this.gravityLevel = gravityLevel;
        this.vitalSignsAreOK = vitalSignsAreOK;
    }

    public Spaceship(UUID id, Double numberOfAliensOnboard, BigDecimal trustPower, BigDecimal thoriumFuelLevel, BigDecimal speedTickets, BigDecimal distanceFromEarth, BigDecimal distanceFromSolarSystem, BigInteger oxygenLevel, BigInteger pressureLevel, BigInteger gravityLevel, Boolean vitalSignsAreOK) {
        super(id);
        this.numberOfAliensOnboard = numberOfAliensOnboard;
        this.trustPower = trustPower;
        this.thoriumFuelLevel = thoriumFuelLevel;
        this.speedTickets = speedTickets;
        this.distanceFromEarth = distanceFromEarth;
        this.distanceFromSolarSystem = distanceFromSolarSystem;
        this.oxygenLevel = oxygenLevel;
        this.pressureLevel = pressureLevel;
        this.gravityLevel = gravityLevel;
        this.vitalSignsAreOK = vitalSignsAreOK;
    }

    public Spaceship(Integer weight, Double numberOfAliensOnboard, BigDecimal trustPower, BigDecimal thoriumFuelLevel, BigDecimal speedTickets, BigDecimal distanceFromEarth, BigDecimal distanceFromSolarSystem, BigInteger oxygenLevel, BigInteger pressureLevel, BigInteger gravityLevel, Boolean vitalSignsAreOK) {
        super(weight);
        this.numberOfAliensOnboard = numberOfAliensOnboard;
        this.trustPower = trustPower;
        this.thoriumFuelLevel = thoriumFuelLevel;
        this.speedTickets = speedTickets;
        this.distanceFromEarth = distanceFromEarth;
        this.distanceFromSolarSystem = distanceFromSolarSystem;
        this.oxygenLevel = oxygenLevel;
        this.pressureLevel = pressureLevel;
        this.gravityLevel = gravityLevel;
        this.vitalSignsAreOK = vitalSignsAreOK;
    }

    @Override
    public String toString() {
        return "Spaceship{" +
                "numberOfAliensOnboard=" + numberOfAliensOnboard +
                ", trustPower=" + trustPower +
                ", thoriumFuelLevel=" + thoriumFuelLevel +
                ", speedTickets=" + speedTickets +
                ", distanceFromEarth=" + distanceFromEarth +
                ", distanceFromSolarSystem=" + distanceFromSolarSystem +
                ", oxygenLevel=" + oxygenLevel +
                ", pressureLevel=" + pressureLevel +
                ", gravityLevel=" + gravityLevel +
                ", vitalSignsAreOK=" + vitalSignsAreOK +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Spaceship spaceship = (Spaceship) o;
        return Objects.equals(numberOfAliensOnboard, spaceship.numberOfAliensOnboard) && Objects.equals(trustPower, spaceship.trustPower) && Objects.equals(thoriumFuelLevel, spaceship.thoriumFuelLevel) && Objects.equals(speedTickets, spaceship.speedTickets) && Objects.equals(distanceFromEarth, spaceship.distanceFromEarth) && Objects.equals(distanceFromSolarSystem, spaceship.distanceFromSolarSystem) && Objects.equals(oxygenLevel, spaceship.oxygenLevel) && Objects.equals(pressureLevel, spaceship.pressureLevel) && Objects.equals(gravityLevel, spaceship.gravityLevel) && Objects.equals(vitalSignsAreOK, spaceship.vitalSignsAreOK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfAliensOnboard, trustPower, thoriumFuelLevel, speedTickets, distanceFromEarth, distanceFromSolarSystem, oxygenLevel, pressureLevel, gravityLevel, vitalSignsAreOK);
    }
}
