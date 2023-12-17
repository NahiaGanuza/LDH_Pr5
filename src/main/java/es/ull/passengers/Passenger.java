/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
package es.ull.passengers;

import java.util.Arrays;
import java.util.Locale;

import es.ull.flights.Flight;

/**
 * Represents a passenger with an identifier, name, and country code.
 */
public class Passenger {

    private String identifier;
    private String name;
    private String countryCode;
    private Flight flight;
    
    /**
     * Constructs a new Passenger object with the specified identifier, name, and country code.
     * 
     * @param identifier the identifier of the passenger
     * @param name the name of the passenger
     * @param countryCode the country code of the passenger's country
     * @throws RuntimeException if the country code is invalid
     */
    public Passenger(String identifier, String name, String countryCode) {
        if (!Arrays.asList(Locale.getISOCountries()).contains(countryCode)) {
            throw new RuntimeException("Invalid country code");
        }

        this.identifier = identifier;
        this.name = name;
        this.countryCode = countryCode;
    }

    /**
     * Returns the identifier of the passenger.
     *
     * @return the identifier of the passenger
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Returns the name of the passenger.
     *
     * @return the name of the passenger
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the country code of the passenger.
     *
     * @return the country code of the passenger
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Returns the flight associated with this passenger.
     *
     * @return the flight associated with this passenger
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * Joins the specified flight by removing the passenger from its previous flight (if any)
     * and adding it to the new flight.
     * 
     * @param flight the flight to join
     * @throws RuntimeException if the passenger cannot be removed from the previous flight or added to the new flight
     */
    public void joinFlight(Flight flight) {
        Flight previousFlight = this.flight;
        if (null != previousFlight) {
            if (!previousFlight.removePassenger(this)) {
                throw new RuntimeException("Cannot remove passenger");
            }
        }
        setFlight(flight);
        if (null != flight) {
            if (!flight.addPassenger(this)) {
                throw new RuntimeException("Cannot add passenger");
            }
        }
    }

    /**
     * Sets the flight for the passenger.
     * 
     * @param flight the flight to set
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    /**
     * Returns a string representation of the Passenger object.
     * The string includes the passenger's name, identifier, and country code.
     *
     * @return a string representation of the Passenger object
     */
    @Override
    public String toString() {
        return "Passenger " + getName() + " with identifier: " + getIdentifier() + " from " + getCountryCode();
    }
}

