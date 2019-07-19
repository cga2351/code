package com.viber.voip.messages.controller.manager;

import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Handler;
import com.google.d.a.c;
import com.google.d.f;
import com.google.d.p;
import com.viber.common.b.b;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.jni.connection.ConnectionController;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CSyncDataFromMyOtherDeviceMsg;
import com.viber.jni.im2.CSyncDataToMyDevicesMsg;
import com.viber.jni.im2.CSyncDataToMyDevicesReplyMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.registration.ActivationController.c;
import com.viber.voip.settings.d.al;
import org.json.JSONException;
import org.json.JSONObject;

public class ax
  implements av
{
  private static final Logger a = ViberEnv.getLogger();
  private volatile boolean b = false;
  private final j c;
  private final dagger.a<f> d;
  private final com.viber.voip.util.i.e e;
  private final Im2Exchanger f;
  private final PhoneController g;
  private final ConnectionController h;
  private final ActivationController i;
  private final Handler j;
  private final com.viber.common.b.d k;
  private final b l;
  private final b m;
  private final com.viber.common.b.e n;
  private final com.viber.common.b.d o;
  private final b p;
  private final b q;
  private final b r;
  private final b s;
  private final h t;
  private SharedPreferences.OnSharedPreferenceChangeListener u;
  private final ConnectionDelegate v = new ConnectionDelegate()
  {
    private int b = 0;

    public void onConnect()
    {
      if ((!ax.a(ax.this).a()) && ((ax.b(ax.this).d() > 0) || (ax.c(ax.this).d())))
        ax.d(ax.this);
    }

    public void onConnectionStateChange(int paramAnonymousInt)
    {
      if ((!ax.a(ax.this).a()) || (this.b == paramAnonymousInt))
        return;
      if (paramAnonymousInt == 3)
      {
        long l = ax.e(ax.this).a();
        if ((l - ax.f(ax.this).d() > ax.a(ax.this).b()) || (ax.g(ax.this).d() > 0) || (ax.h(ax.this).d()))
          ax.i(ax.this);
        ax.f(ax.this).a(l);
      }
      while (true)
      {
        this.b = paramAnonymousInt;
        return;
        if (this.b == 3)
          ax.f(ax.this).a(ax.e(ax.this).a());
      }
    }
  };
  private final ActivationController.c w = new ActivationController.c()
  {
    public void onActivationStateChange(int paramAnonymousInt)
    {
      if ((ax.a(ax.this).a()) && (ax.j(ax.this).getStep() == 8))
        ax.k(ax.this).post(new ay(this));
    }
  };

  public ax(j paramj, dagger.a<f> parama, com.viber.voip.util.i.e parame, Im2Exchanger paramIm2Exchanger, PhoneController paramPhoneController, ConnectionController paramConnectionController, ActivationController paramActivationController, Handler paramHandler, com.viber.common.b.d paramd1, b paramb1, com.viber.common.b.d paramd2, b paramb2, com.viber.common.b.e parame1, b paramb3, b paramb4, b paramb5, b paramb6, h paramh)
  {
    this.c = paramj;
    this.d = parama;
    this.e = parame;
    this.f = paramIm2Exchanger;
    this.g = paramPhoneController;
    this.h = paramConnectionController;
    this.i = paramActivationController;
    this.j = paramHandler;
    this.k = paramd1;
    this.l = paramb1;
    this.m = paramb2;
    this.n = parame1;
    this.o = paramd2;
    this.p = paramb3;
    this.q = paramb4;
    this.r = paramb5;
    this.s = paramb6;
    this.t = paramh;
  }

  private void a()
  {
    int i1 = this.g.generateSequence();
    this.k.a(i1);
    if (this.l.d())
      this.l.a(false);
    if (!this.h.isConnected())
      return;
    a locala = new a(this.p.d(), this.q.d(), this.r.d(), this.s.d(), this.t.d());
    CSyncDataToMyDevicesMsg localCSyncDataToMyDevicesMsg = new CSyncDataToMyDevicesMsg(((f)this.d.get()).b(locala).getBytes(), 0, 2L, i1, 0L);
    this.f.handleCSyncDataToMyDevicesMsg(localCSyncDataToMyDevicesMsg);
  }

  private void b()
  {
    int i1 = this.g.generateSequence();
    this.o.a(i1);
    if (this.m.d())
      this.m.a(false);
    if ((!this.h.isConnected()) || (this.i.getStep() != 8))
      return;
    CSyncDataToMyDevicesMsg localCSyncDataToMyDevicesMsg = new CSyncDataToMyDevicesMsg(((f)this.d.get()).b(new b()).getBytes(), 0, 1L, i1, 0L);
    this.f.handleCSyncDataToMyDevicesMsg(localCSyncDataToMyDevicesMsg);
  }

  public void a(ConnectionListener paramConnectionListener)
  {
    if (this.b)
      return;
    this.b = true;
    paramConnectionListener.registerDelegate(this.v, this.j);
    Handler localHandler = this.j;
    com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[5];
    arrayOfa[0] = this.p;
    arrayOfa[1] = this.q;
    arrayOfa[2] = this.r;
    arrayOfa[3] = this.s;
    arrayOfa[4] = this.t;
    this.u = new d.al(localHandler, arrayOfa)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        if (!ax.a(ax.this).a())
          ax.d(ax.this);
      }
    };
    com.viber.voip.settings.d.a(this.u);
    this.i.registerActivationStateListener(this.w);
  }

  public void onCSyncDataFromMyOtherDeviceMsg(CSyncDataFromMyOtherDeviceMsg paramCSyncDataFromMyOtherDeviceMsg)
  {
    String str1 = new String(paramCSyncDataFromMyOtherDeviceMsg.encryptedData);
    try
    {
      String str2 = new JSONObject(str1).getString("Action");
      if ((this.c.a()) && ("Reply".equalsIgnoreCase(str2)))
      {
        a locala = (a)((f)this.d.get()).a(str1, a.class);
        this.p.a(locala.a());
        this.q.a(locala.b());
        this.r.a(locala.c());
        this.s.a(locala.d());
        this.t.a(locala.e());
        return;
      }
      if ((!this.c.a()) && ("Request".equalsIgnoreCase(str2)))
      {
        a();
        return;
      }
    }
    catch (JSONException localJSONException)
    {
    }
    catch (p localp)
    {
    }
  }

  public void onCSyncDataToMyDevicesReplyMsg(CSyncDataToMyDevicesReplyMsg paramCSyncDataToMyDevicesReplyMsg)
  {
    if (paramCSyncDataToMyDevicesReplyMsg.status == 0)
    {
      if ((this.c.a()) || (paramCSyncDataToMyDevicesReplyMsg.seq != this.k.d()))
        break label39;
      this.k.e();
    }
    label39: 
    while ((!this.c.a()) || (paramCSyncDataToMyDevicesReplyMsg.seq != this.o.d()))
      return;
    this.o.e();
  }

  public static class a
  {

    @com.google.d.a.a(b=false)
    @c(a="Type")
    private final String a = as.a.c.a();

    @com.google.d.a.a(b=false)
    @c(a="Action")
    private final String b = "Reply";

    @c(a="CollectAnalytics")
    private boolean c;

    @c(a="AllowContentPersonalization")
    private boolean d;

    @c(a="AllowInterestBasedAds")
    private boolean e;

    @c(a="AllowLocationBasedAds")
    private boolean f;

    @c(a="IABConsentString")
    private String g;

    public a()
    {
    }

    public a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString)
    {
      this.c = paramBoolean1;
      this.d = paramBoolean2;
      this.e = paramBoolean3;
      this.f = paramBoolean4;
      this.g = paramString;
    }

    public boolean a()
    {
      return this.c;
    }

    public boolean b()
    {
      return this.d;
    }

    public boolean c()
    {
      return this.e;
    }

    public boolean d()
    {
      return this.f;
    }

    public String e()
    {
      return this.g;
    }

    public String toString()
    {
      return "GdprDataReplyMessage{mType='" + this.a + '\'' + ", mAction='" + "Reply" + '\'' + ", mCollectAnalytics=" + this.c + ", mAllowContentPersonalization=" + this.d + ", mAllowInterestBasedAds=" + this.e + ", mAllowLocationBasedAds=" + this.f + ", mConsentString=" + this.g + '}';
    }
  }

  public static class b
  {

    @com.google.d.a.a(b=false)
    @c(a="Type")
    private final String a = as.a.c.a();

    @com.google.d.a.a(b=false)
    @c(a="Action")
    private final String b = "Request";

    public String toString()
    {
      return "GdprDataRequestMessage{mType='" + this.a + '\'' + ", mAction='" + "Request" + '\'' + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.ax
 * JD-Core Version:    0.6.2
 */