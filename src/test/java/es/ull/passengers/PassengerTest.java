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

    /**
    * Test case to verify that a RuntimeException is thrown when an invalid country code is provided to the constructor.
    */
    @Test
    void testInvalidCountryCodeConstructor() {
        // Se espera que el constructor lance una RuntimeException para un código de país inválido
        assertThrows(RuntimeException.class, () -> new Passenger("ID001", "John Doe", "INVALID"));
    }

    /**
    * Test case for the constructor of the Passenger class.
    * It verifies that the constructor initializes the passenger object correctly.
    */
    @Test
    void testConstructorPassenger() {
        assertNotNull(passenger);
        assertEquals("ID001", passenger.getIdentifier());
        assertEquals("John Doe", passenger.getName());
        assertEquals("US", passenger.getCountryCode());
    }

    /**
     * Test case for the getIdentifier() method.
     */
    @Test
    void testGetIdentifier() {
        assertEquals("ID001", passenger.getIdentifier());
    }

    /**
     * Test case for the getName() method.
     */
    @Test
    void testGetName() {
        assertEquals("John Doe", passenger.getName());
    }
    
    /**
     * Test case for the getCountryCode() method.
     */
    @Test
    void testGetCountryCode() {
        assertEquals("US", passenger.getCountryCode());
    }

    /**
    * Test case to verify that the initial flight of a passenger is null.
    */
    @Test
    void testGetFlightInitiallyNull() {
        assertNull(passenger.getFlight());
    }

    /**
     * Test case for the joinFlight method.
     * 
     * This test verifies that the passenger is successfully joined to a flight.
     * It checks if the passenger's flight is set correctly and if the number of passengers in the flight is updated.
     */
    @Test
    void testJoinFlight() {
        passenger.joinFlight(flight);
        assertEquals(flight, passenger.getFlight());
        assertEquals(1, flight.getNumberOfPassengers());
    }

    /**
     * Test case for the setFlight method in the Passenger class.
     * It verifies that the setFlight method correctly sets the flight for a passenger.
     */
    @Test
    void testSetFlight() {
        passenger.setFlight(flight);
        assertEquals(flight, passenger.getFlight());
    }

    /**
    * Test case to verify the behavior of the `setFlight` method when setting the flight to null.
    * It checks if the passenger's flight is set to null and if the number of passengers in the flight is updated accordingly.
    */
    @Test
    void testSetFlightNull() {
        passenger.setFlight(flight);
        passenger.setFlight(null);
        assertNull(passenger.getFlight());
        assertEquals(0, flight.getNumberOfPassengers());
    }    

    /**
     * Test case for the toString() method of the Passenger class.
     * It verifies that the toString() method returns the expected string representation of a Passenger object.
     */
    @Test
    void testToString() {
        assertEquals("Passenger John Doe with identifier: ID001 from US", passenger.toString());
    } 

}