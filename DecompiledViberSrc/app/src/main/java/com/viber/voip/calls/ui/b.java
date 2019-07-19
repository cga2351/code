package com.viber.voip.calls.ui;

import com.viber.voip.model.Call;
import com.viber.voip.ui.h.a;
import java.util.ArrayList;
import java.util.List;

public class b
  implements a
{
  private List<Call> a = new ArrayList();

  public int a()
  {
    return this.a.size();
  }

  public Call a(int paramInt)
  {
    return (Call)this.a.get(paramInt);
  }

  public void a(List<Call> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.b
 * JD-Core Version:    0.6.2
 */