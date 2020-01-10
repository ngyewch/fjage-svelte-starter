import org.arl.fjage.Message;

public class TestNotification extends Message {

  private String message;

  public TestNotification() {
    super();
  }

  public TestNotification(String message) {
    super();

    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
