package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.b.g;
import com.google.android.exoplayer2.drm.p;
import com.google.android.exoplayer2.e.k;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.metadata.e;
import com.google.android.exoplayer2.video.a.b;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class h
  implements ah
{
  private final Context a;
  private final com.google.android.exoplayer2.drm.l<p> b;
  private final int c;
  private final long d;

  public h(Context paramContext)
  {
    this(paramContext, 0);
  }

  public h(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 5000L);
  }

  public h(Context paramContext, int paramInt, long paramLong)
  {
    this.a = paramContext;
    this.c = paramInt;
    this.d = paramLong;
    this.b = null;
  }

  protected void a(Context paramContext, int paramInt, ArrayList<ad> paramArrayList)
  {
    paramArrayList.add(new b());
  }

  protected void a(Context paramContext, Handler paramHandler, int paramInt, ArrayList<ad> paramArrayList)
  {
  }

  protected void a(Context paramContext, com.google.android.exoplayer2.drm.l<p> paraml, long paramLong, Handler paramHandler, com.google.android.exoplayer2.video.h paramh, int paramInt, ArrayList<ad> paramArrayList)
  {
    paramArrayList.add(new com.google.android.exoplayer2.video.c(paramContext, com.google.android.exoplayer2.d.c.a, paramLong, paraml, false, paramHandler, paramh, 50));
    if (paramInt == 0)
      return;
    int i = paramArrayList.size();
    if (paramInt == 2);
    for (int j = i - 1; ; j = i)
      try
      {
        Class localClass = Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer");
        Class[] arrayOfClass = new Class[5];
        arrayOfClass[0] = Boolean.TYPE;
        arrayOfClass[1] = Long.TYPE;
        arrayOfClass[2] = Handler.class;
        arrayOfClass[3] = com.google.android.exoplayer2.video.h.class;
        arrayOfClass[4] = Integer.TYPE;
        Constructor localConstructor = localClass.getConstructor(arrayOfClass);
        Object[] arrayOfObject = new Object[5];
        arrayOfObject[0] = Boolean.valueOf(true);
        arrayOfObject[1] = Long.valueOf(paramLong);
        arrayOfObject[2] = paramHandler;
        arrayOfObject[3] = paramh;
        arrayOfObject[4] = Integer.valueOf(50);
        ad localad = (ad)localConstructor.newInstance(arrayOfObject);
        (j + 1);
        paramArrayList.add(j, localad);
        com.google.android.exoplayer2.g.l.b("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        return;
      }
      catch (Exception localException)
      {
        throw new RuntimeException("Error instantiating VP9 extension", localException);
      }
  }

  // ERROR //
  protected void a(Context paramContext, com.google.android.exoplayer2.drm.l<p> paraml, f[] paramArrayOff, Handler paramHandler, g paramg, int paramInt, ArrayList<ad> paramArrayList)
  {
    // Byte code:
    //   0: aload 7
    //   2: new 134	com/google/android/exoplayer2/b/v
    //   5: dup
    //   6: aload_1
    //   7: getstatic 59	com/google/android/exoplayer2/d/c:a	Lcom/google/android/exoplayer2/d/c;
    //   10: aload_2
    //   11: iconst_0
    //   12: aload 4
    //   14: aload 5
    //   16: aload_1
    //   17: invokestatic 139	com/google/android/exoplayer2/b/c:a	(Landroid/content/Context;)Lcom/google/android/exoplayer2/b/c;
    //   20: aload_3
    //   21: invokespecial 142	com/google/android/exoplayer2/b/v:<init>	(Landroid/content/Context;Lcom/google/android/exoplayer2/d/c;Lcom/google/android/exoplayer2/drm/l;ZLandroid/os/Handler;Lcom/google/android/exoplayer2/b/g;Lcom/google/android/exoplayer2/b/c;[Lcom/google/android/exoplayer2/b/f;)V
    //   24: invokevirtual 46	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   27: pop
    //   28: iload 6
    //   30: ifne +4 -> 34
    //   33: return
    //   34: aload 7
    //   36: invokevirtual 66	java/util/ArrayList:size	()I
    //   39: istore 9
    //   41: iload 6
    //   43: iconst_2
    //   44: if_icmpne +6 -> 50
    //   47: iinc 9 255
    //   50: ldc 144
    //   52: invokestatic 74	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   55: iconst_3
    //   56: anewarray 70	java/lang/Class
    //   59: dup
    //   60: iconst_0
    //   61: ldc 85
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: ldc 146
    //   68: aastore
    //   69: dup
    //   70: iconst_2
    //   71: ldc 148
    //   73: aastore
    //   74: invokevirtual 94	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   77: iconst_3
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: aload 4
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload 5
    //   90: aastore
    //   91: dup
    //   92: iconst_2
    //   93: aload_3
    //   94: aastore
    //   95: invokevirtual 110	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   98: checkcast 112	com/google/android/exoplayer2/ad
    //   101: astore 24
    //   103: iload 9
    //   105: iconst_1
    //   106: iadd
    //   107: istore 25
    //   109: aload 7
    //   111: iload 9
    //   113: aload 24
    //   115: invokevirtual 115	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   118: ldc 117
    //   120: ldc 150
    //   122: invokestatic 124	com/google/android/exoplayer2/g/l:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: iload 25
    //   127: istore 13
    //   129: ldc 152
    //   131: invokestatic 74	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   134: iconst_3
    //   135: anewarray 70	java/lang/Class
    //   138: dup
    //   139: iconst_0
    //   140: ldc 85
    //   142: aastore
    //   143: dup
    //   144: iconst_1
    //   145: ldc 146
    //   147: aastore
    //   148: dup
    //   149: iconst_2
    //   150: ldc 148
    //   152: aastore
    //   153: invokevirtual 94	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   156: iconst_3
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload 4
    //   164: aastore
    //   165: dup
    //   166: iconst_1
    //   167: aload 5
    //   169: aastore
    //   170: dup
    //   171: iconst_2
    //   172: aload_3
    //   173: aastore
    //   174: invokevirtual 110	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   177: checkcast 112	com/google/android/exoplayer2/ad
    //   180: astore 22
    //   182: iload 13
    //   184: iconst_1
    //   185: iadd
    //   186: istore 17
    //   188: aload 7
    //   190: iload 13
    //   192: aload 22
    //   194: invokevirtual 115	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   197: ldc 117
    //   199: ldc 154
    //   201: invokestatic 124	com/google/android/exoplayer2/g/l:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: ldc 156
    //   206: invokestatic 74	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   209: iconst_3
    //   210: anewarray 70	java/lang/Class
    //   213: dup
    //   214: iconst_0
    //   215: ldc 85
    //   217: aastore
    //   218: dup
    //   219: iconst_1
    //   220: ldc 146
    //   222: aastore
    //   223: dup
    //   224: iconst_2
    //   225: ldc 148
    //   227: aastore
    //   228: invokevirtual 94	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   231: iconst_3
    //   232: anewarray 4	java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: aload 4
    //   239: aastore
    //   240: dup
    //   241: iconst_1
    //   242: aload 5
    //   244: aastore
    //   245: dup
    //   246: iconst_2
    //   247: aload_3
    //   248: aastore
    //   249: invokevirtual 110	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   252: checkcast 112	com/google/android/exoplayer2/ad
    //   255: astore 20
    //   257: iload 17
    //   259: iconst_1
    //   260: iadd
    //   261: pop
    //   262: aload 7
    //   264: iload 17
    //   266: aload 20
    //   268: invokevirtual 115	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   271: ldc 117
    //   273: ldc 158
    //   275: invokestatic 124	com/google/android/exoplayer2/g/l:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: return
    //   279: astore 19
    //   281: return
    //   282: astore 11
    //   284: iload 9
    //   286: istore 12
    //   288: iload 12
    //   290: istore 13
    //   292: goto -163 -> 129
    //   295: astore 10
    //   297: new 126	java/lang/RuntimeException
    //   300: dup
    //   301: ldc 160
    //   303: aload 10
    //   305: invokespecial 131	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   308: athrow
    //   309: astore 15
    //   311: iload 13
    //   313: istore 16
    //   315: iload 16
    //   317: istore 17
    //   319: goto -115 -> 204
    //   322: astore 14
    //   324: new 126	java/lang/RuntimeException
    //   327: dup
    //   328: ldc 162
    //   330: aload 14
    //   332: invokespecial 131	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   335: athrow
    //   336: astore 18
    //   338: new 126	java/lang/RuntimeException
    //   341: dup
    //   342: ldc 164
    //   344: aload 18
    //   346: invokespecial 131	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   349: athrow
    //   350: astore 23
    //   352: iload 17
    //   354: istore 16
    //   356: goto -41 -> 315
    //   359: astore 26
    //   361: iload 25
    //   363: istore 12
    //   365: goto -77 -> 288
    //
    // Exception table:
    //   from	to	target	type
    //   204	257	279	java/lang/ClassNotFoundException
    //   262	278	279	java/lang/ClassNotFoundException
    //   50	103	282	java/lang/ClassNotFoundException
    //   50	103	295	java/lang/Exception
    //   109	125	295	java/lang/Exception
    //   129	182	309	java/lang/ClassNotFoundException
    //   129	182	322	java/lang/Exception
    //   188	204	322	java/lang/Exception
    //   204	257	336	java/lang/Exception
    //   262	278	336	java/lang/Exception
    //   188	204	350	java/lang/ClassNotFoundException
    //   109	125	359	java/lang/ClassNotFoundException
  }

  protected void a(Context paramContext, k paramk, Looper paramLooper, int paramInt, ArrayList<ad> paramArrayList)
  {
    paramArrayList.add(new com.google.android.exoplayer2.e.l(paramk, paramLooper));
  }

  protected void a(Context paramContext, d paramd, Looper paramLooper, int paramInt, ArrayList<ad> paramArrayList)
  {
    paramArrayList.add(new e(paramd, paramLooper));
  }

  public ad[] a(Handler paramHandler, com.google.android.exoplayer2.video.h paramh, g paramg, k paramk, d paramd, com.google.android.exoplayer2.drm.l<p> paraml)
  {
    if (paraml == null);
    for (Object localObject = this.b; ; localObject = paraml)
    {
      ArrayList localArrayList = new ArrayList();
      a(this.a, (com.google.android.exoplayer2.drm.l)localObject, this.d, paramHandler, paramh, this.c, localArrayList);
      a(this.a, (com.google.android.exoplayer2.drm.l)localObject, a(), paramHandler, paramg, this.c, localArrayList);
      a(this.a, paramk, paramHandler.getLooper(), this.c, localArrayList);
      a(this.a, paramd, paramHandler.getLooper(), this.c, localArrayList);
      a(this.a, this.c, localArrayList);
      a(this.a, paramHandler, this.c, localArrayList);
      return (ad[])localArrayList.toArray(new ad[localArrayList.size()]);
    }
  }

  protected f[] a()
  {
    return new f[0];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.h
 * JD-Core Version:    0.6.2
 */