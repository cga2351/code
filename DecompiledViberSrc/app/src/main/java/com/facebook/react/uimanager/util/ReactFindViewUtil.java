package com.facebook.react.uimanager.util;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.R.id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

public class ReactFindViewUtil
{
  private static final Map<OnMultipleViewsFoundListener, Set<String>> mOnMultipleViewsFoundListener = new HashMap();
  private static final List<OnViewFoundListener> mOnViewFoundListeners = new ArrayList();

  public static void addViewListener(OnViewFoundListener paramOnViewFoundListener)
  {
    mOnViewFoundListeners.add(paramOnViewFoundListener);
  }

  public static void addViewsListener(OnMultipleViewsFoundListener paramOnMultipleViewsFoundListener, Set<String> paramSet)
  {
    mOnMultipleViewsFoundListener.put(paramOnMultipleViewsFoundListener, paramSet);
  }

  @Nullable
  public static View findView(View paramView, String paramString)
  {
    String str = getNativeId(paramView);
    if ((str != null) && (str.equals(paramString)))
      return paramView;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      for (int i = 0; i < localViewGroup.getChildCount(); i++)
      {
        View localView = findView(localViewGroup.getChildAt(i), paramString);
        if (localView != null)
          return localView;
      }
    }
    return null;
  }

  public static void findView(View paramView, OnViewFoundListener paramOnViewFoundListener)
  {
    View localView = findView(paramView, paramOnViewFoundListener.getNativeId());
    if (localView != null)
      paramOnViewFoundListener.onViewFound(localView);
    addViewListener(paramOnViewFoundListener);
  }

  @Nullable
  private static String getNativeId(View paramView)
  {
    Object localObject = paramView.getTag(R.id.view_tag_native_id);
    if ((localObject instanceof String))
      return (String)localObject;
    return null;
  }

  public static void notifyViewRendered(View paramView)
  {
    String str = getNativeId(paramView);
    if (str == null);
    while (true)
    {
      return;
      Iterator localIterator1 = mOnViewFoundListeners.iterator();
      while (localIterator1.hasNext())
      {
        OnViewFoundListener localOnViewFoundListener = (OnViewFoundListener)localIterator1.next();
        if ((str != null) && (str.equals(localOnViewFoundListener.getNativeId())))
        {
          localOnViewFoundListener.onViewFound(paramView);
          localIterator1.remove();
        }
      }
      Iterator localIterator2 = mOnMultipleViewsFoundListener.entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator2.next();
        Set localSet = (Set)localEntry.getValue();
        if ((localSet != null) && (localSet.contains(str)))
          ((OnMultipleViewsFoundListener)localEntry.getKey()).onViewFound(paramView, str);
      }
    }
  }

  public static void removeViewListener(OnViewFoundListener paramOnViewFoundListener)
  {
    mOnViewFoundListeners.remove(paramOnViewFoundListener);
  }

  public static void removeViewsListener(OnMultipleViewsFoundListener paramOnMultipleViewsFoundListener)
  {
    mOnMultipleViewsFoundListener.remove(paramOnMultipleViewsFoundListener);
  }

  public static abstract interface OnMultipleViewsFoundListener
  {
    public abstract void onViewFound(View paramView, String paramString);
  }

  public static abstract interface OnViewFoundListener
  {
    public abstract String getNativeId();

    public abstract void onViewFound(View paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.util.ReactFindViewUtil
 * JD-Core Version:    0.6.2
 */