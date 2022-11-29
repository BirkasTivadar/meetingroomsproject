package meetingrooms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Office {

    private final List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        meetingRooms.forEach(meetingRoom -> System.out.println(meetingRoom.getName()));
    }


    public void printNamesReverse() {
        List<MeetingRoom> meetingRoomsReverse = new ArrayList<>(meetingRooms);
        Collections.reverse(meetingRoomsReverse);
        meetingRoomsReverse.forEach(meetingRoom -> System.out.println(meetingRoom.getName()));
    }

    public void printEventNames() {
        IntStream.range(0, meetingRooms.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(meetingRooms::get)
                .forEach(meetingRoom -> System.out.println(meetingRoom.getName()));
    }

    public void printAreas() {
        meetingRooms.forEach(meetingRoom -> System.out.printf("A tárgyaló neve: %s, szélessége: %d, hosszúsága: %d, területe: %d%n", meetingRoom.getName(), meetingRoom.getWidth(), meetingRoom.getLength(), meetingRoom.getArea()));
    }

    public void printMeetingRoomsWithName(String name) {
        Optional<String> meetingRoomName = meetingRooms.stream()
                .map(MeetingRoom::getName)
                .filter(roomName -> roomName.equals(name))
                .findAny();
        String result = meetingRoomName.orElse("Nincs ilyen nevű tárgyaló");
        System.out.println(result);
    }

    public void printMeetingRoomsContains(String part) {
        Optional<MeetingRoom> optionalMeetingRoom = meetingRooms.stream()
                .filter(meetingRoom -> meetingRoom.getName().toLowerCase().contains(part.toLowerCase()))
                .findAny();

        MeetingRoom meetingRoom;
        if (optionalMeetingRoom.isEmpty()) {
            System.out.println("Nincs ilyen név részletű tárgyaló");
            return;
        } else {
            meetingRoom = optionalMeetingRoom.get();
        }
        System.out.printf("A tárgyaló szélessége: %d, hosszűsága: %d, területe: %d%n", meetingRoom.getWidth(), meetingRoom.getLength(), meetingRoom.getArea());
    }

    public void printAreasLargerThan(int area) {
        List<MeetingRoom> meetingRoomList = meetingRooms.stream()
                .filter(meetingRoom -> meetingRoom.getArea() > area)
                .toList();
        if (meetingRoomList.isEmpty()) {
            System.out.println("Nincs ilyen méretű tárgyaló.");
            return;
        }
        meetingRoomList.forEach(meetingRoom -> System.out.printf("A tárgyaló neve: %s, szélessége: %d, hosszúsága: %d, területe: %d%n", meetingRoom.getName(), meetingRoom.getWidth(), meetingRoom.getLength(), meetingRoom.getArea()));
    }
}
