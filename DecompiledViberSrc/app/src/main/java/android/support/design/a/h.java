package android.support.design.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class h
{
  private final SimpleArrayMap<String, i> a = new SimpleArrayMap();

  public static h a(Context paramContext, int paramInt)
  {
    try
    {
      Animator localAnimator = AnimatorInflater.loadAnimator(paramContext, paramInt);
      if ((localAnimator instanceof AnimatorSet))
        return a(((AnimatorSet)localAnimator).getChildAnimations());
      if (localAnimator != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localAnimator);
        h localh = a(localArrayList);
        return localh;
      }
      return null;
    }
    catch (Exception localException)
    {
      Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(paramInt), localException);
    }
    return null;
  }

  public static h a(Context paramContext, TypedArray paramTypedArray, int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
        return a(paramContext, i);
    }
    return null;
  }

  private static h a(List<Animator> paramList)
  {
    h localh = new h();
    int i = paramList.size();
    for (int j = 0; j < i; j++)
      a(localh, (Animator)paramList.get(j));
    return localh;
  }

  private static void a(h paramh, Animator paramAnimator)
  {
    if ((paramAnimator instanceof ObjectAnimator))
    {
      ObjectAnimator localObjectAnimator = (ObjectAnimator)paramAnimator;
      paramh.a(localObjectAnimator.getPropertyName(), i.a(localObjectAnimator));
      return;
    }
    throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + paramAnimator);
  }

  public long a()
  {
    long l = 0L;
    int i = this.a.size();
    for (int j = 0; j < i; j++)
    {
      i locali = (i)this.a.valueAt(j);
      l = Math.max(l, locali.a() + locali.b());
    }
    return l;
  }

  public void a(String paramString, i parami)
  {
    this.a.put(paramString, parami);
  }

  public boolean a(String paramString)
  {
    return this.a.get(paramString) != null;
  }

  public i b(String paramString)
  {
    if (!a(paramString))
      throw new IllegalArgumentException();
    return (i)this.a.get(paramString);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    h localh = (h)paramObject;
    return this.a.equals(localh.a);
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" timings: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.a.h
 * JD-Core Version:    0.6.2
 */