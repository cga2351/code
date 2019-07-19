package android.support.transition;

import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class n
{
  static ArrayList<ViewGroup> a = new ArrayList();
  private static l b = new b();
  private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<l>>>> c = new ThreadLocal();

  static ArrayMap<ViewGroup, ArrayList<l>> a()
  {
    WeakReference localWeakReference1 = (WeakReference)c.get();
    if (localWeakReference1 != null)
    {
      ArrayMap localArrayMap2 = (ArrayMap)localWeakReference1.get();
      if (localArrayMap2 != null)
        return localArrayMap2;
    }
    ArrayMap localArrayMap1 = new ArrayMap();
    WeakReference localWeakReference2 = new WeakReference(localArrayMap1);
    c.set(localWeakReference2);
    return localArrayMap1;
  }

  public static void a(ViewGroup paramViewGroup, l paraml)
  {
    if ((!a.contains(paramViewGroup)) && (ViewCompat.isLaidOut(paramViewGroup)))
    {
      a.add(paramViewGroup);
      if (paraml == null)
        paraml = b;
      l locall = paraml.o();
      c(paramViewGroup, locall);
      k.a(paramViewGroup, null);
      b(paramViewGroup, locall);
    }
  }

  private static void b(ViewGroup paramViewGroup, l paraml)
  {
    if ((paraml != null) && (paramViewGroup != null))
    {
      a locala = new a(paraml, paramViewGroup);
      paramViewGroup.addOnAttachStateChangeListener(locala);
      paramViewGroup.getViewTreeObserver().addOnPreDrawListener(locala);
    }
  }

  private static void c(ViewGroup paramViewGroup, l paraml)
  {
    ArrayList localArrayList = (ArrayList)a().get(paramViewGroup);
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
        ((l)localIterator.next()).d(paramViewGroup);
    }
    if (paraml != null)
      paraml.a(paramViewGroup, true);
    k localk = k.a(paramViewGroup);
    if (localk != null)
      localk.a();
  }

  private static class a
    implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener
  {
    l a;
    ViewGroup b;

    a(l paraml, ViewGroup paramViewGroup)
    {
      this.a = paraml;
      this.b = paramViewGroup;
    }

    private void a()
    {
      this.b.getViewTreeObserver().removeOnPreDrawListener(this);
      this.b.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw()
    {
      a();
      if (!n.a.remove(this.b))
        return true;
      final ArrayMap localArrayMap = n.a();
      ArrayList localArrayList1 = (ArrayList)localArrayMap.get(this.b);
      ArrayList localArrayList3;
      Object localObject;
      if (localArrayList1 == null)
      {
        ArrayList localArrayList2 = new ArrayList();
        localArrayMap.put(this.b, localArrayList2);
        localArrayList3 = localArrayList2;
        localObject = null;
      }
      while (true)
      {
        localArrayList3.add(this.a);
        this.a.a(new m()
        {
          public void a(l paramAnonymousl)
          {
            ((ArrayList)localArrayMap.get(n.a.this.b)).remove(paramAnonymousl);
          }
        });
        this.a.a(this.b, false);
        if (localObject != null)
        {
          Iterator localIterator = localObject.iterator();
          while (true)
            if (localIterator.hasNext())
            {
              ((l)localIterator.next()).e(this.b);
              continue;
              if (localArrayList1.size() <= 0)
                break label184;
              ArrayList localArrayList4 = new ArrayList(localArrayList1);
              localArrayList3 = localArrayList1;
              localObject = localArrayList4;
              break;
            }
        }
        this.a.a(this.b);
        return true;
        label184: localArrayList3 = localArrayList1;
        localObject = null;
      }
    }

    public void onViewAttachedToWindow(View paramView)
    {
    }

    public void onViewDetachedFromWindow(View paramView)
    {
      a();
      n.a.remove(this.b);
      ArrayList localArrayList = (ArrayList)n.a().get(this.b);
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
          ((l)localIterator.next()).e(this.b);
      }
      this.a.a(true);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.n
 * JD-Core Version:    0.6.2
 */