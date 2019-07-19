package okhttp3;

import f.f;
import javax.annotation.Nullable;

public abstract interface WebSocket
{
  public abstract void cancel();

  public abstract boolean close(int paramInt, @Nullable String paramString);

  public abstract long queueSize();

  public abstract Request request();

  public abstract boolean send(f paramf);

  public abstract boolean send(String paramString);

  public static abstract interface Factory
  {
    public abstract WebSocket newWebSocket(Request paramRequest, WebSocketListener paramWebSocketListener);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.WebSocket
 * JD-Core Version:    0.6.2
 */