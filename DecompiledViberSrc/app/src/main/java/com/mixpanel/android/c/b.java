package com.mixpanel.android.c;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mixpanel.android.b.f;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class b
  implements o.h
{
  private static String e = "MixpanelAPI.DynamicEventTracker";
  private final MixpanelAPI a;
  private final Handler b;
  private final Runnable c;
  private final Map<b, c> d;

  public b(MixpanelAPI paramMixpanelAPI, Handler paramHandler)
  {
    this.a = paramMixpanelAPI;
    this.d = new HashMap();
    this.c = new a(null);
    this.b = paramHandler;
  }

  private static String a(View paramView)
  {
    String str1;
    if ((paramView instanceof TextView))
    {
      CharSequence localCharSequence = ((TextView)paramView).getText();
      str1 = null;
      if (localCharSequence != null)
        str1 = localCharSequence.toString();
    }
    StringBuilder localStringBuilder;
    int k;
    do
    {
      boolean bool;
      do
      {
        return str1;
        bool = paramView instanceof ViewGroup;
        str1 = null;
      }
      while (!bool);
      localStringBuilder = new StringBuilder();
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i = localViewGroup.getChildCount();
      int j = 0;
      k = 0;
      while ((j < i) && (localStringBuilder.length() < 128))
      {
        String str2 = a(localViewGroup.getChildAt(j));
        if ((str2 != null) && (str2.length() > 0))
        {
          if (k != 0)
            localStringBuilder.append(", ");
          localStringBuilder.append(str2);
          k = 1;
        }
        j++;
      }
      if (localStringBuilder.length() > 128)
        return localStringBuilder.substring(0, 128);
      str1 = null;
    }
    while (k == 0);
    return localStringBuilder.toString();
  }

  public void a(View paramView, String paramString, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("$text", a(paramView));
      localJSONObject.put("$from_binding", true);
      localJSONObject.put("time", l / 1000L);
      if (paramBoolean)
      {
        localb = new b(paramView, paramString);
        localc = new c(paramString, localJSONObject, l);
      }
    }
    catch (JSONException localJSONException)
    {
      synchronized (this.d)
      {
        b localb;
        c localc;
        boolean bool = this.d.isEmpty();
        this.d.put(localb, localc);
        if (bool)
          this.b.postDelayed(this.c, 1000L);
        return;
        localJSONException = localJSONException;
        f.e(e, "Can't format properties from view due to JSON issue", localJSONException);
      }
    }
    this.a.track(paramString, localJSONObject);
  }

  private final class a
    implements Runnable
  {
    private a()
    {
    }

    public void run()
    {
      long l = System.currentTimeMillis();
      synchronized (b.a(b.this))
      {
        Iterator localIterator = b.a(b.this).entrySet().iterator();
        while (localIterator.hasNext())
        {
          b.c localc = (b.c)((Map.Entry)localIterator.next()).getValue();
          if (l - localc.a > 1000L)
          {
            b.b(b.this).track(localc.b, localc.c);
            localIterator.remove();
          }
        }
      }
      if (!b.a(b.this).isEmpty())
        b.c(b.this).postDelayed(this, 500L);
    }
  }

  private static class b
  {
    private final int a;

    public b(View paramView, String paramString)
    {
      this.a = (paramView.hashCode() ^ paramString.hashCode());
    }

    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof b;
      boolean bool2 = false;
      if (bool1)
      {
        int i = this.a;
        int j = paramObject.hashCode();
        bool2 = false;
        if (i == j)
          bool2 = true;
      }
      return bool2;
    }

    public int hashCode()
    {
      return this.a;
    }
  }

  private static class c
  {
    public final long a;
    public final String b;
    public final JSONObject c;

    public c(String paramString, JSONObject paramJSONObject, long paramLong)
    {
      this.b = paramString;
      this.c = paramJSONObject;
      this.a = paramLong;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.c.b
 * JD-Core Version:    0.6.2
 */