package com.viber.voip.schedule;

import android.os.Bundle;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.ap;
import com.viber.voip.util.bj;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;

public abstract class h
  implements f
{
  private static final Logger a = ViberEnv.getLogger();

  private String a(InputStream paramInputStream)
    throws IOException
  {
    String str = bj.a(paramInputStream);
    if (TextUtils.isEmpty(str))
      str = null;
    return str;
  }

  // ERROR //
  private boolean b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iconst_1
    //   3: istore_3
    //   4: iconst_0
    //   5: istore 4
    //   7: aload_0
    //   8: invokevirtual 43	com/viber/voip/schedule/h:b	()Lcom/viber/common/b/h;
    //   11: invokevirtual 49	com/viber/common/b/h:d	()Ljava/lang/String;
    //   14: astore 10
    //   16: invokestatic 53	com/viber/voip/ViberEnv:getOkHttpClientFactory	()Lcom/viber/voip/util/http/OkHttpClientFactory;
    //   19: invokeinterface 59 1 0
    //   24: astore 11
    //   26: new 61	okhttp3/Request$Builder
    //   29: dup
    //   30: invokespecial 62	okhttp3/Request$Builder:<init>	()V
    //   33: aload_1
    //   34: invokevirtual 66	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   37: astore 12
    //   39: aload 12
    //   41: ldc 68
    //   43: aload 10
    //   45: invokevirtual 72	okhttp3/Request$Builder:header	(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   48: pop
    //   49: aload 11
    //   51: invokevirtual 78	okhttp3/OkHttpClient$Builder:build	()Lokhttp3/OkHttpClient;
    //   54: aload 12
    //   56: invokevirtual 81	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   59: invokevirtual 87	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   62: invokeinterface 93 1 0
    //   67: astore 14
    //   69: aload 14
    //   71: invokevirtual 99	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   74: invokevirtual 105	okhttp3/ResponseBody:byteStream	()Ljava/io/InputStream;
    //   77: astore 15
    //   79: aload 14
    //   81: ldc 107
    //   83: invokevirtual 110	okhttp3/Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore 17
    //   88: aload 17
    //   90: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   93: istore 18
    //   95: iconst_0
    //   96: istore 4
    //   98: aconst_null
    //   99: astore_2
    //   100: iload 18
    //   102: ifne +12 -> 114
    //   105: aload_0
    //   106: invokevirtual 43	com/viber/voip/schedule/h:b	()Lcom/viber/common/b/h;
    //   109: aload 17
    //   111: invokevirtual 113	com/viber/common/b/h:a	(Ljava/lang/String;)V
    //   114: aload 14
    //   116: invokevirtual 117	okhttp3/Response:code	()I
    //   119: sipush 304
    //   122: if_icmpne +33 -> 155
    //   125: iload_3
    //   126: istore 4
    //   128: invokestatic 123	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   131: invokevirtual 127	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
    //   134: aload_1
    //   135: invokevirtual 131	com/viber/voip/util/ap:d	(Ljava/lang/String;)V
    //   138: aload 15
    //   140: invokestatic 134	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   143: aload_2
    //   144: ifnull +8 -> 152
    //   147: aload_0
    //   148: aload_2
    //   149: invokevirtual 135	com/viber/voip/schedule/h:a	(Ljava/lang/String;)V
    //   152: iload 4
    //   154: ireturn
    //   155: aload_0
    //   156: aload 15
    //   158: invokespecial 136	com/viber/voip/schedule/h:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   161: astore 19
    //   163: aload 19
    //   165: astore_2
    //   166: aload_2
    //   167: ifnull +9 -> 176
    //   170: iload_3
    //   171: istore 4
    //   173: goto -45 -> 128
    //   176: iconst_0
    //   177: istore_3
    //   178: goto -8 -> 170
    //   181: astore 6
    //   183: aconst_null
    //   184: astore 7
    //   186: invokestatic 123	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   189: invokevirtual 127	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
    //   192: aload_1
    //   193: invokevirtual 137	com/viber/voip/util/ap:a	(Ljava/lang/String;)V
    //   196: aload 7
    //   198: invokestatic 134	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   201: goto -58 -> 143
    //   204: astore 5
    //   206: aload_2
    //   207: invokestatic 134	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   210: aload 5
    //   212: athrow
    //   213: astore 9
    //   215: getstatic 18	com/viber/voip/schedule/h:a	Lcom/viber/dexshared/Logger;
    //   218: aload 9
    //   220: ldc 139
    //   222: invokeinterface 144 3 0
    //   227: invokestatic 123	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
    //   230: invokevirtual 127	com/viber/voip/ViberApplication:getDownloadValve	()Lcom/viber/voip/util/ap;
    //   233: aload_1
    //   234: invokevirtual 137	com/viber/voip/util/ap:a	(Ljava/lang/String;)V
    //   237: iload 4
    //   239: ireturn
    //   240: astore 5
    //   242: aload 15
    //   244: astore_2
    //   245: goto -39 -> 206
    //   248: astore 8
    //   250: aload 7
    //   252: astore_2
    //   253: aload 8
    //   255: astore 5
    //   257: goto -51 -> 206
    //   260: astore 16
    //   262: aload 15
    //   264: astore 7
    //   266: goto -80 -> 186
    //
    // Exception table:
    //   from	to	target	type
    //   7	79	181	java/lang/Exception
    //   7	79	204	finally
    //   147	152	213	org/json/JSONException
    //   79	95	240	finally
    //   105	114	240	finally
    //   114	125	240	finally
    //   128	138	240	finally
    //   155	163	240	finally
    //   186	196	248	finally
    //   79	95	260	java/lang/Exception
    //   105	114	260	java/lang/Exception
    //   114	125	260	java/lang/Exception
    //   128	138	260	java/lang/Exception
    //   155	163	260	java/lang/Exception
  }

  public int a(Bundle paramBundle)
  {
    String str = a();
    if (ViberApplication.getInstance().getDownloadValve().c(str))
    {
      if (b(str))
        return 0;
      return 1;
    }
    return 2;
  }

  protected abstract String a();

  protected abstract void a(String paramString)
    throws JSONException;

  protected abstract com.viber.common.b.h b();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.h
 * JD-Core Version:    0.6.2
 */