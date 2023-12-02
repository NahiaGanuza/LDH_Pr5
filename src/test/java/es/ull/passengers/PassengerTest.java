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
    public void testInvalidCountryCodeConstructor() {
        // Se espera que el constructor lance una RuntimeException para un código de país inválido
        assertThrows(RuntimeException.class, () -> new Passenger("ID001", "John Doe", "INVALID"));
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
    public void testJoinFlight_AddPassengerFails() {
        // Configuración del mock de Flight con comportamiento para simular un fallo al agregar un pasajero
        Flight mockFlight = mock(Flight.class);
        when(mockFlight.addPassenger(any())).thenReturn(false);

        Passenger passenger = new Passenger("ID001", "John Doe", "US");
        passenger.setFlight(new Flight("AB123", 100)); // Establecer un vuelo previo

        // Se espera una RuntimeException porque no se puede agregar el pasajero al nuevo vuelo
        assertThrows(RuntimeException.class, () -> passenger.joinFlight(mockFlight));
    }

    @Test
    public void testSetFlight() {
        passenger.setFlight(flight);
        assertEquals(flight, passenger.getFlight());
    }

    @Test
    public void testSetFlightNull() {
        passenger.setFlight(flight);
        passenger.setFlight(null);
        assertNull(passenger.getFlight());
        assertEquals(0, flight.getNumberOfPassengers());
    }    

    @Test
    public void testToString() {
        assertEquals("Passenger John Doe with identifier: ID001 from US", passenger.toString());
    } 

}
