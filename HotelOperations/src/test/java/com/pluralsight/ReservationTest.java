package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    // RoomType Tests
    @Test
    public void testValidRoomTypeKing() {
        Reservation reservation = new Reservation();
        reservation.setRoomType("king");
        assertEquals("king", reservation.getRoomType());
    }

    @Test
    public void testValidRoomTypeDouble() {
        Reservation reservation = new Reservation();
        reservation.setRoomType("double");
        assertEquals("double", reservation.getRoomType());
    }

    @Test
    public void testInvalidRoomType() {
        Reservation reservation = new Reservation();
        reservation.setRoomType("double");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> reservation.setRoomType("queen"));
        assertEquals("Invalid RoomType: queen", exception.getMessage());
        assertEquals("double", reservation.getRoomType());
    }

    @Test
    public void testSetRoomTypeMultipleTimes() {
        Reservation reservation = new Reservation();
        reservation.setRoomType("king");
        double kingPrice = reservation.getPrice();
        assertEquals(139, reservation.getPrice());
        reservation.setRoomType("double");
        assertEquals(124, reservation.getPrice());
    }

    @Test
    public void testSetRoomTypeWithSpaces() {
        Reservation reservation = new Reservation();
        reservation.setRoomType("  king ");
        assertEquals("king", reservation.getRoomType());
        reservation.setRoomType(" double    ");
        assertEquals("double", reservation.getRoomType());
    }

    @Test
    public void testSetRoomTypeCaseInsensitivity() {
        Reservation reservation = new Reservation();
        reservation.setRoomType("KING");
        assertEquals("king", reservation.getRoomType());
        reservation.setRoomType("DoUBlE");
        assertEquals("double", reservation.getRoomType());
    }


    // Number of Nights Tests
    @Test
    public void testValidNumberOfNightsWeekend() {
        Reservation reservation = new Reservation();
        reservation.setWeekend(true);
        reservation.setNumberOfNights(2);
        assertEquals(2, reservation.getNumberOfNights());
    }

    @Test
    public void testInvalidNumberOfNightsWeekendTooLow() {
        Reservation reservation = new Reservation();
        reservation.setWeekend(true);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> reservation.setNumberOfNights(0));
        assertEquals("Too short of weekend: 0", exception.getMessage());
    }

    @Test
    public void testInvalidNumberOfNightsWeekendTooHigh() {
        Reservation reservation = new Reservation();
        reservation.setWeekend(true);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> reservation.setNumberOfNights(3));
        assertEquals("Too long of weekend: 3", exception.getMessage());
    }

    @Test
    public void testGetNumberOfNightsAfterSetting() {
        Reservation reservation = new Reservation();
        reservation.setNumberOfNights(1);
        assertEquals(1, reservation.getNumberOfNights());
        reservation.setNumberOfNights(2);
        assertEquals(2, reservation.getNumberOfNights());
        reservation.setNumberOfNights(3);
        assertEquals(3, reservation.getNumberOfNights());
        reservation.setNumberOfNights(4);
        assertEquals(4, reservation.getNumberOfNights());
        reservation.setNumberOfNights(5);
        assertEquals(5, reservation.getNumberOfNights());
    }


    // Weekend Tests
    @Test
    public void testSetWeekendTrue() {
        Reservation reservation = new Reservation();
        reservation.setWeekend(true);
        assertEquals(true, reservation.isWeekend());
    }

    @Test
    public void testSetWeekendFalse() {
        Reservation reservation = new Reservation();
        reservation.setWeekend(false);
        assertEquals(false, reservation.isWeekend());
    }

    @Test
    public void testDefaultWeekendFlagValue() {
        Reservation reservation = new Reservation();
        assertFalse(reservation.isWeekend());
    }

    @Test
    public void testToggleWeekendFlag() {
        Reservation reservation = new Reservation();
        reservation.setWeekend(true);
        assertTrue(reservation.isWeekend());
        reservation.setWeekend(false);
        assertFalse(reservation.isWeekend());
    }


    // Pricing Tests
    @Test
    public void testGetPriceForKingRoom() {
        Reservation reservation = new Reservation();
        reservation.setRoomType("king");
        assertEquals(139, reservation.getPrice());
    }

    @Test
    public void testGetPriceForDoubleRoom() {
        Reservation reservation = new Reservation();
        reservation.setRoomType("double");
        assertEquals(124, reservation.getPrice());
    }


    // Reservation Total Tests
    @Test
    public void testGetReservationTotalForKingRoomOnWeekday() {
        Reservation reservation = new Reservation();
        reservation.setRoomType("king");
        reservation.setWeekend(false);
        reservation.setNumberOfNights(3);

        double expectedTotal = 139 * 3; // No weekend charge
        assertEquals(expectedTotal, reservation.getReservationTotal());
    }

    @Test
    public void testGetReservationTotalForDoubleRoomOnWeekday() {
        Reservation reservation = new Reservation();
        reservation.setRoomType("double");
        reservation.setWeekend(false);
        reservation.setNumberOfNights(3);

        double expectedTotal = 124 * 3; // No weekend charge
        assertEquals(expectedTotal, reservation.getReservationTotal());
    }

    @Test
    public void testGetReservationTotalForKingRoomOnWeekend() {
        Reservation reservation = new Reservation();
        reservation.setRoomType("king");
        reservation.setWeekend(true);
        reservation.setNumberOfNights(2);

        double expectedTotal = (139 + (139.00 / 10)) * 2; // 10% extra charge for weekend
        assertEquals(expectedTotal, reservation.getReservationTotal());
    }

    @Test
    public void testGetReservationTotalForDoubleRoomOnWeekend() {
        Reservation reservation = new Reservation();
        reservation.setRoomType("double");
        reservation.setWeekend(true);
        reservation.setNumberOfNights(2);

        double expectedTotal = (124 + (124.00 / 10)) * 2; // 10% extra charge for weekend
        assertEquals(expectedTotal, reservation.getReservationTotal());
    }

    // Edge Case Tests
    @Test
    public void testSetRoomTypeNullException() {
        Reservation reservation = new Reservation();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> reservation.setRoomType(null));
        assertEquals("RoomType Cannot Be Null!", exception.getMessage());
    }


    @Test
    public void testSetNegativeNumberOfNights() {
        Reservation reservation = new Reservation();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> reservation.setNumberOfNights(-1));
        assertEquals("NumberOfNights Cannot Be Negative!", exception.getMessage());
    }

    @Test
    public void testGetPriceWhenRoomTypeIsUnset() {
        Reservation reservation = new Reservation();
        Exception exception = assertThrows(IllegalArgumentException.class, reservation::getPrice);
        assertEquals("RoomType Cannot Be Null!: Please Set RoomType!", exception.getMessage());
    }

}