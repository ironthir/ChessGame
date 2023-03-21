public class CheckHandler {

    private String checkedPlayer;
    public void SetCheckedPlayer(String name)
    {
        this.checkedPlayer = name;
    }
    public boolean IsCurrentPlayerChecked(String curr)
    {
        return curr.equals(checkedPlayer);
    }
    public boolean WillTheMoveResolveCheck()
    {
        return true;
    }
}
