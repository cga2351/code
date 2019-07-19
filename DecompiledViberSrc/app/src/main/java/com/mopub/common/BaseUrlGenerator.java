package com.mopub.common;

import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.network.Networking;

public abstract class BaseUrlGenerator
{
  private StringBuilder a;
  private boolean b;

  private String a()
  {
    if (this.b)
    {
      this.b = false;
      return "?";
    }
    return "&";
  }

  protected void a(Point paramPoint)
  {
    b("w", "" + paramPoint.x);
    b("h", "" + paramPoint.y);
  }

  protected void a(String paramString, Boolean paramBoolean)
  {
    if (paramBoolean == null)
      return;
    this.a.append(a());
    this.a.append(paramString);
    this.a.append("=");
    StringBuilder localStringBuilder = this.a;
    if (paramBoolean.booleanValue());
    for (String str = "1"; ; str = "0")
    {
      localStringBuilder.append(str);
      return;
    }
  }

  protected void a(String paramString1, String paramString2)
  {
    this.a = new StringBuilder(Networking.getScheme()).append("://").append(paramString1).append(paramString2);
    this.b = true;
  }

  protected void a(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1))
      return;
    for (int i = 0; i < -1 + paramArrayOfString.length; i++)
      localStringBuilder.append(paramArrayOfString[i]).append(",");
    localStringBuilder.append(paramArrayOfString[(-1 + paramArrayOfString.length)]);
    b("dn", localStringBuilder.toString());
  }

  protected void b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
      return;
    this.a.append(a());
    this.a.append(paramString1);
    this.a.append("=");
    this.a.append(Uri.encode(paramString2));
  }

  protected void b(boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = "1"; ; str = "0")
    {
      b("android_perms_ext_storage", str);
      return;
    }
  }

  protected String g()
  {
    return this.a.toString();
  }

  public abstract String generateUrlString(String paramString);

  protected void h()
  {
    b("udid", "mp_tmpl_advertising_id");
    b("dnt", "mp_tmpl_do_not_track");
  }

  protected void m(String paramString)
  {
    b("v", paramString);
  }

  protected void n(String paramString)
  {
    b("av", paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.BaseUrlGenerator
 * JD-Core Version:    0.6.2
 */