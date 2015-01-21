package mas.assignment1.agents;

import java.util.List;

public class DefectiveAgent implements Agent {
    @Override
    public Action dilemma(List<Action> opponentPreviousActions) {
        return Action.DEFECT;
    }

    @Override
    public String toString() {
        return "Defective";
    }
}
