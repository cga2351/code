package com.viber.voip.publicaccount.ui.holders.name;

import android.support.v4.app.Fragment;
import com.viber.common.dialogs.j.a;
import com.viber.voip.publicaccount.entity.b;
import com.viber.voip.publicaccount.entity.d;
import com.viber.voip.ui.dialogs.ad;
import java.util.ArrayList;
import java.util.Iterator;

public class a
{
  private final Fragment a;

  public a(Fragment paramFragment)
  {
    this.a = paramFragment;
  }

  public void a(int paramInt, ArrayList<b> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
      return;
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(((b)localIterator.next()).a());
    ((j.a)((j.a)ad.l().a(localArrayList)).i(paramInt).a(this.a)).b(this.a);
  }

  public void b(int paramInt, ArrayList<d> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
      return;
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(((d)localIterator.next()).b());
    ((j.a)((j.a)ad.m().a(localArrayList)).i(paramInt).a(this.a)).b(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.name.a
 * JD-Core Version:    0.6.2
 */