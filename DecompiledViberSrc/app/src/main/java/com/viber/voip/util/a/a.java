package com.viber.voip.util.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.contacts.c.d.m.e;
import com.viber.voip.messages.m;
import com.viber.voip.model.j;
import com.viber.voip.permissions.n;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;

public class a
{
  private static final Logger a = ViberEnv.getLogger();

  public static boolean a(final WeakReference<? extends Activity> paramWeakReference, Intent paramIntent, final c paramc)
  {
    Uri localUri = paramIntent.getData();
    if ((!"android.intent.action.VIEW".equals(paramIntent.getAction())) || (localUri == null) || (localUri.getAuthority() == null) || (!localUri.getAuthority().equals("com.android.contacts")))
      return false;
    if (!paramc.a(n.j))
    {
      paramc.a((Context)paramWeakReference.get(), 78, n.j);
      return true;
    }
    av.e.f.a().post(new Runnable()
    {
      // ERROR //
      public void run()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_1
        //   2: invokestatic 34	com/viber/voip/ViberApplication:getApplication	()Landroid/app/Application;
        //   5: aload_0
        //   6: getfield 20	com/viber/voip/util/a/a$1:a	Landroid/net/Uri;
        //   9: iconst_2
        //   10: anewarray 36	java/lang/String
        //   13: dup
        //   14: iconst_0
        //   15: ldc 38
        //   17: aastore
        //   18: dup
        //   19: iconst_1
        //   20: ldc 40
        //   22: aastore
        //   23: aconst_null
        //   24: aconst_null
        //   25: aconst_null
        //   26: invokestatic 45	com/viber/voip/util/af:a	(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
        //   29: astore_3
        //   30: aload_3
        //   31: ifnull +379 -> 410
        //   34: aload_3
        //   35: invokeinterface 51 1 0
        //   40: ifeq +370 -> 410
        //   43: aload_3
        //   44: iconst_0
        //   45: invokeinterface 55 2 0
        //   50: astore 5
        //   52: aload_3
        //   53: iconst_1
        //   54: invokeinterface 55 2 0
        //   59: astore 12
        //   61: aload 12
        //   63: astore 4
        //   65: aload_3
        //   66: invokestatic 58	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
        //   69: aload 5
        //   71: invokestatic 64	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   74: ifne +11 -> 85
        //   77: aload 4
        //   79: invokestatic 64	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   82: ifeq +11 -> 93
        //   85: return
        //   86: astore_2
        //   87: aload_1
        //   88: invokestatic 58	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
        //   91: aload_2
        //   92: athrow
        //   93: ldc 66
        //   95: aload 4
        //   97: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   100: ifeq +123 -> 223
        //   103: aload_0
        //   104: getfield 22	com/viber/voip/util/a/a$1:b	Lcom/viber/common/permission/c;
        //   107: getstatic 76	com/viber/voip/permissions/n:h	[Ljava/lang/String;
        //   110: invokevirtual 81	com/viber/common/permission/c:a	([Ljava/lang/String;)Z
        //   113: ifne +37 -> 150
        //   116: aload_0
        //   117: getfield 24	com/viber/voip/util/a/a$1:c	Ljava/lang/ref/WeakReference;
        //   120: invokevirtual 87	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
        //   123: checkcast 89	android/app/Activity
        //   126: astore 11
        //   128: aload 11
        //   130: ifnull -45 -> 85
        //   133: aload_0
        //   134: getfield 22	com/viber/voip/util/a/a$1:b	Lcom/viber/common/permission/c;
        //   137: aload 11
        //   139: bipush 58
        //   141: getstatic 76	com/viber/voip/permissions/n:h	[Ljava/lang/String;
        //   144: aload 5
        //   146: invokevirtual 92	com/viber/common/permission/c:a	(Landroid/content/Context;I[Ljava/lang/String;Ljava/lang/Object;)V
        //   149: return
        //   150: invokestatic 98	com/viber/voip/phone/call/CallInitiationId:noteNextCallInitiationAttemptId	()J
        //   153: pop2
        //   154: invokestatic 102	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
        //   157: invokevirtual 106	com/viber/voip/ViberApplication:getLazyUserStartsCallEventCollector	()Ldagger/a;
        //   160: invokeinterface 109 1 0
        //   165: checkcast 111	com/viber/voip/analytics/story/b/a/h
        //   168: invokestatic 117	com/viber/voip/analytics/story/b/a/h$a:i	()Lcom/viber/voip/analytics/story/b/a/h$a$a;
        //   171: iconst_1
        //   172: anewarray 36	java/lang/String
        //   175: dup
        //   176: iconst_0
        //   177: aload 5
        //   179: aastore
        //   180: invokevirtual 122	com/viber/voip/analytics/story/b/a/h$a$a:a	([Ljava/lang/String;)Lcom/viber/voip/analytics/story/b/a/h$a$a;
        //   183: ldc 124
        //   185: invokevirtual 127	com/viber/voip/analytics/story/b/a/h$a$a:a	(Ljava/lang/String;)Lcom/viber/voip/analytics/story/b/a/h$a$a;
        //   188: ldc 129
        //   190: invokevirtual 131	com/viber/voip/analytics/story/b/a/h$a$a:b	(Ljava/lang/String;)Lcom/viber/voip/analytics/story/b/a/h$a$a;
        //   193: iconst_1
        //   194: invokevirtual 134	com/viber/voip/analytics/story/b/a/h$a$a:a	(Z)Lcom/viber/voip/analytics/story/b/a/h$a$a;
        //   197: invokevirtual 137	com/viber/voip/analytics/story/b/a/h$a$a:a	()Lcom/viber/voip/analytics/story/b/a/h$a;
        //   200: invokevirtual 140	com/viber/voip/analytics/story/b/a/h:b	(Lcom/viber/voip/analytics/story/b/a/h$a;)V
        //   203: invokestatic 102	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
        //   206: iconst_1
        //   207: invokevirtual 144	com/viber/voip/ViberApplication:getEngine	(Z)Lcom/viber/jni/Engine;
        //   210: invokevirtual 150	com/viber/jni/Engine:getDialerPendingController	()Lcom/viber/voip/phone/call/DialerPendingController;
        //   213: aload 5
        //   215: iconst_0
        //   216: iconst_0
        //   217: invokeinterface 156 4 0
        //   222: return
        //   223: ldc 158
        //   225: aload 4
        //   227: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   230: ifeq +34 -> 264
        //   233: invokestatic 102	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
        //   236: invokevirtual 162	com/viber/voip/ViberApplication:getContactManager	()Lcom/viber/voip/contacts/c/d/g;
        //   239: invokeinterface 167 1 0
        //   244: aconst_null
        //   245: aload 5
        //   247: invokestatic 173	java/util/Collections:singleton	(Ljava/lang/Object;)Ljava/util/Set;
        //   250: new 175	com/viber/voip/util/a/a$1$1
        //   253: dup
        //   254: aload_0
        //   255: invokespecial 178	com/viber/voip/util/a/a$1$1:<init>	(Lcom/viber/voip/util/a/a$1;)V
        //   258: invokeinterface 183 4 0
        //   263: return
        //   264: ldc 185
        //   266: aload 4
        //   268: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   271: ifne +13 -> 284
        //   274: ldc 187
        //   276: aload 4
        //   278: invokevirtual 70	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   281: ifeq -196 -> 85
        //   284: aload_0
        //   285: getfield 22	com/viber/voip/util/a/a$1:b	Lcom/viber/common/permission/c;
        //   288: getstatic 76	com/viber/voip/permissions/n:h	[Ljava/lang/String;
        //   291: invokevirtual 81	com/viber/common/permission/c:a	([Ljava/lang/String;)Z
        //   294: ifne +37 -> 331
        //   297: aload_0
        //   298: getfield 24	com/viber/voip/util/a/a$1:c	Ljava/lang/ref/WeakReference;
        //   301: invokevirtual 87	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
        //   304: checkcast 89	android/app/Activity
        //   307: astore 8
        //   309: aload 8
        //   311: ifnull -226 -> 85
        //   314: aload_0
        //   315: getfield 22	com/viber/voip/util/a/a$1:b	Lcom/viber/common/permission/c;
        //   318: aload 8
        //   320: bipush 39
        //   322: getstatic 76	com/viber/voip/permissions/n:h	[Ljava/lang/String;
        //   325: aload 5
        //   327: invokevirtual 92	com/viber/common/permission/c:a	(Landroid/content/Context;I[Ljava/lang/String;Ljava/lang/Object;)V
        //   330: return
        //   331: invokestatic 98	com/viber/voip/phone/call/CallInitiationId:noteNextCallInitiationAttemptId	()J
        //   334: pop2
        //   335: invokestatic 102	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
        //   338: invokevirtual 106	com/viber/voip/ViberApplication:getLazyUserStartsCallEventCollector	()Ldagger/a;
        //   341: invokeinterface 109 1 0
        //   346: checkcast 111	com/viber/voip/analytics/story/b/a/h
        //   349: invokestatic 117	com/viber/voip/analytics/story/b/a/h$a:i	()Lcom/viber/voip/analytics/story/b/a/h$a$a;
        //   352: iconst_1
        //   353: anewarray 36	java/lang/String
        //   356: dup
        //   357: iconst_0
        //   358: aload 5
        //   360: aastore
        //   361: invokevirtual 122	com/viber/voip/analytics/story/b/a/h$a$a:a	([Ljava/lang/String;)Lcom/viber/voip/analytics/story/b/a/h$a$a;
        //   364: ldc 124
        //   366: invokevirtual 127	com/viber/voip/analytics/story/b/a/h$a$a:a	(Ljava/lang/String;)Lcom/viber/voip/analytics/story/b/a/h$a$a;
        //   369: ldc 189
        //   371: invokevirtual 131	com/viber/voip/analytics/story/b/a/h$a$a:b	(Ljava/lang/String;)Lcom/viber/voip/analytics/story/b/a/h$a$a;
        //   374: iconst_1
        //   375: invokevirtual 191	com/viber/voip/analytics/story/b/a/h$a$a:b	(Z)Lcom/viber/voip/analytics/story/b/a/h$a$a;
        //   378: invokevirtual 137	com/viber/voip/analytics/story/b/a/h$a$a:a	()Lcom/viber/voip/analytics/story/b/a/h$a;
        //   381: invokevirtual 140	com/viber/voip/analytics/story/b/a/h:b	(Lcom/viber/voip/analytics/story/b/a/h$a;)V
        //   384: invokestatic 102	com/viber/voip/ViberApplication:getInstance	()Lcom/viber/voip/ViberApplication;
        //   387: iconst_1
        //   388: invokevirtual 144	com/viber/voip/ViberApplication:getEngine	(Z)Lcom/viber/jni/Engine;
        //   391: invokevirtual 150	com/viber/jni/Engine:getDialerPendingController	()Lcom/viber/voip/phone/call/DialerPendingController;
        //   394: aload 5
        //   396: iconst_1
        //   397: iconst_0
        //   398: invokeinterface 156 4 0
        //   403: return
        //   404: astore_2
        //   405: aload_3
        //   406: astore_1
        //   407: goto -320 -> 87
        //   410: aconst_null
        //   411: astore 4
        //   413: aconst_null
        //   414: astore 5
        //   416: goto -351 -> 65
        //
        // Exception table:
        //   from	to	target	type
        //   2	30	86	finally
        //   34	61	404	finally
      }
    });
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.a.a
 * JD-Core Version:    0.6.2
 */