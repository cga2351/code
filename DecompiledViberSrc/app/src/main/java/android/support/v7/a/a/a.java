package android.support.v7.a.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ColorStateListInflaterCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

public final class a
{
  private static final ThreadLocal<TypedValue> a = new ThreadLocal();
  private static final WeakHashMap<Context, SparseArray<a>> b = new WeakHashMap(0);
  private static final Object c = new Object();

  public static ColorStateList a(Context paramContext, int paramInt)
  {
    ColorStateList localColorStateList1;
    if (Build.VERSION.SDK_INT >= 23)
      localColorStateList1 = paramContext.getColorStateList(paramInt);
    do
    {
      return localColorStateList1;
      localColorStateList1 = d(paramContext, paramInt);
    }
    while (localColorStateList1 != null);
    ColorStateList localColorStateList2 = c(paramContext, paramInt);
    if (localColorStateList2 != null)
    {
      a(paramContext, paramInt, localColorStateList2);
      return localColorStateList2;
    }
    return ContextCompat.getColorStateList(paramContext, paramInt);
  }

  private static TypedValue a()
  {
    TypedValue localTypedValue = (TypedValue)a.get();
    if (localTypedValue == null)
    {
      localTypedValue = new TypedValue();
      a.set(localTypedValue);
    }
    return localTypedValue;
  }

  private static void a(Context paramContext, int paramInt, ColorStateList paramColorStateList)
  {
    synchronized (c)
    {
      SparseArray localSparseArray = (SparseArray)b.get(paramContext);
      if (localSparseArray == null)
      {
        localSparseArray = new SparseArray();
        b.put(paramContext, localSparseArray);
      }
      localSparseArray.append(paramInt, new a(paramColorStateList, paramContext.getResources().getConfiguration()));
      return;
    }
  }

  public static Drawable b(Context paramContext, int paramInt)
  {
    return AppCompatDrawableManager.get().getDrawable(paramContext, paramInt);
  }

  private static ColorStateList c(Context paramContext, int paramInt)
  {
    if (e(paramContext, paramInt))
      return null;
    Resources localResources = paramContext.getResources();
    XmlResourceParser localXmlResourceParser = localResources.getXml(paramInt);
    try
    {
      ColorStateList localColorStateList = ColorStateListInflaterCompat.createFromXml(localResources, localXmlResourceParser, paramContext.getTheme());
      return localColorStateList;
    }
    catch (Exception localException)
    {
      Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", localException);
    }
    return null;
  }

  private static ColorStateList d(Context paramContext, int paramInt)
  {
    synchronized (c)
    {
      SparseArray localSparseArray = (SparseArray)b.get(paramContext);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        a locala = (a)localSparseArray.get(paramInt);
        if (locala != null)
        {
          if (locala.b.equals(paramContext.getResources().getConfiguration()))
          {
            ColorStateList localColorStateList = locala.a;
            return localColorStateList;
          }
          localSparseArray.remove(paramInt);
        }
      }
      return null;
    }
  }

  private static boolean e(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    TypedValue localTypedValue = a();
    localResources.getValue(paramInt, localTypedValue, true);
    return (localTypedValue.type >= 28) && (localTypedValue.type <= 31);
  }

  private static class a
  {
    final ColorStateList a;
    final Configuration b;

    a(ColorStateList paramColorStateList, Configuration paramConfiguration)
    {
      this.a = paramColorStateList;
      this.b = paramConfiguration;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.a.a.a
 * JD-Core Version:    0.6.2
 */