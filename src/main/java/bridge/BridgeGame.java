package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private List<String> userBridgeHistroy = new ArrayList<>();
    private int movingCount;
    private int tryCount;

    public boolean isSuccess;

    BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(String moving) {
        validate(moving);
        userBridgeHistroy.add(moving);
        isSuccess = canMove(moving);
        movingCount++;
        return toResult();
    }

    private List<String> toResult() {
        List<String> result = new ArrayList<>(userBridgeHistroy);
        if (isSuccess) {
            result.add("O");
        }
        if (!isSuccess) {
            result.add("X");
        }
        return result;
    }

    private boolean canMove(String moving) {
        if (bridge.get(movingCount).equals(moving)) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String command) {
        validateCommand(command);
        if (command.equals("R")) {
            movingCount = 0;
            userBridgeHistroy.clear();
            tryCount++;
            isSuccess = true;
        }
    }

    public int getTryCount() {
        return tryCount;
    }

    private void validate(String moving) {
        if (!moving.equals(Direction.Code.UP.getName()) && !moving.equals(Direction.Code.DOWN.getName())) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCommand(String command) {
        if (!command.equals("R") && !command.equals("Q")) {
            throw new IllegalArgumentException();
        }
    }
}
