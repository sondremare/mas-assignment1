package mas.assignment1.agents;

import java.util.List;

public class TitForEveryOtherTatAgent implements Agent{
    @Override
    public Action dilemma(List<Action> opponentPreviousActions) {
        if (opponentPreviousActions != null && opponentPreviousActions.size() >= 2) {
            if (opponentPreviousActions.get(opponentPreviousActions.size()-1) == Action.DEFECT
                    && opponentPreviousActions.get(opponentPreviousActions.size()-2) == Action.DEFECT) {
                return Action.DEFECT;
            }
        }
        return Action.COOPERATE;
    }

    @Override
    public String toString() {
        return "TitForEveryOtherTat";
    }
}
