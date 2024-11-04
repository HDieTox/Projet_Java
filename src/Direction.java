public enum Direction {
    UP(2), DOWN(0), LEFT(1), RIGHT(3);
    private int frameLineNumber;

    Direction(int frameLineNumber) {
        this.frameLineNumber = frameLineNumber;
    }

    public int getFrameLineNumber() {
        return frameLineNumber;
    }
}
