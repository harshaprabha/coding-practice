package lld.votingSystem;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class VotingWinner {

    class Team implements Comparable<Team> {
        int totalCount;
        String name;
        Map<Integer, Integer> voteMap;

        Team(String n) {
            this.name = n;
            this.totalCount = 0;
            voteMap = new HashMap<>();
        }

        void vote(int priority, int value) {
            this.totalCount += value;
            voteMap.put(priority, voteMap.getOrDefault(priority, 0) + value);
        }

        @Override
        public int compareTo(Team o) {
            if (this.totalCount == o.totalCount) {
                int N = voteMap.size();
                for (int i = 0; i < N; i++) {
                    if (this.voteMap.getOrDefault(i, 0) == o.voteMap.getOrDefault(i, 0))
                        continue;
                    return this.voteMap.getOrDefault(i, 0) - o.voteMap.getOrDefault(i, 0);
                }
            }
            return this.totalCount - o.totalCount;
        }
    }

    public String rankTeams(List<List<String>> votes, List<Integer> priority) {

        int n = votes.size();
        Map<String, Team> teamMap = new HashMap<>();

        for (int i = 0; i < votes.size(); i++) {
            for (int j = 0; j < votes.get(i).size(); j++) {
                String team = votes.get(i).get(j);

                teamMap.putIfAbsent(team, new Team(team));
                teamMap.get(team).vote(j, priority.get(j));
            }
        }

        List<Team> entryList = new ArrayList<Team>(teamMap.values());
        String ans = entryList.stream().max(new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                return o1.compareTo(o2);
            }
        }).get().name;

        System.out.println(System.currentTimeMillis() );
        return ans;

    }

    public static void main(String[] args) {
        List<List<String>> votes = new ArrayList<>();
        votes.add(Arrays.asList("A", "B", "C"));
        votes.add(Arrays.asList("D", "A", "C"));

        List<Integer> priority = Arrays.asList(3, 2, 1);
        System.out.println(new VotingWinner().rankTeams(votes, priority));
        System.out.println(new VotingWinner().rankTeams(votes, priority));


    }


}
