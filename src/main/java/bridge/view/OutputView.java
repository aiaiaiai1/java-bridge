package bridge.view;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_NOTICE = "다리 건너기 게임을 시작합니다.";
    private static final String BRIDGE_SIZE_INPUT_NOTICE = "다리의 길이를 입력해주세요.";
    private static final String RESTART_OR_QUIT_INPUT_NOTICE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String FINAL_RESULT_NOTICE = "최종 게임 결과";

    private static final String MOVING_DIRECTION_INPUT_NOTICE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String WIN_OR_NOT_NOTICE = "게임 성공 여부: %s";
    private static final String TOTAL_TRY_COUNT_NOTICE = "총 시도한 횟수: %d";
    private static final String NEW_LINE = "\n";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    public void printMap(List<String> map) {
        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i));
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> map, boolean hasWin, int tryCount) {
        printResultNotice();
        printMap(map);
        String winOrNot = FAIL;
        if (hasWin) {
            winOrNot = SUCCESS;
        }
        System.out.printf(WIN_OR_NOT_NOTICE + NEW_LINE, winOrNot);
        System.out.printf(TOTAL_TRY_COUNT_NOTICE + NEW_LINE, tryCount);
    }

    public void printStartNotice() {
        System.out.println(START_NOTICE);
    }

    public void printBridgeSizeInputNotice() {
        System.out.println(BRIDGE_SIZE_INPUT_NOTICE);
    }

    public void printRestartOrQuitInputNotice() {
        System.out.println(RESTART_OR_QUIT_INPUT_NOTICE);
    }

    public void printResultNotice() {
        System.out.println(FINAL_RESULT_NOTICE);

    }

    public void printMovingDirectionInputNotice() {
        System.out.println(MOVING_DIRECTION_INPUT_NOTICE);

    }

    public void printNewLine() {
        System.out.println();
    }

    public void printErrorNotice(Exception e) {
        System.out.println(e.getMessage());
    }
}

