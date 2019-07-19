package com.viber.voip.wallet.wu;

import android.app.Activity;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.market.b.o;
import com.viber.voip.market.s;
import com.viber.voip.market.s.a;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends s
{
  private static final Logger b = ViberEnv.getLogger();
  private Handler c = av.a(av.e.a);
  private Activity d;
  private a e;

  public b(Activity paramActivity, a parama)
  {
    super("NONE", parama);
    this.d = paramActivity;
    this.e = parama;
    parama.a(new b(null), "WUApp");
  }

  private void a(Runnable paramRunnable)
  {
    this.c.post(paramRunnable);
  }

  public static abstract interface a extends s.a
  {
    public abstract void a();

    public abstract void a(Object paramObject, String paramString);

    public abstract void a_(String paramString1, String paramString2, String paramString3);

    public abstract void f_(String paramString);
  }

  private class b
  {
    private b()
    {
    }

    @JavascriptInterface
    public void closeWallet()
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          b.a(b.this).a();
        }
      });
    }

    @JavascriptInterface
    public void log(String paramString)
    {
    }

    @JavascriptInterface
    public void openBrowserWU(final String paramString)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          try
          {
            String str = new JSONObject(paramString).getString("url");
            b.a(b.this).f_(str);
            return;
          }
          catch (JSONException localJSONException)
          {
          }
        }
      });
    }

    @JavascriptInterface
    public void sendCDR(final String paramString1, final String paramString2)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          new o().a(paramString1, paramString2, b.this.d());
        }
      });
    }

    @JavascriptInterface
    public void setPageOptions(final String paramString)
    {
      b.a(b.this, new Runnable()
      {
        public void run()
        {
          try
          {
            JSONObject localJSONObject = new JSONObject(paramString);
            String str1 = localJSONObject.getString("title");
            String str2 = localJSONObject.getString("sub_title");
            String str3 = localJSONObject.getString("back_button_url_hash");
            if ("null".equalsIgnoreCase(str3))
              str3 = null;
            b.a(b.this).a_(str1, str2, str3);
            return;
          }
          catch (JSONException localJSONException)
          {
          }
        }
      });
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.wallet.wu.b
 * JD-Core Version:    0.6.2
 */