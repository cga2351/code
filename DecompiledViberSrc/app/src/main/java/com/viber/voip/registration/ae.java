package com.viber.voip.registration;

import android.os.Handler;
import android.util.Base64;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.secure.SecureTokenDelegate;
import com.viber.jni.secure.SecureTokenListener;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.c.b;
import com.viber.voip.registration.c.d;
import com.viber.voip.registration.c.g;
import com.viber.voip.registration.c.r;
import com.viber.voip.registration.c.v;

public class ae
{
  private static final Logger a = ViberEnv.getLogger();
  private Engine b;
  private Handler c;
  private ah d;

  public ae(Engine paramEngine, Handler paramHandler, ah paramah)
  {
    this.b = paramEngine;
    this.c = paramHandler;
    this.d = paramah;
  }

  private void a(final a parama)
  {
    final int i = this.b.getPhoneController().generateSequence();
    SecureTokenListener localSecureTokenListener = this.b.getDelegatesManager().getSecureTokenListener();
    SecureTokenDelegate[] arrayOfSecureTokenDelegate = new SecureTokenDelegate[1];
    arrayOfSecureTokenDelegate[0] = new SecureTokenDelegate()
    {
      public void onSecureTokenReply(int paramAnonymousInt, long paramAnonymousLong, byte[] paramAnonymousArrayOfByte)
      {
        if (i == paramAnonymousInt)
        {
          ae.c(ae.this).getDelegatesManager().getSecureTokenListener().removeDelegate(this);
          if ((paramAnonymousLong > 0L) && (paramAnonymousArrayOfByte != null) && (paramAnonymousArrayOfByte.length > 0))
          {
            String str1 = String.valueOf(paramAnonymousLong);
            String str2 = Base64.encodeToString(paramAnonymousArrayOfByte, 0);
            parama.a(str1, str2);
          }
        }
        else
        {
          return;
        }
        parama.a();
      }
    };
    localSecureTokenListener.registerDelegate(arrayOfSecureTokenDelegate);
    this.b.getPhoneController().handleSecureTokenRequest(i);
  }

  public void a(aj<com.viber.voip.registration.c.t> paramaj, com.viber.voip.util.t paramt)
  {
    ag localag = this.d.b();
    new ai().a(this.c, localag, paramaj, paramt);
  }

  public void a(String paramString, aj<d> paramaj, com.viber.voip.util.t paramt)
  {
    ag localag = this.d.b(paramString);
    new ai().a(this.c, localag, paramaj, paramt);
  }

  public void a(final String paramString1, final String paramString2, final aj<b> paramaj, final com.viber.voip.util.t paramt)
  {
    a(new a()
    {
      public void a()
      {
        paramaj.a(null);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2)
      {
        ag localag = ae.a(ae.this).a(paramString2, paramString1, paramAnonymousString2, paramAnonymousString1);
        new ai().a(ae.b(ae.this), localag, paramaj, paramt);
      }
    });
  }

  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte paramByte, boolean paramBoolean, aj<r> paramaj, com.viber.voip.util.t paramt)
  {
    ag localag = this.d.a(paramString1, paramString2, paramString3, paramString5, paramString4, 4, paramByte, paramBoolean);
    new ai().a(this.c, localag, paramaj, paramt);
  }

  public void a(final String paramString1, final String paramString2, final boolean paramBoolean, final aj<g> paramaj, final com.viber.voip.util.t paramt)
  {
    a(new a()
    {
      public void a()
      {
        paramaj.a(null);
      }

      public void a(String paramAnonymousString1, String paramAnonymousString2)
      {
        ag localag = ae.a(ae.this).a(paramString1, paramString2, paramBoolean, paramAnonymousString2, paramAnonymousString1);
        new ai().a(ae.b(ae.this), localag, paramaj, paramt);
      }
    });
  }

  public void b(String paramString, aj<v> paramaj, com.viber.voip.util.t paramt)
  {
    ag localag = this.d.a(paramString);
    new ai().a(this.c, localag, paramaj, paramt);
  }

  static abstract interface a
  {
    public abstract void a();

    public abstract void a(String paramString1, String paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.ae
 * JD-Core Version:    0.6.2
 */