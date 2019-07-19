package a.a;

import android.app.Activity;
import android.os.Handler;
import com.appboy.a.b;
import com.appboy.f.i;
import com.appboy.f.j;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class ap
  implements au
{
  private static final String a = com.appboy.f.c.a(ap.class);
  private AtomicInteger b = new AtomicInteger(0);
  private AtomicInteger c = new AtomicInteger(0);
  private volatile String d = "";
  private final Object e = new Object();
  private final Object f = new Object();
  private final ar g;
  private final aq h;
  private final gq i;
  private final d j;
  private final av k;
  private final b l;
  private final dd m;
  private final al n;
  private final String o;
  private final dc p;
  private final Handler q;
  private boolean r = false;
  private Class<? extends Activity> s = null;

  public ap(ar paramar, gq paramgq, d paramd, av paramav, b paramb, dd paramdd, al paramal, String paramString, boolean paramBoolean, aq paramaq, dc paramdc)
  {
    this.g = paramar;
    this.i = paramgq;
    this.j = paramd;
    this.k = paramav;
    this.l = paramb;
    this.r = paramBoolean;
    this.o = paramString;
    this.m = paramdd;
    this.n = paramal;
    this.h = paramaq;
    this.p = paramdc;
    this.q = do.a();
  }

  private void a(Throwable paramThrowable, boolean paramBoolean)
  {
    try
    {
      if (c(paramThrowable))
      {
        com.appboy.f.c.d(a, "Not logging duplicate error: " + paramThrowable);
        return;
      }
      a(bp.a(paramThrowable, b(), paramBoolean));
      return;
    }
    catch (JSONException localJSONException)
    {
      com.appboy.f.c.d(a, "Failed to create error event from " + paramThrowable, localJSONException);
      return;
    }
    catch (Exception localException)
    {
      com.appboy.f.c.d(a, "Failed to log error.", localException);
    }
  }

  private static boolean a(boolean paramBoolean, be parambe)
  {
    boolean bool = true;
    if (!paramBoolean);
    do
    {
      return false;
      if ((parambe instanceof bq))
      {
        if (!((bq)parambe).n());
        while (true)
        {
          return bool;
          bool = false;
        }
      }
    }
    while ((!(parambe instanceof br)) && (!(parambe instanceof bs)));
    return bool;
  }

  private boolean c(Throwable paramThrowable)
  {
    while (true)
    {
      synchronized (this.f)
      {
        this.b.getAndIncrement();
        if ((this.d.equals(paramThrowable.getMessage())) && (this.c.get() > 3) && (this.b.get() < 100))
          return true;
        if (this.d.equals(paramThrowable.getMessage()))
        {
          this.c.getAndIncrement();
          if (this.b.get() >= 100)
            this.b.set(0);
          this.d = paramThrowable.getMessage();
          return false;
        }
      }
      this.c.set(0);
    }
  }

  public bh a()
  {
    if (this.p.a())
    {
      com.appboy.f.c.d(a, "SDK is disabled. Returning null session.");
      return null;
    }
    bh localbh = this.g.a();
    com.appboy.f.c.c(a, "Completed the openSession call. Starting or continuing session " + localbh.a());
    return localbh;
  }

  public bh a(Activity paramActivity)
  {
    if (this.p.a())
    {
      com.appboy.f.c.d(a, "SDK is disabled. Returning null session.");
      return null;
    }
    bh localbh = a();
    this.s = paramActivity.getClass();
    this.h.a();
    com.appboy.f.c.a(a, "Opened session with activity: " + paramActivity.getLocalClassName());
    return localbh;
  }

  public void a(long paramLong1, long paramLong2)
  {
    this.i.a(new cb(this.l.a(), paramLong1, paramLong2, this.o));
  }

  public void a(bf parambf)
  {
    com.appboy.f.c.b(a, "Posting geofence request for location.");
    a(new cf(this.l.a(), parambf));
  }

  public void a(bn.a parama)
  {
    if (parama == null)
    {
      com.appboy.f.c.b(a, "Cannot request data sync with null respond with object");
      return;
    }
    if ((this.m != null) && (this.m.l()))
      parama.a(new bm(this.m.g()));
    parama.a(e());
    bn localbn = parama.c();
    if ((localbn.c()) && ((localbn.d()) || (localbn.e())))
      this.m.a(false);
    a(new cc(this.l.a(), localbn));
  }

  void a(br parambr)
  {
    JSONObject localJSONObject = parambr.c();
    if (localJSONObject != null)
    {
      String str = localJSONObject.optString("cid", null);
      this.j.a(new s(str, parambr), s.class);
      return;
    }
    com.appboy.f.c.d(a, "Event json was null. Not publishing push clicked trigger event.");
  }

  public void a(ch paramch)
  {
    if (this.p.a())
    {
      com.appboy.f.c.d(a, "SDK is disabled. Not adding request to dispatch.");
      return;
    }
    this.i.a(paramch);
  }

  public void a(ea paramea, ez paramez)
  {
    a(new cn(this.l.a(), paramea, paramez, this, e()));
  }

  public void a(ez paramez)
  {
    this.j.a(new t(paramez), t.class);
  }

  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramString1 == null) || (!j.a(paramString1)))
      throw new IllegalArgumentException("Reply to email address is invalid");
    if (i.c(paramString2))
      throw new IllegalArgumentException("Feedback message cannot be null or blank");
    com.appboy.e.b.c localc = new com.appboy.e.b.c(paramString2, paramString1, paramBoolean, this.k.a(), e());
    a(new ce(this.l.a(), localc));
  }

  public void a(Throwable paramThrowable)
  {
    a(paramThrowable, true);
  }

  public void a(List<String> paramList, long paramLong)
  {
    a(new co(this.l.a(), paramList, paramLong, this.o));
  }

  public void a(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }

  public boolean a(be parambe)
  {
    if (this.p.a())
    {
      com.appboy.f.c.d(a, "SDK is disabled. Not logging event: " + parambe);
      return false;
    }
    Object localObject1 = this.e;
    if (parambe == null)
      try
      {
        com.appboy.f.c.e(a, "Appboy manager received null event.");
        throw new NullPointerException();
      }
      finally
      {
      }
    boolean bool;
    if ((!this.g.d()) && (this.g.c() != null))
    {
      parambe.a(this.g.c());
      bool = false;
      if (i.b(e()))
        break label350;
      parambe.a(e());
      label131: com.appboy.f.c.a(a, "Attempting to log event: " + dr.a((JSONObject)parambe.h()));
      if ((parambe instanceof br))
      {
        com.appboy.f.c.b(a, "Publishing an internal push body clicked event for any awaiting triggers.");
        a((br)parambe);
      }
      if (!parambe.e_())
        this.n.a(parambe);
      if (!a(bool, parambe))
        break label391;
      com.appboy.f.c.b(a, "Adding push click to dispatcher pending list");
      this.i.b(parambe);
    }
    while (true)
    {
      if (parambe.b().equals(gs.z))
        this.i.a(parambe.g());
      if (bool)
      {
        this.q.removeCallbacksAndMessages(null);
        this.q.postDelayed(new Runnable()
        {
          public void run()
          {
            ap.this.d();
          }
        }
        , 1000L);
      }
      return true;
      com.appboy.f.c.b(a, "Not adding session id to event: " + dr.a((JSONObject)parambe.h()));
      bool = true;
      break;
      label350: com.appboy.f.c.b(a, "Not adding user id to event: " + dr.a((JSONObject)parambe.h()));
      break label131;
      label391: this.i.a(parambe);
    }
  }

  public bh b(Activity paramActivity)
  {
    if (this.p.a())
      com.appboy.f.c.d(a, "SDK is disabled. Returning null session.");
    while ((this.s != null) && (!paramActivity.getClass().equals(this.s)))
      return null;
    this.h.b();
    com.appboy.f.c.a(a, "Closed session with activity: " + paramActivity.getLocalClassName());
    return this.g.b();
  }

  public bi b()
  {
    return this.g.c();
  }

  public void b(be parambe)
  {
    com.appboy.f.c.b(a, "Posting geofence report for geofence event.");
    a(new cg(this.l.a(), parambe));
  }

  public void b(Throwable paramThrowable)
  {
    a(paramThrowable, false);
  }

  public void c()
  {
    if (this.p.a())
    {
      com.appboy.f.c.d(a, "SDK is disabled. Not force closing session.");
      return;
    }
    this.s = null;
    this.g.e();
  }

  public void d()
  {
    a(new bn.a());
  }

  public String e()
  {
    return this.o;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ap
 * JD-Core Version:    0.6.2
 */