package utilities;

public enum Action {
    FALL,
    GRAB,
    OPEN;

    @Override
    public String toString() {
        switch (this) {
            case FALL: {
                return "Падение";
            }
            case GRAB: {
                return "Нажатие на ручку";
            }
            case OPEN: {
                return "Открытие";
            }
            default: {
                return "Неизвестное действие";
            }
        }
    }
}
