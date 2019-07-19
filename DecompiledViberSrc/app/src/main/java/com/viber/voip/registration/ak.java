package com.viber.voip.registration;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64;
import com.viber.common.dialogs.h.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.secure.SecureTokenDelegate;
import com.viber.jni.secure.SecureTokenListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.c.l;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.util.cj;
import com.viber.voip.util.t;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ak
  implements SecureTokenDelegate
{
  private static final Logger a = ViberEnv.getLogger();
  private Map<Integer, d> b;
  private Engine c;
  private c d;

  public ak(c paramc)
  {
    this.d = paramc;
    this.b = new ConcurrentHashMap();
    this.c = ViberApplication.getInstance().getEngine(false);
  }

  private void a(int paramInt)
  {
    d locald = (d)this.b.remove(Integer.valueOf(paramInt));
    c localc;
    if (this.d != null)
    {
      localc = this.d;
      if (locald == null)
        break label48;
    }
    label48: for (String str = locald.a; ; str = "")
    {
      localc.a(str);
      return;
    }
  }

  private void b(int paramInt)
  {
    d locald = (d)this.b.remove(Integer.valueOf(paramInt));
    c localc;
    if (this.d != null)
    {
      localc = this.d;
      if (locald == null)
        break label48;
    }
    label48: for (String str = locald.a; ; str = "")
    {
      localc.b(str);
      return;
    }
  }

  public void a(String paramString, int paramInt)
  {
    this.c.getDelegatesManager().getSecureTokenListener().registerDelegate(new SecureTokenDelegate[] { this });
    int i = this.c.getPhoneController().generateSequence();
    this.b.put(Integer.valueOf(i), new d(paramString, paramInt));
    this.c.getPhoneController().handleSecureTokenRequest(i);
  }

  public void onSecureTokenReply(int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    this.c.getDelegatesManager().getSecureTokenListener().removeDelegate(this);
    if ((paramLong > 0L) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      new a(paramLong, paramArrayOfByte, paramInt).execute(new Void[0]);
      return;
    }
    ad.a().d();
  }

  private class a extends AsyncTask<Void, Integer, ak.b>
  {
    private t b = new t();
    private String c;
    private String d;
    private int e;

    public a(long arg2, byte[] paramInt, int arg5)
    {
      this.c = String.valueOf(???);
      this.d = Base64.encodeToString(paramInt, 0);
      int i;
      this.e = i;
    }

    protected ak.b a(Void[] paramArrayOfVoid)
    {
      ak.d locald = (ak.d)ak.a(ak.this).get(Integer.valueOf(this.e));
      ak.b localb = new ak.b(ak.this);
      if ((locald != null) && (!TextUtils.isEmpty(locald.a)))
      {
        if (!cj.b(ViberApplication.getApplication()))
          ak.b.a(localb, "CONNECTION_PROBLEM");
      }
      else
        return localb;
      ag localag = ViberApplication.getInstance().getRequestCreator().a(locald.a, locald.b, this.d, this.c);
      ai localai = new ai();
      try
      {
        ak.b.a(localb, (l)localai.a(localag, this.b));
        ak.b.a(localb, this.e);
        return localb;
      }
      catch (Exception localException)
      {
      }
      return localb;
    }

    protected void a(ak.b paramb)
    {
      if (paramb.a())
      {
        a(ak.b.a(paramb));
        ak.a(ak.this).remove(Integer.valueOf(ak.b.b(paramb)));
        return;
      }
      if ((ak.b.c(paramb) != null) && (ak.b.c(paramb).f()))
      {
        ak.a(ak.this, ak.b.b(paramb));
        return;
      }
      ak.b(ak.this, ak.b.b(paramb));
    }

    void a(String paramString)
    {
      if ("CONNECTION_PROBLEM".equals(paramString))
        ad.a().d();
    }

    protected void onCancelled()
    {
      super.onCancelled();
      this.b.b();
    }
  }

  class b
  {
    private String b;
    private l c;
    private int d;

    b()
    {
    }

    boolean a()
    {
      return !TextUtils.isEmpty(this.b);
    }
  }

  public static abstract interface c
  {
    public abstract void a(String paramString);

    public abstract void b(String paramString);
  }

  private class d
  {
    public String a;
    public int b;

    d(String paramInt, int arg3)
    {
      this.a = paramInt;
      int i;
      this.b = i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.ak
 * JD-Core Version:    0.6.2
 */