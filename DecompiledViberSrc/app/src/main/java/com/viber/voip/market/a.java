package com.viber.voip.market;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.registration.af;
import com.viber.voip.schedule.d.a;
import com.viber.voip.schedule.d.c;
import com.viber.voip.user.UserManager;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a
  implements d.c
{
  private static final Logger a = ViberEnv.getLogger();
  private Integer b;
  private Integer c;
  private AtomicBoolean d = new AtomicBoolean(false);
  private BroadcastReceiver e;
  private Context f;
  private af g;
  private Handler h = av.a(av.e.a);

  public a(Context paramContext, d.a parama)
  {
    this.f = paramContext;
    this.g = UserManager.from(paramContext).getRegistrationValues();
    a(parama);
  }

  private void a(d.a parama)
  {
    parama.a(this);
    this.e = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        a.a(a.this, a.this.g());
        a.this.i();
        a.this.e();
      }
    };
    this.f.registerReceiver(this.e, new IntentFilter(b()));
    this.d.set(true);
  }

  private int b(JSONObject paramJSONObject)
  {
    int i = 0;
    ViberApplication localViberApplication = ViberApplication.getInstance();
    String str1 = "+" + this.g.b();
    String str2 = localViberApplication.getHardwareParameters().getMCC();
    String str3 = localViberApplication.getHardwareParameters().getMNC();
    String str4 = this.g.g();
    String str5;
    Iterator localIterator;
    int j;
    int k;
    int m;
    if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
    {
      str5 = String.format("%s/%s", new Object[] { str2, str3 });
      localIterator = paramJSONObject.keys();
      j = 0;
      k = 0;
      m = 0;
    }
    while (true)
    {
      if (localIterator.hasNext())
      {
        String str6 = (String)localIterator.next();
        try
        {
          if (str6.equals(""))
          {
            i = paramJSONObject.getInt(str6);
          }
          else if (str6.equals(str1))
          {
            k = paramJSONObject.getInt(str6);
          }
          else if (str6.equals(str5))
          {
            j = paramJSONObject.getInt(str6);
          }
          else if ((str4 != null) && (str4.startsWith(str6)))
          {
            int i4 = paramJSONObject.getInt(str6);
            m = i4;
          }
        }
        catch (JSONException localJSONException)
        {
          n = i;
          i1 = j;
          i2 = k;
          i3 = m;
          break label297;
        }
      }
      else
      {
        if (m != 0)
          return m;
        if (j != 0)
          return j;
        if (k != 0)
          return k;
        return i;
        str5 = null;
        break;
      }
      int n = i;
      int i1 = j;
      int i2 = k;
      int i3 = m;
      label297: m = i3;
      k = i2;
      j = i1;
      i = n;
    }
  }

  private void b(int paramInt)
  {
    this.c = Integer.valueOf(paramInt);
    c().a(paramInt);
  }

  private int j()
  {
    if (this.c == null)
      this.c = Integer.valueOf(c().d());
    return this.c.intValue();
  }

  protected abstract String a();

  public void a(int paramInt)
  {
    this.b = Integer.valueOf(paramInt);
    d().a(paramInt);
  }

  public void a(JSONObject paramJSONObject)
  {
    final int i = b(paramJSONObject);
    this.h.post(new Runnable()
    {
      public void run()
      {
        if ((a.this.g() == 0) && (a.a(a.this) == 0))
          a.a(a.this, i);
        a.this.a(i);
        a.this.i();
      }
    });
  }

  protected abstract String b();

  protected abstract d c();

  protected abstract d d();

  protected void e()
  {
  }

  public void f()
  {
    if ((this.e != null) && (this.d.get()))
    {
      this.f.unregisterReceiver(this.e);
      this.e = null;
    }
  }

  public int g()
  {
    if (this.b == null)
      this.b = Integer.valueOf(d().d());
    return this.b.intValue();
  }

  public int h()
  {
    int i = g() - j();
    if (i < 0)
      i = 0;
    return i;
  }

  public void i()
  {
    this.f.sendBroadcast(new Intent(a()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.a
 * JD-Core Version:    0.6.2
 */