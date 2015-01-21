package mas.assignment1;

import mas.assignment1.agents.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Tournament {

    public static int utility(Agent.Action agent1Action, Agent.Action agent2Action) {
        if (agent1Action.equals(agent2Action)) {
            return (agent1Action.equals(Agent.Action.DEFECT) ? 2 : 3);
        } else {
            return (agent1Action.equals(Agent.Action.DEFECT) ? 5 : 0);
        }
    }

    public static ArrayList<Agent> initAgents() {
        CooperativeAgent cooperativeAgent = new CooperativeAgent();
        DefectiveAgent defectiveAgent = new DefectiveAgent();
        RandomAgent randomAgent = new RandomAgent();
        TitForEveryOtherTatAgent titForEveryOtherTatAgent = new TitForEveryOtherTatAgent();
        TitForTatAgent titForTatAgent = new TitForTatAgent();
        MyOwnAgent myOwnAgent = new MyOwnAgent();

        ArrayList<Agent> agents = new ArrayList<Agent>();
        agents.add(cooperativeAgent);
        agents.add(defectiveAgent);
        agents.add(randomAgent);
        agents.add(titForEveryOtherTatAgent);
        agents.add(titForTatAgent);
        agents.add(myOwnAgent);
        return agents;
    }

    public static Map<Agent, Double> updateAccumulatedMScore(Map<Agent, Double> mScores, Agent agent, double mScore) {
        double accumulatedMScore;
        if (mScores.get(agent) == null) {
            accumulatedMScore = mScore;
        } else {
            accumulatedMScore = mScores.get(agent) + mScore;
        }
        mScores.put(agent, accumulatedMScore);
        return mScores;
    }

    public static void main(String[] args) {
        ArrayList<Agent> agents = initAgents();
        int[] rounds = {10, 20, 30};
        for (int r = 0; r < rounds.length; r++) {
            Map<Agent, Double> mScores = new HashMap<Agent, Double>();
            for (int i = 0; i < agents.size() ; i++) {
                for (int j = i+1; j < agents.size(); j++) {
                    Agent agent1 = agents.get(i);
                    Agent agent2 = agents.get(j);
                    //System.out.println(agent1 + " VS " + agent2);
                    int accumulatedScore1 = 0;
                    int accumulatedScore2 = 0;
                    ArrayList<Agent.Action> agent1PreviousActions = new ArrayList<Agent.Action>();
                    ArrayList<Agent.Action> agent2PreviousActions = new ArrayList<Agent.Action>();
                    for (int k = 0; k < rounds[r]; k++) {
                        Agent.Action agent1Action = agent1.dilemma(agent2PreviousActions);
                        Agent.Action agent2Action = agent2.dilemma(agent1PreviousActions);
                        agent1PreviousActions.add(agent1Action);
                        agent2PreviousActions.add(agent2Action);
                        //System.out.println(agent1 + " - " + agent1Action + " : "+utility(agent1Action, agent2Action) + " - " + utility(agent2Action, agent1Action) + " : " + agent2Action + " - " + agent2);
                        accumulatedScore1 += utility(agent1Action, agent2Action);
                        accumulatedScore2 += utility(agent2Action, agent1Action);

                    }

                    double mScore1 =  (double) accumulatedScore1 / rounds[r];
                    double mScore2 = (double) accumulatedScore2 / rounds[r];
                    //System.out.println("TOTAL - " + agent1 + " : " + accumulatedScore1 + " - " + accumulatedScore2 + " : " + agent2);
                    //System.out.println("mScore - " + agent1 + " : " + mScore1 + " - " + mScore2 + " : " + agent2);
                    updateAccumulatedMScore(mScores, agent1, mScore1);
                    updateAccumulatedMScore(mScores, agent2, mScore2);
                }
            }

            System.out.println("Number of rounds: " + rounds[r] + "\n***********************************");
            Iterator iterator = mScores.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator.next();
                System.out.println(pair.getKey() + ": " + ((Double) pair.getValue() / agents.size()));
            }
        }

    }
}
