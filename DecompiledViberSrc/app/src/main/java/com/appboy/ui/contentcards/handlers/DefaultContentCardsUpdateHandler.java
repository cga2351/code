package com.appboy.ui.contentcards.handlers;

import com.appboy.c.a;
import com.appboy.e.a.c;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultContentCardsUpdateHandler
  implements IContentCardsUpdateHandler
{
  public List<c> handleCardUpdate(a parama)
  {
    List localList = parama.b();
    Collections.sort(localList, new Comparator()
    {
      public int compare(c paramAnonymousc1, c paramAnonymousc2)
      {
        if ((paramAnonymousc1.o()) && (!paramAnonymousc2.o()));
        do
        {
          return -1;
          if ((!paramAnonymousc1.o()) && (paramAnonymousc2.o()))
            return 1;
        }
        while (paramAnonymousc1.q() > paramAnonymousc2.q());
        if (paramAnonymousc1.q() < paramAnonymousc2.q())
          return 1;
        return 0;
      }
    });
    return localList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.contentcards.handlers.DefaultContentCardsUpdateHandler
 * JD-Core Version:    0.6.2
 */