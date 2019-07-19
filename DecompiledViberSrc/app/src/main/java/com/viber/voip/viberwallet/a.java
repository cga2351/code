package com.viber.voip.viberwallet;

import android.location.Location;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.market.b.h;
import com.viber.voip.market.b.h.a;
import com.viber.voip.market.b.i;
import com.viber.voip.market.b.i.a;
import com.viber.voip.market.b.o;
import com.viber.voip.market.r;
import com.viber.voip.market.s;
import com.viber.voip.market.s.a;
import com.viber.voip.messages.extras.b.d.c;
import com.viber.voip.p;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.cg;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class a extends s
{
  private static final Logger b = ViberEnv.getLogger();
  private Handler c = av.a(av.e.a);
  private c d;

  a(c paramc)
  {
    super("Wallet", paramc);
    this.d = paramc;
    paramc.a(new b(null), "WalletApp");
  }

  private void a(Runnable paramRunnable)
  {
    ViberWalletWebActivity localViberWalletWebActivity;
    if ((this.d instanceof ViberWalletWebActivity))
      localViberWalletWebActivity = (ViberWalletWebActivity)this.d;
    try
    {
      if (localViberWalletWebActivity.d(new URL(localViberWalletWebActivity.c()).getHost()))
        this.c.post(paramRunnable);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
    }
  }

  static enum a
  {
    String b;

    static
    {
      a[] arrayOfa = new a[1];
      arrayOfa[0] = a;
    }

    private a(String paramString)
    {
      this.b = paramString;
    }

    public static a a(String paramString)
    {
      for (a locala : values())
        if (locala.a().equals(paramString))
          return locala;
      return a;
    }

    public String a()
    {
      return this.b;
    }
  }

  private class b
  {
    private b()
    {
    }

    @JavascriptInterface
    public void closeWallet()
    {
      a.a(a.this, new Runnable()
      {
        public void run()
        {
          a.a(a.this).a();
        }
      });
    }

    @JavascriptInterface
    public void getClientInfo()
    {
      a.a(a.this, new Runnable()
      {
        public void run()
        {
          HardwareParameters localHardwareParameters = ViberApplication.getInstance().getHardwareParameters();
          af localaf = UserManager.from(ViberApplication.getApplication()).getRegistrationValues();
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("version", p.d());
            localJSONObject.put("system", p.i());
            localJSONObject.put("language", Locale.getDefault());
            localJSONObject.put("country", localaf.e());
            localJSONObject.put("mcc", localHardwareParameters.getMCC());
            localJSONObject.put("mnc", localHardwareParameters.getMNC());
            localJSONObject.put("sim_mcc", localHardwareParameters.getSimMCC());
            localJSONObject.put("sim_mnc", localHardwareParameters.getSimMNC());
            localJSONObject.put("api_ver", "1");
            Set localSet = r.a();
            if (!localSet.isEmpty())
              localJSONObject.put("supported_features", new JSONArray(localSet));
            a.a(a.this, "onGetClientInfo", new Object[] { localJSONObject });
            return;
          }
          catch (JSONException localJSONException)
          {
          }
        }
      });
    }

    @JavascriptInterface
    public void getContactInfo(final String paramString)
    {
      a.a(a.this, new Runnable()
      {
        public void run()
        {
          ArrayList localArrayList = new ArrayList();
          try
          {
            JSONArray localJSONArray = new JSONArray(paramString);
            int i = 0;
            if (i < localJSONArray.length())
            {
              Object localObject = ((JSONObject)localJSONArray.get(i)).getString("phone_number");
              if (((String)localObject).startsWith("+"));
              while (true)
              {
                localArrayList.add(localObject);
                i++;
                break;
                String str = "+" + (String)localObject;
                localObject = str;
              }
            }
          }
          catch (JSONException localJSONException)
          {
            new h().a(localArrayList, new h.a()
            {
              public void a(Map<String, String> paramAnonymous2Map)
              {
                JSONArray localJSONArray = new JSONArray();
                Iterator localIterator = paramAnonymous2Map.entrySet().iterator();
                while (localIterator.hasNext())
                {
                  Map.Entry localEntry = (Map.Entry)localIterator.next();
                  try
                  {
                    if (localEntry.getValue() != null)
                    {
                      JSONObject localJSONObject = new JSONObject();
                      localJSONObject.put("phone_number", cg.b((String)localEntry.getKey()));
                      localJSONObject.put("contact_name", localEntry.getValue());
                      localJSONArray.put(localJSONObject);
                    }
                  }
                  catch (JSONException localJSONException)
                  {
                  }
                }
                a locala = a.this;
                Object[] arrayOfObject = new Object[1];
                arrayOfObject[0] = localJSONArray.toString();
                a.b(locala, "onGetContactInfo", arrayOfObject);
              }
            });
          }
        }
      });
    }

    @JavascriptInterface
    public void getGeolocation()
    {
      a.a(a.this, new Runnable()
      {
        public void run()
        {
          new i().a(new i.a()
          {
            public void a(Location paramAnonymous2Location, d.c paramAnonymous2c)
            {
              try
              {
                JSONObject localJSONObject = new JSONObject();
                d.c localc = d.c.b;
                int i = 0;
                if (paramAnonymous2c != localc);
                while (true)
                {
                  localJSONObject.put("status", i);
                  if (paramAnonymous2Location != null)
                  {
                    localJSONObject.put("lat", String.valueOf(paramAnonymous2Location.getLatitude()));
                    localJSONObject.put("lon", String.valueOf(paramAnonymous2Location.getLongitude()));
                  }
                  a.c(a.this, "onGetGeolocation", new Object[] { localJSONObject });
                  return;
                  i = 1;
                }
              }
              catch (JSONException localJSONException)
              {
              }
            }
          });
        }
      });
    }

    @JavascriptInterface
    public void openBrowser(final String paramString)
    {
      a.a(a.this, new Runnable()
      {
        public void run()
        {
          a.a(a.this).b(paramString);
        }
      });
    }

    @JavascriptInterface
    public void renewWebToken()
    {
      a.a(a.this, new Runnable()
      {
        public void run()
        {
          a.a(a.this).af_();
        }
      });
    }

    @JavascriptInterface
    public void selectContact(final String paramString)
    {
      a.a(a.this, new Runnable()
      {
        public void run()
        {
          try
          {
            JSONArray localJSONArray = new JSONArray(paramString);
            HashMap localHashMap = new HashMap(localJSONArray.length());
            for (int i = 0; i < localJSONArray.length(); i++)
            {
              JSONObject localJSONObject = localJSONArray.getJSONObject(i);
              localHashMap.put(a.a.a(localJSONObject.optString("filter_by")), Boolean.valueOf(localJSONObject.optBoolean("value")));
            }
            a.a(a.this).a(localHashMap);
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
      a.a(a.this, new Runnable()
      {
        public void run()
        {
          new o().a(paramString1, paramString2, a.this.d());
        }
      });
    }

    @JavascriptInterface
    public void setLoadingPageStatus(final int paramInt)
    {
      a.a(a.this, new Runnable()
      {
        public void run()
        {
          a.a(a.this).a(paramInt);
        }
      });
    }

    @JavascriptInterface
    public void setPageOptions(final String paramString)
    {
      a.a(a.this, new Runnable()
      {
        public void run()
        {
          try
          {
            JSONObject localJSONObject = new JSONObject(paramString);
            if (localJSONObject.has("title"));
            for (String str1 = localJSONObject.getString("title"); ; str1 = null)
            {
              boolean bool = localJSONObject.has("sub_title");
              String str2 = null;
              if (bool)
                str2 = localJSONObject.getString("sub_title");
              String str3 = localJSONObject.optString("back_button_url_hash");
              String str4 = localJSONObject.optString("back_button_token");
              String str5 = localJSONObject.optString("back_button_mode");
              a.a(a.this).a(str1, str2, str3, str4, str5);
              return;
            }
          }
          catch (JSONException localJSONException)
          {
          }
        }
      });
    }
  }

  static abstract interface c extends s.a
  {
    public abstract void a();

    public abstract void a(int paramInt);

    public abstract void a(Object paramObject, String paramString);

    public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);

    public abstract void a(Map<a.a, Boolean> paramMap);

    public abstract void af_();

    public abstract void b(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberwallet.a
 * JD-Core Version:    0.6.2
 */