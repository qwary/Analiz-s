package entitys;

import java.util.ArrayList;

public class LogicCondition implements ConditionInterface {
	int condition; // 0 - AND 1 - OR 2 - XOR todo use enum
	ArrayList<ConditionInterface> elements;
}
