package com.mixpanel.android.c;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.mixpanel.android.b.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

@TargetApi(16)
abstract class o
  implements h.a
{
  private final List<h.c> a;
  private final h b;

  protected o(List<h.c> paramList)
  {
    this.a = paramList;
    this.b = new h();
  }

  public abstract void a();

  protected List<h.c> b()
  {
    return this.a;
  }

  public void b(View paramView)
  {
    this.b.a(paramView, this.a, this);
  }

  protected h c()
  {
    return this.b;
  }

  public static class a extends o.d
  {
    private final int a;
    private final WeakHashMap<View, a> b;

    public a(List<h.c> paramList, int paramInt, String paramString, o.h paramh)
    {
      super(paramString, paramh, false);
      this.a = paramInt;
      this.b = new WeakHashMap();
    }

    private View.AccessibilityDelegate d(View paramView)
    {
      try
      {
        View.AccessibilityDelegate localAccessibilityDelegate = (View.AccessibilityDelegate)paramView.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(paramView, new Object[0]);
        return localAccessibilityDelegate;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        return null;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        return null;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        f.d("MixpanelAPI.ViewVisitor", "getAccessibilityDelegate threw an exception when called.", localInvocationTargetException);
      }
      return null;
    }

    public void a()
    {
      Iterator localIterator = this.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        View localView = (View)localEntry.getKey();
        a locala = (a)localEntry.getValue();
        View.AccessibilityDelegate localAccessibilityDelegate = d(localView);
        if (localAccessibilityDelegate == locala)
          localView.setAccessibilityDelegate(locala.a());
        else if ((localAccessibilityDelegate instanceof a))
          ((a)localAccessibilityDelegate).a(locala);
      }
      this.b.clear();
    }

    public void a(View paramView)
    {
      View.AccessibilityDelegate localAccessibilityDelegate = d(paramView);
      if (((localAccessibilityDelegate instanceof a)) && (((a)localAccessibilityDelegate).a(d())))
        return;
      a locala = new a(localAccessibilityDelegate);
      paramView.setAccessibilityDelegate(locala);
      this.b.put(paramView, locala);
    }

    private class a extends View.AccessibilityDelegate
    {
      private View.AccessibilityDelegate b;

      public a(View.AccessibilityDelegate arg2)
      {
        Object localObject;
        this.b = localObject;
      }

      public View.AccessibilityDelegate a()
      {
        return this.b;
      }

      public void a(a parama)
      {
        if (this.b == parama)
          this.b = parama.a();
        while (!(this.b instanceof a))
          return;
        ((a)this.b).a(parama);
      }

      public boolean a(String paramString)
      {
        if (o.a.this.d() == paramString)
          return true;
        if ((this.b instanceof a))
          return ((a)this.b).a(paramString);
        return false;
      }

      public void sendAccessibilityEvent(View paramView, int paramInt)
      {
        if (paramInt == o.a.a(o.a.this))
          o.a.this.c(paramView);
        if (this.b != null)
          this.b.sendAccessibilityEvent(paramView, paramInt);
      }
    }
  }

  public static class b extends o.d
  {
    private final Map<TextView, TextWatcher> a = new HashMap();

    public b(List<h.c> paramList, String paramString, o.h paramh)
    {
      super(paramString, paramh, true);
    }

    public void a()
    {
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        ((TextView)localEntry.getKey()).removeTextChangedListener((TextWatcher)localEntry.getValue());
      }
      this.a.clear();
    }

    public void a(View paramView)
    {
      if ((paramView instanceof TextView))
      {
        TextView localTextView = (TextView)paramView;
        a locala = new a(localTextView);
        TextWatcher localTextWatcher = (TextWatcher)this.a.get(localTextView);
        if (localTextWatcher != null)
          localTextView.removeTextChangedListener(localTextWatcher);
        localTextView.addTextChangedListener(locala);
        this.a.put(localTextView, locala);
      }
    }

    private class a
      implements TextWatcher
    {
      private final View b;

      public a(View arg2)
      {
        Object localObject;
        this.b = localObject;
      }

      public void afterTextChanged(Editable paramEditable)
      {
        o.b.this.c(this.b);
      }

      public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
      {
      }

      public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
      {
      }
    }
  }

  private static class c
  {
    private boolean a(TreeMap<View, List<View>> paramTreeMap, View paramView, List<View> paramList)
    {
      if (paramList.contains(paramView))
        return false;
      if (paramTreeMap.containsKey(paramView))
      {
        List localList = (List)paramTreeMap.remove(paramView);
        paramList.add(paramView);
        int i = localList.size();
        for (int j = 0; j < i; j++)
          if (!a(paramTreeMap, (View)localList.get(j), paramList))
            return false;
        paramList.remove(paramView);
      }
      return true;
    }

    public boolean a(TreeMap<View, List<View>> paramTreeMap)
    {
      ArrayList localArrayList = new ArrayList();
      while (!paramTreeMap.isEmpty())
        if (!a(paramTreeMap, (View)paramTreeMap.firstKey(), localArrayList))
          return false;
      return true;
    }
  }

  private static abstract class d extends o
  {
    private final o.h a;
    private final String b;
    private final boolean c;

    public d(List<h.c> paramList, String paramString, o.h paramh, boolean paramBoolean)
    {
      super();
      this.a = paramh;
      this.b = paramString;
      this.c = paramBoolean;
    }

    protected void c(View paramView)
    {
      this.a.a(paramView, this.b, this.c);
    }

    protected String d()
    {
      return this.b;
    }
  }

  public static class e
  {
    private final String a;
    private final String b;

    public e(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }

    public String a()
    {
      return this.a;
    }

    public String b()
    {
      return this.b;
    }
  }

  public static class f
  {
    public final int a;
    public final int b;
    public final int c;

    public f(int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
    }
  }

  public static class g extends o
  {
    private static final Set<Integer> d;
    private static final Set<Integer> e = new HashSet(Arrays.asList(arrayOfInteger2));
    private final WeakHashMap<View, int[]> a = new WeakHashMap();
    private final List<o.f> b;
    private final String c;
    private boolean f;
    private final o.i g;
    private final o.c h;

    static
    {
      Integer[] arrayOfInteger1 = new Integer[4];
      arrayOfInteger1[0] = Integer.valueOf(0);
      arrayOfInteger1[1] = Integer.valueOf(1);
      arrayOfInteger1[2] = Integer.valueOf(5);
      arrayOfInteger1[3] = Integer.valueOf(7);
      d = new HashSet(Arrays.asList(arrayOfInteger1));
      Integer[] arrayOfInteger2 = new Integer[5];
      arrayOfInteger2[0] = Integer.valueOf(2);
      arrayOfInteger2[1] = Integer.valueOf(3);
      arrayOfInteger2[2] = Integer.valueOf(4);
      arrayOfInteger2[3] = Integer.valueOf(6);
      arrayOfInteger2[4] = Integer.valueOf(8);
    }

    public g(List<h.c> paramList, List<o.f> paramList1, String paramString, o.i parami)
    {
      super();
      this.b = paramList1;
      this.c = paramString;
      this.f = true;
      this.g = parami;
      this.h = new o.c(null);
    }

    private boolean a(Set<Integer> paramSet, SparseArray<View> paramSparseArray)
    {
      TreeMap localTreeMap = new TreeMap(new Comparator()
      {
        public int a(View paramAnonymousView1, View paramAnonymousView2)
        {
          if (paramAnonymousView1 == paramAnonymousView2)
            return 0;
          if (paramAnonymousView1 == null)
            return -1;
          if (paramAnonymousView2 == null)
            return 1;
          return paramAnonymousView2.hashCode() - paramAnonymousView1.hashCode();
        }
      });
      int i = paramSparseArray.size();
      for (int j = 0; j < i; j++)
      {
        View localView = (View)paramSparseArray.valueAt(j);
        int[] arrayOfInt = ((RelativeLayout.LayoutParams)localView.getLayoutParams()).getRules();
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramSet.iterator();
        while (localIterator.hasNext())
        {
          int k = arrayOfInt[((Integer)localIterator.next()).intValue()];
          if ((k > 0) && (k != localView.getId()))
            localArrayList.add(paramSparseArray.get(k));
        }
        localTreeMap.put(localView, localArrayList);
      }
      return this.h.a(localTreeMap);
    }

    public void a()
    {
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        View localView = (View)localEntry.getKey();
        int[] arrayOfInt = (int[])localEntry.getValue();
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        for (int i = 0; i < arrayOfInt.length; i++)
          localLayoutParams.addRule(i, arrayOfInt[i]);
        localView.setLayoutParams(localLayoutParams);
      }
      this.f = false;
    }

    public void a(View paramView)
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      SparseArray localSparseArray = new SparseArray();
      int i = localViewGroup.getChildCount();
      for (int j = 0; j < i; j++)
      {
        View localView2 = localViewGroup.getChildAt(j);
        int n = localView2.getId();
        if (n > 0)
          localSparseArray.put(n, localView2);
      }
      int k = this.b.size();
      int m = 0;
      o.f localf;
      View localView1;
      if (m < k)
      {
        localf = (o.f)this.b.get(m);
        localView1 = (View)localSparseArray.get(localf.a);
        if (localView1 != null);
      }
      while (true)
      {
        m++;
        break;
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
        int[] arrayOfInt = (int[])localLayoutParams.getRules().clone();
        if (arrayOfInt[localf.b] != localf.c)
        {
          Set localSet;
          if (this.a.containsKey(localView1))
          {
            localLayoutParams.addRule(localf.b, localf.c);
            if (!d.contains(Integer.valueOf(localf.b)))
              break label272;
            localSet = d;
          }
          while (true)
          {
            if ((localSet == null) || (a(localSet, localSparseArray)))
              break label305;
            a();
            this.g.a(new o.e("circular_dependency", this.c));
            return;
            this.a.put(localView1, arrayOfInt);
            break;
            label272: if (e.contains(Integer.valueOf(localf.b)))
              localSet = e;
            else
              localSet = null;
          }
          label305: localView1.setLayoutParams(localLayoutParams);
        }
      }
    }

    public void b(View paramView)
    {
      if (this.f)
        c().a(paramView, b(), this);
    }
  }

  public static abstract interface h
  {
    public abstract void a(View paramView, String paramString, boolean paramBoolean);
  }

  public static abstract interface i
  {
    public abstract void a(o.e parame);
  }

  public static class j extends o
  {
    private final a a;
    private final a b;
    private final WeakHashMap<View, Object> c;
    private final Object[] d;

    public j(List<h.c> paramList, a parama1, a parama2)
    {
      super();
      this.a = parama1;
      this.b = parama2;
      this.d = new Object[1];
      this.c = new WeakHashMap();
    }

    public void a()
    {
      Iterator localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        View localView = (View)localEntry.getKey();
        Object localObject = localEntry.getValue();
        if (localObject != null)
        {
          this.d[0] = localObject;
          this.a.a(localView, this.d);
        }
      }
    }

    public void a(View paramView)
    {
      Object localObject1;
      Object localObject2;
      if (this.b != null)
      {
        Object[] arrayOfObject = this.a.a();
        if (1 == arrayOfObject.length)
        {
          localObject1 = arrayOfObject[0];
          localObject2 = this.b.a(paramView);
          if (localObject1 == localObject2);
          do
          {
            return;
            if (localObject1 == null)
              break;
            if ((!(localObject1 instanceof Bitmap)) || (!(localObject2 instanceof Bitmap)))
              break label118;
          }
          while (((Bitmap)localObject1).sameAs((Bitmap)localObject2));
          if ((!(localObject2 instanceof Bitmap)) && (!(localObject2 instanceof BitmapDrawable)) && (!this.c.containsKey(paramView)))
            break label181;
        }
      }
      while (true)
      {
        this.a.a(paramView);
        return;
        label118: if (((localObject1 instanceof BitmapDrawable)) && ((localObject2 instanceof BitmapDrawable)))
        {
          Bitmap localBitmap1 = ((BitmapDrawable)localObject1).getBitmap();
          Bitmap localBitmap2 = ((BitmapDrawable)localObject2).getBitmap();
          if ((localBitmap1 == null) || (!localBitmap1.sameAs(localBitmap2)))
            break;
          return;
        }
        if (!localObject1.equals(localObject2))
          break;
        return;
        label181: this.d[0] = localObject2;
        if (this.a.a(this.d))
          this.c.put(paramView, localObject2);
        else
          this.c.put(paramView, null);
      }
    }
  }

  public static class k extends o.d
  {
    private boolean a = false;

    public k(List<h.c> paramList, String paramString, o.h paramh)
    {
      super(paramString, paramh, false);
    }

    public void a()
    {
    }

    public void a(View paramView)
    {
      if ((paramView != null) && (!this.a))
        c(paramView);
      if (paramView != null);
      for (boolean bool = true; ; bool = false)
      {
        this.a = bool;
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.c.o
 * JD-Core Version:    0.6.2
 */