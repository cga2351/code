package com.viber.voip.notif.g;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.b.f.b.p;
import com.viber.voip.notif.b.f.d.i;
import com.viber.voip.registration.af;
import com.viber.voip.util.da;
import java.util.Arrays;

public class g
  implements f
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final dagger.a<ak> c;
  private final dagger.a<ab> d;
  private final dagger.a<com.viber.voip.contacts.c.d.m> e;
  private final dagger.a<com.viber.voip.messages.d.b> f;
  private final af g;
  private final p h;

  public g(Context paramContext, dagger.a<ak> parama, dagger.a<ab> parama1, dagger.a<com.viber.voip.contacts.c.d.m> parama2, dagger.a<com.viber.voip.messages.d.b> parama3, af paramaf, p paramp)
  {
    this.b = paramContext;
    this.c = parama;
    this.d = parama1;
    this.e = parama2;
    this.f = parama3;
    this.g = paramaf;
    this.h = paramp;
  }

  private com.viber.voip.notif.d.e a(com.viber.voip.notif.h.m paramm, boolean paramBoolean)
  {
    com.viber.voip.notif.b.f.b.e locale = this.h.a(this.b, paramm, paramBoolean).a(paramBoolean);
    if (paramm.c().isRakutenSystemMessage())
      return com.viber.voip.notif.b.f.f.a.b(paramm, locale);
    if (!com.viber.voip.messages.m.i(paramm.e().l()))
      return com.viber.voip.notif.b.f.f.a.a(paramm, locale);
    return null;
  }

  private com.viber.voip.notif.d.e a(String paramString, com.viber.voip.notif.h.m paramm, boolean paramBoolean)
  {
    String str = this.g.l();
    if ((!da.a(str)) && (str.equals(paramString)))
    {
      if (paramm.e().e())
        return new com.viber.voip.notif.b.f.d.a.e(paramm, this.c, this.d, this.e, str);
      return new com.viber.voip.notif.b.f.d.a.d(paramm, this.c);
    }
    if (paramBoolean)
      return com.viber.voip.notif.b.f.d.a.a.b(paramm);
    return com.viber.voip.notif.b.f.d.a.a.a(paramm);
  }

  private com.viber.voip.notif.d.e b(com.viber.voip.notif.h.m paramm)
  {
    if (1008 == paramm.c().getMimeType());
    label15: String[] arrayOfString;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                      return null;
                    while (da.a(paramm.c().getBody()));
                    arrayOfString = paramm.c().getBody().split("/", -1);
                    String str = arrayOfString[0];
                    int i = -1;
                    switch (str.hashCode())
                    {
                    default:
                    case -240205570:
                    case 96417:
                    case 1655531844:
                    case 145188545:
                    case 1117226395:
                    case 1269692078:
                    case 742834177:
                    case 1622584410:
                    case -604161437:
                    case 188373111:
                    case 1091836000:
                    case -1186106015:
                    case 5736961:
                    }
                    while (true)
                      switch (i)
                      {
                      default:
                        return null;
                      case 0:
                        if (arrayOfString.length <= 3)
                          break label15;
                        return new com.viber.voip.notif.b.f.d.f(paramm, com.viber.voip.messages.j.j(arrayOfString[2]), com.viber.voip.messages.j.j(arrayOfString[3]));
                        if (str.equals("group_rename"))
                        {
                          i = 0;
                          continue;
                          if (str.equals("add"))
                          {
                            i = 1;
                            continue;
                            if (str.equals("add_by_link"))
                            {
                              i = 2;
                              continue;
                              if (str.equals("many_add"))
                              {
                                i = 3;
                                continue;
                                if (str.equals("many_add_members"))
                                {
                                  i = 4;
                                  continue;
                                  if (str.equals("group_icon_changed"))
                                  {
                                    i = 5;
                                    continue;
                                    if (str.equals("group_icon_changed_with_icon"))
                                    {
                                      i = 6;
                                      continue;
                                      if (str.equals("group_icon_removed"))
                                      {
                                        i = 7;
                                        continue;
                                        if (str.equals("group_background_changed"))
                                        {
                                          i = 8;
                                          continue;
                                          if (str.equals("many_group_attrs_changed"))
                                          {
                                            i = 9;
                                            continue;
                                            if (str.equals("removed"))
                                            {
                                              i = 10;
                                              continue;
                                              if (str.equals("added_as_admin"))
                                              {
                                                i = 11;
                                                continue;
                                                if (str.equals("removed_as_admin"))
                                                  i = 12;
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                        break;
                      case 1:
                      case 2:
                      case 3:
                      case 4:
                      case 5:
                      case 6:
                      case 7:
                      case 8:
                      case 9:
                      case 10:
                      case 11:
                      case 12:
                      }
                  }
                  while (arrayOfString.length <= 1);
                  return a(com.viber.voip.messages.j.j(arrayOfString[1]), paramm, false);
                }
                while (arrayOfString.length <= 1);
                return a(com.viber.voip.messages.j.j(arrayOfString[1]), paramm, true);
              }
              while (arrayOfString.length <= 2);
              return new com.viber.voip.notif.b.f.d.a.b(paramm, com.viber.voip.messages.j.j(arrayOfString[1]), arrayOfString[2]);
            }
            while (arrayOfString.length <= 1);
            return new com.viber.voip.notif.b.f.d.a.c(paramm, this.c, com.viber.voip.messages.j.j(arrayOfString[1]).split(","));
            return new com.viber.voip.notif.b.f.d.c(paramm);
            return new com.viber.voip.notif.b.f.d.d(paramm);
            return new com.viber.voip.notif.b.f.d.b(paramm);
          }
          while (arrayOfString.length <= 2);
          return new com.viber.voip.notif.b.f.d.e(paramm, arrayOfString[2]);
        }
        while (arrayOfString.length <= 2);
        return new com.viber.voip.notif.b.f.d.h(paramm, this.f, this.g, (String[])Arrays.copyOfRange(arrayOfString, 1, arrayOfString.length));
      }
      while (arrayOfString.length <= 1);
      return new com.viber.voip.notif.b.f.d.a(paramm, this.f, this.g, com.viber.voip.messages.j.j(arrayOfString[1]));
    }
    while (arrayOfString.length <= 1);
    return new com.viber.voip.notif.b.f.d.g(paramm, this.f, this.g, com.viber.voip.messages.j.j(arrayOfString[1]));
  }

  public boolean a(com.viber.voip.notif.h.m paramm)
  {
    return 1 == paramm.i();
  }

  public com.viber.voip.notif.d.e b(com.viber.voip.notif.h.b paramb, e parame)
  {
    return null;
  }

  public com.viber.voip.notif.d.e b(com.viber.voip.notif.h.m paramm, e parame)
  {
    if (!a(paramm));
    do
    {
      return null;
      if (paramm.c().isNotification())
        return b(paramm);
      if (paramm.c().isSystemMessage())
        return a(paramm, parame.a());
      if (paramm.c().isYouWasMentionedInThisMessage())
        return new i(paramm);
    }
    while (!paramm.c().hasYouWasMentionedInRepliedMessage());
    return new com.viber.voip.notif.b.f.d.j(paramm);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.g.g
 * JD-Core Version:    0.6.2
 */