package com.viber.voip.ui.bottomnavigation;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

public abstract class b<ITEM extends a>
{
  private void a(List<ITEM> paramList)
  {
    int i = paramList.size();
    if (((i < 3) || (i > 5)) && (i > 5))
      paramList.subList(5, i).clear();
  }

  private Menu b(Context paramContext, int paramInt)
  {
    Menu localMenu = new PopupMenu(paramContext, null).getMenu();
    new MenuInflater(paramContext).inflate(paramInt, localMenu);
    return localMenu;
  }

  protected abstract ITEM a(MenuItem paramMenuItem);

  public List<ITEM> a(Context paramContext, int paramInt)
  {
    Menu localMenu = b(paramContext, paramInt);
    ArrayList localArrayList = new ArrayList(localMenu.size());
    int i = 0;
    int j = localMenu.size();
    while (i < j)
    {
      a locala = a(localMenu.getItem(i));
      if (locala != null)
        localArrayList.add(locala);
      i++;
    }
    a(localArrayList);
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.bottomnavigation.b
 * JD-Core Version:    0.6.2
 */