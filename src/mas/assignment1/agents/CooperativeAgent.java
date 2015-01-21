package mas.assignment1.agents;

import java.util.List;

public class CooperativeAgent implements Agent {
    @Override
    public Action dilemma(List<Action> opponentPreviousActions) {
        return Action.COOPERATE;
    }

    @Override
    public String toString() {
        return "Cooperative";
    }
}
