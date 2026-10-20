class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        LinkedList<String> itinerary = new LinkedList<>();

        dfs("JFK", graph, itinerary);

        return itinerary;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> itinerary) {
        PriorityQueue<String> outwardFlights = graph.get(airport);

        while (outwardFlights != null && !outwardFlights.isEmpty()) {
            dfs(outwardFlights.poll(), graph, itinerary);
        }

        itinerary.addFirst(airport);
    }
}
