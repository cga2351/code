package okhttp3;

import f.f;
import javax.annotation.Nullable;

public abstract class WebSocketListener
{
  public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
  {
  }

  public void onClosing(WebSocket paramWebSocket, int paramInt, String paramString)
  {
  }

  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, @Nullable Response paramResponse)
  {
  }

  public void onMessage(WebSocket paramWebSocket, f paramf)
  {
  }

  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
  }

  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.WebSocketListener
 * JD-Core Version:    0.6.2
 */