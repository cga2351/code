package com.appnexus.opensdk.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.Pair;
import com.appnexus.opensdk.SDKSettings;
import java.lang.ref.WeakReference;
import java.util.concurrent.RejectedExecutionException;

public class AdvertisingIDUtil
{
  public static void retrieveAndSetAAID(Context paramContext)
  {
    if ((!StringUtil.isEmpty(SDKSettings.getAAID())) || (!Settings.getSettings().aaidEnabled))
      return;
    a locala = new a(paramContext, null);
    try
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        locala.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
      }
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      Clog.e(Clog.baseLogTag, "Concurrent Thread Exception while fetching the AAID: " + localRejectedExecutionException.getMessage());
      return;
      locala.execute(new Void[0]);
      return;
    }
    catch (Exception localException)
    {
      Clog.e(Clog.baseLogTag, "Exception while fetching the AAID: " + localException.getMessage());
    }
  }

  private static class a extends AsyncTask<Void, Void, Pair<String, Boolean>>
  {
    private WeakReference<Context> a;

    private a(Context paramContext)
    {
      this.a = new WeakReference(paramContext);
    }

    // ERROR //
    protected Pair<String, Boolean> a(Void[] paramArrayOfVoid)
    {
      // Byte code:
      //   0: iconst_0
      //   1: invokestatic 44	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   4: astore_2
      //   5: invokestatic 50	com/appnexus/opensdk/utils/Settings:getSettings	()Lcom/appnexus/opensdk/utils/Settings;
      //   8: getfield 54	com/appnexus/opensdk/utils/Settings:aaidEnabled	Z
      //   11: ifne +13 -> 24
      //   14: new 56	android/util/Pair
      //   17: dup
      //   18: aconst_null
      //   19: aload_2
      //   20: invokespecial 59	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   23: areturn
      //   24: aload_0
      //   25: getfield 20	com/appnexus/opensdk/utils/AdvertisingIDUtil$a:a	Ljava/lang/ref/WeakReference;
      //   28: invokevirtual 63	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   31: checkcast 65	android/content/Context
      //   34: astore 11
      //   36: aload 11
      //   38: ifnull +215 -> 253
      //   41: ldc 67
      //   43: invokestatic 73	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
      //   46: astore 12
      //   48: ldc 75
      //   50: invokestatic 73	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
      //   53: ldc 77
      //   55: iconst_1
      //   56: anewarray 69	java/lang/Class
      //   59: dup
      //   60: iconst_0
      //   61: ldc 65
      //   63: aastore
      //   64: invokevirtual 81	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   67: astore 13
      //   69: aload 12
      //   71: ldc 83
      //   73: iconst_0
      //   74: anewarray 69	java/lang/Class
      //   77: invokevirtual 81	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   80: astore 14
      //   82: aload 12
      //   84: ldc 85
      //   86: iconst_0
      //   87: anewarray 69	java/lang/Class
      //   90: invokevirtual 81	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   93: astore 15
      //   95: aload 12
      //   97: aload 13
      //   99: aconst_null
      //   100: iconst_1
      //   101: anewarray 87	java/lang/Object
      //   104: dup
      //   105: iconst_0
      //   106: aload 11
      //   108: aastore
      //   109: invokevirtual 93	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   112: invokevirtual 97	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
      //   115: astore 16
      //   117: aload 14
      //   119: aload 16
      //   121: iconst_0
      //   122: anewarray 87	java/lang/Object
      //   125: invokevirtual 93	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   128: checkcast 99	java/lang/String
      //   131: astore 4
      //   133: aload 15
      //   135: aload 16
      //   137: iconst_0
      //   138: anewarray 87	java/lang/Object
      //   141: invokevirtual 93	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   144: checkcast 40	java/lang/Boolean
      //   147: astore 24
      //   149: aload 24
      //   151: astore_2
      //   152: new 56	android/util/Pair
      //   155: dup
      //   156: aload 4
      //   158: aload_2
      //   159: invokespecial 59	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   162: areturn
      //   163: astore 10
      //   165: aconst_null
      //   166: astore 4
      //   168: goto -16 -> 152
      //   171: astore 23
      //   173: goto -21 -> 152
      //   176: astore 9
      //   178: aconst_null
      //   179: astore 4
      //   181: goto -29 -> 152
      //   184: astore 22
      //   186: goto -34 -> 152
      //   189: astore 8
      //   191: aconst_null
      //   192: astore 4
      //   194: goto -42 -> 152
      //   197: astore 21
      //   199: goto -47 -> 152
      //   202: astore 7
      //   204: aconst_null
      //   205: astore 4
      //   207: goto -55 -> 152
      //   210: astore 20
      //   212: goto -60 -> 152
      //   215: astore 6
      //   217: aconst_null
      //   218: astore 4
      //   220: goto -68 -> 152
      //   223: astore 19
      //   225: goto -73 -> 152
      //   228: astore 5
      //   230: aconst_null
      //   231: astore 4
      //   233: goto -81 -> 152
      //   236: astore 18
      //   238: goto -86 -> 152
      //   241: astore_3
      //   242: aconst_null
      //   243: astore 4
      //   245: goto -93 -> 152
      //   248: astore 17
      //   250: goto -98 -> 152
      //   253: aload_2
      //   254: astore 24
      //   256: aconst_null
      //   257: astore 4
      //   259: goto -110 -> 149
      //
      // Exception table:
      //   from	to	target	type
      //   24	36	163	java/lang/Exception
      //   41	133	163	java/lang/Exception
      //   133	149	171	java/lang/Exception
      //   24	36	176	java/lang/NullPointerException
      //   41	133	176	java/lang/NullPointerException
      //   133	149	184	java/lang/NullPointerException
      //   24	36	189	java/lang/ClassCastException
      //   41	133	189	java/lang/ClassCastException
      //   133	149	197	java/lang/ClassCastException
      //   24	36	202	java/lang/IllegalAccessException
      //   41	133	202	java/lang/IllegalAccessException
      //   133	149	210	java/lang/IllegalAccessException
      //   24	36	215	java/lang/NoSuchMethodException
      //   41	133	215	java/lang/NoSuchMethodException
      //   133	149	223	java/lang/NoSuchMethodException
      //   24	36	228	java/lang/reflect/InvocationTargetException
      //   41	133	228	java/lang/reflect/InvocationTargetException
      //   133	149	236	java/lang/reflect/InvocationTargetException
      //   24	36	241	java/lang/ClassNotFoundException
      //   41	133	241	java/lang/ClassNotFoundException
      //   133	149	248	java/lang/ClassNotFoundException
    }

    protected void a(Pair<String, Boolean> paramPair)
    {
      super.onPostExecute(paramPair);
      SDKSettings.setAAID((String)paramPair.first, ((Boolean)paramPair.second).booleanValue());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.utils.AdvertisingIDUtil
 * JD-Core Version:    0.6.2
 */