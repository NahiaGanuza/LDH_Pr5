package es.ull.flights;

import org.junit.jupiter.api.*;

import es.ull.passengers.Passenger;

import static org.junit.jupiter.api.Assertions.*;

public class FlightTest {
    
    private Flight flight;
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;

    @BeforeEach
    public void setUp() {
        // Configuración inicial para las pruebas
        flight = new Flight("AB123", 2); // Se crea un vuelo con 2 asientos disponibles
        passenger1 = new Passenger("ID1", "John", "US");
        passenger2 = new Passenger("ID2", "Jane", "ES");
        passenger3 = new Passenger("ID3", "Marie", "ES");
    }

    @Test
    public void testInvalidFlightNumber() {
        // Definir un número de vuelo que no cumpla con el patrón regex esperado
        String invalidFlightNumber = "InvalidFlightNumber";

        // Se espera que el constructor lance una RuntimeException debido a un número de vuelo inválido
        assertThrows(RuntimeException.class, () -> new Flight(invalidFlightNumber, 100));
 
    }

    @Test
    public void testConstructorValidFlightNumber() {
        String validFlightNumber = "AB123";
        int seats = 100;

        Flight flight = new Flight(validFlightNumber, seats);

        assertNotNull(flight);
        assertEquals(validFlightNumber, flight.getFlightNumber());
        assertEquals(seats, flight.getSeats());
    }

    @Test
    public void testGetFlightNumber() {
        assertEquals("AB123", flight.getFlightNumber());
    }

    @Test
    public void testGetSeats() {
        assertEquals(2, flight.getSeats());
    }

    @Test
    public void testGetNumberOfPassengers() {
        assertEquals(0, flight.getNumberOfPassengers());
    }
        
    @Test
    public void testAddPassenger() {
        assertTrue(flight.addPassenger(passenger1));
        assertEquals(1, flight.getNumberOfPassengers());
    }

    @Test
    public void testAddPassengerExceedSeats() {
        assertTrue(flight.addPassenger(passenger1));
        assertTrue(flight.addPassenger(passenger2));
        assertEquals(2, flight.getNumberOfPassengers());
        assertThrows(RuntimeException.class, () -> flight.addPassenger(passenger3));
    }
    
    @Test
    public void testRemovePassenger() {
        flight.addPassenger(passenger1);
        assertEquals(true, flight.removePassenger(passenger1));
        assertEquals(0, flight.getNumberOfPassengers());
    }

}
