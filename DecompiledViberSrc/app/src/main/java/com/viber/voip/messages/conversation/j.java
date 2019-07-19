package com.viber.voip.messages.conversation;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.g.b;
import com.viber.voip.messages.orm.creator.Creator;
import com.viber.voip.model.c;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserManager;
import dagger.a;

public class j extends com.viber.provider.d
{
  private static final Creator l = com.viber.voip.model.entity.d.c;
  private final a<g> m;
  private g.b n = new g.b()
  {
    public void a()
    {
      j.this.l();
    }
  };

  public j(Context paramContext, LoaderManager paramLoaderManager, a<g> parama, d.a parama1)
  {
    super(5, l.getContentUri(), paramContext, paramLoaderManager, parama1, 0);
    this.m = parama;
    a(l.getProjections());
    String str = UserManager.from(paramContext).getRegistrationValues().h();
    if (str == null);
    for (String[] arrayOfString = null; ; arrayOfString = new String[] { str })
    {
      b(arrayOfString);
      a("phonebookcontact.viber=1 AND phonebookcontact._id IN (SELECT phonebookdata.contact_id FROM phonebookdata WHERE phonebookdata.data2<>? AND phonebookdata.data2 IN (SELECT vibernumbers.canonized_number FROM  vibernumbers))");
      d("phonebookcontact.low_display_name ASC, phonebookcontact._id DESC");
      d(4);
      return;
    }
  }

  public c e(int paramInt)
  {
    if (b_(paramInt))
      return (c)l.createInstance(this.f);
    return null;
  }

  public void p()
  {
    super.p();
    ((g)this.m.get()).a(this.n);
  }

  public void q()
  {
    super.q();
    ((g)this.m.get()).b(this.n);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.j
 * JD-Core Version:    0.6.2
 */