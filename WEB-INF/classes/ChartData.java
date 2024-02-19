public class ChartData {
    int nooftasks,finished,unfinished;

    public int getNooftasks() {
        return nooftasks;
    }

    public void setNooftasks(int nooftasks) {
        this.nooftasks = nooftasks;
    }

    public int getFinished() {
        return finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    public int getUnfinished() {
        return unfinished;
    }

    public void setUnfinished(int unfinished) {
        this.unfinished = unfinished;
    }

    public ChartData(int nooftasks, int finished, int unfinished) {
        this.nooftasks = nooftasks;
        this.finished = finished;
        this.unfinished = unfinished;
    }
}
