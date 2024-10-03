package bankify.beans;

import bankify.App;

public class Status {
    private int iStatusCode;
    private String sStatusMessage;

    public Status(int iStatusCode,String sStatusMessage){
        this.iStatusCode = iStatusCode;
        this.sStatusMessage = sStatusMessage;
    }

    public Status() {
        this.iStatusCode = App.iStatusCode0;
        this.sStatusMessage = App.sStatusMessageClear;
    }

    public int getStatusCode() {
        return iStatusCode;
    }

    public String getStatusMessage() {
        return sStatusMessage;
    }

    public void setStatusCode(int iStatusCode) {
        this.iStatusCode = iStatusCode;
    }

    public void setStatusMessage(String sStatusMessage) {
        this.sStatusMessage = sStatusMessage;
    }
}
