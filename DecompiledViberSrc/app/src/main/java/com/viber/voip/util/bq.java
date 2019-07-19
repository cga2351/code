package com.viber.voip.util;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ao;
import com.viber.voip.av;
import com.viber.voip.av.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class bq extends Handler
{
  private static final Logger c;
  private static volatile Semaphore d;
  private static volatile Semaphore e;
  private static bq h;
  final WeakReference<ContentResolver> a;
  private ao f;
  private Handler g;
  private volatile AtomicInteger i = new AtomicInteger();

  static
  {
    if (!bq.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      b = bool;
      c = ViberEnv.getLogger();
      d = new Semaphore(64);
      e = new d(128);
      h = null;
      return;
    }
  }

  public bq(ContentResolver paramContentResolver)
  {
    this(paramContentResolver, av.a(av.e.h));
  }

  public bq(ContentResolver paramContentResolver, Handler paramHandler)
  {
    this(paramContentResolver, paramHandler, av.a(av.e.h));
  }

  public bq(ContentResolver paramContentResolver, Handler paramHandler1, Handler paramHandler2)
  {
    super(paramHandler1.getLooper());
    this.a = new WeakReference(paramContentResolver);
    try
    {
      this.f = a(paramHandler2.getLooper());
      this.g = av.a(av.e.a);
      return;
    }
    finally
    {
    }
  }

  private ao a(Looper paramLooper)
  {
    return new k(paramLooper);
  }

  private void a(int paramInt1, Object paramObject, Uri paramUri, ContentValues[] paramArrayOfContentValues, int paramInt2, Exception paramException)
  {
  }

  private void a(int paramInt, Object paramObject1, Object paramObject2, Throwable paramThrowable)
  {
  }

  private void a(bq parambq, Message paramMessage)
  {
    j localj = (j)paramMessage.obj;
    int j = paramMessage.what;
    switch (paramMessage.arg1)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    while (true)
    {
      e.release();
      return;
      if (localj.n != null)
        localj.n.onQueryComplete(j, localj.h, (Cursor)localj.g);
      while (true)
      {
        if (localj.g != null)
        {
          d.release();
          this.i.decrementAndGet();
        }
        if (!localj.l)
          break;
        af.a((Cursor)localj.g);
        break;
        parambq.a(j, localj.h, (Cursor)localj.g);
      }
      if (localj.o != null)
      {
        localj.o.onInsertComplete(j, localj.h, (Uri)localj.g, localj.j);
      }
      else
      {
        parambq.a(j, localj.h, (Uri)localj.g);
        continue;
        if (localj.p != null)
        {
          localj.p.onUpdateComplete(j, localj.h, localj.a, localj.j, ((Integer)localj.g).intValue());
        }
        else
        {
          parambq.a(j, localj.h, ((Integer)localj.g).intValue());
          continue;
          if (localj.q != null)
          {
            localj.q.onDeleteComplete(j, localj.h, ((Integer)localj.g).intValue());
          }
          else
          {
            parambq.b(j, localj.h, ((Integer)localj.g).intValue());
            continue;
            if (localj.r != null)
            {
              localj.r.a(j, localj.h, localj.t, (ContentProviderResult[])localj.g, localj.j);
            }
            else
            {
              parambq.a(j, localj.h, localj.t, (ContentProviderResult[])localj.g, localj.j);
              continue;
              if (localj.s != null)
              {
                localj.s.a(j, localj.h, localj.a, localj.u, ((Integer)localj.g).intValue(), localj.j);
              }
              else
              {
                parambq.a(j, localj.h, localj.a, localj.u, ((Integer)localj.g).intValue(), localj.j);
                continue;
                if (localj.w != null)
                  localj.w.a(j, localj.h, localj.g, localj.j);
                else
                  parambq.a(j, localj.h, localj.g, localj.j);
              }
            }
          }
        }
      }
    }
  }

  public static bq b(Context paramContext)
  {
    try
    {
      if (h == null)
        h = new bq(paramContext.getContentResolver());
      bq localbq = h;
      return localbq;
    }
    finally
    {
    }
  }

  public ao a()
  {
    return this.f;
  }

  protected void a(int paramInt1, Object paramObject, int paramInt2)
  {
  }

  protected void a(int paramInt, Object paramObject, Cursor paramCursor)
  {
    af.a(paramCursor);
    this.i.decrementAndGet();
  }

  protected void a(int paramInt, Object paramObject, Uri paramUri)
  {
  }

  public final void a(int paramInt, Object paramObject, Uri paramUri, ContentValues paramContentValues, f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    Message localMessage = this.f.obtainMessage(paramInt);
    localMessage.arg1 = 2;
    j localj = new j();
    localj.b = this;
    localj.a = paramUri;
    localj.h = paramObject;
    localj.i = paramContentValues;
    localj.o = paramf;
    localj.k = paramBoolean1;
    localj.m = paramBoolean2;
    localMessage.obj = localj;
    if ((localj.k) || (paramBoolean2))
    {
      this.f.sendMessageAtFrontOfQueue(localMessage);
      return;
    }
    this.f.sendMessage(localMessage);
  }

  public final void a(int paramInt, Object paramObject, Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString, i parami)
  {
    a(paramInt, paramObject, paramUri, paramContentValues, paramString, paramArrayOfString, parami, true);
  }

  public final void a(int paramInt, Object paramObject, Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString, i parami, boolean paramBoolean)
  {
    a(paramInt, paramObject, paramUri, paramContentValues, paramString, paramArrayOfString, parami, paramBoolean, false);
  }

  public final void a(int paramInt, Object paramObject, Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString, i parami, boolean paramBoolean1, boolean paramBoolean2)
  {
    Message localMessage = this.f.obtainMessage(paramInt);
    localMessage.arg1 = 3;
    j localj = new j();
    localj.b = this;
    localj.a = paramUri;
    localj.h = paramObject;
    localj.i = paramContentValues;
    localj.d = paramString;
    localj.e = paramArrayOfString;
    localj.p = parami;
    localj.k = paramBoolean1;
    localj.m = paramBoolean2;
    localMessage.obj = localj;
    if ((localj.k) || (paramBoolean2))
    {
      this.f.sendMessageAtFrontOfQueue(localMessage);
      return;
    }
    this.f.sendMessage(localMessage);
  }

  public final void a(int paramInt, Object paramObject, Uri paramUri, String paramString, String[] paramArrayOfString, c paramc)
  {
    a(paramInt, paramObject, paramUri, paramString, paramArrayOfString, paramc, true);
  }

  public final void a(int paramInt, Object paramObject, Uri paramUri, String paramString, String[] paramArrayOfString, c paramc, boolean paramBoolean)
  {
    a(paramInt, paramObject, paramUri, paramString, paramArrayOfString, paramc, paramBoolean, false);
  }

  public final void a(int paramInt, Object paramObject, Uri paramUri, String paramString, String[] paramArrayOfString, c paramc, boolean paramBoolean1, boolean paramBoolean2)
  {
    Message localMessage = this.f.obtainMessage(paramInt);
    localMessage.arg1 = 4;
    j localj = new j();
    localj.b = this;
    localj.a = paramUri;
    localj.h = paramObject;
    localj.d = paramString;
    localj.e = paramArrayOfString;
    localj.q = paramc;
    localj.k = paramBoolean1;
    localj.m = paramBoolean2;
    localMessage.obj = localj;
    if ((localj.k) || (paramBoolean2))
    {
      this.f.sendMessageAtFrontOfQueue(localMessage);
      return;
    }
    this.f.sendMessage(localMessage);
  }

  public void a(int paramInt, Object paramObject, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, g paramg)
  {
    a(paramInt, paramObject, paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramg, true);
  }

  public void a(int paramInt, Object paramObject, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, g paramg, boolean paramBoolean)
  {
    a(paramInt, paramObject, paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramg, paramBoolean, true);
  }

  public void a(int paramInt, Object paramObject, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, g paramg, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramObject, paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramg, paramBoolean1, paramBoolean2, false);
  }

  public void a(int paramInt, Object paramObject, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, g paramg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Message localMessage = this.f.obtainMessage(paramInt);
    localMessage.arg1 = 1;
    j localj = new j();
    localj.b = this;
    localj.a = paramUri;
    localj.c = paramArrayOfString1;
    localj.d = paramString1;
    localj.e = paramArrayOfString2;
    localj.f = paramString2;
    localj.h = paramObject;
    localj.n = paramg;
    localj.k = paramBoolean1;
    localj.l = paramBoolean2;
    localj.m = paramBoolean3;
    localMessage.obj = localj;
    if ((localj.k) || (paramBoolean3))
    {
      this.f.sendMessageAtFrontOfQueue(localMessage);
      return;
    }
    this.f.sendMessage(localMessage);
  }

  protected void a(int paramInt, Object paramObject, List<ContentProviderOperation> paramList, ContentProviderResult[] paramArrayOfContentProviderResult, Exception paramException)
  {
  }

  public void a(int paramInt, String paramString, Object paramObject, List<ContentProviderOperation> paramList)
  {
    a(paramInt, paramString, paramObject, paramList, null);
  }

  public void a(int paramInt, String paramString, Object paramObject, List<ContentProviderOperation> paramList, a parama)
  {
    a(paramInt, paramString, paramObject, paramList, parama, false, false);
  }

  public void a(int paramInt, String paramString, Object paramObject, List<ContentProviderOperation> paramList, a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    Message localMessage = this.f.obtainMessage(paramInt);
    localMessage.arg1 = 5;
    j localj = new j();
    localj.b = this;
    localj.h = paramObject;
    localj.d = paramString;
    if (paramList != null);
    for (ArrayList localArrayList = new ArrayList(paramList); ; localArrayList = null)
    {
      localj.t = localArrayList;
      localj.r = parama;
      localj.k = paramBoolean1;
      localj.m = paramBoolean2;
      localMessage.obj = localj;
      if ((!localj.k) && (!paramBoolean2))
        break;
      this.f.sendMessageAtFrontOfQueue(localMessage);
      return;
    }
    this.f.sendMessage(localMessage);
  }

  protected void b(int paramInt1, Object paramObject, int paramInt2)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    e.acquireUninterruptibly();
    if (((j)paramMessage.obj).k)
    {
      h localh = new h(this, paramMessage);
      this.g.post(localh);
      return;
    }
    a(this, paramMessage);
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt, Object paramObject, List<ContentProviderOperation> paramList, ContentProviderResult[] paramArrayOfContentProviderResult, Exception paramException);
  }

  public static abstract interface b
  {
    public abstract void a(int paramInt1, Object paramObject, Uri paramUri, ContentValues[] paramArrayOfContentValues, int paramInt2, Exception paramException);
  }

  public static abstract interface c
  {
    public abstract void onDeleteComplete(int paramInt1, Object paramObject, int paramInt2);
  }

  private static class d extends Semaphore
  {
    public d(int paramInt)
    {
      super();
    }

    public void acquireUninterruptibly()
    {
    }

    public void release()
    {
    }
  }

  public static abstract interface e<T>
  {
    public abstract T a(int paramInt, Object paramObject, bq parambq, ContentResolver paramContentResolver, Object[] paramArrayOfObject);

    public abstract void a(int paramInt, Object paramObject1, Object paramObject2, Throwable paramThrowable);
  }

  public static abstract interface f
  {
    public abstract void onInsertComplete(int paramInt, Object paramObject, Uri paramUri, Exception paramException);
  }

  public static abstract interface g
  {
    public abstract void onQueryComplete(int paramInt, Object paramObject, Cursor paramCursor);
  }

  private static class h
    implements Runnable
  {
    final Message a;
    final bq b;

    public h(bq parambq, Message paramMessage)
    {
      this.b = parambq;
      this.a = Message.obtain(paramMessage);
    }

    public void run()
    {
      bq.a(this.b, this.b, this.a);
    }
  }

  public static abstract interface i
  {
    public abstract void onUpdateComplete(int paramInt1, Object paramObject, Uri paramUri, Exception paramException, int paramInt2);
  }

  protected static final class j
  {
    public Uri a;
    public Handler b;
    public String[] c;
    public String d;
    public String[] e;
    public String f;
    public Object g;
    public Object h;
    public ContentValues i;
    public Exception j;
    public boolean k = true;
    public boolean l = true;
    public boolean m = false;
    bq.g n;
    bq.f o;
    bq.i p;
    bq.c q;
    bq.a r;
    bq.b s;
    ArrayList<ContentProviderOperation> t;
    ContentValues[] u;
    Object v;
    bq.e<? extends Object> w;
  }

  protected class k extends ao
  {
    public k(Looper arg2)
    {
      super(localLooper);
    }

    // ERROR //
    public void handleMessage(Message paramMessage)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 10	com/viber/voip/util/bq$k:c	Lcom/viber/voip/util/bq;
      //   4: getfield 29	com/viber/voip/util/bq:a	Ljava/lang/ref/WeakReference;
      //   7: invokevirtual 35	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   10: checkcast 37	android/content/ContentResolver
      //   13: astore_2
      //   14: aload_2
      //   15: ifnonnull +4 -> 19
      //   18: return
      //   19: aload_1
      //   20: getfield 43	android/os/Message:obj	Ljava/lang/Object;
      //   23: checkcast 45	com/viber/voip/util/bq$j
      //   26: astore_3
      //   27: aload_1
      //   28: getfield 49	android/os/Message:what	I
      //   31: istore 4
      //   33: aload_1
      //   34: getfield 52	android/os/Message:arg1	I
      //   37: tableswitch	default:+43 -> 80, 1:+95->132, 2:+186->223, 3:+242->279, 4:+272->309, 5:+298->335, 6:+328->365, 7:+361->398
      //   81: getfield 56	com/viber/voip/util/bq$j:b	Landroid/os/Handler;
      //   84: iload 4
      //   86: invokevirtual 62	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
      //   89: astore 6
      //   91: aload 6
      //   93: aload_3
      //   94: putfield 43	android/os/Message:obj	Ljava/lang/Object;
      //   97: aload 6
      //   99: aload_1
      //   100: getfield 52	android/os/Message:arg1	I
      //   103: putfield 52	android/os/Message:arg1	I
      //   106: aload_3
      //   107: getfield 66	com/viber/voip/util/bq$j:k	Z
      //   110: ifne +10 -> 120
      //   113: aload_3
      //   114: getfield 69	com/viber/voip/util/bq$j:m	Z
      //   117: ifeq +347 -> 464
      //   120: aload 6
      //   122: invokevirtual 73	android/os/Message:getTarget	()Landroid/os/Handler;
      //   125: aload 6
      //   127: invokevirtual 77	android/os/Handler:sendMessageAtFrontOfQueue	(Landroid/os/Message;)Z
      //   130: pop
      //   131: return
      //   132: invokestatic 80	com/viber/voip/util/bq:b	()Ljava/util/concurrent/Semaphore;
      //   135: invokevirtual 86	java/util/concurrent/Semaphore:acquireUninterruptibly	()V
      //   138: aload_2
      //   139: aload_3
      //   140: getfield 89	com/viber/voip/util/bq$j:a	Landroid/net/Uri;
      //   143: aload_3
      //   144: getfield 92	com/viber/voip/util/bq$j:c	[Ljava/lang/String;
      //   147: aload_3
      //   148: getfield 96	com/viber/voip/util/bq$j:d	Ljava/lang/String;
      //   151: aload_3
      //   152: getfield 99	com/viber/voip/util/bq$j:e	[Ljava/lang/String;
      //   155: aload_3
      //   156: getfield 102	com/viber/voip/util/bq$j:f	Ljava/lang/String;
      //   159: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   162: astore 17
      //   164: aload 17
      //   166: astore 16
      //   168: aload 16
      //   170: ifnull +11 -> 181
      //   173: aload 16
      //   175: invokeinterface 112 1 0
      //   180: pop
      //   181: aload_0
      //   182: getfield 10	com/viber/voip/util/bq$k:c	Lcom/viber/voip/util/bq;
      //   185: invokestatic 115	com/viber/voip/util/bq:a	(Lcom/viber/voip/util/bq;)Ljava/util/concurrent/atomic/AtomicInteger;
      //   188: invokevirtual 120	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
      //   191: pop
      //   192: aload_3
      //   193: aload 16
      //   195: putfield 123	com/viber/voip/util/bq$j:g	Ljava/lang/Object;
      //   198: goto -118 -> 80
      //   201: astore 15
      //   203: aconst_null
      //   204: astore 16
      //   206: aload 16
      //   208: invokestatic 128	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
      //   211: invokestatic 80	com/viber/voip/util/bq:b	()Ljava/util/concurrent/Semaphore;
      //   214: invokevirtual 131	java/util/concurrent/Semaphore:release	()V
      //   217: aconst_null
      //   218: astore 16
      //   220: goto -28 -> 192
      //   223: aload_3
      //   224: getfield 135	com/viber/voip/util/bq$j:o	Lcom/viber/voip/util/bq$f;
      //   227: ifnonnull +22 -> 249
      //   230: aload_3
      //   231: aload_2
      //   232: aload_3
      //   233: getfield 89	com/viber/voip/util/bq$j:a	Landroid/net/Uri;
      //   236: aload_3
      //   237: getfield 139	com/viber/voip/util/bq$j:i	Landroid/content/ContentValues;
      //   240: invokevirtual 143	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
      //   243: putfield 123	com/viber/voip/util/bq$j:g	Ljava/lang/Object;
      //   246: goto -166 -> 80
      //   249: aload_3
      //   250: aload_2
      //   251: aload_3
      //   252: getfield 89	com/viber/voip/util/bq$j:a	Landroid/net/Uri;
      //   255: aload_3
      //   256: getfield 139	com/viber/voip/util/bq$j:i	Landroid/content/ContentValues;
      //   259: invokevirtual 143	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
      //   262: putfield 123	com/viber/voip/util/bq$j:g	Ljava/lang/Object;
      //   265: goto -185 -> 80
      //   268: astore 14
      //   270: aload_3
      //   271: aload 14
      //   273: putfield 147	com/viber/voip/util/bq$j:j	Ljava/lang/Exception;
      //   276: goto -196 -> 80
      //   279: aload_3
      //   280: aload_2
      //   281: aload_3
      //   282: getfield 89	com/viber/voip/util/bq$j:a	Landroid/net/Uri;
      //   285: aload_3
      //   286: getfield 139	com/viber/voip/util/bq$j:i	Landroid/content/ContentValues;
      //   289: aload_3
      //   290: getfield 96	com/viber/voip/util/bq$j:d	Ljava/lang/String;
      //   293: aload_3
      //   294: getfield 99	com/viber/voip/util/bq$j:e	[Ljava/lang/String;
      //   297: invokevirtual 151	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      //   300: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   303: putfield 123	com/viber/voip/util/bq$j:g	Ljava/lang/Object;
      //   306: goto -226 -> 80
      //   309: aload_3
      //   310: aload_2
      //   311: aload_3
      //   312: getfield 89	com/viber/voip/util/bq$j:a	Landroid/net/Uri;
      //   315: aload_3
      //   316: getfield 96	com/viber/voip/util/bq$j:d	Ljava/lang/String;
      //   319: aload_3
      //   320: getfield 99	com/viber/voip/util/bq$j:e	[Ljava/lang/String;
      //   323: invokevirtual 161	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
      //   326: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   329: putfield 123	com/viber/voip/util/bq$j:g	Ljava/lang/Object;
      //   332: goto -252 -> 80
      //   335: aload_3
      //   336: aload_2
      //   337: aload_3
      //   338: getfield 96	com/viber/voip/util/bq$j:d	Ljava/lang/String;
      //   341: aload_3
      //   342: getfield 165	com/viber/voip/util/bq$j:t	Ljava/util/ArrayList;
      //   345: invokevirtual 169	android/content/ContentResolver:applyBatch	(Ljava/lang/String;Ljava/util/ArrayList;)[Landroid/content/ContentProviderResult;
      //   348: putfield 123	com/viber/voip/util/bq$j:g	Ljava/lang/Object;
      //   351: goto -271 -> 80
      //   354: astore 13
      //   356: aload_3
      //   357: aload 13
      //   359: putfield 147	com/viber/voip/util/bq$j:j	Ljava/lang/Exception;
      //   362: goto -282 -> 80
      //   365: aload_3
      //   366: aload_2
      //   367: aload_3
      //   368: getfield 89	com/viber/voip/util/bq$j:a	Landroid/net/Uri;
      //   371: aload_3
      //   372: getfield 173	com/viber/voip/util/bq$j:u	[Landroid/content/ContentValues;
      //   375: invokevirtual 177	android/content/ContentResolver:bulkInsert	(Landroid/net/Uri;[Landroid/content/ContentValues;)I
      //   378: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   381: putfield 123	com/viber/voip/util/bq$j:g	Ljava/lang/Object;
      //   384: goto -304 -> 80
      //   387: astore 12
      //   389: aload_3
      //   390: aload 12
      //   392: putfield 147	com/viber/voip/util/bq$j:j	Ljava/lang/Exception;
      //   395: goto -315 -> 80
      //   398: aload_3
      //   399: getfield 181	com/viber/voip/util/bq$j:w	Lcom/viber/voip/util/bq$e;
      //   402: astore 8
      //   404: aload_3
      //   405: getfield 183	com/viber/voip/util/bq$j:h	Ljava/lang/Object;
      //   408: astore 9
      //   410: aload_0
      //   411: getfield 10	com/viber/voip/util/bq$k:c	Lcom/viber/voip/util/bq;
      //   414: astore 10
      //   416: iconst_1
      //   417: anewarray 185	java/lang/Object
      //   420: astore 11
      //   422: aload 11
      //   424: iconst_0
      //   425: aload_3
      //   426: getfield 188	com/viber/voip/util/bq$j:v	Ljava/lang/Object;
      //   429: aastore
      //   430: aload_3
      //   431: aload 8
      //   433: iload 4
      //   435: aload 9
      //   437: aload 10
      //   439: aload_2
      //   440: aload 11
      //   442: invokeinterface 193 6 0
      //   447: putfield 123	com/viber/voip/util/bq$j:g	Ljava/lang/Object;
      //   450: goto -370 -> 80
      //   453: astore 5
      //   455: aload_3
      //   456: aload 5
      //   458: putfield 147	com/viber/voip/util/bq$j:j	Ljava/lang/Exception;
      //   461: goto -381 -> 80
      //   464: aload 6
      //   466: invokevirtual 196	android/os/Message:sendToTarget	()V
      //   469: return
      //   470: astore 18
      //   472: goto -266 -> 206
      //
      // Exception table:
      //   from	to	target	type
      //   132	164	201	java/lang/Exception
      //   249	265	268	java/lang/Exception
      //   335	351	354	java/lang/Exception
      //   365	384	387	java/lang/Exception
      //   398	450	453	java/lang/Exception
      //   173	181	470	java/lang/Exception
      //   181	192	470	java/lang/Exception
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bq
 * JD-Core Version:    0.6.2
 */