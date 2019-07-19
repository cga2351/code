package com.viber.voip.messages.ui.forward.sharelink;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d.a;
import com.viber.voip.messages.conversation.a.h;
import com.viber.voip.messages.conversation.ai;
import com.viber.voip.messages.conversation.n.a;
import com.viber.voip.messages.k;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class d
  implements d.a
{
  private final ai a;
  private Set<d.a> b;

  public d(Context paramContext, dagger.a<k> parama, LoaderManager paramLoaderManager, dagger.a<h> parama1, dagger.a<ConferenceCallsRepository> parama2, Bundle paramBundle, String paramString)
  {
    this.a = new ai(paramContext, paramLoaderManager, parama, true, true, n.a.a, paramBundle, paramString, this, com.viber.voip.h.a.b(), (h)parama1.get(), parama2);
    this.a.h(true);
    this.a.i(false);
    this.a.p(true);
    this.a.t(true);
    this.a.i();
    this.a.p();
    this.b = new HashSet();
  }

  public void a()
  {
    this.a.q();
  }

  public void a(Bundle paramBundle)
  {
    paramBundle.putString("search_query_key", this.a.K());
  }

  public void a(d.a parama)
  {
    this.b.add(parama);
  }

  public ai b()
  {
    return this.a;
  }

  public void b(d.a parama)
  {
    this.b.remove(parama);
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((d.a)localIterator.next()).onLoadFinished(paramd, paramBoolean);
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((d.a)localIterator.next()).onLoaderReset(paramd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.forward.sharelink.d
 * JD-Core Version:    0.6.2
 */