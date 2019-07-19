package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class l
  implements Cloneable
{
  private static ThreadLocal<ArrayMap<Animator, a>> A = new ThreadLocal();
  private static final int[] h = { 2, 1, 3, 4 };
  private static final g i = new g()
  {
    public Path a(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4)
    {
      Path localPath = new Path();
      localPath.moveTo(paramAnonymousFloat1, paramAnonymousFloat2);
      localPath.lineTo(paramAnonymousFloat3, paramAnonymousFloat4);
      return localPath;
    }
  };
  private ViewGroup B = null;
  private int C = 0;
  private boolean D = false;
  private boolean E = false;
  private ArrayList<c> F = null;
  private ArrayList<Animator> G = new ArrayList();
  private b H;
  private ArrayMap<String, String> I;
  private g J = i;
  long a = -1L;
  ArrayList<Integer> b = new ArrayList();
  ArrayList<View> c = new ArrayList();
  p d = null;
  boolean e = false;
  ArrayList<Animator> f = new ArrayList();
  o g;
  private String j = getClass().getName();
  private long k = -1L;
  private TimeInterpolator l = null;
  private ArrayList<String> m = null;
  private ArrayList<Class> n = null;
  private ArrayList<Integer> o = null;
  private ArrayList<View> p = null;
  private ArrayList<Class> q = null;
  private ArrayList<String> r = null;
  private ArrayList<Integer> s = null;
  private ArrayList<View> t = null;
  private ArrayList<Class> u = null;
  private t v = new t();
  private t w = new t();
  private int[] x = h;
  private ArrayList<s> y;
  private ArrayList<s> z;

  private void a(Animator paramAnimator, final ArrayMap<Animator, a> paramArrayMap)
  {
    if (paramAnimator != null)
    {
      paramAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramArrayMap.remove(paramAnonymousAnimator);
          l.this.f.remove(paramAnonymousAnimator);
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          l.this.f.add(paramAnonymousAnimator);
        }
      });
      a(paramAnimator);
    }
  }

  private void a(t paramt1, t paramt2)
  {
    ArrayMap localArrayMap1 = new ArrayMap(paramt1.a);
    ArrayMap localArrayMap2 = new ArrayMap(paramt2.a);
    int i1 = 0;
    if (i1 < this.x.length)
    {
      switch (this.x[i1])
      {
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        i1++;
        break;
        a(localArrayMap1, localArrayMap2);
        continue;
        a(localArrayMap1, localArrayMap2, paramt1.d, paramt2.d);
        continue;
        a(localArrayMap1, localArrayMap2, paramt1.b, paramt2.b);
        continue;
        a(localArrayMap1, localArrayMap2, paramt1.c, paramt2.c);
      }
    }
    b(localArrayMap1, localArrayMap2);
  }

  private static void a(t paramt, View paramView, s params)
  {
    paramt.a.put(paramView, params);
    int i1 = paramView.getId();
    String str;
    if (i1 >= 0)
    {
      if (paramt.b.indexOfKey(i1) >= 0)
        paramt.b.put(i1, null);
    }
    else
    {
      str = ViewCompat.getTransitionName(paramView);
      if (str != null)
      {
        if (!paramt.d.containsKey(str))
          break label183;
        paramt.d.put(str, null);
      }
    }
    long l1;
    while (true)
    {
      if ((paramView.getParent() instanceof ListView))
      {
        ListView localListView = (ListView)paramView.getParent();
        if (localListView.getAdapter().hasStableIds())
        {
          l1 = localListView.getItemIdAtPosition(localListView.getPositionForView(paramView));
          if (paramt.c.indexOfKey(l1) < 0)
            break label197;
          View localView = (View)paramt.c.get(l1);
          if (localView != null)
          {
            ViewCompat.setHasTransientState(localView, false);
            paramt.c.put(l1, null);
          }
        }
      }
      return;
      paramt.b.put(i1, paramView);
      break;
      label183: paramt.d.put(str, paramView);
    }
    label197: ViewCompat.setHasTransientState(paramView, true);
    paramt.c.put(l1, paramView);
  }

  private void a(ArrayMap<View, s> paramArrayMap1, ArrayMap<View, s> paramArrayMap2)
  {
    for (int i1 = -1 + paramArrayMap1.size(); i1 >= 0; i1--)
    {
      View localView = (View)paramArrayMap1.keyAt(i1);
      if ((localView != null) && (a(localView)))
      {
        s locals1 = (s)paramArrayMap2.remove(localView);
        if ((locals1 != null) && (locals1.b != null) && (a(locals1.b)))
        {
          s locals2 = (s)paramArrayMap1.removeAt(i1);
          this.y.add(locals2);
          this.z.add(locals1);
        }
      }
    }
  }

  private void a(ArrayMap<View, s> paramArrayMap1, ArrayMap<View, s> paramArrayMap2, ArrayMap<String, View> paramArrayMap3, ArrayMap<String, View> paramArrayMap4)
  {
    int i1 = paramArrayMap3.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView1 = (View)paramArrayMap3.valueAt(i2);
      if ((localView1 != null) && (a(localView1)))
      {
        View localView2 = (View)paramArrayMap4.get(paramArrayMap3.keyAt(i2));
        if ((localView2 != null) && (a(localView2)))
        {
          s locals1 = (s)paramArrayMap1.get(localView1);
          s locals2 = (s)paramArrayMap2.get(localView2);
          if ((locals1 != null) && (locals2 != null))
          {
            this.y.add(locals1);
            this.z.add(locals2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
    }
  }

  private void a(ArrayMap<View, s> paramArrayMap1, ArrayMap<View, s> paramArrayMap2, LongSparseArray<View> paramLongSparseArray1, LongSparseArray<View> paramLongSparseArray2)
  {
    int i1 = paramLongSparseArray1.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView1 = (View)paramLongSparseArray1.valueAt(i2);
      if ((localView1 != null) && (a(localView1)))
      {
        View localView2 = (View)paramLongSparseArray2.get(paramLongSparseArray1.keyAt(i2));
        if ((localView2 != null) && (a(localView2)))
        {
          s locals1 = (s)paramArrayMap1.get(localView1);
          s locals2 = (s)paramArrayMap2.get(localView2);
          if ((locals1 != null) && (locals2 != null))
          {
            this.y.add(locals1);
            this.z.add(locals2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
    }
  }

  private void a(ArrayMap<View, s> paramArrayMap1, ArrayMap<View, s> paramArrayMap2, SparseArray<View> paramSparseArray1, SparseArray<View> paramSparseArray2)
  {
    int i1 = paramSparseArray1.size();
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView1 = (View)paramSparseArray1.valueAt(i2);
      if ((localView1 != null) && (a(localView1)))
      {
        View localView2 = (View)paramSparseArray2.get(paramSparseArray1.keyAt(i2));
        if ((localView2 != null) && (a(localView2)))
        {
          s locals1 = (s)paramArrayMap1.get(localView1);
          s locals2 = (s)paramArrayMap2.get(localView2);
          if ((locals1 != null) && (locals2 != null))
          {
            this.y.add(locals1);
            this.z.add(locals2);
            paramArrayMap1.remove(localView1);
            paramArrayMap2.remove(localView2);
          }
        }
      }
    }
  }

  private static boolean a(s params1, s params2, String paramString)
  {
    boolean bool = true;
    Object localObject1 = params1.a.get(paramString);
    Object localObject2 = params2.a.get(paramString);
    if ((localObject1 == null) && (localObject2 == null))
      bool = false;
    while ((localObject1 == null) || (localObject2 == null) || (!localObject1.equals(localObject2)))
      return bool;
    return false;
  }

  private void b(ArrayMap<View, s> paramArrayMap1, ArrayMap<View, s> paramArrayMap2)
  {
    int i3;
    for (int i1 = 0; ; i1++)
    {
      int i2 = paramArrayMap1.size();
      i3 = 0;
      if (i1 >= i2)
        break;
      s locals2 = (s)paramArrayMap1.valueAt(i1);
      if (a(locals2.b))
      {
        this.y.add(locals2);
        this.z.add(null);
      }
    }
    while (i3 < paramArrayMap2.size())
    {
      s locals1 = (s)paramArrayMap2.valueAt(i3);
      if (a(locals1.b))
      {
        this.z.add(locals1);
        this.y.add(null);
      }
      i3++;
    }
  }

  private void c(View paramView, boolean paramBoolean)
  {
    if (paramView == null);
    while (true)
    {
      return;
      int i1 = paramView.getId();
      if (((this.o == null) || (!this.o.contains(Integer.valueOf(i1)))) && ((this.p == null) || (!this.p.contains(paramView))))
      {
        if (this.q != null)
        {
          int i5 = this.q.size();
          for (int i6 = 0; ; i6++)
          {
            if (i6 >= i5)
              break label100;
            if (((Class)this.q.get(i6)).isInstance(paramView))
              break;
          }
        }
        label100: s locals;
        if ((paramView.getParent() instanceof ViewGroup))
        {
          locals = new s();
          locals.b = paramView;
          if (!paramBoolean)
            break label262;
          a(locals);
          label135: locals.c.add(this);
          c(locals);
          if (!paramBoolean)
            break label271;
          a(this.v, paramView, locals);
        }
        while (true)
        {
          if ((!(paramView instanceof ViewGroup)) || ((this.s != null) && (this.s.contains(Integer.valueOf(i1)))) || ((this.t != null) && (this.t.contains(paramView))))
            break label282;
          if (this.u == null)
            break label284;
          int i3 = this.u.size();
          for (int i4 = 0; ; i4++)
          {
            if (i4 >= i3)
              break label284;
            if (((Class)this.u.get(i4)).isInstance(paramView))
              break;
          }
          label262: b(locals);
          break label135;
          label271: a(this.w, paramView, locals);
        }
        label282: continue;
        label284: ViewGroup localViewGroup = (ViewGroup)paramView;
        for (int i2 = 0; i2 < localViewGroup.getChildCount(); i2++)
          c(localViewGroup.getChildAt(i2), paramBoolean);
      }
    }
  }

  private static ArrayMap<Animator, a> q()
  {
    ArrayMap localArrayMap = (ArrayMap)A.get();
    if (localArrayMap == null)
    {
      localArrayMap = new ArrayMap();
      A.set(localArrayMap);
    }
    return localArrayMap;
  }

  public Animator a(ViewGroup paramViewGroup, s params1, s params2)
  {
    return null;
  }

  public l a(long paramLong)
  {
    this.a = paramLong;
    return this;
  }

  public l a(TimeInterpolator paramTimeInterpolator)
  {
    this.l = paramTimeInterpolator;
    return this;
  }

  public l a(c paramc)
  {
    if (this.F == null)
      this.F = new ArrayList();
    this.F.add(paramc);
    return this;
  }

  public s a(View paramView, boolean paramBoolean)
  {
    if (this.d != null)
      return this.d.a(paramView, paramBoolean);
    if (paramBoolean);
    for (t localt = this.v; ; localt = this.w)
      return (s)localt.a.get(paramView);
  }

  String a(String paramString)
  {
    String str1 = paramString + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
    if (this.a != -1L)
      str1 = str1 + "dur(" + this.a + ") ";
    if (this.k != -1L)
      str1 = str1 + "dly(" + this.k + ") ";
    if (this.l != null)
      str1 = str1 + "interp(" + this.l + ") ";
    if ((this.b.size() > 0) || (this.c.size() > 0))
    {
      String str2 = str1 + "tgts(";
      if (this.b.size() > 0)
      {
        str3 = str2;
        for (int i3 = 0; i3 < this.b.size(); i3++)
        {
          if (i3 > 0)
            str3 = str3 + ", ";
          str3 = str3 + this.b.get(i3);
        }
      }
      String str3 = str2;
      int i1 = this.c.size();
      int i2 = 0;
      if (i1 > 0)
        while (i2 < this.c.size())
        {
          if (i2 > 0)
            str3 = str3 + ", ";
          str3 = str3 + this.c.get(i2);
          i2++;
        }
      str1 = str3 + ")";
    }
    return str1;
  }

  protected void a(Animator paramAnimator)
  {
    if (paramAnimator == null)
    {
      k();
      return;
    }
    if (b() >= 0L)
      paramAnimator.setDuration(b());
    if (c() >= 0L)
      paramAnimator.setStartDelay(c());
    if (d() != null)
      paramAnimator.setInterpolator(d());
    paramAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        l.this.k();
        paramAnonymousAnimator.removeListener(this);
      }
    });
    paramAnimator.start();
  }

  public void a(g paramg)
  {
    if (paramg == null)
    {
      this.J = i;
      return;
    }
    this.J = paramg;
  }

  public void a(b paramb)
  {
    this.H = paramb;
  }

  public void a(o paramo)
  {
    this.g = paramo;
  }

  public abstract void a(s params);

  void a(ViewGroup paramViewGroup)
  {
    this.y = new ArrayList();
    this.z = new ArrayList();
    a(this.v, this.w);
    ArrayMap localArrayMap = q();
    int i1 = localArrayMap.size();
    al localal = ad.b(paramViewGroup);
    int i2 = i1 - 1;
    if (i2 >= 0)
    {
      Animator localAnimator = (Animator)localArrayMap.keyAt(i2);
      int i3;
      if (localAnimator != null)
      {
        a locala = (a)localArrayMap.get(localAnimator);
        if ((locala != null) && (locala.a != null) && (localal.equals(locala.d)))
        {
          s locals1 = locala.c;
          View localView = locala.a;
          s locals2 = a(localView, true);
          s locals3 = b(localView, true);
          if (((locals2 == null) && (locals3 == null)) || (!locala.e.a(locals1, locals3)))
            break label204;
          i3 = 1;
          label172: if (i3 != 0)
          {
            if ((!localAnimator.isRunning()) && (!localAnimator.isStarted()))
              break label210;
            localAnimator.cancel();
          }
        }
      }
      while (true)
      {
        i2--;
        break;
        label204: i3 = 0;
        break label172;
        label210: localArrayMap.remove(localAnimator);
      }
    }
    a(paramViewGroup, this.v, this.w, this.y, this.z);
    e();
  }

  protected void a(ViewGroup paramViewGroup, t paramt1, t paramt2, ArrayList<s> paramArrayList1, ArrayList<s> paramArrayList2)
  {
    ArrayMap localArrayMap = q();
    long l1 = 9223372036854775807L;
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int i1 = paramArrayList1.size();
    int i2 = 0;
    s locals1;
    s locals2;
    if (i2 < i1)
    {
      locals1 = (s)paramArrayList1.get(i2);
      locals2 = (s)paramArrayList2.get(i2);
      if ((locals1 == null) || (locals1.c.contains(this)))
        break label601;
    }
    label282: label284: label294: label584: label601: for (s locals3 = null; ; locals3 = locals1)
    {
      if ((locals2 != null) && (!locals2.c.contains(this)));
      for (s locals4 = null; ; locals4 = locals2)
      {
        if ((locals3 == null) && (locals4 == null));
        Animator localAnimator2;
        View localView2;
        s locals7;
        while (true)
        {
          i2++;
          break;
          if ((locals3 == null) || (locals4 == null) || (a(locals3, locals4)));
          for (int i5 = 1; ; i5 = 0)
          {
            if (i5 == 0)
              break label282;
            localAnimator2 = a(paramViewGroup, locals3, locals4);
            if (localAnimator2 == null)
              break;
            if (locals4 == null)
              break label484;
            localView2 = locals4.b;
            String[] arrayOfString = a();
            if ((localView2 == null) || (arrayOfString == null) || (arrayOfString.length <= 0))
              break label584;
            locals7 = new s();
            locals7.b = localView2;
            s locals8 = (s)paramt2.a.get(localView2);
            if (locals8 == null)
              break label284;
            for (int i8 = 0; i8 < arrayOfString.length; i8++)
              locals7.a.put(arrayOfString[i8], locals8.a.get(arrayOfString[i8]));
          }
        }
        int i6 = localArrayMap.size();
        int i7 = 0;
        Animator localAnimator4;
        s locals6;
        if (i7 < i6)
        {
          a locala = (a)localArrayMap.get((Animator)localArrayMap.keyAt(i7));
          if ((locala.c != null) && (locala.a == localView2) && (locala.b.equals(p())) && (locala.c.equals(locals7)))
          {
            localAnimator4 = null;
            locals6 = locals7;
          }
        }
        while (true)
        {
          s locals5 = locals6;
          Animator localAnimator3 = localAnimator4;
          View localView1 = localView2;
          while (true)
          {
            if (localAnimator3 == null)
              break label499;
            if (this.g != null)
            {
              long l2 = this.g.a(paramViewGroup, this, locals3, locals4);
              localSparseIntArray.put(this.G.size(), (int)l2);
              l1 = Math.min(l2, l1);
            }
            localArrayMap.put(localAnimator3, new a(localView1, p(), this, ad.b(paramViewGroup), locals5));
            this.G.add(localAnimator3);
            break;
            i7++;
            break label294;
            label484: localView1 = locals3.b;
            localAnimator3 = localAnimator2;
            locals5 = null;
          }
          label499: break;
          if (l1 != 0L)
            for (int i3 = 0; i3 < localSparseIntArray.size(); i3++)
            {
              int i4 = localSparseIntArray.keyAt(i3);
              Animator localAnimator1 = (Animator)this.G.get(i4);
              localAnimator1.setStartDelay(localSparseIntArray.valueAt(i3) - l1 + localAnimator1.getStartDelay());
            }
          return;
          locals6 = locals7;
          localAnimator4 = localAnimator2;
          continue;
          localAnimator4 = localAnimator2;
          locals6 = null;
        }
      }
    }
  }

  void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    a(paramBoolean);
    if (((this.b.size() > 0) || (this.c.size() > 0)) && ((this.m == null) || (this.m.isEmpty())) && ((this.n == null) || (this.n.isEmpty())))
    {
      int i1 = 0;
      if (i1 < this.b.size())
      {
        View localView3 = paramViewGroup.findViewById(((Integer)this.b.get(i1)).intValue());
        s locals2;
        if (localView3 != null)
        {
          locals2 = new s();
          locals2.b = localView3;
          if (!paramBoolean)
            break label160;
          a(locals2);
          label123: locals2.c.add(this);
          c(locals2);
          if (!paramBoolean)
            break label169;
          a(this.v, localView3, locals2);
        }
        while (true)
        {
          i1++;
          break;
          label160: b(locals2);
          break label123;
          label169: a(this.w, localView3, locals2);
        }
      }
      int i2 = 0;
      if (i2 < this.c.size())
      {
        View localView2 = (View)this.c.get(i2);
        s locals1 = new s();
        locals1.b = localView2;
        if (paramBoolean)
        {
          a(locals1);
          label238: locals1.c.add(this);
          c(locals1);
          if (!paramBoolean)
            break label284;
          a(this.v, localView2, locals1);
        }
        while (true)
        {
          i2++;
          break;
          b(locals1);
          break label238;
          label284: a(this.w, localView2, locals1);
        }
      }
    }
    else
    {
      c(paramViewGroup, paramBoolean);
    }
    if ((!paramBoolean) && (this.I != null))
    {
      int i3 = this.I.size();
      ArrayList localArrayList = new ArrayList(i3);
      int i5;
      for (int i4 = 0; ; i4++)
      {
        i5 = 0;
        if (i4 >= i3)
          break;
        String str2 = (String)this.I.keyAt(i4);
        localArrayList.add(this.v.d.remove(str2));
      }
      while (i5 < i3)
      {
        View localView1 = (View)localArrayList.get(i5);
        if (localView1 != null)
        {
          String str1 = (String)this.I.valueAt(i5);
          this.v.d.put(str1, localView1);
        }
        i5++;
      }
    }
  }

  void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.v.a.clear();
      this.v.b.clear();
      this.v.c.clear();
      return;
    }
    this.w.a.clear();
    this.w.b.clear();
    this.w.c.clear();
  }

  public boolean a(s params1, s params2)
  {
    boolean bool1 = false;
    int i2;
    if (params1 != null)
    {
      bool1 = false;
      if (params2 != null)
      {
        String[] arrayOfString = a();
        if (arrayOfString == null)
          break label65;
        int i1 = arrayOfString.length;
        i2 = 0;
        if (i2 >= i1)
          break label117;
        if (!a(params1, params2, arrayOfString[i2]))
          break label59;
      }
    }
    label59: label65: label117: for (boolean bool3 = true; ; bool3 = false)
    {
      bool1 = bool3;
      return bool1;
      i2++;
      break;
      Iterator localIterator = params1.a.keySet().iterator();
      do
      {
        boolean bool2 = localIterator.hasNext();
        bool1 = false;
        if (!bool2)
          break;
      }
      while (!a(params1, params2, (String)localIterator.next()));
      return true;
    }
  }

  boolean a(View paramView)
  {
    int i1 = paramView.getId();
    if ((this.o != null) && (this.o.contains(Integer.valueOf(i1))));
    while (true)
    {
      return false;
      if ((this.p == null) || (!this.p.contains(paramView)))
      {
        if (this.q != null)
        {
          int i3 = this.q.size();
          for (int i4 = 0; ; i4++)
          {
            if (i4 >= i3)
              break label97;
            if (((Class)this.q.get(i4)).isInstance(paramView))
              break;
          }
        }
        label97: if ((this.r == null) || (ViewCompat.getTransitionName(paramView) == null) || (!this.r.contains(ViewCompat.getTransitionName(paramView))))
        {
          if ((this.b.size() == 0) && (this.c.size() == 0) && ((this.n == null) || (this.n.isEmpty())) && ((this.m == null) || (this.m.isEmpty())))
            return true;
          if ((this.b.contains(Integer.valueOf(i1))) || (this.c.contains(paramView)))
            return true;
          if ((this.m != null) && (this.m.contains(ViewCompat.getTransitionName(paramView))))
            return true;
          if (this.n != null)
            for (int i2 = 0; i2 < this.n.size(); i2++)
              if (((Class)this.n.get(i2)).isInstance(paramView))
                return true;
        }
      }
    }
  }

  public String[] a()
  {
    return null;
  }

  public long b()
  {
    return this.a;
  }

  public l b(long paramLong)
  {
    this.k = paramLong;
    return this;
  }

  public l b(c paramc)
  {
    if (this.F == null);
    do
    {
      return this;
      this.F.remove(paramc);
    }
    while (this.F.size() != 0);
    this.F = null;
    return this;
  }

  public l b(View paramView)
  {
    this.c.add(paramView);
    return this;
  }

  s b(View paramView, boolean paramBoolean)
  {
    s locals1;
    if (this.d != null)
      locals1 = this.d.b(paramView, paramBoolean);
    ArrayList localArrayList1;
    int i2;
    label46: s locals3;
    do
    {
      do
      {
        return locals1;
        if (!paramBoolean)
          break;
        localArrayList1 = this.y;
        locals1 = null;
      }
      while (localArrayList1 == null);
      int i1 = localArrayList1.size();
      i2 = 0;
      if (i2 >= i1)
        break label140;
      locals3 = (s)localArrayList1.get(i2);
      locals1 = null;
    }
    while (locals3 == null);
    if (locals3.b == paramView);
    while (true)
    {
      ArrayList localArrayList2;
      if (i2 >= 0)
        if (paramBoolean)
          localArrayList2 = this.z;
      label96: for (s locals2 = (s)localArrayList2.get(i2); ; locals2 = null)
      {
        return locals2;
        localArrayList1 = this.z;
        break;
        i2++;
        break label46;
        localArrayList2 = this.y;
        break label96;
      }
      label140: i2 = -1;
    }
  }

  public abstract void b(s params);

  public long c()
  {
    return this.k;
  }

  public l c(View paramView)
  {
    this.c.remove(paramView);
    return this;
  }

  void c(s params)
  {
    String[] arrayOfString;
    if ((this.g != null) && (!params.a.isEmpty()))
    {
      arrayOfString = this.g.a();
      if (arrayOfString != null)
        break label32;
    }
    label32: label86: 
    while (true)
    {
      return;
      int i1 = 0;
      int i2;
      if (i1 < arrayOfString.length)
      {
        boolean bool = params.a.containsKey(arrayOfString[i1]);
        i2 = 0;
        if (bool);
      }
      while (true)
      {
        if (i2 != 0)
          break label86;
        this.g.a(params);
        return;
        i1++;
        break;
        i2 = 1;
      }
    }
  }

  public TimeInterpolator d()
  {
    return this.l;
  }

  public void d(View paramView)
  {
    if (!this.E)
    {
      ArrayMap localArrayMap = q();
      int i1 = localArrayMap.size();
      al localal = ad.b(paramView);
      for (int i2 = i1 - 1; i2 >= 0; i2--)
      {
        a locala = (a)localArrayMap.valueAt(i2);
        if ((locala.a != null) && (localal.equals(locala.d)))
          a.a((Animator)localArrayMap.keyAt(i2));
      }
      if ((this.F != null) && (this.F.size() > 0))
      {
        ArrayList localArrayList = (ArrayList)this.F.clone();
        int i3 = localArrayList.size();
        for (int i4 = 0; i4 < i3; i4++)
          ((c)localArrayList.get(i4)).b(this);
      }
      this.D = true;
    }
  }

  protected void e()
  {
    j();
    ArrayMap localArrayMap = q();
    Iterator localIterator = this.G.iterator();
    while (localIterator.hasNext())
    {
      Animator localAnimator = (Animator)localIterator.next();
      if (localArrayMap.containsKey(localAnimator))
      {
        j();
        a(localAnimator, localArrayMap);
      }
    }
    this.G.clear();
    k();
  }

  public void e(View paramView)
  {
    if (this.D)
    {
      if (!this.E)
      {
        ArrayMap localArrayMap = q();
        int i1 = localArrayMap.size();
        al localal = ad.b(paramView);
        for (int i2 = i1 - 1; i2 >= 0; i2--)
        {
          a locala = (a)localArrayMap.valueAt(i2);
          if ((locala.a != null) && (localal.equals(locala.d)))
            a.b((Animator)localArrayMap.keyAt(i2));
        }
        if ((this.F != null) && (this.F.size() > 0))
        {
          ArrayList localArrayList = (ArrayList)this.F.clone();
          int i3 = localArrayList.size();
          for (int i4 = 0; i4 < i3; i4++)
            ((c)localArrayList.get(i4)).c(this);
        }
      }
      this.D = false;
    }
  }

  public List<Integer> f()
  {
    return this.b;
  }

  public List<View> g()
  {
    return this.c;
  }

  public List<String> h()
  {
    return this.m;
  }

  public List<Class> i()
  {
    return this.n;
  }

  protected void j()
  {
    if (this.C == 0)
    {
      if ((this.F != null) && (this.F.size() > 0))
      {
        ArrayList localArrayList = (ArrayList)this.F.clone();
        int i1 = localArrayList.size();
        for (int i2 = 0; i2 < i1; i2++)
          ((c)localArrayList.get(i2)).d(this);
      }
      this.E = false;
    }
    this.C = (1 + this.C);
  }

  protected void k()
  {
    this.C = (-1 + this.C);
    if (this.C == 0)
    {
      if ((this.F != null) && (this.F.size() > 0))
      {
        ArrayList localArrayList = (ArrayList)this.F.clone();
        int i3 = localArrayList.size();
        for (int i4 = 0; i4 < i3; i4++)
          ((c)localArrayList.get(i4)).a(this);
      }
      for (int i1 = 0; i1 < this.v.c.size(); i1++)
      {
        View localView2 = (View)this.v.c.valueAt(i1);
        if (localView2 != null)
          ViewCompat.setHasTransientState(localView2, false);
      }
      for (int i2 = 0; i2 < this.w.c.size(); i2++)
      {
        View localView1 = (View)this.w.c.valueAt(i2);
        if (localView1 != null)
          ViewCompat.setHasTransientState(localView1, false);
      }
      this.E = true;
    }
  }

  public g l()
  {
    return this.J;
  }

  public b m()
  {
    return this.H;
  }

  public o n()
  {
    return this.g;
  }

  public l o()
  {
    try
    {
      l locall = (l)super.clone();
      locall.G = new ArrayList();
      locall.v = new t();
      locall.w = new t();
      locall.y = null;
      locall.z = null;
      return locall;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
    }
    return null;
  }

  public String p()
  {
    return this.j;
  }

  public String toString()
  {
    return a("");
  }

  private static class a
  {
    View a;
    String b;
    s c;
    al d;
    l e;

    a(View paramView, String paramString, l paraml, al paramal, s params)
    {
      this.a = paramView;
      this.b = paramString;
      this.c = params;
      this.d = paramal;
      this.e = paraml;
    }
  }

  public static abstract class b
  {
  }

  public static abstract interface c
  {
    public abstract void a(l paraml);

    public abstract void b(l paraml);

    public abstract void c(l paraml);

    public abstract void d(l paraml);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.l
 * JD-Core Version:    0.6.2
 */