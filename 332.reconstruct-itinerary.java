/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 *
 * https://leetcode.com/problems/reconstruct-itinerary/description/
 *
 * algorithms
 * Medium (31.56%)
 * Total Accepted:    80.4K
 * Total Submissions: 254.6K
 * Testcase Example:  '[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]'
 *
 * Given a list of airline tickets represented by pairs of departure and
 * arrival airports [from, to], reconstruct the itinerary in order. All of the
 * tickets belong to a man who departs from JFK. Thus, the itinerary must begin
 * with JFK.
 *
 * Note:
 *
 *
 * If there are multiple valid itineraries, you should return the itinerary
 * that has the smallest lexical order when read as a single string. For
 * example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
 * ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 *
 *
 * Example 1:
 *
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 *
 * Example 2:
 *
 *
 * Input:
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is
 * ["JFK","SFO","ATL","JFK","ATL","SFO"].
 * But it is larger in lexical order.
 *
 *
 */
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> itinerary = new ArrayList<>();

        if (tickets.size() == 0) {
          return itinerary;
        }

        // Bulid the map from departure to destination
        Map<String, List<String>> itineraryMap = new HashMap<>();
        for (List<String> ticket : tickets) {
            itineraryMap.putIfAbsent(ticket.get(0), new LinkedList<>());
            itineraryMap.get(ticket.get(0)).add(ticket.get(1));
        }

        // Try DFS and find out the correct path
        findPath(tickets, "JFK", itinerary);
        return itinerary;
    }

    private boolean findPath(List<List<String>> tickets, String cur, List<String> itinerary) {
        itinerary.add(cur);
        if (tickets.size() == 0) {
            return true;
        }

        List<List<String>> destinations = new ArrayList<>();

        for (List<String> ticket : tickets) {
            if (!cur.equals(ticket.get(0))) {
                continue;
            }

            destinations.add(ticket);
        }

        Collections.sort(destinations, (t1, t2) -> t1.get(1).compareTo(t2.get(1)));

        // System.out.println("Arrived at " + cur + " and itinerary " + itinerary);

        for (List<String> ticket : destinations) {
            tickets.remove(ticket);
            if (findPath(tickets, ticket.get(1), itinerary)) {
                return true;
            }

            tickets.add(ticket);
        }

        itinerary.remove(itinerary.size() - 1);
        return false;
    }
}
