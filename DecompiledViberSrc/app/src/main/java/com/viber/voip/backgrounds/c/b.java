package com.viber.voip.backgrounds.c;

import android.app.Application;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.viber.common.b.d;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.backgrounds.f;
import com.viber.voip.backgrounds.l;
import com.viber.voip.backgrounds.m;
import com.viber.voip.backgrounds.p;
import com.viber.voip.settings.d.i;
import com.viber.voip.util.bj;
import com.viber.voip.util.da;
import com.viber.voip.util.http.OkHttpClientFactory;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class b
  implements Runnable
{
  private static final Logger a = ViberEnv.getLogger();
  private f b;
  private com.viber.voip.backgrounds.b.a c;
  private com.viber.voip.backgrounds.b d;

  public b(f paramf, com.viber.voip.backgrounds.b paramb)
  {
    this.b = paramf;
    this.d = paramb;
    this.c = new com.viber.voip.backgrounds.b.a();
  }

  private String a()
    throws IOException
  {
    String str1 = d.i.i.d();
    Response localResponse = ViberEnv.getOkHttpClientFactory().createClient().newCall(new Request.Builder().url(m.b()).header("If-Modified-Since", str1).build()).execute();
    InputStream localInputStream = localResponse.body().byteStream();
    try
    {
      String str2 = localResponse.header("Last-Modified");
      if (!TextUtils.isEmpty(str2))
        d.i.i.a(str2);
      String str3 = bj.a(localInputStream);
      return str3;
    }
    finally
    {
      localInputStream.close();
    }
  }

  private void a(com.viber.voip.backgrounds.a parama)
    throws IOException
  {
    int i;
    int j;
    if (parama != null)
    {
      d.i.a.a(parama.a());
      this.c.a(parama);
      d.i.g.a(parama.b());
      if (d.i.f.d())
      {
        String str = parama.b();
        i = com.viber.voip.backgrounds.a.b(str);
        j = parama.a();
        if ((!str.startsWith("t")) && (!str.startsWith("c")))
          break label133;
      }
    }
    label133: for (boolean bool = true; ; bool = false)
    {
      p localp = new p(i, j, bool, parama.d());
      if ((!bj.a(localp.h)) || (da.a(d.i.d.d())))
        ViberApplication.getInstance().getBackgroundDownloadTaskController().a(localp);
      return;
    }
  }

  private com.viber.voip.backgrounds.a b()
  {
    try
    {
      InputStream localInputStream = ViberApplication.getApplication().getAssets().open("bg/default_bg_config.json");
      byte[] arrayOfByte = new byte[localInputStream.available()];
      localInputStream.read(arrayOfByte);
      localInputStream.close();
      str = new String(arrayOfByte, "UTF-8");
      return com.viber.voip.backgrounds.a.a(str);
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        c();
        String str = null;
      }
    }
  }

  private void c()
  {
    l locall = new l(0);
    this.b.b(locall);
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 252	com/viber/voip/backgrounds/c/b:a	()Ljava/lang/String;
    //   4: astore 9
    //   6: aconst_null
    //   7: astore_2
    //   8: aload 9
    //   10: astore 5
    //   12: aload 5
    //   14: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +13 -> 30
    //   20: aload 5
    //   22: invokestatic 238	com/viber/voip/backgrounds/a:a	(Ljava/lang/String;)Lcom/viber/voip/backgrounds/a;
    //   25: astore 7
    //   27: aload 7
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull +8 -> 39
    //   34: aload_0
    //   35: aload_2
    //   36: invokespecial 253	com/viber/voip/backgrounds/c/b:a	(Lcom/viber/voip/backgrounds/a;)V
    //   39: aload_0
    //   40: getfield 30	com/viber/voip/backgrounds/c/b:b	Lcom/viber/voip/backgrounds/f;
    //   43: aload_2
    //   44: invokeinterface 254 2 0
    //   49: return
    //   50: astore_3
    //   51: getstatic 133	com/viber/voip/settings/d$i:a	Lcom/viber/common/b/d;
    //   54: invokevirtual 256	com/viber/common/b/d:d	()I
    //   57: istore 4
    //   59: aload_0
    //   60: getfield 32	com/viber/voip/backgrounds/c/b:d	Lcom/viber/voip/backgrounds/b;
    //   63: iload 4
    //   65: invokevirtual 261	com/viber/voip/backgrounds/b:a	(I)Lcom/viber/voip/backgrounds/l;
    //   68: ifnonnull +41 -> 109
    //   71: aload_0
    //   72: invokespecial 263	com/viber/voip/backgrounds/c/b:b	()Lcom/viber/voip/backgrounds/a;
    //   75: astore 8
    //   77: aload 8
    //   79: astore_2
    //   80: getstatic 133	com/viber/voip/settings/d$i:a	Lcom/viber/common/b/d;
    //   83: aload_2
    //   84: invokevirtual 138	com/viber/voip/backgrounds/a:a	()I
    //   87: invokevirtual 143	com/viber/common/b/d:a	(I)V
    //   90: aconst_null
    //   91: astore 5
    //   93: goto -81 -> 12
    //   96: astore_1
    //   97: aload_0
    //   98: getfield 30	com/viber/voip/backgrounds/c/b:b	Lcom/viber/voip/backgrounds/f;
    //   101: aload_2
    //   102: invokeinterface 254 2 0
    //   107: aload_1
    //   108: athrow
    //   109: aconst_null
    //   110: astore_2
    //   111: aconst_null
    //   112: astore 5
    //   114: goto -102 -> 12
    //   117: astore 6
    //   119: goto -80 -> 39
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_2
    //   125: goto -28 -> 97
    //
    // Exception table:
    //   from	to	target	type
    //   0	6	50	java/io/IOException
    //   12	27	96	finally
    //   34	39	96	finally
    //   80	90	96	finally
    //   34	39	117	java/io/IOException
    //   0	6	122	finally
    //   51	77	122	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.c.b
 * JD-Core Version:    0.6.2
 */