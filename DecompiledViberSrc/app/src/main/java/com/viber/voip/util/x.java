package com.viber.voip.util;

import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.DialogInterface.OnShowListener;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.support.v7.app.c.a;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.contacts.ui.ParticipantSelector.d;
import com.viber.voip.memberid.Member;
import com.viber.voip.model.a;
import com.viber.voip.model.a.a;
import com.viber.voip.model.entity.k;
import com.viber.voip.model.entity.m;
import com.viber.voip.model.f;
import com.viber.voip.permissions.n;
import com.viber.voip.util.a.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class x
{
  private static final Logger b;

  static
  {
    if (!x.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      b = ViberEnv.getLogger();
      return;
    }
  }

  private x()
  {
    if (!a)
      throw new AssertionError();
  }

  public static Uri a(long paramLong)
  {
    if (paramLong > 0L)
      return ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, paramLong);
    return null;
  }

  public static Uri a(a parama)
  {
    Uri localUri = null;
    if (parama != null)
      localUri = parama.o();
    return localUri;
  }

  public static com.viber.voip.model.entity.g a(m paramm)
  {
    String str = paramm.o();
    Uri localUri = paramm.p();
    return a(paramm.getNumber(), str, localUri, Member.from(paramm));
  }

  public static com.viber.voip.model.entity.g a(String paramString1, String paramString2, Uri paramUri, Member paramMember)
  {
    com.viber.voip.model.entity.g localg = new com.viber.voip.model.entity.g();
    localg.i(paramString2);
    k localk = new k(paramString1, paramString1, paramString1, null, null);
    int i;
    com.viber.voip.model.entity.x localx;
    if (paramMember != null)
    {
      i = 1;
      if (i == 0)
        break label230;
      localx = new com.viber.voip.model.entity.x();
      localx.e(paramMember.getId());
      localx.b(paramMember.getPhoneNumber());
      localx.d(paramMember.getViberName());
      localx.f(paramMember.getViberId());
      if (paramUri != null)
        localx.c(paramUri.getLastPathSegment());
      localg.c(true);
      if (!paramString2.equals(paramMember.getPhoneNumber()))
      {
        if (!e.m(paramString2))
          break label187;
        localg.m(paramString2);
      }
      label129: localg.a(paramUri);
    }
    while (true)
    {
      com.viber.voip.model.entity.c localc;
      if (paramMember != null)
      {
        boolean bool2 = com.viber.voip.block.g.a(paramMember);
        localc = null;
        if (bool2)
          localc = new com.viber.voip.model.entity.c(paramMember.getId(), 0L);
      }
      while (true)
      {
        localg.a(localk, localx, localc);
        return localg;
        i = 0;
        break;
        label187: localg.m(paramString2.toLowerCase());
        break label129;
        boolean bool1 = com.viber.voip.block.g.a(Member.fromVln(paramString1));
        localc = null;
        if (bool1)
          localc = new com.viber.voip.model.entity.c(paramString1, 0L);
      }
      label230: localx = null;
    }
  }

  public static String a(Context paramContext, long paramLong1, long paramLong2)
  {
    long l1 = TimeUnit.MILLISECONDS.toSeconds(paramLong2);
    long l2 = TimeUnit.MILLISECONDS.toMinutes(paramLong2);
    long l3 = TimeUnit.MILLISECONDS.toHours(paramLong2);
    long l4 = TimeUnit.MILLISECONDS.toDays(paramLong2);
    long l5 = TimeUnit.MILLISECONDS.toSeconds(paramLong1);
    long l6 = TimeUnit.MILLISECONDS.toMinutes(paramLong1);
    long l7 = TimeUnit.MILLISECONDS.toHours(paramLong1);
    long l8 = TimeUnit.MILLISECONDS.toDays(paramLong1);
    long l9 = l1 - l5;
    long l10 = l2 - l6;
    long l11 = l3 - l7;
    long l12 = l4 - l8;
    if ((l9 >= 0L) && (l9 < TimeUnit.MINUTES.toSeconds(1L)))
      return paramContext.getString(R.string.seen_moment_ago);
    if ((l9 >= TimeUnit.MINUTES.toSeconds(1L)) && (l10 < TimeUnit.HOURS.toMinutes(1L)))
    {
      int n = R.string.seen_minutes_ago;
      Object[] arrayOfObject5 = new Object[1];
      arrayOfObject5[0] = Long.toString(l2 - l6);
      return paramContext.getString(n, arrayOfObject5);
    }
    if ((l10 >= TimeUnit.HOURS.toMinutes(1L)) && (l11 < TimeUnit.DAYS.toHours(1L)))
    {
      if (ae.b(paramLong2, paramLong1))
      {
        int m = R.string.seen_today;
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = DateUtils.formatDateTime(paramContext, paramLong1, 1);
        return paramContext.getString(m, arrayOfObject4);
      }
      int k = R.string.seen_yesterday;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = DateUtils.formatDateTime(paramContext, paramLong1, 1);
      return paramContext.getString(k, arrayOfObject3);
    }
    if (((l12 == 1L) && (!ae.b(paramLong2, paramLong1))) || ((l11 < 48L) && (ae.c(paramLong2, paramLong1))))
    {
      int j = R.string.seen_yesterday;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = DateUtils.formatDateTime(paramContext, paramLong1, 1);
      return paramContext.getString(j, arrayOfObject2);
    }
    if ((l12 > 1L) && (l12 < 30L))
    {
      int i = R.string.seen_on;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = DateUtils.formatDateTime(paramContext, paramLong1, 8);
      return paramContext.getString(i, arrayOfObject1);
    }
    return paramContext.getString(R.string.seen_more_than_month);
  }

  // ERROR //
  @java.lang.Deprecated
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 248	com/viber/voip/util/da:a	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aload_2
    //   8: areturn
    //   9: getstatic 253	android/provider/ContactsContract$PhoneLookup:CONTENT_FILTER_URI	Landroid/net/Uri;
    //   12: aload_1
    //   13: invokestatic 257	android/net/Uri:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 261	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   19: astore_3
    //   20: iconst_1
    //   21: anewarray 124	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc_w 263
    //   29: aastore
    //   30: astore 4
    //   32: aload_0
    //   33: aload_3
    //   34: aload 4
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: invokestatic 268	com/viber/voip/util/af:a	(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore 7
    //   44: aload 7
    //   46: astore 6
    //   48: aload 6
    //   50: ifnull +35 -> 85
    //   53: aload 6
    //   55: invokeinterface 273 1 0
    //   60: ifeq +25 -> 85
    //   63: aload 6
    //   65: aload 6
    //   67: ldc_w 263
    //   70: invokeinterface 277 2 0
    //   75: invokeinterface 278 2 0
    //   80: astore 8
    //   82: aload 8
    //   84: astore_2
    //   85: aload 6
    //   87: invokestatic 281	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   90: aload_2
    //   91: areturn
    //   92: astore 5
    //   94: aconst_null
    //   95: astore 6
    //   97: aload 6
    //   99: invokestatic 281	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   102: aload 5
    //   104: athrow
    //   105: astore 5
    //   107: goto -10 -> 97
    //
    // Exception table:
    //   from	to	target	type
    //   32	44	92	finally
    //   53	82	105	finally
  }

  public static String a(Context paramContext, boolean paramBoolean, long paramLong)
  {
    return a(paramContext, paramBoolean, paramLong, System.currentTimeMillis());
  }

  public static String a(Context paramContext, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    long l1 = TimeUnit.MILLISECONDS.toSeconds(paramLong2);
    long l2 = TimeUnit.MILLISECONDS.toMinutes(paramLong2);
    long l3 = TimeUnit.MILLISECONDS.toHours(paramLong2);
    long l4 = TimeUnit.MILLISECONDS.toDays(paramLong2);
    long l5 = TimeUnit.MILLISECONDS.toSeconds(paramLong1);
    long l6 = TimeUnit.MILLISECONDS.toMinutes(paramLong1);
    long l7 = TimeUnit.MILLISECONDS.toHours(paramLong1);
    long l8 = TimeUnit.MILLISECONDS.toDays(paramLong1);
    long l9 = l1 - l5;
    long l10 = l2 - l6;
    long l11 = l3 - l7;
    long l12 = l4 - l8;
    if ((l9 == 0L) || (paramBoolean))
      return paramContext.getString(R.string.status_last_online_online);
    if ((l9 > 0L) && (l9 < TimeUnit.MINUTES.toSeconds(1L)))
      return paramContext.getString(R.string.status_last_online_moment_ago);
    if ((l9 >= TimeUnit.MINUTES.toSeconds(1L)) && (l10 < TimeUnit.HOURS.toMinutes(1L)))
    {
      int n = R.string.status_last_online_minutes_ago;
      Object[] arrayOfObject5 = new Object[1];
      arrayOfObject5[0] = Long.toString(l2 - l6);
      return paramContext.getString(n, arrayOfObject5);
    }
    if ((l10 >= TimeUnit.HOURS.toMinutes(1L)) && (l11 < TimeUnit.DAYS.toHours(1L)))
    {
      if (ae.b(paramLong2, paramLong1))
      {
        int m = R.string.status_last_online_today;
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = DateUtils.formatDateTime(paramContext, paramLong1, 1);
        return paramContext.getString(m, arrayOfObject4);
      }
      int k = R.string.status_last_online_yesterday;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = DateUtils.formatDateTime(paramContext, paramLong1, 1);
      return paramContext.getString(k, arrayOfObject3);
    }
    if (((l12 == 1L) && (!ae.b(paramLong2, paramLong1))) || ((l11 < 48L) && (ae.c(paramLong2, paramLong1))))
    {
      int j = R.string.status_last_online_yesterday;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = DateUtils.formatDateTime(paramContext, paramLong1, 1);
      return paramContext.getString(j, arrayOfObject2);
    }
    if ((l12 > 1L) && (l12 < 30L))
    {
      int i = R.string.status_last_online_at;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = DateUtils.formatDateTime(paramContext, paramLong1, 8);
      return paramContext.getString(i, arrayOfObject1);
    }
    return paramContext.getString(R.string.status_last_online_more_than_month);
  }

  public static String a(a parama, String paramString)
  {
    if (parama == null)
      return paramString;
    return parama.k();
  }

  public static void a(final Context paramContext, a parama, final ParticipantSelector.d paramd)
  {
    if (parama != null)
      parama.a(paramContext, new a.a()
      {
        public void a(Collection<f> paramAnonymousCollection)
        {
          if (paramAnonymousCollection == null);
          HashMap localHashMap1;
          HashSet localHashSet;
          do
          {
            return;
            localHashMap1 = new HashMap();
            localHashSet = new HashSet();
            Iterator localIterator1 = paramAnonymousCollection.iterator();
            while (localIterator1.hasNext())
            {
              f localf = (f)localIterator1.next();
              if (!localHashMap1.containsKey(localf.b()))
                localHashMap1.put(localf.b(), localf);
              localHashSet.add(ParticipantSelector.Participant.from(localf, this.a));
            }
            if (localHashSet.size() == 1)
            {
              paramd.a(false, (ParticipantSelector.Participant)localHashSet.iterator().next());
              return;
            }
          }
          while (localHashMap1.size() <= 1);
          HashMap localHashMap2 = new HashMap(1 + (int)(localHashMap1.values().size() / 0.75F));
          Iterator localIterator2 = localHashMap1.values().iterator();
          while (localIterator2.hasNext())
            localHashMap2.put(((f)localIterator2.next()).a(), null);
          x.a(paramContext, localHashSet, new ParticipantSelector.d()
          {
            public void a(ParticipantSelector.Participant paramAnonymous2Participant)
            {
            }

            public void a(boolean paramAnonymous2Boolean, ParticipantSelector.Participant paramAnonymous2Participant)
            {
              x.1.this.b.a(paramAnonymous2Boolean, paramAnonymous2Participant);
            }
          });
        }
      });
  }

  public static void a(Context paramContext, Collection<ParticipantSelector.Participant> paramCollection, ParticipantSelector.d paramd)
  {
    a(paramContext, paramCollection, null, null, a.b, paramd);
  }

  public static void a(Context paramContext, Collection<ParticipantSelector.Participant> paramCollection1, Collection<ParticipantSelector.Participant> paramCollection2, Collection<ParticipantSelector.Participant> paramCollection3, a parama, final ParticipantSelector.d paramd)
  {
    if (paramCollection1.size() == 1)
      paramd.a(false, (ParticipantSelector.Participant)paramCollection1.iterator().next());
    while (paramCollection1.size() <= 1)
      return;
    ParticipantSelector.Participant[] arrayOfParticipant = (ParticipantSelector.Participant[])paramCollection1.toArray(new ParticipantSelector.Participant[paramCollection1.size()]);
    Arrays.sort(arrayOfParticipant, new Comparator()
    {
      public int a(ParticipantSelector.Participant paramAnonymousParticipant1, ParticipantSelector.Participant paramAnonymousParticipant2)
      {
        if (paramAnonymousParticipant1 != null)
          return paramAnonymousParticipant1.getNumber().compareTo(paramAnonymousParticipant2.getNumber());
        return -1;
      }
    });
    boolean[] arrayOfBoolean1 = new boolean[arrayOfParticipant.length];
    final boolean[] arrayOfBoolean2 = new boolean[arrayOfParticipant.length];
    int i = 0;
    int j = arrayOfParticipant.length;
    while (i < j)
    {
      ParticipantSelector.Participant localParticipant2 = arrayOfParticipant[i];
      arrayOfBoolean1[i] = u.a(paramCollection2, localParticipant2);
      arrayOfBoolean2[i] = u.a(paramCollection3, localParticipant2);
      i++;
    }
    c.a locala = new c.a(paramContext).a(R.string.select_viber_number);
    int k = R.drawable.ic_contacts_viber_badge_transparent;
    int m = R.drawable.transparent;
    String[] arrayOfString1 = { "participant", "viberBadge", "checked" };
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = R.id.number;
    arrayOfInt[1] = R.id.call_badge;
    arrayOfInt[2] = R.id.check;
    switch (7.a[parama.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      if (parama == a.c)
        locala.b(R.string.cancel_btn_text, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
          }
        });
      android.support.v7.app.c localc = locala.b();
      localc.setOnShowListener(new DialogInterface.OnShowListener()
      {
        public void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          ListView localListView = ((android.support.v7.app.c)paramAnonymousDialogInterface).a();
          int i = 0;
          if (i < localListView.getChildCount())
          {
            View localView = localListView.getChildAt(i);
            if (this.a[i] == 0);
            for (boolean bool = true; ; bool = false)
            {
              localView.setEnabled(bool);
              i++;
              break;
            }
          }
        }
      });
      localc.show();
      return;
      ArrayList localArrayList = new ArrayList(arrayOfParticipant.length);
      int i2 = arrayOfParticipant.length;
      int i3 = 0;
      if (i3 < i2)
      {
        ParticipantSelector.Participant localParticipant1 = arrayOfParticipant[i3];
        HashMap localHashMap = new HashMap();
        localHashMap.put("participant", localParticipant1.getNumber());
        if (!localParticipant1.isViber())
        {
          localHashMap.put("viberBadge", Integer.valueOf(m));
          label386: if (!u.a(paramCollection2, localParticipant1))
            break label449;
        }
        label449: for (int i4 = R.drawable.ic_compose_check; ; i4 = 0)
        {
          localHashMap.put("checked", Integer.valueOf(i4));
          localArrayList.add(localHashMap);
          i3++;
          break;
          localHashMap.put("viberBadge", Integer.valueOf(k));
          break label386;
        }
      }
      locala.a(new SimpleAdapter(paramContext, localArrayList, R.layout._ics_fragment_contacts_dialog_list_item, arrayOfString1, arrayOfInt), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface.dismiss();
          ParticipantSelector.Participant localParticipant = this.a[paramAnonymousInt];
          if (arrayOfBoolean2[paramAnonymousInt] == 0)
            paramd.a(true, localParticipant);
        }
      });
      continue;
      String[] arrayOfString2 = new String[arrayOfParticipant.length];
      int n = 0;
      int i1 = arrayOfParticipant.length;
      while (n < i1)
      {
        arrayOfString2[n] = arrayOfParticipant[n].getNumber();
        n++;
      }
      locala.a(arrayOfString2, arrayOfBoolean1, new DialogInterface.OnMultiChoiceClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          ParticipantSelector.Participant localParticipant = this.a[paramAnonymousInt];
          if (paramAnonymousBoolean)
            if (arrayOfBoolean2[paramAnonymousInt] == 0)
              paramd.a(true, localParticipant);
          while (true)
          {
            paramAnonymousDialogInterface.dismiss();
            return;
            if (arrayOfBoolean2[paramAnonymousInt] == 0)
              paramd.a(localParticipant);
          }
        }
      });
    }
  }

  public static boolean a(Context paramContext)
  {
    return com.viber.common.permission.c.a(paramContext).a(n.j);
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.x
 * JD-Core Version:    0.6.2
 */