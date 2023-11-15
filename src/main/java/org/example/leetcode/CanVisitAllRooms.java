package org.example.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

class CanVisitAllRooms {
    public static void main(String[] args) {
        System.out.println(canVisitAllRooms(asList(asList(1), asList(2), asList(3), Collections.emptyList())));
        System.out.println("SECOND:");
        System.out.println(canVisitAllRooms(asList(asList(1,3), asList(3,0,1), asList(2), asList(0))));
    }

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);

        //At the beginning, we have a todo list "stack" of keys to use.
        //'seen' represents at some point we have entered this room.
        while (!stack.isEmpty()) { // While we have keys...
            int node = stack.pop(); // Get the next key 'node'
            for (int nei: rooms.get(node)) // For every key in room # 'node'...
                if (!seen[nei]) { // ...that hasn't been used yet
                    seen[nei] = true; // mark that we've entered the room
                    stack.push(nei); // add the key to the todo list
                }
        }

        for (boolean v: seen)  // if any room hasn't been visited, return false
            if (!v) return false;
        return true;
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        System.out.println("================================");
        System.out.println("Rooms in the beginning: " + rooms);
        Map<Integer, List<Integer>> roomsMap = IntStream.range(0, rooms.size())
                .boxed()
                .collect(Collectors.toMap(Function.identity(), rooms::get));
        List<Integer> currentKeys = rooms.get(0);
        System.out.println("Entered into room 0 and found keys for rooms: " + currentKeys);
        HashSet<Integer> allKeys = new HashSet<>(currentKeys);
        allKeys.add(0);
        findNewKeysInCurrentRooms(currentKeys, allKeys, roomsMap);
        System.out.println("Finally we have keys: " + allKeys.size());
        System.out.println("rooms: " + rooms.size());
        System.out.println("Can we visit all rooms:");
        return allKeys.size() == rooms.size();
    }

    private static List<Integer> findNewKeysInCurrentRooms(List<Integer> currentKeys, Set<Integer> allKeys, Map<Integer, List<Integer>> rooms) {
        System.out.println("---------------------------------");
        System.out.println("We are going to visit rooms: " + currentKeys);
        System.out.println("Keys we have as for now: " + allKeys);
        System.out.println("Rooms to visit after current: " + (rooms.size() - 1));

        List<Integer> newKeys = new ArrayList<>();
        for (Integer key : currentKeys) {
            List<Integer> currentRoomKeys = rooms.remove(key);
            System.out.println("***");
            System.out.println("Entering room: " + key);
            if (currentRoomKeys == null) {
                return Collections.emptyList();
            }
            for (Integer currentRoomKey : currentRoomKeys) {
                if (!allKeys.contains(currentRoomKey)) {
                    newKeys.add(currentRoomKey);
                }
            }
            System.out.println("New keys found: " + newKeys);
            allKeys.addAll(currentRoomKeys);
        }
        if (newKeys.isEmpty()) {
            return Collections.emptyList();
        }
        return findNewKeysInCurrentRooms(newKeys, allKeys, rooms);
    }
}