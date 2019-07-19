package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentValues;
import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.a;

public class e
  implements a
{
  private static final String[] a = { "_id", "class" };
  private DefaultBadger b;

  public e()
  {
    if (Build.VERSION.SDK_INT >= 21)
      this.b = new DefaultBadger();
  }

  private ContentValues a(ComponentName paramComponentName, int paramInt, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    if (paramBoolean)
    {
      localContentValues.put("package", paramComponentName.getPackageName());
      localContentValues.put("class", paramComponentName.getClassName());
    }
    localContentValues.put("badgecount", Integer.valueOf(paramInt));
    return localContentValues;
  }

  public List<String> a()
  {
    return Arrays.asList(new String[] { "com.sec.android.app.launcher", "com.sec.android.app.twlauncher" });
  }

  // ERROR //
  public void a(android.content.Context paramContext, ComponentName paramComponentName, int paramInt)
    throws me.leolin.shortcutbadger.b
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	me/leolin/shortcutbadger/impl/e:b	Lme/leolin/shortcutbadger/impl/DefaultBadger;
    //   4: ifnull +25 -> 29
    //   7: aload_0
    //   8: getfield 34	me/leolin/shortcutbadger/impl/e:b	Lme/leolin/shortcutbadger/impl/DefaultBadger;
    //   11: aload_1
    //   12: invokevirtual 81	me/leolin/shortcutbadger/impl/DefaultBadger:a	(Landroid/content/Context;)Z
    //   15: ifeq +14 -> 29
    //   18: aload_0
    //   19: getfield 34	me/leolin/shortcutbadger/impl/e:b	Lme/leolin/shortcutbadger/impl/DefaultBadger;
    //   22: aload_1
    //   23: aload_2
    //   24: iload_3
    //   25: invokevirtual 83	me/leolin/shortcutbadger/impl/DefaultBadger:a	(Landroid/content/Context;Landroid/content/ComponentName;I)V
    //   28: return
    //   29: ldc 85
    //   31: invokestatic 91	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   34: astore 4
    //   36: aload_1
    //   37: invokevirtual 97	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   40: astore 5
    //   42: getstatic 20	me/leolin/shortcutbadger/impl/e:a	[Ljava/lang/String;
    //   45: astore 8
    //   47: iconst_1
    //   48: anewarray 14	java/lang/String
    //   51: astore 9
    //   53: aload 9
    //   55: iconst_0
    //   56: aload_2
    //   57: invokevirtual 46	android/content/ComponentName:getPackageName	()Ljava/lang/String;
    //   60: aastore
    //   61: aload 5
    //   63: aload 4
    //   65: aload 8
    //   67: ldc 99
    //   69: aload 9
    //   71: aconst_null
    //   72: invokevirtual 105	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore 10
    //   77: aload 10
    //   79: ifnull +120 -> 199
    //   82: aload_2
    //   83: invokevirtual 53	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   86: astore 11
    //   88: iconst_0
    //   89: istore 12
    //   91: aload 10
    //   93: invokeinterface 111 1 0
    //   98: ifeq +81 -> 179
    //   101: aload 10
    //   103: iconst_0
    //   104: invokeinterface 115 2 0
    //   109: istore 14
    //   111: aload_0
    //   112: aload_2
    //   113: iload_3
    //   114: iconst_0
    //   115: invokespecial 117	me/leolin/shortcutbadger/impl/e:a	(Landroid/content/ComponentName;IZ)Landroid/content/ContentValues;
    //   118: astore 15
    //   120: iconst_1
    //   121: anewarray 14	java/lang/String
    //   124: astore 16
    //   126: aload 16
    //   128: iconst_0
    //   129: iload 14
    //   131: invokestatic 120	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   134: aastore
    //   135: aload 5
    //   137: aload 4
    //   139: aload 15
    //   141: ldc 122
    //   143: aload 16
    //   145: invokevirtual 126	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   148: pop
    //   149: aload 11
    //   151: aload 10
    //   153: aload 10
    //   155: ldc 18
    //   157: invokeinterface 130 2 0
    //   162: invokeinterface 133 2 0
    //   167: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   170: ifeq -79 -> 91
    //   173: iconst_1
    //   174: istore 12
    //   176: goto -85 -> 91
    //   179: iload 12
    //   181: ifne +18 -> 199
    //   184: aload 5
    //   186: aload 4
    //   188: aload_0
    //   189: aload_2
    //   190: iload_3
    //   191: iconst_1
    //   192: invokespecial 117	me/leolin/shortcutbadger/impl/e:a	(Landroid/content/ComponentName;IZ)Landroid/content/ContentValues;
    //   195: invokevirtual 141	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   198: pop
    //   199: aload 10
    //   201: invokestatic 146	me/leolin/shortcutbadger/a/b:a	(Landroid/database/Cursor;)V
    //   204: return
    //   205: astore 6
    //   207: aconst_null
    //   208: astore 7
    //   210: aload 7
    //   212: invokestatic 146	me/leolin/shortcutbadger/a/b:a	(Landroid/database/Cursor;)V
    //   215: aload 6
    //   217: athrow
    //   218: astore 6
    //   220: aload 10
    //   222: astore 7
    //   224: goto -14 -> 210
    //
    // Exception table:
    //   from	to	target	type
    //   42	77	205	finally
    //   82	88	218	finally
    //   91	173	218	finally
    //   184	199	218	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.leolin.shortcutbadger.impl.e
 * JD-Core Version:    0.6.2
 */