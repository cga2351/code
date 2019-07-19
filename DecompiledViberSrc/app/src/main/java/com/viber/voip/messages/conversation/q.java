package com.viber.voip.messages.conversation;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.util.SparseArray;
import com.viber.provider.d.a;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.g;
import com.viber.voip.messages.k;
import com.viber.voip.messages.m;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.i;
import com.viber.voip.stickers.n;
import com.viber.voip.util.upload.ObjectId;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

public abstract class q<T extends aa> extends z<T>
{
  private boolean A;
  private boolean B;
  private int[] C;
  private List<T> D = new ArrayList();
  private SparseArray<T> E = new SparseArray();
  private boolean F;
  private boolean G;
  private bv.g H = new r(this);
  private n I = new n()
  {
    public void onStickerDeployed(Sticker paramAnonymousSticker)
    {
      q.this.l();
    }

    public void onStickerPackageDeployed(com.viber.voip.stickers.entity.a paramAnonymousa)
    {
      q.this.l();
    }
  };
  protected long l = 0L;
  protected long m = 0L;
  protected long n = 0L;
  protected long o;
  protected T p;
  protected boolean q = true;
  protected int r;
  protected long s;
  private boolean v;
  private boolean w;
  private boolean x;
  private T y;
  private int z;

  protected q(Context paramContext, int paramInt, Uri paramUri, String[] paramArrayOfString, LoaderManager paramLoaderManager, dagger.a<k> parama, d.a parama1, EventBus paramEventBus)
  {
    super(paramContext, paramInt, paramUri, paramArrayOfString, paramLoaderManager, parama, parama1, paramEventBus);
    d(50);
    d("messages.order_key DESC, messages.msg_date DESC");
    a("messages.conversation_id=? AND +deleted=0 AND status<>12 AND extra_flags & 4194304 = 0 AND messages.order_key>=?");
  }

  private void J()
  {
    if (this.p != null)
      ((k)this.u.get()).c().b(this.p);
  }

  private void K()
  {
    this.l = 0L;
    r();
  }

  private T L()
  {
    try
    {
      if (this.y == null)
        this.y = f(0);
      aa localaa = this.y;
      return localaa;
    }
    finally
    {
    }
  }

  private void M()
  {
    this.D.clear();
    this.E.clear();
  }

  private void N()
  {
    this.x = false;
    this.z = -1;
  }

  private int b(T paramT)
  {
    if (paramT != null)
      return m.a(paramT);
    return -1;
  }

  private void s()
  {
    if ((this.p != null) && (!this.G))
      ((k)this.u.get()).c().a(this.p);
  }

  public void A()
  {
    int i = 50 + super.getCount();
    if (this.s > 0L)
    {
      a(this.t, this.s, i);
      this.r = i;
    }
    while (true)
    {
      K();
      l();
      return;
      d(i);
    }
  }

  public boolean B()
  {
    return this.q;
  }

  public int C()
  {
    return this.z;
  }

  public long D()
  {
    return this.m;
  }

  public boolean E()
  {
    return this.A;
  }

  public void F()
  {
    try
    {
      this.s = 0L;
      K();
      this.p = null;
      this.x = false;
      this.G = false;
      this.z = -1;
      this.y = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void G()
  {
    N();
  }

  public long H()
  {
    return this.l;
  }

  public long a(int paramInt)
  {
    return super.a(-1 + super.getCount() - paramInt);
  }

  public void a(long paramLong)
  {
    if (this.t != paramLong)
    {
      M();
      this.F = false;
    }
    super.a(paramLong);
  }

  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    this.s = paramLong2;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Long.valueOf(paramLong2);
    arrayOfObject1[1] = Long.valueOf(paramLong1);
    String str = String.format("SELECT COUNT(*) FROM messages WHERE order_key>=%s AND conversation_id=%s AND +deleted=0 AND status<>12 AND extra_flags & 4194304 = 0", arrayOfObject1);
    Object[] arrayOfObject2 = new Object[4];
    arrayOfObject2[0] = Long.valueOf(paramLong2);
    arrayOfObject2[1] = str;
    arrayOfObject2[2] = Integer.valueOf(paramInt);
    arrayOfObject2[3] = Integer.valueOf(paramInt);
    e(String.format("CASE WHEN %s>0 THEN MAX((%s), %s) ELSE %s END", arrayOfObject2));
  }

  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if ((!e()) && (!paramBoolean))
      this.v = true;
  }

  protected void a(long paramLong, boolean paramBoolean)
  {
    if ((!paramBoolean) && (!this.B))
      this.v = true;
  }

  protected void a(T paramT)
  {
    this.p = paramT;
    this.x = false;
    this.z = -1;
    this.D.add(paramT);
    this.E.append(paramT.x(), paramT);
  }

  public void a(boolean paramBoolean)
  {
    if ((!this.B) && (paramBoolean) && (this.o != 0L))
      s();
    this.B = paramBoolean;
  }

  public int[] a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[paramInt2];
    int i = 0;
    int j = -1 + super.getCount() - paramInt1;
    while ((i < paramInt2) && (j >= 0) && (j < this.C.length) && (j < super.getCount()))
    {
      int k = this.C[j];
      if (k != 0)
        if (k != -1)
          arrayOfInt[i] = k;
      while (true)
      {
        i++;
        if (!paramBoolean)
          break label155;
        j++;
        break;
        if (b_(j))
          if (4 == this.f.getInt(13))
          {
            int i1 = this.f.getInt(20);
            this.C[j] = i1;
            arrayOfInt[i] = i1;
          }
          else
          {
            this.C[j] = -1;
          }
      }
      label155: j--;
    }
    return arrayOfInt;
  }

  protected void b(long paramLong)
  {
    this.v = true;
    this.w = true;
  }

  public void b(boolean paramBoolean)
  {
    this.F = paramBoolean;
    s();
  }

  protected boolean b_(int paramInt)
  {
    return super.b_(paramInt);
  }

  public void c(boolean paramBoolean)
  {
    this.G = paramBoolean;
    if (!paramBoolean)
      s();
  }

  public void d(int paramInt)
  {
    try
    {
      super.d(paramInt);
      this.r = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public long d_(int paramInt)
  {
    return super.d_(-1 + super.getCount() - paramInt);
  }

  public T f(int paramInt)
  {
    int i = super.getCount();
    if (paramInt < i)
    {
      int k = i - 1 - paramInt;
      aa localaa = super.f(k);
      int[] arrayOfInt;
      if ((this.C != null) && (localaa != null))
      {
        arrayOfInt = this.C;
        if (!localaa.ax())
          break label86;
      }
      label86: for (int i1 = localaa.r().toStickerId(); ; i1 = -1)
      {
        arrayOfInt[k] = i1;
        if ((paramInt == 0) && (localaa != null))
          this.y = localaa;
        return localaa;
      }
    }
    int j = paramInt - i;
    if (j < this.D.size())
      return (aa)this.D.get(j);
    return null;
  }

  public int getCount()
  {
    if (this.F)
      return super.getCount() + this.D.size();
    return 0;
  }

  public void i()
  {
    try
    {
      K();
      this.q = true;
      this.o = 0L;
      super.i();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected void m()
  {
    while (true)
    {
      int i;
      boolean bool1;
      int j;
      label53: int k;
      int i1;
      label94: long l2;
      int i3;
      try
      {
        i = super.getCount();
        super.m();
        this.C = new int[i];
        if (this.r > i)
          break label542;
        bool1 = true;
        this.q = bool1;
        this.y = null;
        int i2;
        if (this.D.size() > 0)
        {
          j = 0;
          if ((j < i) && (b_(j)) && (this.E.size() != 0));
        }
        else
        {
          this.x = false;
          this.A = false;
          k = 0;
          i1 = 0;
          if ((k >= i) || (!b_(k)))
            break label349;
          i2 = this.f.getInt(4);
          long l1 = this.f.getLong(17);
          l2 = this.f.getLong(16);
          if (this.f.getInt(19) != 4)
            break label553;
          i3 = 1;
          break label516;
          label168: i1 = 1;
          this.p = a(this.f);
          this.n = l1;
          if (this.f.getInt(3) <= 0)
            break label349;
          this.x = true;
          this.z = (-1 + (i - k));
          if ((this.m != 0L) && (this.m <= l1))
            break label536;
          this.m = l1;
          break label536;
        }
        int i4 = this.f.getInt(18);
        aa localaa = (aa)this.E.get(i4);
        if (localaa == null)
          break label547;
        this.E.remove(i4);
        this.D.remove(localaa);
        break label547;
        label301: if ((l2 != 0L) || (i3 != 0))
          continue;
        if (this.A)
          break label559;
        if (i2 != -1)
        {
          break label559;
          this.A = bool2;
        }
      }
      finally
      {
      }
      boolean bool2 = false;
      continue;
      label349: if ((this.p != null) && (this.p.ap()))
        this.m = 0L;
      if ((this.x) && (e()) && (this.z == -1))
        this.z = 0;
      if (i > 0)
      {
        b_(i - 1);
        e(null);
        this.l = this.f.getLong(17);
        r();
      }
      if (u())
      {
        if (!e())
          break label455;
        s();
      }
      while (true)
      {
        return;
        label455: if (this.v)
        {
          if (this.B)
          {
            if (this.w)
            {
              this.w = false;
              s();
            }
            while (true)
            {
              this.o = 0L;
              this.v = false;
              break;
              J();
            }
          }
          this.o = this.n;
        }
      }
      while (true)
      {
        label516: if (i1 != 0)
          break label557;
        if (l2 != 0L)
          break label168;
        if (i3 == 0)
          break label301;
        break label168;
        label536: k++;
        break label94;
        label542: bool1 = false;
        break;
        label547: j++;
        break label53;
        label553: i3 = 0;
      }
      label557: continue;
      label559: bool2 = true;
    }
  }

  public void p()
  {
    super.p();
    ((k)this.u.get()).b().a(this.H);
    i.a().a(this.I);
  }

  public void q()
  {
    super.q();
    ((k)this.u.get()).b().b(this.H);
    i.a().b(this.I);
  }

  protected void r()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(this.t);
    arrayOfString[1] = String.valueOf(this.l);
    b(arrayOfString);
  }

  public boolean t()
  {
    return (this.x) && (this.D.size() == 0);
  }

  public boolean u()
  {
    return this.F;
  }

  protected void v()
  {
    M();
  }

  public int w()
  {
    try
    {
      if (this.p != null)
      {
        int j = this.p.F();
        i = j;
        return i;
      }
      int i = -1;
    }
    finally
    {
    }
  }

  public int x()
  {
    try
    {
      aa localaa = L();
      int i;
      if (localaa != null)
        i = localaa.F();
      for (int j = i; ; j = -1)
        return j;
    }
    finally
    {
    }
  }

  public int y()
  {
    try
    {
      int i = b(L());
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int z()
  {
    try
    {
      int i = C();
      if (i < 0);
      int j;
      for (int k = 0; ; k = j - i)
      {
        return k;
        j = getCount();
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.q
 * JD-Core Version:    0.6.2
 */