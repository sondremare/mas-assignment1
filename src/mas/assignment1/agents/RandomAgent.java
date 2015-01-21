package mas.assignment1.agents;

import java.util.List;

public class RandomAgent implements Agent {
    @Override
    public Action dilemma(List<Action> opponentPreviousActions) {
        if (Math.random() < 0.5) {
            return Action.COOPERATE;
        } else {
            return Action.DEFECT;
        }
    }

    @Override
    public String toString() {
        return "Random";
    }
}
