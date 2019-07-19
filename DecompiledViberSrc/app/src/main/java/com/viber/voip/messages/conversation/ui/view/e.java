package com.viber.voip.messages.conversation.ui.view;

import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.ui.view.b.a;
import java.util.List;

public class e extends com.viber.voip.mvp.core.e<a>
{
  public void a()
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      ((a)this.a.get(j)).L_();
  }

  public void a(int paramInt, aa paramaa)
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      ((a)this.a.get(j)).a(paramInt, paramaa);
  }

  public void a(boolean paramBoolean)
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      ((a)this.a.get(j)).d_(paramBoolean);
  }

  public void b()
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      ((a)this.a.get(j)).s();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.e
 * JD-Core Version:    0.6.2
 */