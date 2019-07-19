package com.viber.voip.videoconvert;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.viber.voip.VideoConverterPreparedRequest;
import com.viber.voip.VideoConverterRequest;
import com.viber.voip.ag;
import com.viber.voip.ag.a;
import com.viber.voip.ah;
import com.viber.voip.ai;
import java.util.concurrent.atomic.AtomicReference;

public class VideoConverterService extends Service
  implements d
{
  static AtomicReference<Context> a = new AtomicReference();
  private static ag.a b = new ag.a()
  {
    private n a = new n();

    public VideoConverterPreparedRequest a(VideoConverterRequest paramAnonymousVideoConverterRequest)
      throws RemoteException
    {
      return this.a.a(paramAnonymousVideoConverterRequest);
    }

    public ag a()
      throws RemoteException
    {
      return this.a;
    }

    public String a(String paramAnonymousString)
      throws RemoteException
    {
      return this.a.a(paramAnonymousString);
    }

    public void a(VideoConverterPreparedRequest paramAnonymousVideoConverterPreparedRequest)
      throws RemoteException
    {
      this.a.a(paramAnonymousVideoConverterPreparedRequest);
    }

    public void a(VideoConverterPreparedRequest paramAnonymousVideoConverterPreparedRequest, ah paramAnonymousah)
      throws RemoteException
    {
      this.a.a(paramAnonymousVideoConverterPreparedRequest, paramAnonymousah);
    }

    public void a(ai paramAnonymousai)
      throws RemoteException
    {
      this.a.a(paramAnonymousai);
    }

    public void b(ai paramAnonymousai)
      throws RemoteException
    {
      this.a.b(paramAnonymousai);
    }
  };

  public VideoConverterService()
  {
    a.set(this);
  }

  public static final Context b()
  {
    return (Context)a.get();
  }

  public VideoConverterPreparedRequest a(VideoConverterRequest paramVideoConverterRequest)
    throws RemoteException
  {
    return b.a(paramVideoConverterRequest);
  }

  public ag a()
    throws RemoteException
  {
    return b.a();
  }

  public String a(String paramString)
    throws RemoteException
  {
    return b.a(paramString);
  }

  public void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest)
    throws RemoteException
  {
    b.a(paramVideoConverterPreparedRequest);
  }

  public void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest, ah paramah)
    throws RemoteException
  {
    b.a(paramVideoConverterPreparedRequest, paramah);
  }

  public void a(ai paramai)
    throws RemoteException
  {
    b.a(paramai);
  }

  public IBinder asBinder()
  {
    return b;
  }

  public void b(ai paramai)
    throws RemoteException
  {
    b.b(paramai);
  }

  public IBinder onBind(Intent paramIntent)
  {
    return b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.VideoConverterService
 * JD-Core Version:    0.6.2
 */