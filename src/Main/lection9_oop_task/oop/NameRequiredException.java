package lection9_oop_task.oop;

class NameRequiredException extends IllegalArgumentException {
    public NameRequiredException(String message) {
        super(message);
    }
}
