package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;
import com.mopub.common.AdReport;
import com.mopub.common.util.DateAndTime;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class AdAlertReporter
{
  private final String a;
  private final View b;
  private final Context c;
  private Intent d;
  private String e;
  private String f;

  public AdAlertReporter(Context paramContext, View paramView, AdReport paramAdReport)
  {
    this.b = paramView;
    this.c = paramContext;
    this.a = new SimpleDateFormat("M/d/yy hh:mm:ss a z", Locale.US).format(DateAndTime.now());
    a();
    String str = a(b());
    this.e = "";
    this.f = "";
    if (paramAdReport != null)
    {
      this.e = paramAdReport.toString();
      this.f = paramAdReport.getResponseString();
    }
    c();
    String[] arrayOfString = new String[3];
    arrayOfString[0] = this.e;
    arrayOfString[1] = this.f;
    arrayOfString[2] = str;
    a(arrayOfString);
  }

  private String a(Bitmap paramBitmap)
  {
    Object localObject = null;
    if (paramBitmap != null);
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 25, localByteArrayOutputStream);
      String str = Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 0);
      localObject = str;
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private void a()
  {
    this.d = new Intent("android.intent.action.SENDTO");
    this.d.setData(Uri.parse("mailto:creative-review@mopub.com"));
  }

  private void a(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Thank you for taking the time to tell us about your ad experience.\n\nPlease share with us how the ad experience was poor:\n\n");
    localStringBuilder.append("\n=================\n");
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      localStringBuilder.append(paramArrayOfString[i]);
      if (i != -1 + paramArrayOfString.length)
        localStringBuilder.append("\n=================\n");
    }
    this.d.putExtra("android.intent.extra.TEXT", localStringBuilder.toString());
  }

  private Bitmap b()
  {
    if ((this.b == null) || (this.b.getRootView() == null));
    View localView;
    boolean bool;
    Bitmap localBitmap1;
    do
    {
      return null;
      localView = this.b.getRootView();
      bool = localView.isDrawingCacheEnabled();
      localView.setDrawingCacheEnabled(true);
      localBitmap1 = localView.getDrawingCache();
    }
    while (localBitmap1 == null);
    Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1);
    localView.setDrawingCacheEnabled(bool);
    return localBitmap2;
  }

  private void c()
  {
    this.d.putExtra("android.intent.extra.SUBJECT", "New creative violation report - " + this.a);
  }

  public void send()
  {
    try
    {
      Intents.startActivity(this.c, this.d);
      return;
    }
    catch (IntentNotResolvableException localIntentNotResolvableException)
    {
      Toast.makeText(this.c, "No email client available", 0).show();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.AdAlertReporter
 * JD-Core Version:    0.6.2
 */