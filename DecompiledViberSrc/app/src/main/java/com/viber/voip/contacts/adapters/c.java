package com.viber.voip.contacts.adapters;

import android.database.DataSetObserver;
import android.widget.AlphabetIndexer;
import android.widget.SectionIndexer;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public abstract class c<T extends com.viber.voip.model.d>
  implements SectionIndexer
{
  private static final Logger a = ViberEnv.getLogger();
  private final SectionIndexer b;
  private final String[] c;

  public c(com.viber.provider.c paramc, CharSequence paramCharSequence, String[] paramArrayOfString)
  {
    this.b = new AlphabetIndexer(new a(paramc), 0, paramCharSequence);
    this.c = paramArrayOfString;
  }

  public static Character a(char paramChar)
  {
    if (Character.isLetter(paramChar));
    for (char c1 = Character.toUpperCase(paramChar); ; c1 = ' ')
      return Character.valueOf(c1);
  }

  protected abstract String a(T paramT, int paramInt);

  public int getPositionForSection(int paramInt)
  {
    return this.b.getPositionForSection(paramInt);
  }

  public int getSectionForPosition(int paramInt)
  {
    return this.b.getSectionForPosition(paramInt);
  }

  public Object[] getSections()
  {
    if (this.c != null)
      return this.c;
    return this.b.getSections();
  }

  private class a extends d
  {
    public a(com.viber.provider.c arg2)
    {
      super();
    }

    public String getString(int paramInt)
    {
      com.viber.voip.model.d locald = (com.viber.voip.model.d)this.b.b(this.c);
      if (locald == null)
        return "";
      return c.this.a(locald, this.c);
    }

    public int getType(int paramInt)
    {
      return 0;
    }

    public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
    }

    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.adapters.c
 * JD-Core Version:    0.6.2
 */