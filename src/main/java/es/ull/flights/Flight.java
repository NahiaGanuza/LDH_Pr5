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
package es.ull.flights;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.ull.passengers.Passenger;

/**
 * Represents a flight with a flight number and a number of seats.
 * Passengers can be added or removed from the flight.
 */
public class Flight {

    private String flightNumber;
    private int seats;
    private Set<Passenger> passengers = new HashSet<>();

    private static String flightNumberRegex = "^[A-Z]{2}\\d{3,4}$";
    private static Pattern pattern = Pattern.compile(flightNumberRegex);

    /**
     * Constructs a Flight object with the given flight number and number of seats.
     * 
     * @param flightNumber the flight number
     * @param seats the number of seats
     * @throws RuntimeException if the flight number is invalid
     */
    public Flight(String flightNumber, int seats) {
        Matcher matcher = pattern.matcher(flightNumber);
        if (!matcher.matches()) {
            throw new RuntimeException("Invalid flight number");
        }
        this.flightNumber = flightNumber;
        this.seats = seats;
    }

    /**
     * Returns the flight number.
     *
     * @return the flight number as a String
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Returns the number of seats available in the flight.
     *
     * @return the number of seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Returns the number of passengers on the flight.
     *
     * @return the number of passengers
     */
    public int getNumberOfPassengers() {
        return passengers.size();
    }

    /**
     * Adds a passenger to the flight.
     * 
     * @param passenger the passenger to be added
     * @return true if the passenger was successfully added, false otherwise
     * @throws RuntimeException if there are not enough seats for the flight
     */
    public boolean addPassenger(Passenger passenger) {
        if (getNumberOfPassengers() >= seats) {
            throw new RuntimeException("Not enough seats for flight " + getFlightNumber());
        }
        passenger.setFlight(this);
        return passengers.add(passenger);
    }

    /**
     * Removes a passenger from the flight.
     * 
     * @param passenger the passenger to be removed
     * @return true if the passenger was successfully removed, false otherwise
     */
    public boolean removePassenger(Passenger passenger) {
        passenger.setFlight(null);
        return passengers.remove(passenger);
    }
}

