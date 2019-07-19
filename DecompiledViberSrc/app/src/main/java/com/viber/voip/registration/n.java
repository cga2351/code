package com.viber.voip.registration;

import android.content.Context;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.util.Base64;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.secure.SecureTokenDelegate;
import com.viber.jni.secure.SecureTokenListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.c.l;
import com.viber.voip.util.cj;
import com.viber.voip.util.t;

public class n
  implements SecureTokenDelegate
{
  private static final Logger a = ViberEnv.getLogger();
  private final SecureTokenListener b;
  private final PhoneController c;
  private final Context d;
  private final a e;
  private b f;

  public n(SecureTokenListener paramSecureTokenListener, PhoneController paramPhoneController, Context paramContext, a parama)
  {
    this.b = paramSecureTokenListener;
    this.c = paramPhoneController;
    this.d = paramContext;
    this.e = parama;
  }

  public void a()
  {
    this.b.registerDelegate(new SecureTokenDelegate[] { this });
    this.c.handleSecureTokenRequest(this.c.generateSequence());
  }

  public void b()
  {
    if ((this.f != null) && (this.f.getStatus() == AsyncTask.Status.RUNNING))
      this.f.cancel(true);
  }

  public void onSecureTokenReply(int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    this.b.removeDelegate(this);
    if ((paramLong > 0L) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      b localb = new b(paramLong, paramArrayOfByte);
      this.f = localb;
      localb.execute(new Void[0]);
      return;
    }
    this.e.a("CONNECTION_PROBLEM");
  }

  public static abstract interface a
  {
    public abstract void a(l paraml);

    public abstract void a(String paramString);

    public abstract void b();
  }

  public class b extends AsyncTask<Void, Integer, Void>
  {
    private t b = new t();
    private String c;
    private String d;

    public b(long arg2, byte[] arg4)
    {
      this.c = String.valueOf(???);
      byte[] arrayOfByte1;
      this.d = Base64.encodeToString(arrayOfByte1, 0);
    }

    protected Void a(Void[] paramArrayOfVoid)
    {
      if (!cj.b(n.b(n.this)))
      {
        n.a(n.this).a("CONNECTION_PROBLEM");
        return null;
      }
      ag localag = ViberApplication.getInstance().getRequestCreator().a(null, -1, this.d, this.c);
      ai localai = new ai();
      try
      {
        l locall = (l)localai.a(localag, this.b);
        if (!isCancelled())
        {
          n.a(n.this).a(locall);
          return null;
        }
      }
      catch (Exception localException)
      {
        n.a(n.this).a("UNKNOWN");
        return null;
      }
      n.a(n.this).a("CANCEL");
      return null;
    }

    protected void onCancelled()
    {
      super.onCancelled();
      this.b.b();
    }

    protected void onPreExecute()
    {
      if (!isCancelled())
      {
        n.a(n.this).b();
        return;
      }
      n.a(n.this).a("CANCEL");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.n
 * JD-Core Version:    0.6.2
 */