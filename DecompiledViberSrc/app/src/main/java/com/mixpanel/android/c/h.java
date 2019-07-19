package com.mixpanel.android.c;

import android.view.View;
import android.view.ViewGroup;
import com.mixpanel.android.b.f;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class h
{
  private final b a = new b();

  private View a(c paramc, View paramView, int paramInt)
  {
    int i = this.a.a(paramInt);
    if (a(paramc, paramView))
    {
      this.a.b(paramInt);
      if ((paramc.c == -1) || (paramc.c == i))
        return paramView;
    }
    if ((paramc.a == 1) && ((paramView instanceof ViewGroup)))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = localViewGroup.getChildCount();
      for (int k = 0; k < j; k++)
      {
        View localView = a(paramc, localViewGroup.getChildAt(k), paramInt);
        if (localView != null)
          return localView;
      }
    }
    return null;
  }

  private boolean a(c paramc, View paramView)
  {
    if ((paramc.b != null) && (!a(paramView, paramc.b)));
    String str;
    do
    {
      do
        return false;
      while (((-1 != paramc.d) && (paramView.getId() != paramc.d)) || ((paramc.e != null) && (!paramc.e.equals(paramView.getContentDescription()))));
      str = paramc.f;
    }
    while ((paramc.f != null) && ((paramView.getTag() == null) || (!str.equals(paramView.getTag().toString()))));
    return true;
  }

  private static boolean a(Object paramObject, String paramString)
  {
    for (Class localClass = paramObject.getClass(); ; localClass = localClass.getSuperclass())
    {
      String str = localClass.getCanonicalName();
      if ((str != null) && (str.equals(paramString)))
        return true;
      if (localClass == Object.class)
        return false;
    }
  }

  private void b(View paramView, List<c> paramList, a parama)
  {
    int i = 0;
    if (paramList.isEmpty())
      parama.a(paramView);
    while (!(paramView instanceof ViewGroup))
      return;
    if (this.a.a())
    {
      f.a("MixpanelAPI.PathFinder", "Path is too deep, will not match");
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)paramView;
    c localc = (c)paramList.get(0);
    List localList = paramList.subList(1, paramList.size());
    int j = localViewGroup.getChildCount();
    int k = this.a.b();
    while (true)
    {
      if (i < j)
      {
        View localView = a(localc, localViewGroup.getChildAt(i), k);
        if (localView != null)
          b(localView, localList, parama);
        if ((localc.c < 0) || (this.a.a(k) <= localc.c));
      }
      else
      {
        this.a.c();
        return;
      }
      i++;
    }
  }

  public void a(View paramView, List<c> paramList, a parama)
  {
    if (paramList.isEmpty());
    List localList;
    View localView;
    do
    {
      return;
      if (this.a.a())
      {
        f.d("MixpanelAPI.PathFinder", "There appears to be a concurrency issue in the pathfinding code. Path will not be matched.");
        return;
      }
      c localc = (c)paramList.get(0);
      localList = paramList.subList(1, paramList.size());
      localView = a(localc, paramView, this.a.b());
      this.a.c();
    }
    while (localView == null);
    b(localView, localList, parama);
  }

  public static abstract interface a
  {
    public abstract void a(View paramView);
  }

  private static class b
  {
    private final int[] a = new int[256];
    private int b = 0;

    public int a(int paramInt)
    {
      return this.a[paramInt];
    }

    public boolean a()
    {
      return this.a.length == this.b;
    }

    public int b()
    {
      int i = this.b;
      this.b = (1 + this.b);
      this.a[i] = 0;
      return i;
    }

    public void b(int paramInt)
    {
      int[] arrayOfInt = this.a;
      arrayOfInt[paramInt] = (1 + arrayOfInt[paramInt]);
    }

    public void c()
    {
      this.b = (-1 + this.b);
      if (this.b < 0)
        throw new ArrayIndexOutOfBoundsException(this.b);
    }
  }

  public static class c
  {
    public final int a;
    public final String b;
    public final int c;
    public final int d;
    public final String e;
    public final String f;

    public c(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
    {
      this.a = paramInt1;
      this.b = paramString1;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramString2;
      this.f = paramString3;
    }

    public String toString()
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (this.a == 1)
          localJSONObject.put("prefix", "shortest");
        if (this.b != null)
          localJSONObject.put("view_class", this.b);
        if (this.c > -1)
          localJSONObject.put("index", this.c);
        if (this.d > -1)
          localJSONObject.put("id", this.d);
        if (this.e != null)
          localJSONObject.put("contentDescription", this.e);
        if (this.f != null)
          localJSONObject.put("tag", this.f);
        String str = localJSONObject.toString();
        return str;
      }
      catch (JSONException localJSONException)
      {
        throw new RuntimeException("Can't serialize PathElement to String", localJSONException);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.c.h
 * JD-Core Version:    0.6.2
 */