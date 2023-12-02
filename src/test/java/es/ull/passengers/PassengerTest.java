package es.ull.passengers;
import es.ull.flights.Flight;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;



public class PassengerTest {
    
    private Flight flight;

    @BeforeEach
    public void setUp() {
        // Crear un vuelo de ejemplo para usar en las pruebas
        flight = new Flight("AB123", 100);
    }

    @Test
    public void testConstructorPassenger() {
        String identifier = "ABC123";
        String name = "John Doe";
        String validCountryCode = "US";

        Passenger passenger = new Passenger(identifier, name, validCountryCode);

        assertNotNull(passenger);
        assertEquals(identifier, passenger.getIdentifier());
        assertEquals(name, passenger.getName());
        assertEquals(validCountryCode, passenger.getCountryCode());
    }


}
