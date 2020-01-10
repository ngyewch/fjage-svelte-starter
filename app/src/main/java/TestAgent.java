import org.arl.fjage.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TestAgent extends Agent {

  private AgentID topic;

  @Override
  protected void init() {
    register("TEST");
    topic = topic();
    add(new TickerBehavior(5000) {
      @Override
      public void onTick() {
        final TestNotification testNotification = new TestNotification(String.format("[%s] I'm awake!",
            LocalDateTime.ofInstant(Instant.ofEpochMilli(currentTimeMillis()), ZoneId.systemDefault())));
        topic.send(testNotification);
        log.info("I'm awake!");
      }
    });
    add(new MessageBehavior() {
      @Override
      public void onReceive(Message msg) {
        if (msg instanceof Message) {
          final TestRequest testRequest = (TestRequest) msg;
          final TestResponse testResponse = new TestResponse(testRequest,
              testRequest.getValue1() * testRequest.getValue2());
          send(testResponse);
        }
      }
    });
  }
}
