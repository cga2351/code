package com.viber.voip.ads;

import android.content.Context;
import android.os.Handler;
import com.viber.jni.cdr.CdrConst.AdsAfterCallTypeCall.Converter;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.util.ax;

public class h
{
  private Context a;
  private PhoneController b;
  private ICdrController c;
  private Handler d;
  private int e;
  private int f = 1;
  private String g;
  private String h;
  private int i = 0;

  public h(Context paramContext, PhoneController paramPhoneController, ICdrController paramICdrController, int paramInt, Handler paramHandler, String paramString)
  {
    this.a = paramContext;
    this.b = paramPhoneController;
    this.c = paramICdrController;
    this.d = paramHandler;
    this.e = paramInt;
    this.h = paramString;
  }

  public void a(int paramInt)
  {
    this.f = paramInt;
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.d.post(new a(this.a, this.b, this.c, paramInt1, this.e, this.f, this.g, this.h, paramInt2, this.i));
  }

  public void a(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4)
  {
    this.d.post(new a(this.a, this.b, this.c, paramInt1, paramInt3, this.f, paramString1, paramString2, paramInt2, paramInt4));
  }

  public void a(int paramInt1, CallInfo paramCallInfo, int paramInt2)
  {
    this.d.post(new a(this.a, this.b, this.c, paramInt1, paramCallInfo, this.e, this.f, this.g, this.h, paramInt2, true, this.i));
  }

  public void a(String paramString)
  {
    this.g = paramString;
  }

  public void b(int paramInt)
  {
    this.i = paramInt;
  }

  private static class a
    implements Runnable
  {
    private final Context a;
    private final PhoneController b;
    private final ICdrController c;
    private final int d;
    private final CallInfo e;
    private int f;
    private int g;
    private final int h;
    private String i;
    private String j;
    private boolean k;
    private final int l;

    a(Context paramContext, PhoneController paramPhoneController, ICdrController paramICdrController, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, int paramInt5)
    {
      this(paramContext, paramPhoneController, paramICdrController, paramInt1, null, paramInt2, paramInt3, paramString1, paramString2, paramInt4, false, paramInt5);
    }

    a(Context paramContext, PhoneController paramPhoneController, ICdrController paramICdrController, int paramInt1, CallInfo paramCallInfo, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, boolean paramBoolean, int paramInt5)
    {
      this.a = paramContext;
      this.b = paramPhoneController;
      this.c = paramICdrController;
      this.d = paramInt1;
      this.e = paramCallInfo;
      this.f = paramInt2;
      this.g = paramInt3;
      this.i = paramString1;
      this.j = paramString2;
      this.h = paramInt4;
      this.k = paramBoolean;
      this.l = paramInt5;
    }

    public void run()
    {
      long l1;
      if (this.k)
        if (this.e != null)
        {
          l1 = this.e.getInCallState().getCallToken();
          if (l1 > 0L)
            break label151;
        }
      label151: for (long l2 = this.b.handleGetCallToken(); ; l2 = l1)
      {
        this.c.handleReportAdRequestSent(ax.a(this.a.getPackageManager()), this.d, l2, this.h, CdrConst.AdsAfterCallTypeCall.Converter.fromCallInfo(this.e), this.f, this.g, this.i, this.j, this.l);
        return;
        this.c.handleReportAdRequestSent(ax.a(this.a.getPackageManager()), this.d, 0L, this.h, 1, this.f, this.g, this.i, this.j, this.l);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.h
 * JD-Core Version:    0.6.2
 */