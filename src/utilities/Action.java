package utilities;

public enum Action {
    FALL,
    GRAB,
    OPEN;

    @Override
    public String toString() {
        switch (ordinal()) {
            case 0: {
                return "Падение";
            }
            case 1: {
                return "Нажатие на ручку";
            }
            case 2: {
                return "Открытие";
            }
            default: {
                return "Неизвестное действие";
            }
        }
    }
}
