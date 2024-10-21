public enum Direction {
    UP(0), DOWN(2), LEFT(3), RIGHT(1);
    private int frameLineNumber;

    Direction(int frameLineNumber) {
        this.frameLineNumber = frameLineNumber;
    }

    public int getFrameLineNumber() {
        return frameLineNumber;
    }
}
