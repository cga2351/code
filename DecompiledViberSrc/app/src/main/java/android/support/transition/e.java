package android.support.transition;

import android.graphics.Rect;
import android.support.v4.app.FragmentTransitionImpl;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class e extends FragmentTransitionImpl
{
  private static boolean a(l paraml)
  {
    return (!isNullOrEmpty(paraml.f())) || (!isNullOrEmpty(paraml.h())) || (!isNullOrEmpty(paraml.i()));
  }

  public void addTarget(Object paramObject, View paramView)
  {
    if (paramObject != null)
      ((l)paramObject).b(paramView);
  }

  public void addTargets(Object paramObject, ArrayList<View> paramArrayList)
  {
    int i = 0;
    l locall = (l)paramObject;
    if (locall == null);
    while (true)
    {
      return;
      if ((locall instanceof p))
      {
        p localp = (p)locall;
        int m = localp.q();
        while (i < m)
        {
          addTargets(localp.b(i), paramArrayList);
          i++;
        }
      }
      else if ((!a(locall)) && (isNullOrEmpty(locall.g())))
      {
        int j = paramArrayList.size();
        for (int k = 0; k < j; k++)
          locall.b((View)paramArrayList.get(k));
      }
    }
  }

  public void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject)
  {
    n.a(paramViewGroup, (l)paramObject);
  }

  public boolean canHandle(Object paramObject)
  {
    return paramObject instanceof l;
  }

  public Object cloneTransition(Object paramObject)
  {
    l locall = null;
    if (paramObject != null)
      locall = ((l)paramObject).o();
    return locall;
  }

  public Object mergeTransitionsInSequence(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    l locall1 = (l)paramObject1;
    l locall2 = (l)paramObject2;
    l locall3 = (l)paramObject3;
    Object localObject;
    if ((locall1 != null) && (locall2 != null))
      localObject = new p().a(locall1).a(locall2).a(1);
    while (locall3 != null)
    {
      p localp = new p();
      if (localObject != null)
        localp.a((l)localObject);
      localp.a(locall3);
      return localp;
      if (locall1 != null)
      {
        localObject = locall1;
      }
      else
      {
        localObject = null;
        if (locall2 != null)
          localObject = locall2;
      }
    }
    return localObject;
  }

  public Object mergeTransitionsTogether(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    p localp = new p();
    if (paramObject1 != null)
      localp.a((l)paramObject1);
    if (paramObject2 != null)
      localp.a((l)paramObject2);
    if (paramObject3 != null)
      localp.a((l)paramObject3);
    return localp;
  }

  public void removeTarget(Object paramObject, View paramView)
  {
    if (paramObject != null)
      ((l)paramObject).c(paramView);
  }

  public void replaceTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    int i = 0;
    l locall = (l)paramObject;
    if ((locall instanceof p))
    {
      p localp = (p)locall;
      int n = localp.q();
      while (i < n)
      {
        replaceTargets(localp.b(i), paramArrayList1, paramArrayList2);
        i++;
      }
    }
    if (!a(locall))
    {
      List localList = locall.g();
      if ((localList.size() == paramArrayList1.size()) && (localList.containsAll(paramArrayList1)))
      {
        if (paramArrayList2 == null);
        for (int j = 0; ; j = paramArrayList2.size())
          for (int k = 0; k < j; k++)
            locall.b((View)paramArrayList2.get(k));
        for (int m = -1 + paramArrayList1.size(); m >= 0; m--)
          locall.c((View)paramArrayList1.get(m));
      }
    }
  }

  public void scheduleHideFragmentView(Object paramObject, final View paramView, final ArrayList<View> paramArrayList)
  {
    ((l)paramObject).a(new l.c()
    {
      public void a(l paramAnonymousl)
      {
        paramAnonymousl.b(this);
        paramView.setVisibility(8);
        int i = paramArrayList.size();
        for (int j = 0; j < i; j++)
          ((View)paramArrayList.get(j)).setVisibility(0);
      }

      public void b(l paramAnonymousl)
      {
      }

      public void c(l paramAnonymousl)
      {
      }

      public void d(l paramAnonymousl)
      {
      }
    });
  }

  public void scheduleRemoveTargets(Object paramObject1, final Object paramObject2, final ArrayList<View> paramArrayList1, final Object paramObject3, final ArrayList<View> paramArrayList2, final Object paramObject4, final ArrayList<View> paramArrayList3)
  {
    ((l)paramObject1).a(new l.c()
    {
      public void a(l paramAnonymousl)
      {
      }

      public void b(l paramAnonymousl)
      {
      }

      public void c(l paramAnonymousl)
      {
      }

      public void d(l paramAnonymousl)
      {
        if (paramObject2 != null)
          e.this.replaceTargets(paramObject2, paramArrayList1, null);
        if (paramObject3 != null)
          e.this.replaceTargets(paramObject3, paramArrayList2, null);
        if (paramObject4 != null)
          e.this.replaceTargets(paramObject4, paramArrayList3, null);
      }
    });
  }

  public void setEpicenter(Object paramObject, final Rect paramRect)
  {
    if (paramObject != null)
      ((l)paramObject).a(new l.b()
      {
      });
  }

  public void setEpicenter(Object paramObject, View paramView)
  {
    if (paramView != null)
    {
      l locall = (l)paramObject;
      final Rect localRect = new Rect();
      getBoundsOnScreen(paramView, localRect);
      locall.a(new l.b()
      {
      });
    }
  }

  public void setSharedElementTargets(Object paramObject, View paramView, ArrayList<View> paramArrayList)
  {
    p localp = (p)paramObject;
    List localList = localp.g();
    localList.clear();
    int i = paramArrayList.size();
    for (int j = 0; j < i; j++)
      bfsAddViewChildren(localList, (View)paramArrayList.get(j));
    localList.add(paramView);
    paramArrayList.add(paramView);
    addTargets(localp, paramArrayList);
  }

  public void swapSharedElementTargets(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    p localp = (p)paramObject;
    if (localp != null)
    {
      localp.g().clear();
      localp.g().addAll(paramArrayList2);
      replaceTargets(localp, paramArrayList1, paramArrayList2);
    }
  }

  public Object wrapTransitionInSet(Object paramObject)
  {
    if (paramObject == null)
      return null;
    p localp = new p();
    localp.a((l)paramObject);
    return localp;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.e
 * JD-Core Version:    0.6.2
 */