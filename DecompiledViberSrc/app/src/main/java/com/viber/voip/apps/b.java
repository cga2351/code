package com.viber.voip.apps;

import android.net.Uri;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.CGetAppDetails;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.av;
import com.viber.voip.util.dx;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static final Logger a = ViberEnv.getLogger();
  private final int b;
  private int c;
  private String d;
  private String e;
  private String f;
  private String g;
  private int h;
  private int i;
  private long j;

  public b(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, int paramInt3, long paramLong, int paramInt4)
  {
    this.b = paramInt1;
    this.d = paramString1;
    this.c = paramInt2;
    this.g = paramString2;
    this.e = paramString3;
    this.f = paramString4;
    this.h = paramInt3;
    this.j = paramLong;
    this.i = paramInt4;
  }

  public b(CGetAppDetails paramCGetAppDetails)
  {
    this.b = paramCGetAppDetails.appId;
    this.c = paramCGetAppDetails.type;
    this.d = paramCGetAppDetails.name;
    this.h = paramCGetAppDetails.status;
    a(paramCGetAppDetails.clientData);
    d(paramCGetAppDetails.replyable);
    b(paramCGetAppDetails.platformData);
  }

  public static b a(int paramInt)
  {
    return new b(paramInt, null, -1, null, null, null, 0, 0L, 0);
  }

  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (this.c != 2);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      b(localJSONObject.getBoolean("auto_approve"));
      c(localJSONObject.getBoolean("track_url"));
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (this.c != 2);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      this.e = localJSONObject.getString("store_id");
      this.f = localJSONObject.getString("urlscheme");
      this.g = localJSONObject.getString("package");
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  public int a()
  {
    return this.b;
  }

  public Uri a(a parama)
  {
    return dx.a(this.b, parama);
  }

  public void a(b paramb)
  {
    this.d = paramb.d;
    this.g = paramb.g;
    this.c = paramb.c;
    this.e = paramb.e;
    this.f = paramb.f;
    this.h = paramb.h;
    this.i |= paramb.i;
  }

  public void a(boolean paramBoolean)
  {
    this.i = av.a(this.i, 0, paramBoolean);
  }

  public int b()
  {
    return this.c;
  }

  public void b(boolean paramBoolean)
  {
    this.i = av.a(this.i, 4, paramBoolean);
  }

  public String c()
  {
    return this.d;
  }

  public void c(boolean paramBoolean)
  {
    this.i = av.a(this.i, 2, paramBoolean);
  }

  public String d()
  {
    return this.e;
  }

  public void d(boolean paramBoolean)
  {
    this.i = av.a(this.i, 3, paramBoolean);
  }

  public String e()
  {
    return this.f;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    b localb;
    do
    {
      return true;
      if (!(paramObject instanceof b))
        return false;
      localb = (b)paramObject;
    }
    while (this.b == localb.b);
    return false;
  }

  public String f()
  {
    return this.g;
  }

  public int g()
  {
    return this.h;
  }

  public boolean h()
  {
    return (!TextUtils.isEmpty(this.d)) && (this.h == 1) && (this.c != -1) && ((this.c == 2) || (!TextUtils.isEmpty(this.g)));
  }

  public int hashCode()
  {
    return this.b;
  }

  public boolean i()
  {
    return (this.c != 2) && (!TextUtils.isEmpty(this.g));
  }

  public int j()
  {
    return this.i;
  }

  public boolean k()
  {
    return av.c(this.i, 2);
  }

  public boolean l()
  {
    return av.c(this.i, 3);
  }

  public String toString()
  {
    return "CGetAppDetails{mAppId=" + this.b + ", mType=" + this.c + ", mName='" + this.d + '\'' + ", mStoreId='" + this.e + '\'' + ", mUrlScheme='" + this.f + '\'' + ", mPackageName='" + this.g + '\'' + ", mStatus=" + this.h + ", mFlags=" + this.i + ", mLastModified=" + this.j + '}';
  }

  public static enum a
  {
    public final String e;

    static
    {
      a[] arrayOfa = new a[4];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
    }

    private a(String paramString)
    {
      this.e = paramString;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.apps.b
 * JD-Core Version:    0.6.2
 */