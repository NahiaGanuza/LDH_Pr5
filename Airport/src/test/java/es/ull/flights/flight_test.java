package es.ull.flights;

import org.junit.jupiter.api.*;

import es.ull.passengers.Passenger;

import static org.junit.jupiter.api.Assertions.*;

public class flight_test {
    
    private Flight flight;
    private Passenger passenger1;
    private Passenger passenger2;

    @BeforeEach
    public void setUp() {
        // Configuración inicial para las pruebas
        flight = new Flight("AB123", 2); // Se crea un vuelo con 2 asientos disponibles
        passenger1 = new Passenger("ID1", "John", "US");
        passenger2 = new Passenger("ID2", "Jane", "UK");
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
    public void testAddPassengerWhenSeatsAvailable() {
        assertTrue(flight.addPassenger(passenger1)); // Agrega el primer pasajero
        assertEquals(1, flight.getNumberOfPassengers()); // Verifica que se agregó el pasajero
    }

}