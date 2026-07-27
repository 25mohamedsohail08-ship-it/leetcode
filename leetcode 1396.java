import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Route {
        long totalTime;
        int count;

        Route() {
            totalTime = 0;
            count = 0;
        }
    }

    private Map<Integer, CheckIn> checkInMap;
    private Map<String, Route> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn in = checkInMap.remove(id);
        String key = in.station + "#" + stationName;

        Route route = routeMap.getOrDefault(key, new Route());
        route.totalTime += (t - in.time);
        route.count++;

        routeMap.put(key, route);
    }

    public double getAverageTime(String startStation, String endStation) {
        Route route = routeMap.get(startStation + "#" + endStation);
        return (double) route.totalTime / route.count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id, stationName, t);
 * obj.checkOut(id, stationName, t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
