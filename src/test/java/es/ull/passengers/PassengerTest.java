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


}
