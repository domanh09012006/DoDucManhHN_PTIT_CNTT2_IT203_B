package SESSION08.BT3;

import java.util.Stack;

public class RemoteControl {
    private Command[] buttons;
    private Stack<Command> undoStack;
    public RemoteControl(int slotCount) {
        buttons = new Command[slotCount];
        undoStack = new Stack<>();
    }
    public void setCommand(int slot, Command command) {
        buttons[slot] = command;
        System.out.println("Đã gán " + command.getClass().getSimpleName() + " cho nút " + (slot + 1));
    }
    public void pressButton(int slot) {
        if (buttons[slot] != null) {
            buttons[slot].execute();
            undoStack.push(buttons[slot]);
        } else {
            System.out.println("Nút " + (slot + 1) + " chưa được gán lệnh!");
        }
    }
    public void pressUndo() {
        if (!undoStack.isEmpty()) {
            Command lastCommand = undoStack.pop();
            lastCommand.undo();
        } else {
            System.out.println("Không có lệnh nào để Undo!");
        }
    }
}