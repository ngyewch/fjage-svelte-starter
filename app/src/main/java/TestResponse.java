import org.arl.fjage.Message;

public class TestResponse extends Message {

  private float value;

  public TestResponse(Message inReplyTo) {
    super(inReplyTo);
  }

  public TestResponse(Message inReplyTo, float value) {
    super(inReplyTo);

    this.value = value;
  }

  public float getValue() {
    return value;
  }

  public void setValue(float value) {
    this.value = value;
  }
}
