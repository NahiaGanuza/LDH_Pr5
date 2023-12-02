package es.ull.passengers;
import es.ull.flights.Flight;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;



public class PassengerTest {
    
    private Flight flight;
    private Passenger passenger;

    @BeforeEach
    public void setUp() {
        // Crear un vuelo de ejemplo para usar en las pruebas
        passenger = new Passenger("ID001", "John Doe", "US");
        flight = new Flight("AB123", 100);
    }

    @Test
    public void testConstructorPassenger() {
        assertNotNull(passenger);
        assertEquals("ID001", passenger.getIdentifier());
        assertEquals("John Doe", passenger.getName());
        assertEquals("US", passenger.getCountryCode());
    }

    @Test
    public void testGetIdentifier() {
        assertEquals("ID001", passenger.getIdentifier());
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", passenger.getName());
    }

    @Test
    public void testGetCountryCode() {
        assertEquals("US", passenger.getCountryCode());
    }

    @Test
    public void testGetFlightInitiallyNull() {
        assertNull(passenger.getFlight());
    }

    @Test
    public void testJoinFlight() {
        passenger.joinFlight(flight);
        assertEquals(flight, passenger.getFlight());
        assertEquals(1, flight.getNumberOfPassengers());
    }

    @Test
    public void testSetFlight() {
        passenger.setFlight(flight);
        assertEquals(flight, passenger.getFlight());
    }    

    @Test
    public void testToString() {
        assertEquals("Passenger John Doe with identifier: ID001 from US", passenger.toString());
    } 

}
