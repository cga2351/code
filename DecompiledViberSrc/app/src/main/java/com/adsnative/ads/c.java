package com.adsnative.ads;

import android.content.Context;
import android.os.AsyncTask;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.adsnative.b.f;
import com.adsnative.c.i;
import com.adsnative.c.l;
import com.adsnative.c.m;
import com.adsnative.c.m.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import org.apache.http.client.ClientProtocolException;

public class c extends WebView
{
  Context a;
  ArrayList<String> b;
  v c;
  w d;

  public c(Context paramContext, ArrayList<String> paramArrayList, v paramv, w paramw)
  {
    super(paramContext);
    this.a = paramContext;
    this.b = paramArrayList;
    this.c = paramv;
    this.d = paramw;
    setBackgroundColor(0);
    getSettings().setJavaScriptEnabled(true);
    a();
    setWebViewClient(new a(null));
  }

  private void a()
  {
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    setHorizontalScrollbarOverlay(false);
    setVerticalScrollbarOverlay(false);
  }

  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return false;
  }

  private class a extends WebViewClient
  {
    private a()
    {
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      c.this.c.c(c.this.d);
      new m(EnumSet.of(l.a, l.c, l.d), new m.a()
      {
        public void a(String paramAnonymousString, l paramAnonymousl)
        {
        }

        public void b(String paramAnonymousString, l paramAnonymousl)
        {
        }
      }).a(c.this.a, paramString);
      Iterator localIterator = c.this.b.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        new c.b(c.this, str).execute(new String[0]);
      }
      return true;
    }
  }

  private class b extends AsyncTask<String, Void, Boolean>
  {
    private final String b;
    private final f c;

    public b(String arg2)
    {
      Object localObject;
      this.b = localObject;
      this.c = f.a(c.this.a);
    }

    protected Boolean a(String[] paramArrayOfString)
    {
      try
      {
        Boolean localBoolean = new Boolean(this.c.a(c.this.a, this.b));
        return localBoolean;
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        i.e("ClientProtocolException firing the tracking url: " + localClientProtocolException.getMessage());
        return Boolean.valueOf(false);
      }
      catch (IOException localIOException)
      {
        while (true)
          i.e("IOException firing the tracking url: " + localIOException.getMessage());
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        while (true)
          i.e("IllegalArgumentException firing the tracking url: " + localIllegalArgumentException.getMessage());
      }
      catch (Exception localException)
      {
        while (true)
          i.e("Unknown Exception firing the tracking url: " + localException.getMessage());
      }
    }

    protected void a(Boolean paramBoolean)
    {
      super.onPostExecute(paramBoolean);
      if (!paramBoolean.booleanValue())
        i.e("Failed to fire banner click tracking url: " + this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.c
 * JD-Core Version:    0.6.2
 */