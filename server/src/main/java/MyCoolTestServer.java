import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class MyCoolTestServer extends WebSocketServer{

  public MyCoolTestServer(InetSocketAddress address){
    super(address);
  }

  @Override
  public void onOpen(WebSocket conn, ClientHandshake handshake) {
    System.out.println("Hello, I´m alive");
  }

  @Override
  public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    System.out.println("I´m dead");
  }

  @Override
  public void onMessage(WebSocket conn, String message) {
    System.out.println("Received: " + message);
    conn.send(message);
  }

  @Override
  public void onMessage(WebSocket conn, ByteBuffer message) {
    byte[] data = message.array();
    System.out.println("Received bytes: " + new String(data, StandardCharsets.UTF_8));
    conn.send(data);
  }

  @Override
  public void onError(WebSocket conn, Exception ex) {

  }

  @Override
  public void onStart() {

  }

  public static void main(String[] args) {
    MyCoolTestServer server = new MyCoolTestServer(new InetSocketAddress(4132));
    server.start();
  }
}
