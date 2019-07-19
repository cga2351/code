package com.viber.voip.registration;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.R.array;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.notif.e.m;
import com.viber.voip.notif.g;
import com.viber.voip.util.an;
import com.viber.voip.util.cf;
import com.viber.voip.y;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b extends PhoneStateListener
{
  public static final Pattern a;
  private static final Logger b = ViberEnv.getLogger();
  private static Handler l = new Handler(localHandlerThread.getLooper());
  private Context c;
  private ActivationController.a d;
  private String e = "";
  private String f = "";
  private HashSet<String> g = new HashSet();
  private final ActivationController h;
  private boolean i;
  private boolean j;
  private Runnable k = new Runnable()
  {
    public void run()
    {
      ViberApplication localViberApplication;
      String[] arrayOfString;
      if ((b.a(b.this)) && (b.b(b.this)))
      {
        localViberApplication = ViberApplication.getInstance();
        if (!y.c())
          break label77;
        arrayOfString = new String[3];
        arrayOfString[0] = RegistrationActivity.class.getName();
        arrayOfString[1] = y.a().getName();
        arrayOfString[2] = y.b().getName();
      }
      while (true)
      {
        if (!localViberApplication.isActivityOnForeground(arrayOfString))
          b.c(b.this);
        return;
        label77: arrayOfString = new String[2];
        arrayOfString[0] = RegistrationActivity.class.getName();
        arrayOfString[1] = y.a().getName();
      }
    }
  };
  private cf m;
  private TelephonyManager n;
  private m o;
  private boolean p = false;

  static
  {
    a = Pattern.compile("(\\d{2})(\\d)(\\d)(\\d{6})(\\d)(\\d)");
    HandlerThread localHandlerThread = new HandlerThread("ActivationCallReceiver");
    localHandlerThread.start();
  }

  public b(ActivationController.a parama, Context paramContext, boolean paramBoolean)
  {
    this.c = paramContext;
    this.d = parama;
    this.i = paramBoolean;
    this.n = ((TelephonyManager)this.c.getSystemService("phone"));
    this.m = new cf(l, this.k, 200L);
    this.h = ViberApplication.getInstance().getActivationController();
    this.o = g.a(paramContext).a();
  }

  private boolean a(String paramString)
  {
    label7: String str1;
    Matcher localMatcher;
    if (TextUtils.isEmpty(paramString));else
    {
      String str2;
      do
      {
        do
        {
          return false;
          str1 = paramString.replaceAll("[^0-9]", "");
        }
        while ((TextUtils.isEmpty(str1)) || (str1.length() < 12));
        str2 = str1.substring(-12 + str1.length(), str1.length());
      }
      while ((TextUtils.isEmpty(str2)) || (!str2.matches(a.pattern())));
      localMatcher = a.matcher(str2);
    }
    label251: 
    while (true)
    {
      if (!localMatcher.find())
        break label7;
      if (localMatcher.groupCount() != 6)
        break;
      String str3 = localMatcher.group(1);
      String[] arrayOfString = this.c.getResources().getStringArray(R.array.tzintuk_country_codes);
      for (int i1 = 0; ; i1++)
      {
        if (i1 >= arrayOfString.length)
          break label251;
        if (str3.equals(arrayOfString[i1]))
        {
          if (0 + Integer.valueOf(str3.substring(0, 1)).intValue() + Integer.valueOf(str3.substring(1)).intValue() + Integer.valueOf(localMatcher.group(2)).intValue() + Integer.valueOf(localMatcher.group(3)).intValue() + Integer.valueOf(localMatcher.group(5)).intValue() + Integer.valueOf(localMatcher.group(6)).intValue() != 29)
            break;
          this.e = localMatcher.group(4);
          this.f = str1;
          return true;
        }
      }
    }
  }

  private void d()
  {
    Intent localIntent = new Intent(ViberApplication.getApplication(), RegistrationActivity.class);
    localIntent.setFlags(805437440);
    ViberApplication.getApplication().startActivity(localIntent);
  }

  private void e()
  {
    this.p = true;
    this.m.a();
  }

  private void f()
  {
    this.p = false;
    this.m.b();
  }

  public void a()
  {
    this.n.listen(this, 33);
  }

  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  public void b()
  {
    f();
    this.o.b();
    this.n.listen(this, 0);
  }

  public void c()
  {
    if ((this.p) && (this.i))
      d();
  }

  public void onCallStateChanged(int paramInt, String paramString)
  {
    int i1 = this.h.getStep();
    if ((this.i) && (i1 != 1) && (i1 != 9) && (i1 != 0));
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt)
          {
          default:
            return;
          case 0:
          case 1:
          }
        }
        while (!this.p);
        this.o.b();
        if ((TextUtils.isEmpty(paramString)) || (!this.g.contains(paramString)))
          break;
        this.g.remove(paramString);
      }
      while (!this.g.isEmpty());
      f();
    }
    while (TextUtils.isEmpty(this.e));
    ActivationController.ActivationCode localActivationCode = new ActivationController.ActivationCode(this.e, ActivationController.b.c);
    this.d.a(localActivationCode);
    return;
    e();
    if (!a(paramString))
    {
      f();
      return;
    }
    if (this.j)
      an.b(this.c);
    this.o.a();
    this.g.add(this.f);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.b
 * JD-Core Version:    0.6.2
 */