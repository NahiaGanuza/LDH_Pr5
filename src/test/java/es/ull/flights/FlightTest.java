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

    /**
     * Test case to verify the behavior of the Flight constructor when an invalid flight number is provided.
     */
    @Test
    public void testInvalidFlightNumber() {
        // Definir un número de vuelo que no cumpla con el patrón regex esperado
        String invalidFlightNumber = "InvalidFlightNumber";

        // Se espera que el constructor lance una RuntimeException debido a un número de vuelo inválido
        assertThrows(RuntimeException.class, () -> new Flight(invalidFlightNumber, 100));
 
    }

    /**
     * Test case for the constructor with a valid flight number.
     */
    @Test
    public void testConstructorValidFlightNumber() {
        String validFlightNumber = "AB123";
        int seats = 100;

        Flight flight = new Flight(validFlightNumber, seats);

        assertNotNull(flight);
        assertEquals(validFlightNumber, flight.getFlightNumber());
        assertEquals(seats, flight.getSeats());
    }

    /**
     * Test case for the getFlightNumber() method.
     * 
     * This test verifies that the correct flight number is returned by the getFlightNumber() method.
     */
    @Test
    public void testGetFlightNumber() {
        assertEquals("AB123", flight.getFlightNumber());
    }

    /**
     * Test case for the getSeats() method.
     */
    @Test
    public void testGetSeats() {
        assertEquals(2, flight.getSeats());
    }

    /**
     * Test case for the getNumberOfPassengers method.
     */
    @Test
    public void testGetNumberOfPassengers() {
        assertEquals(0, flight.getNumberOfPassengers());
    }
        
    /**
     * Test case for the addPassenger method.
     * It verifies that a passenger is successfully added to the flight and the number of passengers is updated accordingly.
     */
    @Test
    public void testAddPassenger() {
        assertTrue(flight.addPassenger(passenger1));
        assertEquals(1, flight.getNumberOfPassengers());
    }

    /**
     * Test case to verify that adding passengers to a flight exceeds the available seats.
     * It checks if the flight allows adding two passengers successfully, and then attempts to add a third passenger,
     * expecting a RuntimeException to be thrown.
     */
    @Test
    public void testAddPassengerExceedSeats() {
        assertTrue(flight.addPassenger(passenger1));
        assertTrue(flight.addPassenger(passenger2));
        assertEquals(2, flight.getNumberOfPassengers());
        assertThrows(RuntimeException.class, () -> flight.addPassenger(passenger3));
    }
    
    /**
    * Test case for the removePassenger() method.
    * It verifies that a passenger is successfully removed from the flight.
    */
    @Test
    public void testRemovePassenger() {
        flight.addPassenger(passenger1);
        assertEquals(true, flight.removePassenger(passenger1));
        assertEquals(0, flight.getNumberOfPassengers());
    }

}
