package com.mixpanel.android.c;

import com.mixpanel.android.a.a.a;
import com.mixpanel.android.a.b.c;
import com.mixpanel.android.a.c.g;
import com.mixpanel.android.a.d.d.a;
import com.mixpanel.android.a.e.h;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

class e
{
  private static final ByteBuffer d = ByteBuffer.allocate(0);
  private final a a;
  private final b b;
  private final URI c;

  public e(URI paramURI, a parama, Socket paramSocket)
    throws e.c
  {
    this.a = parama;
    this.c = paramURI;
    try
    {
      this.b = new b(paramURI, 5000, paramSocket);
      this.b.c();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new c(localInterruptedException);
    }
  }

  public boolean a()
  {
    return (!this.b.f()) && (!this.b.g()) && (!this.b.e());
  }

  public boolean b()
  {
    return this.b.d();
  }

  public BufferedOutputStream c()
  {
    return new BufferedOutputStream(new d(null));
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(JSONObject paramJSONObject);

    public abstract void b();

    public abstract void b(JSONObject paramJSONObject);

    public abstract void c(JSONObject paramJSONObject);

    public abstract void d(JSONObject paramJSONObject);

    public abstract void e(JSONObject paramJSONObject);
  }

  private class b extends a
  {
    public b(URI paramInt, int paramSocket, Socket arg4)
      throws InterruptedException
    {
      super(new c(), null, paramSocket);
      Socket localSocket;
      a(localSocket);
    }

    public void a(h paramh)
    {
      com.mixpanel.android.b.f.a("MixpanelAPI.EditorCnctn", "Websocket connected");
    }

    public void a(Exception paramException)
    {
      if ((paramException != null) && (paramException.getMessage() != null))
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.EditorCnctn", "Websocket Error: " + paramException.getMessage());
        return;
      }
      com.mixpanel.android.b.f.e("MixpanelAPI.EditorCnctn", "Unknown websocket error occurred");
    }

    public void a(String paramString)
    {
      com.mixpanel.android.b.f.a("MixpanelAPI.EditorCnctn", "Received message from editor:\n" + paramString);
      JSONObject localJSONObject;
      String str;
      try
      {
        localJSONObject = new JSONObject(paramString);
        str = localJSONObject.getString("type");
        if (str.equals("device_info_request"))
        {
          e.a(e.this).a();
          return;
        }
        if (str.equals("snapshot_request"))
        {
          e.a(e.this).a(localJSONObject);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        com.mixpanel.android.b.f.e("MixpanelAPI.EditorCnctn", "Bad JSON received:" + paramString, localJSONException);
        return;
      }
      if (str.equals("change_request"))
      {
        e.a(e.this).b(localJSONObject);
        return;
      }
      if (str.equals("event_binding_request"))
      {
        e.a(e.this).d(localJSONObject);
        return;
      }
      if (str.equals("clear_request"))
      {
        e.a(e.this).c(localJSONObject);
        return;
      }
      if (str.equals("tweak_request"))
        e.a(e.this).e(localJSONObject);
    }

    public void b(int paramInt, String paramString, boolean paramBoolean)
    {
      com.mixpanel.android.b.f.a("MixpanelAPI.EditorCnctn", "WebSocket closed. Code: " + paramInt + ", reason: " + paramString + "\nURI: " + e.b(e.this));
      e.a(e.this).b();
    }
  }

  public class c extends IOException
  {
    public c(Throwable arg2)
    {
      super();
    }
  }

  private class d extends OutputStream
  {
    private d()
    {
    }

    public void close()
      throws e.c
    {
      try
      {
        e.c(e.this).a(d.a.b, e.d(), true);
        return;
      }
      catch (g localg)
      {
        throw new e.c(e.this, localg);
      }
      catch (com.mixpanel.android.a.c.f localf)
      {
        throw new e.c(e.this, localf);
      }
    }

    public void write(int paramInt)
      throws e.c
    {
      byte[] arrayOfByte = new byte[1];
      arrayOfByte[0] = ((byte)paramInt);
      write(arrayOfByte, 0, 1);
    }

    public void write(byte[] paramArrayOfByte)
      throws e.c
    {
      write(paramArrayOfByte, 0, paramArrayOfByte.length);
    }

    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws e.c
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2);
      try
      {
        e.c(e.this).a(d.a.b, localByteBuffer, false);
        return;
      }
      catch (g localg)
      {
        throw new e.c(e.this, localg);
      }
      catch (com.mixpanel.android.a.c.f localf)
      {
        throw new e.c(e.this, localf);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.c.e
 * JD-Core Version:    0.6.2
 */