package ru.itmo.lessons.course2;

public class InvokerClass {
    private Command startCommand;
    private Command downloadCommand;
    private Command saveGameCommand;
    private Command exitCommand;

    public InvokerClass(Command startCommand, Command downloadCommand, Command saveGameCommand, Command exitCommand) {
        this.startCommand = startCommand;
        this.downloadCommand = downloadCommand;
        this.saveGameCommand = saveGameCommand;
        this.exitCommand = exitCommand;
    }

    public void flipStart(){
        startCommand.execute();
    }

    public void flipDownload(){ downloadCommand.execute(); }

    public void flipSaveGame(){ saveGameCommand.execute(); }

    public void flipExit(){ exitCommand.execute(); }
}
