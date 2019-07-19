package com.viber.voip.wallet;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.viber.common.b.b;
import com.viber.common.b.d;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.ControllerListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.wallet.WalletController;
import com.viber.jni.wallet.WalletControllerDelegate;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.g.f;
import com.viber.voip.contacts.c.d.m;
import com.viber.voip.contacts.c.e.c;
import com.viber.voip.contacts.c.f.b.f;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.orm.entity.json.ActionType;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.bm;
import com.viber.voip.settings.d.bm.a;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.bj;
import com.viber.voip.util.dr;
import com.viber.voip.util.http.OkHttpClientFactory;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends ControllerListener<WalletControllerDelegate>
  implements WalletControllerDelegate, g.f
{
  private static int a = 24;
  private static Logger b = ViberEnv.getLogger();
  private static String c;
  private static String d;
  private UserManager e;
  private g f;
  private WalletController g;
  private PhoneController h;
  private c i;
  private SparseArray<a> j = new SparseArray();
  private SparseArray<b> k = new SparseArray();
  private int[] l;
  private boolean m;
  private final Handler n;

  public a(Context paramContext, PhoneController paramPhoneController, WalletController paramWalletController, g paramg, UserManager paramUserManager)
  {
    this.h = paramPhoneController;
    this.f = paramg;
    this.g = paramWalletController;
    this.e = paramUserManager;
    if (!ViberApplication.isTablet(paramContext));
    for (boolean bool = true; ; bool = false)
    {
      this.m = bool;
      this.i = new c(paramContext);
      this.f.a(this);
      this.n = av.e.f.a();
      if (b())
        j();
      return;
    }
  }

  private int a(int paramInt, b paramb, String paramString1, String paramString2, boolean paramBoolean, a parama)
  {
    if (TextUtils.isEmpty(paramString1));
    for (String str1 = ""; ; str1 = paramString1)
    {
      if (TextUtils.isEmpty(paramString2));
      for (String str2 = ""; ; str2 = paramString2)
      {
        int i1 = this.h.generateSequence();
        this.j.put(i1, parama);
        this.k.put(i1, paramb);
        String str3 = this.e.getUserData().getViberName();
        int i2 = f.a(ViberApplication.getApplication()).f();
        int i3 = ab.b().c().size();
        if (!TextUtils.isEmpty(ViberApplication.getInstance().getFacebookManager().e()));
        for (boolean bool = true; ; bool = false)
        {
          this.g.handleGetWalletSecureToken(paramInt, str3, i2, i3, bool, i1, paramBoolean, paramb.a(), str1, str2);
          return i1;
        }
      }
    }
  }

  private int a(b paramb, String paramString1, String paramString2, a parama)
  {
    return a(d.bm.b.d(), paramb, paramString1, paramString2, d.bm.a.b.d(), parama);
  }

  private void a(final Set<String> paramSet)
  {
    this.n.post(new Runnable()
    {
      public void run()
      {
        if (a.this.b())
          a.a(a.this, paramSet);
      }
    });
  }

  private void a(JSONObject paramJSONObject)
  {
    int i1 = 0;
    int i2 = paramJSONObject.optInt("revision");
    if (i2 <= d.bm.c.d())
      return;
    String str = this.e.getRegistrationValues().g();
    JSONObject localJSONObject = paramJSONObject.optJSONObject("+" + dr.c(ViberApplication.getInstance(), str));
    this.i.b();
    JSONArray localJSONArray1;
    boolean bool;
    if (localJSONObject != null)
    {
      d.bm.a.a(localJSONObject.optString("type"));
      if (d.bm.a.d().equals("wu"))
        d.bm.b.a(localJSONObject.optInt("service_id"));
      d.bm.f.a(localJSONObject.optBoolean("support_payments", false));
      localJSONArray1 = localJSONObject.optJSONArray("send_to");
      if (localJSONArray1 != null)
      {
        bool = true;
        d.bm.e.a(bool);
        if (bool)
          break label291;
      }
    }
    label291: for (JSONArray localJSONArray2 = localJSONObject.optJSONArray("cant_send_to"); ; localJSONArray2 = localJSONArray1)
    {
      if (localJSONArray2 == null)
        localJSONArray2 = new JSONArray();
      this.l = new int[localJSONArray2.length()];
      while (true)
        if (i1 < localJSONArray2.length())
        {
          this.l[i1] = localJSONArray2.optInt(i1);
          i1++;
          continue;
          bool = false;
          break;
        }
      Arrays.sort(this.l);
      while (true)
      {
        this.i.a(this.l);
        b(this.f.c().a());
        d.bm.c.a(i2);
        return;
        k();
        this.l = new int[0];
      }
    }
  }

  public static String[] a(MessageEntity paramMessageEntity, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return new String[] { "[]", "{}" };
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if ((paramMessageEntity != null) && ("MoneyRequest".equals(localJSONObject.optString("Type"))))
        paramMessageEntity.addExtraFlag(23);
      String[] arrayOfString = b(localJSONObject);
      return arrayOfString;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  private void b(Set<String> paramSet)
  {
    if ((paramSet == null) || (paramSet.size() == 0));
    HashSet localHashSet;
    do
    {
      return;
      localHashSet = new HashSet();
      Iterator localIterator = paramSet.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (TextUtils.isEmpty(str))
        {
          localIterator.remove();
        }
        else if (!a(str))
        {
          localIterator.remove();
          localHashSet.add(str);
        }
      }
      if (!paramSet.isEmpty())
        this.i.a(paramSet, true);
    }
    while (localHashSet.isEmpty());
    this.i.a(localHashSet, false);
  }

  private boolean b(int paramInt)
  {
    if (this.l == null)
    {
      this.l = this.i.a();
      Arrays.sort(this.l);
    }
    if (this.l.length == 0);
    while (true)
    {
      return true;
      boolean bool = d.bm.e.d();
      if (Arrays.binarySearch(this.l, paramInt) >= 0);
      for (int i1 = 1; ((!bool) || (i1 == 0)) && ((bool) || (i1 != 0)); i1 = 0)
        return false;
    }
  }

  private static String[] b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
      return null;
    try
    {
      JSONArray localJSONArray1 = new JSONArray();
      JSONArray localJSONArray2 = l();
      String str1 = m();
      String str2 = paramJSONObject.getString("ImageUrl");
      String str3 = paramJSONObject.getString("Text");
      String str4 = paramJSONObject.optString("ButtonCaption");
      String str5 = paramJSONObject.getString("PreviewText");
      String str6 = paramJSONObject.optString("ButtonAction");
      String str7 = paramJSONObject.optString("PushEntry");
      localJSONArray2.getJSONObject(0).put("ImageUrl", str2);
      localJSONArray1.put(localJSONArray2.get(0));
      localJSONArray2.getJSONObject(1).put("Text", str3);
      localJSONArray1.put(localJSONArray2.get(1));
      if ((!TextUtils.isEmpty(str6)) && (!TextUtils.isEmpty(str4)))
      {
        localJSONArray2.getJSONObject(2).put("Caption", str4);
        Locale localLocale = Locale.US;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = ActionType.OPEN_URL.getAction();
        JSONObject localJSONObject = new JSONObject(String.format(localLocale, str1, arrayOfObject));
        localJSONObject.getJSONObject("parameters").put("url", str6);
        localJSONArray2.getJSONObject(2).put("Action", localJSONObject);
        localJSONArray1.put(localJSONArray2.get(2));
      }
      localJSONArray2.getJSONObject(3).put("PreviewText", str5);
      if (!TextUtils.isEmpty(str7))
        localJSONArray2.getJSONObject(3).put("PushText", str7);
      localJSONArray1.put(localJSONArray2.getJSONObject(3));
      String[] arrayOfString = new String[2];
      arrayOfString[0] = localJSONArray1.toString();
      arrayOfString[1] = paramJSONObject.toString();
      return arrayOfString;
    }
    catch (IOException localIOException)
    {
      return null;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  private void j()
  {
    this.n.post(new Runnable()
    {
      public void run()
      {
        a.this.i();
      }
    });
  }

  private void k()
  {
    d.bm.a.b();
    d.bm.b.b();
    d.bm.d.b();
    d.bm.k.b();
    d.bm.c.b();
    d.bm.f.b();
  }

  private static JSONArray l()
    throws IOException, JSONException
  {
    if (c == null)
      c = bj.a(ViberApplication.getApplication().getAssets().open("wallet/wallet_template.json"));
    return new JSONArray(c);
  }

  private static String m()
    throws IOException, JSONException
  {
    if (d == null)
      d = bj.a(ViberApplication.getApplication().getAssets().open("wallet/view_action.json"));
    return d;
  }

  public int a(a parama)
  {
    return a(b.d, "", "", parama);
  }

  public int a(String paramString1, String paramString2, a parama)
  {
    return a(5003, b.a, paramString1, paramString2, true, parama);
  }

  public int a(String paramString1, String paramString2, b paramb, a parama)
  {
    return a(paramb, paramString2, paramString1, parama);
  }

  public void a()
  {
  }

  public void a(int paramInt)
  {
    this.j.remove(paramInt);
    this.k.remove(paramInt);
  }

  public void a(Map<String, Long> paramMap)
  {
    a(new HashSet(paramMap.keySet()));
  }

  public boolean a(String paramString)
  {
    if ((!b()) || (TextUtils.isEmpty(paramString)));
    int i1;
    do
    {
      do
        return false;
      while ((!f()) && (paramString.equals(this.e.getRegistrationValues().h())));
      i1 = dr.c(ViberApplication.getInstance(), paramString);
    }
    while ((i1 <= 0) || (!b(i1)));
    return true;
  }

  public int b(a parama)
  {
    return a(b.c, "", "", parama);
  }

  public boolean b()
  {
    return (c()) || (f()) || (g());
  }

  public int c(a parama)
  {
    return a(b.b, "", "", parama);
  }

  public boolean c()
  {
    if ((com.viber.common.d.a.g()) && (d.bm.a.a()) && (d.bm.a.d().equals("wu")) && (d.bm.b.a()));
    for (int i1 = 1; (this.m) && (i1 != 0); i1 = 0)
      return true;
    return false;
  }

  public int d()
  {
    if (c())
      return R.string.options_send_wo_via_western_union_subtitle;
    if (g())
      return R.string.options_send_rb_via_rakuten_subtitle;
    return 0;
  }

  public int e()
  {
    if (c())
      return R.string.options_send_wo;
    if (g())
      return R.string.send_money_title_rakuten;
    if (f())
      return R.string.viber_wallet_title;
    return R.string.options_send_wo;
  }

  public boolean f()
  {
    if ((d.bm.a.a()) && (d.bm.a.d().equals("w1")));
    for (int i1 = 1; (this.m) && (i1 != 0); i1 = 0)
      return true;
    return false;
  }

  public boolean g()
  {
    if ((d.bm.a.a()) && (d.bm.a.d().equals("rb")));
    for (int i1 = 1; (this.m) && (i1 != 0); i1 = 0)
      return true;
    return false;
  }

  public boolean h()
  {
    return (b()) && (d.bm.f.d());
  }

  public void i()
  {
    if ((!d.bm.i.d()) && (System.currentTimeMillis() - d.bm.d.d() < TimeUnit.HOURS.toMillis(a)));
    while (true)
    {
      return;
      d.bm.d.a(System.currentTimeMillis());
      try
      {
        String str1 = d.bm.k.d();
        String str2 = d.bm.h.d();
        OkHttpClient.Builder localBuilder = ViberEnv.getOkHttpClientFactory().createBuilder();
        Request.Builder localBuilder1 = new Request.Builder().url(str2);
        localBuilder1.header("If-Modified-Since", str1);
        Response localResponse = localBuilder.build().newCall(localBuilder1.build()).execute();
        String str3 = localResponse.body().string();
        if (!TextUtils.isEmpty(str3))
          a(new JSONObject(str3));
        String str4 = localResponse.header("Last-Modified");
        if (!TextUtils.isEmpty(str4))
        {
          d.bm.k.a(str4);
          return;
        }
      }
      catch (IOException localIOException)
      {
      }
      catch (JSONException localJSONException)
      {
      }
    }
  }

  public void onGetWalletSecureTokenReply(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a locala = (a)this.j.get(paramInt3);
    this.j.remove(paramInt3);
    if (locala != null)
      if (paramInt1 != 0)
        break label78;
    label78: for (c localc = c.a; ; localc = c.b)
    {
      locala.a(paramInt3, localc, paramString, (b)this.k.get(paramInt3));
      this.k.remove(paramInt3);
      d.bm.a.b.a(false);
      return;
    }
  }

  public void onWalletSupported()
  {
    j();
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt, a.c paramc, String paramString, a.b paramb);
  }

  public static enum b
  {
    private int g;

    static
    {
      b[] arrayOfb = new b[6];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      arrayOfb[5] = f;
    }

    private b(int paramInt)
    {
      this.g = paramInt;
    }

    public int a()
    {
      return this.g;
    }
  }

  public static enum c
  {
    static
    {
      c[] arrayOfc = new c[2];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.wallet.a
 * JD-Core Version:    0.6.2
 */