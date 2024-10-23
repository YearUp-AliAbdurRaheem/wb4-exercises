package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    Room room = new Room(2, 100, false, false);
    Room room2 = new Room(2, 100.0, false, true);
    Room room3 = new Room(2, 100.0, true, false);
    Room room4 = new Room(2, 100.0, true, true);

    @Test
    public void testRoomConstructor() {

        assertEquals(2, room.getNumberOfBeds());
        assertEquals(100.0, room.getPrice());
        assertFalse(room.isOccupied());
        assertFalse(room.isDirty());
    }

    @Test
    public void testCheckIn() throws Exception {
        room.checkIn();
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void testCheckInFailsIfOccupied() {
        room = new Room(2, 100.0, true, false);
        Exception exception = assertThrows(Exception.class, () -> room.checkIn());
        assertEquals("Error: The room is occupied.", exception.getMessage());
    }



    @Test
    public void testCheckInFailsIfDirty() {
        room = new Room(2, 100.0, false, true);
        Exception exception = assertThrows(Exception.class, () -> room.checkIn());
        assertEquals("Error: The room is dirty.", exception.getMessage());
    }

    @Test
    public void testCheckInFailsIfOccupiedAndDirty() {
        room = new Room(2, 100.0, true, true);
        Exception exception = assertThrows(Exception.class, () -> room.checkIn());
        assertEquals("Error: The room is occupied and dirty.", exception.getMessage());
    }

    @Test
    public void testCheckOutSuccess() throws Exception {
        // Set the room to occupied
        room.checkIn();
        room.checkOut();
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty()); // After checkout, the room should be dirty
    }

    @Test
    public void testCheckOutFailsWhenUnoccupied() {
        // The room is not occupied, so checkOut should fail
        Exception exception = assertThrows(Exception.class, () -> room.checkOut());
        assertEquals("Error: The room is unoccupied.", exception.getMessage());
    }

    @Test
    public void testCleanRoom() throws Exception {
        // Set the room to dirty and then clean it
        room.checkIn(); // Room becomes dirty after check-in
        room.cleanRoom();
        assertFalse(room.isDirty());
    }

    @Test
    public void testIsAvailableReturnsFalseWhenRoomIsNotOccupied() {
        assertFalse(room.isAvailable()); // It is Not occupied and not dirty
    }

    @Test
    public void testIsAvailableReturnsTrueWhenRoomIsOccupiedAndDirty() throws Exception {
        room.checkIn(); // It is Occupied and dirty after user check-in
        assertTrue(room.isAvailable());
    }

}