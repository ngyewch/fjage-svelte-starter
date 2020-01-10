import org.arl.fjage.Message;

public class TestRequest extends Message {

  private float value1;
  private float value2;

  public TestRequest() {
    super();
  }

  public TestRequest(float value1, float value2) {
    super();

    this.value1 = value1;
    this.value2 = value2;
  }

  public float getValue1() {
    return value1;
  }

  public void setValue1(float value1) {
    this.value1 = value1;
  }

  public float getValue2() {
    return value2;
  }

  public void setValue2(float value2) {
    this.value2 = value2;
  }
}
