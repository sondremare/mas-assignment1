package mas.assignment1.agents;

import java.util.List;

public class MyOwnAgent implements Agent {
    @Override
    public Action dilemma(List<Action> opponentPreviousActions) {
        if (opponentPreviousActions == null || opponentPreviousActions.size() == 0) {
            return Action.COOPERATE;
        } else {
            if (opponentPreviousActions.size() >= 2
                    && opponentPreviousActions.get(opponentPreviousActions.size()-1) == Action.COOPERATE
                    && opponentPreviousActions.get(opponentPreviousActions.size()-2) == Action.COOPERATE) {
                return Action.COOPERATE;
            } else {
                return Action.DEFECT;
            }
        }

    }

    @Override
    public String toString() {
        return "MyOwn";
    }
}
