package com.viber.voip.messages.translation;

import android.content.Context;
import android.content.res.Resources;
import com.google.d.f;
import com.google.d.g;
import com.viber.voip.R.raw;
import com.viber.voip.messages.orm.entity.json.Language;
import com.viber.voip.messages.orm.entity.json.Languages;
import com.viber.voip.util.bj;
import java.util.List;

public enum a
{
  static
  {
    a[] arrayOfa = new a[2];
    arrayOfa[0] = a;
    arrayOfa[1] = b;
  }

  private int a()
  {
    switch (1.a[ordinal()])
    {
    default:
      return R.raw.translation_languages;
    case 1:
    }
    return R.raw.ui_languages;
  }

  public Language a(Context paramContext, String paramString)
  {
    List localList = a(paramContext);
    int i = localList.size();
    for (int j = 0; j < i; j++)
    {
      Language localLanguage = (Language)localList.get(j);
      if (paramString.equals(localLanguage.getCode()))
        return localLanguage;
    }
    return null;
  }

  public List<Language> a(Context paramContext)
  {
    String str = bj.a(paramContext.getResources().openRawResource(a()));
    return ((Languages)new g().a().a(str, Languages.class)).getLanguage();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.translation.a
 * JD-Core Version:    0.6.2
 */