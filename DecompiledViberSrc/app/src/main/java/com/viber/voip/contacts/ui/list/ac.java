package com.viber.voip.contacts.ui.list;

import android.support.v7.d.c.a;
import com.viber.voip.messages.conversation.ae;
import java.util.List;

public class ac extends c.a
{
  private final List<z> a;
  private final List<z> b;

  public ac(List<z> paramList1, List<z> paramList2)
  {
    this.a = paramList1;
    this.b = paramList2;
  }

  public boolean areContentsTheSame(int paramInt1, int paramInt2)
  {
    return false;
  }

  public boolean areItemsTheSame(int paramInt1, int paramInt2)
  {
    ae localae1 = ((z)this.a.get(paramInt1)).a;
    ae localae2 = ((z)this.b.get(paramInt2)).a;
    return localae1.h().equals(localae2.h());
  }

  public int getNewListSize()
  {
    return this.b.size();
  }

  public int getOldListSize()
  {
    return this.a.size();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.ac
 * JD-Core Version:    0.6.2
 */