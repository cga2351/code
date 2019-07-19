package com.viber.voip.calls;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import com.viber.provider.contacts.a.c;
import com.viber.voip.R.string;
import com.viber.voip.contacts.c.e.b;
import com.viber.voip.util.af;
import com.viber.voip.util.bq;
import com.viber.voip.util.bq.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class h
{
  private static final String[] a = { "_id", "display_name" };
  private Context b;
  private Map<Character, Character> c = new HashMap();
  private bq d;

  public h(Context paramContext)
  {
    this.b = paramContext;
    this.d = b.a(paramContext);
    b();
  }

  private void a(char paramChar, int paramInt)
  {
    if (paramInt != 0);
    for (String str = this.b.getResources().getString(paramInt); str != null; str = null)
      for (char c1 : str.toLowerCase().toCharArray())
        this.c.put(Character.valueOf(c1), Character.valueOf(paramChar));
    this.c.put(Character.valueOf(paramChar), Character.valueOf(paramChar));
  }

  private void b()
  {
    try
    {
      this.c.clear();
      a('0', R.string.keypad_latters_button_0);
      a('1', R.string.keypad_latters_button_1);
      a('2', R.string.keypad_latters_button_2);
      a('3', R.string.keypad_latters_button_3);
      a('4', R.string.keypad_latters_button_4);
      a('5', R.string.keypad_latters_button_5);
      a('6', R.string.keypad_latters_button_6);
      a('7', R.string.keypad_latters_button_7);
      a('8', R.string.keypad_latters_button_8);
      a('9', R.string.keypad_latters_button_9);
      this.c.put(Character.valueOf(' '), Character.valueOf('0'));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void c()
  {
    this.d.a(1584, null, a.c.a, a, null, null, null, new bq.g()
    {
      public void onQueryComplete(int paramAnonymousInt, Object paramAnonymousObject, Cursor paramAnonymousCursor)
      {
        ArrayList localArrayList = new ArrayList();
        int j;
        long l;
        if ((paramAnonymousCursor != null) && (paramAnonymousCursor.moveToFirst()))
        {
          int i = paramAnonymousCursor.getColumnIndex("_id");
          j = paramAnonymousCursor.getColumnIndex("display_name");
          l = paramAnonymousCursor.getLong(i);
          if (paramAnonymousCursor.getString(j) == null)
            break label168;
        }
        label168: for (String str = paramAnonymousCursor.getString(j).toLowerCase(); ; str = null)
        {
          localArrayList.add(ContentProviderOperation.newUpdate(a.c.a).withValue("numbers_name", h.this.a(str)).withSelection("_id=" + l, null).withYieldAllowed(true).build());
          if (paramAnonymousCursor.moveToNext())
            break;
          h.a(h.this).a(0, "com.viber.voip.provider.vibercontacts", null, localArrayList, null, false, false);
          af.a(paramAnonymousCursor);
          return;
        }
      }
    }
    , false, false);
  }

  public String a(String paramString)
  {
    if (paramString != null);
    while (true)
    {
      StringBuilder localStringBuilder;
      int j;
      try
      {
        char[] arrayOfChar = paramString.toCharArray();
        localStringBuilder = new StringBuilder();
        int i = arrayOfChar.length;
        j = 0;
        if (j < i)
        {
          char c1 = arrayOfChar[j];
          Character localCharacter = (Character)this.c.get(Character.valueOf(c1));
          if (localCharacter != null)
            localStringBuilder.append(localCharacter);
          else
            localStringBuilder.append('1');
        }
      }
      finally
      {
      }
      String str2 = localStringBuilder.toString();
      for (String str1 = str2; ; str1 = "?")
        return str1;
      j++;
    }
  }

  public void a()
  {
    b();
    c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.h
 * JD-Core Version:    0.6.2
 */