package states;

public class Context {
    private State state = null;

    public Context(State state) {
        this.transitionTo(state);
    }

    public void transitionTo(State state)
    {
        this.state = state;
        this.state.setContext(this);
    }

    public void execute() {
        state.execute();
    }
}