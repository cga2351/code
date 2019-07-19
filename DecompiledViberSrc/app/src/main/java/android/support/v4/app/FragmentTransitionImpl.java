package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class FragmentTransitionImpl
{
  protected static void bfsAddViewChildren(List<View> paramList, View paramView)
  {
    int i = paramList.size();
    if (containedBeforeIndex(paramList, paramView, i));
    while (true)
    {
      return;
      paramList.add(paramView);
      for (int j = i; j < paramList.size(); j++)
      {
        View localView1 = (View)paramList.get(j);
        if ((localView1 instanceof ViewGroup))
        {
          ViewGroup localViewGroup = (ViewGroup)localView1;
          int k = localViewGroup.getChildCount();
          for (int m = 0; m < k; m++)
          {
            View localView2 = localViewGroup.getChildAt(m);
            if (!containedBeforeIndex(paramList, localView2, i))
              paramList.add(localView2);
          }
        }
      }
    }
  }

  private static boolean containedBeforeIndex(List<View> paramList, View paramView, int paramInt)
  {
    for (int i = 0; ; i++)
    {
      boolean bool = false;
      if (i < paramInt)
      {
        if (paramList.get(i) == paramView)
          bool = true;
      }
      else
        return bool;
    }
  }

  static String findKeyForValue(Map<String, String> paramMap, String paramString)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramString.equals(localEntry.getValue()))
        return (String)localEntry.getKey();
    }
    return null;
  }

  protected static boolean isNullOrEmpty(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }

  public abstract void addTarget(Object paramObject, View paramView);

  public abstract void addTargets(Object paramObject, ArrayList<View> paramArrayList);

  public abstract void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject);

  public abstract boolean canHandle(Object paramObject);

  void captureTransitioningViews(ArrayList<View> paramArrayList, View paramView)
  {
    ViewGroup localViewGroup;
    if (paramView.getVisibility() == 0)
    {
      if (!(paramView instanceof ViewGroup))
        break label71;
      localViewGroup = (ViewGroup)paramView;
      if (!ViewGroupCompat.isTransitionGroup(localViewGroup))
        break label36;
      paramArrayList.add(localViewGroup);
    }
    while (true)
    {
      return;
      label36: int i = localViewGroup.getChildCount();
      for (int j = 0; j < i; j++)
        captureTransitioningViews(paramArrayList, localViewGroup.getChildAt(j));
    }
    label71: paramArrayList.add(paramView);
  }

  public abstract Object cloneTransition(Object paramObject);

  void findNamedViews(Map<String, View> paramMap, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      String str = ViewCompat.getTransitionName(paramView);
      if (str != null)
        paramMap.put(str, paramView);
      if ((paramView instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        int i = localViewGroup.getChildCount();
        for (int j = 0; j < i; j++)
          findNamedViews(paramMap, localViewGroup.getChildAt(j));
      }
    }
  }

  protected void getBoundsOnScreen(View paramView, Rect paramRect)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }

  public abstract Object mergeTransitionsInSequence(Object paramObject1, Object paramObject2, Object paramObject3);

  public abstract Object mergeTransitionsTogether(Object paramObject1, Object paramObject2, Object paramObject3);

  ArrayList<String> prepareSetNameOverridesReordered(ArrayList<View> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayList.size();
    for (int j = 0; j < i; j++)
    {
      View localView = (View)paramArrayList.get(j);
      localArrayList.add(ViewCompat.getTransitionName(localView));
      ViewCompat.setTransitionName(localView, null);
    }
    return localArrayList;
  }

  public abstract void removeTarget(Object paramObject, View paramView);

  public abstract void replaceTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);

  public abstract void scheduleHideFragmentView(Object paramObject, View paramView, ArrayList<View> paramArrayList);

  void scheduleNameReset(ViewGroup paramViewGroup, final ArrayList<View> paramArrayList, final Map<String, String> paramMap)
  {
    OneShotPreDrawListener.add(paramViewGroup, new Runnable()
    {
      public void run()
      {
        int i = paramArrayList.size();
        for (int j = 0; j < i; j++)
        {
          View localView = (View)paramArrayList.get(j);
          String str = ViewCompat.getTransitionName(localView);
          ViewCompat.setTransitionName(localView, (String)paramMap.get(str));
        }
      }
    });
  }

  public abstract void scheduleRemoveTargets(Object paramObject1, Object paramObject2, ArrayList<View> paramArrayList1, Object paramObject3, ArrayList<View> paramArrayList2, Object paramObject4, ArrayList<View> paramArrayList3);

  public abstract void setEpicenter(Object paramObject, Rect paramRect);

  public abstract void setEpicenter(Object paramObject, View paramView);

  void setNameOverridesOrdered(View paramView, final ArrayList<View> paramArrayList, final Map<String, String> paramMap)
  {
    OneShotPreDrawListener.add(paramView, new Runnable()
    {
      public void run()
      {
        int i = paramArrayList.size();
        for (int j = 0; j < i; j++)
        {
          View localView = (View)paramArrayList.get(j);
          String str = ViewCompat.getTransitionName(localView);
          if (str != null)
            ViewCompat.setTransitionName(localView, FragmentTransitionImpl.findKeyForValue(paramMap, str));
        }
      }
    });
  }

  void setNameOverridesReordered(View paramView, final ArrayList<View> paramArrayList1, final ArrayList<View> paramArrayList2, final ArrayList<String> paramArrayList, Map<String, String> paramMap)
  {
    final int i = paramArrayList2.size();
    final ArrayList localArrayList = new ArrayList();
    int j = 0;
    if (j < i)
    {
      View localView = (View)paramArrayList1.get(j);
      String str1 = ViewCompat.getTransitionName(localView);
      localArrayList.add(str1);
      if (str1 == null);
      label128: 
      while (true)
      {
        j++;
        break;
        ViewCompat.setTransitionName(localView, null);
        String str2 = (String)paramMap.get(str1);
        for (int k = 0; ; k++)
        {
          if (k >= i)
            break label128;
          if (str2.equals(paramArrayList.get(k)))
          {
            ViewCompat.setTransitionName((View)paramArrayList2.get(k), str1);
            break;
          }
        }
      }
    }
    OneShotPreDrawListener.add(paramView, new Runnable()
    {
      public void run()
      {
        for (int i = 0; i < i; i++)
        {
          ViewCompat.setTransitionName((View)paramArrayList2.get(i), (String)paramArrayList.get(i));
          ViewCompat.setTransitionName((View)paramArrayList1.get(i), (String)localArrayList.get(i));
        }
      }
    });
  }

  public abstract void setSharedElementTargets(Object paramObject, View paramView, ArrayList<View> paramArrayList);

  public abstract void swapSharedElementTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);

  public abstract Object wrapTransitionInSet(Object paramObject);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentTransitionImpl
 * JD-Core Version:    0.6.2
 */