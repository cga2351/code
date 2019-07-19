package com.viber.voip.contacts.adapters;

import android.text.TextUtils;
import java.text.Collator;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class b
{
  public static final Character a = Character.valueOf('他');
  public static final String b = a.toString();
  public static final Character c = Character.valueOf('一');
  public static final String d = c.toString();
  public static final Character e = Character.valueOf('#');
  public static final Character f = Character.valueOf('★');
  public static final String g = f.toString();
  public static final String h = e.toString();
  public static final Character i = Character.valueOf(' ');
  public static final Character[] j = arrayOfCharacter;
  private Set<Character> k = new HashSet();
  private CharSequence l = new StringBuilder();
  private Character[] m;
  private String[] n;

  static
  {
    Character[] arrayOfCharacter = new Character[3];
    arrayOfCharacter[0] = i;
    arrayOfCharacter[1] = e;
    arrayOfCharacter[2] = f;
  }

  public static String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (Character.isDigit(paramString.charAt(0))))
      paramString = String.valueOf(e);
    return paramString;
  }

  private void d()
  {
    int i1 = 0;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(45);
      this.k.remove(i);
      Character[] arrayOfCharacter1 = new Character[this.k.size() + j.length];
      String[] arrayOfString = new String[this.k.size() + j.length];
      Character[] arrayOfCharacter2 = j;
      int i2 = arrayOfCharacter2.length;
      int i3 = 0;
      while (i3 < i2)
      {
        Character localCharacter1 = arrayOfCharacter2[i3];
        localStringBuilder.append(localCharacter1);
        arrayOfCharacter1[i1] = localCharacter1;
        arrayOfString[i1] = String.valueOf(localCharacter1);
        int i4 = i1 + 1;
        i3++;
        i1 = i4;
      }
      Iterator localIterator = this.k.iterator();
      for (int i5 = i1; localIterator.hasNext(); i5++)
      {
        Character localCharacter2 = (Character)localIterator.next();
        localStringBuilder.append(localCharacter2);
        if (localCharacter2.equals(c))
          localCharacter2 = Character.valueOf(' ');
        arrayOfCharacter1[i5] = localCharacter2;
        arrayOfString[i5] = String.valueOf(Character.toUpperCase(localCharacter2.charValue()));
      }
      this.m = arrayOfCharacter1;
      this.n = arrayOfString;
      this.l = localStringBuilder;
      return;
    }
    finally
    {
    }
  }

  public CharSequence a()
  {
    return this.l;
  }

  public void a(Collection<Character> paramCollection, Locale paramLocale)
  {
    try
    {
      this.k = new TreeSet(new a(paramLocale));
      this.k.addAll(paramCollection);
      d();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Character[] b()
  {
    return this.m;
  }

  public String[] c()
  {
    return this.n;
  }

  public static class a
    implements Comparator<Character>
  {
    private Collator a = Collator.getInstance();

    public a(Locale paramLocale)
    {
      this.a.setStrength(0);
    }

    public int a(Character paramCharacter1, Character paramCharacter2)
    {
      return this.a.compare(paramCharacter1.toString(), paramCharacter2.toString());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.adapters.b
 * JD-Core Version:    0.6.2
 */