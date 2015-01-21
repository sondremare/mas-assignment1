package mas.assignment1.agents;

import java.util.List;

public class TitForTatAgent implements Agent {
    @Override
    public Action dilemma(List<Action> opponentPreviousActions) {
        if (opponentPreviousActions == null || opponentPreviousActions.size() == 0) {
            return Action.COOPERATE;
        } else {
            return opponentPreviousActions.get(opponentPreviousActions.size()-1);
        }
    }

    @Override
    public String toString() {
        return "TitForTat";
    }
}
