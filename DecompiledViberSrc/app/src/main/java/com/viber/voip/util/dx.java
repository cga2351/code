package com.viber.voip.util;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.EncryptionParams;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.apps.b.a;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.orm.entity.json.ImageType;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.upload.ObjectId;
import com.viber.voip.util.upload.i;
import com.viber.voip.util.upload.i.c;
import com.viber.voip.util.upload.i.o;
import com.viber.voip.util.upload.t.d;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;

public class dx
{
  public static final Uri a = Uri.parse("fileupload:///sync-history-desktop");
  private static final Logger b = ViberEnv.getLogger();
  private static final Uri c = Uri.parse("fake-ptt-id");
  private static final Uri d = Uri.parse("http://viber-fake-uri.com/image_id");
  private static final Uri e = Uri.parse("http://viber-fake-uri.com/hd/image_id");
  private static final Uri f = Uri.parse("http://viber-fake-uri.com/media");
  private static final Uri g = Uri.parse("http://viber-fake-uri.com/newmedia");
  private static final Uri h = Uri.parse("http://viber-fake-uri.com/gif");
  private static final Uri i = Uri.parse("http://viber-fake-uri.com/kesm_img");
  private static final Uri j = Uri.parse("http://viber-fake-uri.com/pg");
  private static final Uri k = Uri.parse("http://viber-fake-uri.com/shsh_img");
  private static final Uri l = Uri.parse("http://viber-fake-uri.com/big_emo");
  private static final Uri m = Uri.parse("http://viber-fake-uri.com/local");
  private static String n;

  public static Uri a(int paramInt)
  {
    Resources localResources = ViberApplication.getApplication().getResources();
    return Uri.parse("android.resource://" + localResources.getResourcePackageName(paramInt) + '/' + localResources.getResourceTypeName(paramInt) + '/' + localResources.getResourceEntryName(paramInt));
  }

  public static Uri a(int paramInt, b.a parama)
  {
    return Uri.parse(ap.c().aH + parama.e + "/" + paramInt + "/icon.png");
  }

  public static Uri a(long paramLong)
  {
    return Uri.parse("filedownload://msgid/" + paramLong);
  }

  public static Uri a(Context paramContext, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Uri.Builder localBuilder = Uri.parse(ap.c().al).buildUpon().appendQueryParameter("type", "AD").appendQueryParameter("appid", String.valueOf(902));
    try
    {
      String str2 = URLEncoder.encode(UserManager.from(paramContext).getRegistrationValues().n(), "UTF-8");
      str1 = str2;
      if (!TextUtils.isEmpty(str1))
        localBuilder.appendQueryParameter("reporter", str1);
      if (paramArrayOfString != null)
        localBuilder.appendQueryParameter("impressionurl", TextUtils.join(",", paramArrayOfString));
      if (!TextUtils.isEmpty(paramString2))
        localBuilder.appendQueryParameter("adplatform", paramString2);
      if (!TextUtils.isEmpty(paramString3))
        localBuilder.appendQueryParameter("adprovider", paramString3);
      if (!TextUtils.isEmpty(paramString1))
        localBuilder.appendQueryParameter("crid", paramString1);
      if (!TextUtils.isEmpty(paramString4))
        localBuilder.appendQueryParameter("adunitid", paramString4);
      if (paramInt >= 0)
        localBuilder.appendQueryParameter("adloc", String.valueOf(paramInt));
      return localBuilder.build();
    }
    catch (Exception localException)
    {
      while (true)
        String str1 = null;
    }
  }

  public static Uri a(Uri paramUri)
  {
    return k.buildUpon().appendQueryParameter("shsh_img_url", paramUri.toString()).build();
  }

  public static Uri a(aa paramaa)
  {
    return a(paramaa.a());
  }

  public static Uri a(MessageEntity paramMessageEntity)
  {
    return a(paramMessageEntity.getId());
  }

  public static Uri a(ObjectId paramObjectId)
  {
    if (paramObjectId.isEmpty())
      return null;
    return a(paramObjectId.toDecString(), null, t.d.d, as.a.a(), 0, null);
  }

  public static Uri a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    return d.buildUpon().appendEncodedPath(paramString).build();
  }

  public static Uri a(String paramString, int paramInt)
  {
    return m.buildUpon().appendQueryParameter("path", paramString).appendQueryParameter("mt", Integer.toString(paramInt)).build();
  }

  public static Uri a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, null, t.d.g, as.a.a(), paramInt, paramString2);
  }

  private static Uri a(String paramString1, EncryptionParams paramEncryptionParams, t.d paramd, String paramString2, int paramInt, String paramString3)
  {
    Uri.Builder localBuilder = j.buildUpon().appendEncodedPath(paramString1).appendEncodedPath(paramd.toString()).appendEncodedPath(paramString2).appendEncodedPath(Integer.toString(paramInt));
    if (!TextUtils.isEmpty(paramString3))
      localBuilder.appendQueryParameter("th", paramString3);
    if (paramEncryptionParams != null)
      localBuilder.appendQueryParameter("ep", EncryptionParams.serializeEncryptionParams(paramEncryptionParams));
    return localBuilder.build();
  }

  public static Uri a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)))
      return null;
    return f.buildUpon().appendEncodedPath(paramString1).appendEncodedPath(paramString2).build();
  }

  public static Uri a(String paramString1, String paramString2, EncryptionParams paramEncryptionParams, i.c paramc, i.o paramo, Boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1));
    while (i.c(paramString1))
      return null;
    Uri.Builder localBuilder = g.buildUpon().appendQueryParameter("dlid", paramString1).appendQueryParameter("vrnt", Integer.toString(paramo.d));
    if (!TextUtils.isEmpty(paramString2))
      localBuilder.appendQueryParameter("th", paramString2);
    if (paramc != i.c.d)
      localBuilder.appendQueryParameter("fltp", paramc.e);
    if (paramBoolean != null)
      localBuilder.appendQueryParameter("pgfile", paramBoolean.toString());
    if (paramEncryptionParams != null)
      localBuilder.appendQueryParameter("ep", EncryptionParams.serializeEncryptionParams(paramEncryptionParams));
    return localBuilder.build();
  }

  public static Uri a(String paramString1, String paramString2, String paramString3, ImageType paramImageType)
  {
    if (!TextUtils.isEmpty(paramString3))
      return Uri.parse(paramString3);
    switch (1.a[paramImageType.ordinal()])
    {
    default:
      return a(paramString1, paramString2);
    case 1:
      return a(paramString2);
    case 2:
      return g(paramString2);
    case 3:
    }
    return g(paramString2);
  }

  public static Uri a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
      return g(paramString);
    return h(paramString);
  }

  public static Uri a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, EncryptionParams paramEncryptionParams)
  {
    if ((!paramBoolean1) && (TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString3)))
      return null;
    Uri.Builder localBuilder = h.buildUpon();
    if (!TextUtils.isEmpty(paramString1))
      localBuilder.appendEncodedPath(paramString1);
    localBuilder.appendQueryParameter("pg", String.valueOf(paramBoolean2));
    if (!TextUtils.isEmpty(paramString2))
      localBuilder.appendQueryParameter("th", paramString2);
    if (!TextUtils.isEmpty(paramString3))
      localBuilder.appendQueryParameter("th_url", paramString3);
    if (paramEncryptionParams != null)
      localBuilder.appendQueryParameter("ep", EncryptionParams.serializeEncryptionParams(paramEncryptionParams));
    return localBuilder.build();
  }

  public static a a(Context paramContext, Uri paramUri)
  {
    if (n == null)
      n = dj.l(paramContext);
    String str1 = paramUri.getQueryParameter("big_emo_name");
    Locale localLocale = Locale.US;
    String str2 = ap.c().aU;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(1);
    arrayOfObject[1] = n;
    arrayOfObject[2] = str1;
    return new a(String.format(localLocale, str2, arrayOfObject), n + '/' + str1);
  }

  public static String a(String paramString, long paramLong)
  {
    Uri.Builder localBuilder = c.buildUpon();
    localBuilder.appendQueryParameter("pttUri", paramString);
    localBuilder.appendQueryParameter("pttMessageId", String.valueOf(paramLong));
    return localBuilder.build().toString();
  }

  public static Uri b(aa paramaa)
  {
    return Uri.parse("fileupload:///msgid/" + paramaa.a());
  }

  public static Uri b(MessageEntity paramMessageEntity)
  {
    return Uri.parse("fileupload:///msgid/" + paramMessageEntity.getId());
  }

  public static Uri b(ObjectId paramObjectId)
  {
    if (paramObjectId.isEmpty())
      return null;
    return a(paramObjectId.toDecString(), null, t.d.e, as.a.a(), 0, null);
  }

  public static Uri b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    return e.buildUpon().appendEncodedPath(paramString).build();
  }

  public static boolean b(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.toString().startsWith("http://viber-fake-uri.com/image_id"));
  }

  public static Uri c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    return i.buildUpon().appendQueryParameter("kesm_img_url", paramString).build();
  }

  public static boolean c(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.toString().startsWith("http://viber-fake-uri.com/hd/image_id"));
  }

  public static Uri d(String paramString)
  {
    return l.buildUpon().appendQueryParameter("big_emo_name", paramString).build();
  }

  public static boolean d(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.toString().startsWith("http://viber-fake-uri.com/pg"));
  }

  public static Uri e(String paramString)
  {
    return a(paramString, null, t.d.h, "null", 400, null);
  }

  public static boolean e(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.toString().startsWith("http://viber-fake-uri.com/media"));
  }

  public static Uri f(String paramString)
  {
    return a(paramString, null, t.d.f, as.a.a(), 0, null);
  }

  public static boolean f(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.toString().startsWith("http://viber-fake-uri.com/newmedia"));
  }

  public static Uri g(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    return a(paramString, null, t.d.d, as.a.a(), 0, null);
  }

  public static boolean g(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.toString().startsWith("http://viber-fake-uri.com/kesm_img"));
  }

  public static Uri h(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    return a(paramString, null, t.d.e, as.a.a(), 0, null);
  }

  public static boolean h(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.toString().startsWith("http://viber-fake-uri.com/shsh_img"));
  }

  public static Uri i(String paramString)
  {
    if (paramString == null);
    Uri localUri;
    do
    {
      return null;
      localUri = Uri.parse(paramString);
    }
    while (localUri == null);
    return Uri.parse(localUri.getQueryParameter("pttUri"));
  }

  public static String i(Uri paramUri)
  {
    if (paramUri != null);
    for (String str = paramUri.getQueryParameter("kesm_img_url"); ; str = null)
      return dl.n(str);
  }

  public static Uri j(String paramString)
  {
    if (paramString == null);
    Uri localUri;
    do
    {
      return null;
      localUri = Uri.parse(paramString);
    }
    while (localUri == null);
    return Uri.parse(localUri.getQueryParameter("pttMessageId"));
  }

  public static String j(Uri paramUri)
  {
    if (paramUri != null);
    for (String str = paramUri.getQueryParameter("shsh_img_url"); ; str = null)
      return dl.n(str);
  }

  public static boolean k(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.toString().startsWith("http://viber-fake-uri.com/big_emo"));
  }

  public static boolean l(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.toString().startsWith("http://viber-fake-uri.com/gif"));
  }

  public static b m(Uri paramUri)
  {
    String str1 = paramUri.getQueryParameter("ep");
    if (str1 != null);
    for (EncryptionParams localEncryptionParams = EncryptionParams.unserializeEncryptionParams(str1); ; localEncryptionParams = null)
    {
      boolean bool = paramUri.getBooleanQueryParameter("pg", false);
      String str2 = paramUri.getQueryParameter("th");
      String str3 = paramUri.getQueryParameter("th_url");
      List localList = paramUri.getPathSegments();
      String str4 = null;
      if (localList != null)
      {
        int i1 = localList.size();
        str4 = null;
        if (i1 > 1)
          str4 = (String)localList.get(1);
      }
      return new b(str4, bool, str2, str3, localEncryptionParams);
    }
  }

  public static boolean n(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.toString().startsWith("http://viber-fake-uri.com/local"));
  }

  public static e o(Uri paramUri)
  {
    int i1 = -1;
    String str1 = dl.n(paramUri.getQueryParameter("path"));
    if (TextUtils.isEmpty(str1))
      str1 = "";
    String str2 = paramUri.getQueryParameter("mt");
    if (!TextUtils.isEmpty(str2));
    try
    {
      int i2 = Integer.parseInt(str2);
      i1 = i2;
      label48: return new e(str1, i1);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label48;
    }
  }

  public static d p(Uri paramUri)
  {
    d locald = new d();
    List localList = paramUri.getPathSegments();
    locald.a = ((String)localList.get(1));
    locald.b = t.d.valueOf((String)localList.get(2));
    locald.c = ((String)localList.get(3));
    locald.d = Integer.valueOf((String)localList.get(4)).intValue();
    locald.e = paramUri.getQueryParameter("th");
    String str = paramUri.getQueryParameter("ep");
    if (str != null)
      locald.f = EncryptionParams.unserializeEncryptionParams(str);
    return locald;
  }

  public static boolean q(Uri paramUri)
  {
    return (paramUri != null) && (paramUri.toString().startsWith("http://viber-fake-uri.com"));
  }

  public static String r(Uri paramUri)
  {
    return paramUri.getQueryParameter("th");
  }

  public static class a
  {
    private String a;
    private String b;

    a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }

    public String a()
    {
      return this.a;
    }

    public String b()
    {
      return this.b;
    }
  }

  public static class b
  {
    public final String a;
    public final boolean b;
    public final EncryptionParams c;
    public final String d;
    public final String e;

    b(String paramString1, boolean paramBoolean, String paramString2, String paramString3, EncryptionParams paramEncryptionParams)
    {
      this.a = paramString1;
      this.b = paramBoolean;
      this.d = paramString2;
      this.e = paramString3;
      this.c = paramEncryptionParams;
    }
  }

  public static class c
  {
    public final String a;
    public final String b;
    public final i.o c;
    public final i.c d;
    public final EncryptionParams e;
    public final Boolean f;

    public c(Uri paramUri)
    {
      this.a = paramUri.getQueryParameter("dlid");
      this.b = paramUri.getQueryParameter("th");
      this.c = i.o.a(Integer.parseInt(paramUri.getQueryParameter("vrnt")));
      this.d = i.c.a(paramUri.getQueryParameter("fltp"));
      String str1 = paramUri.getQueryParameter("ep");
      if (str1 == null);
      for (EncryptionParams localEncryptionParams = null; ; localEncryptionParams = EncryptionParams.unserializeEncryptionParams(str1))
      {
        this.e = localEncryptionParams;
        String str2 = paramUri.getQueryParameter("pgfile");
        if (str2 == null)
          break;
        this.f = Boolean.valueOf(Boolean.parseBoolean(str2));
        return;
      }
      this.f = null;
    }
  }

  public static class d
  {
    public String a;
    public t.d b;
    public String c;
    public int d;
    public String e;
    public EncryptionParams f;
  }

  public static class e
  {
    private String a;
    private int b;

    e(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = paramInt;
    }

    public String a()
    {
      return this.a;
    }

    public int b()
    {
      return this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.dx
 * JD-Core Version:    0.6.2
 */