package ru.ama0.adventofcode.day16;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Day16a {
    public static void main(String[] args) throws IOException {
        DataHolder dataHolder = new DataHolder();
        dataHolder.loadFrom("/day16.txt");

        // First question
        long errorRate = 0;
        Iterator<List<Integer>> iterator = dataHolder.getNearbyTickets().iterator();
        while (iterator.hasNext()) {
            List<Integer> ticket = iterator.next();
            for (Integer number : ticket) {
                if (dataHolder.getConstraints().values().stream().noneMatch(constraint -> constraint.matches(number))) {
                    errorRate += number;
                    iterator.remove();
                    break;
                }
            }
        }
        System.out.println(errorRate);

        // Second question
        dataHolder.getNearbyTickets().add(dataHolder.getMyTicket());

        Map<Integer, Set<String>> possibleNames = new HashMap<>();
        for (int i = 0; i < dataHolder.getMyTicket().size(); i++) {
            possibleNames.put(i, new HashSet<>(dataHolder.getConstraints().keySet()));
        }
        for (List<Integer> ticket : dataHolder.getNearbyTickets()) {
            for (int ticketPart = 0; ticketPart < ticket.size(); ticketPart++) {
                Integer number = ticket.get(ticketPart);
                for (Map.Entry<String, Constraint> constraintEntry : dataHolder.getConstraints().entrySet()) {
                    if (!constraintEntry.getValue().matches(number)) {
                        possibleNames.get(ticketPart).remove(constraintEntry.getKey());
                    }
                }
            }
        }
        Map<String, Integer> resultMappings = new HashMap<>();
        Optional<Map.Entry<Integer, Set<String>>> determinedEntry;
        while ((determinedEntry = possibleNames.entrySet().stream().filter(entry -> entry.getValue().size() == 1).findAny()).isPresent()) {
            String determinedName = determinedEntry.get().getValue().iterator().next();
            Integer index = determinedEntry.get().getKey();
            resultMappings.put(determinedName, index);
            possibleNames.forEach((k, v) -> v.remove(determinedName));
        }
        System.out.println(resultMappings);
        System.out.println(resultMappings.size());
        System.out.println(resultMappings.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith("departure"))
                .map(entry -> (long)dataHolder.getMyTicket().get(entry.getValue()))
                .reduce(1L, (x, y) -> x * y));
    }
}
