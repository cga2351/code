package com.viber.voip.notif.b.i;

import android.content.Context;
import android.content.Intent;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.market.StickerMarketActivity;
import com.viber.voip.notif.b.b;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.d.e;
import com.viber.voip.notif.f.g;
import com.viber.voip.util.dz;

public class a extends b
{
  private final int a;
  private final String b;
  private final int c;
  private final n[] h;

  private a(int paramInt1, String paramString, int paramInt2, n[] paramArrayOfn)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramInt2;
    this.h = paramArrayOfn;
  }

  public static e a(int paramInt1, int paramInt2, String paramString, o paramo, g paramg)
  {
    int i = R.string.downloading_stickers_progress;
    n[] arrayOfn = new n[5];
    arrayOfn[0] = paramo.a(100, paramInt2);
    arrayOfn[1] = paramo.a(paramInt2 + "%");
    arrayOfn[2] = paramo.b(true);
    arrayOfn[3] = paramo.a(false);
    arrayOfn[4] = paramo.a(paramg);
    return new a(paramInt1, paramString, i, arrayOfn);
  }

  public static e a(int paramInt, String paramString, o paramo)
  {
    int i = R.string.downloading_stickers_progress;
    n[] arrayOfn = new n[3];
    arrayOfn[0] = paramo.a();
    arrayOfn[1] = paramo.b(true);
    arrayOfn[2] = paramo.a(false);
    return new a(paramInt, paramString, i, arrayOfn);
  }

  public static e a(int paramInt, String paramString, o paramo, g paramg)
  {
    int i = R.string.downloading_stickers_finish;
    n[] arrayOfn = new n[1];
    arrayOfn[0] = paramo.a(paramg);
    return new a(paramInt, paramString, i, arrayOfn);
  }

  public static e b(int paramInt, String paramString, o paramo, g paramg)
  {
    int i = R.string.downloading_stickers_error;
    n[] arrayOfn = new n[1];
    arrayOfn[0] = paramo.a(paramg);
    return new a(paramInt, paramString, i, arrayOfn);
  }

  public static e c(int paramInt, String paramString, o paramo, g paramg)
  {
    int i = R.string.installing_stickers;
    n[] arrayOfn = new n[4];
    arrayOfn[0] = paramo.a();
    arrayOfn[1] = paramo.b(true);
    arrayOfn[2] = paramo.a(false);
    arrayOfn[3] = paramo.a(paramg);
    return new a(paramInt, paramString, i, arrayOfn);
  }

  private Intent e()
  {
    Intent localIntent = StickerMarketActivity.a(this.a, false, 99, "Notification", "Product Page");
    dz.a(localIntent);
    return localIntent;
  }

  public String R_()
  {
    return "sticker_package";
  }

  public int a()
  {
    return this.a;
  }

  protected void a(Context paramContext, o paramo)
  {
    a(this.h);
    n[] arrayOfn = new n[2];
    arrayOfn[0] = paramo.b(paramContext, this.a, e(), 0);
    arrayOfn[1] = paramo.b(this.b);
    a(arrayOfn);
  }

  public int b()
  {
    return R.drawable.download_icon;
  }

  public CharSequence b(Context paramContext)
  {
    return paramContext.getString(this.c);
  }

  public CharSequence b_(Context paramContext)
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.i.a
 * JD-Core Version:    0.6.2
 */