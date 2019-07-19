package com.viber.voip.messages.conversation.publicaccount;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.format.DateUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView.a;
import com.viber.voip.messages.conversation.ui.view.a.a.c;
import com.viber.voip.o.a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class k
{
  private static final Logger a = ViberEnv.getLogger();
  private static volatile boolean c = true;
  private Context b = ViberApplication.getApplication();

  private int a(long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    long l = paramLong2 - paramLong1;
    int i = paramInt1 - paramInt2;
    double d;
    int j;
    label38: int k;
    label50: int m;
    if (paramInt2 != 0)
    {
      d = i / paramInt2;
      if (l < 43200000L)
        break label98;
      j = 1;
      if (d < 0.005D)
        break label104;
      k = 1;
      m = j & k;
      if (TimeUnit.MILLISECONDS.toDays(paramLong1) == TimeUnit.MILLISECONDS.toDays(paramLong2))
        break label110;
    }
    label98: label104: label110: for (int n = 1; ; n = 0)
    {
      if ((n & m) == 0)
        break label116;
      return i;
      d = i;
      break;
      j = 0;
      break label38;
      k = 0;
      break label50;
    }
    label116: return 0;
  }

  public static k a()
  {
    return c.a();
  }

  private String a(int paramInt)
  {
    Resources localResources = this.b.getResources();
    int i = R.string.watchers_increase_alert_today;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    return localResources.getString(i, arrayOfObject);
  }

  private String a(int paramInt, Calendar paramCalendar)
  {
    Resources localResources = this.b.getResources();
    switch (paramCalendar.get(7))
    {
    default:
      int i2 = R.string.watchers_increase_alert_since_sunday;
      Object[] arrayOfObject7 = new Object[1];
      arrayOfObject7[0] = Integer.valueOf(paramInt);
      return localResources.getString(i2, arrayOfObject7);
    case 2:
      int i1 = R.string.watchers_increase_alert_since_monday;
      Object[] arrayOfObject6 = new Object[1];
      arrayOfObject6[0] = Integer.valueOf(paramInt);
      return localResources.getString(i1, arrayOfObject6);
    case 3:
      int n = R.string.watchers_increase_alert_since_tuesday;
      Object[] arrayOfObject5 = new Object[1];
      arrayOfObject5[0] = Integer.valueOf(paramInt);
      return localResources.getString(n, arrayOfObject5);
    case 4:
      int m = R.string.watchers_increase_alert_since_wednesday;
      Object[] arrayOfObject4 = new Object[1];
      arrayOfObject4[0] = Integer.valueOf(paramInt);
      return localResources.getString(m, arrayOfObject4);
    case 5:
      int k = R.string.watchers_increase_alert_since_thursday;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = Integer.valueOf(paramInt);
      return localResources.getString(k, arrayOfObject3);
    case 6:
      int j = R.string.watchers_increase_alert_since_friday;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(paramInt);
      return localResources.getString(j, arrayOfObject2);
    case 7:
    }
    int i = R.string.watchers_increase_alert_since_saturday;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Integer.valueOf(paramInt);
    return localResources.getString(i, arrayOfObject1);
  }

  private String a(long paramLong1, long paramLong2, int paramInt)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    localCalendar2.set(11, 0);
    localCalendar2.set(12, 0);
    localCalendar2.set(13, 0);
    localCalendar2.set(14, 0);
    Calendar localCalendar3 = Calendar.getInstance();
    localCalendar3.setTimeInMillis(localCalendar2.getTimeInMillis());
    localCalendar3.set(6, 0);
    if (paramLong1 > localCalendar2.getTimeInMillis())
      return a(paramInt);
    localCalendar2.setTimeInMillis(localCalendar2.getTimeInMillis() - 86400000L);
    if (paramLong1 > localCalendar2.getTimeInMillis())
      return b(paramInt);
    localCalendar2.setTimeInMillis(localCalendar2.getTimeInMillis() - 86400000L * 5L);
    if (paramLong1 > localCalendar2.getTimeInMillis())
      return a(paramInt, localCalendar1);
    if (paramLong1 > localCalendar3.getTimeInMillis())
      return b(paramInt, localCalendar1);
    return c(paramInt, localCalendar1);
  }

  private String a(Calendar paramCalendar)
  {
    return DateUtils.formatDateTime(this.b, paramCalendar.getTimeInMillis(), 131096);
  }

  private void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, b paramb, d paramd)
  {
    if (paramLong2 <= 0L)
      a(paramLong1, paramInt1, paramLong3);
    int i;
    String str;
    do
    {
      do
      {
        return;
        i = a(paramLong2, paramInt1, paramInt2, paramLong3);
      }
      while (i <= 0);
      str = a(paramLong2, paramLong3, i);
    }
    while (paramb == null);
    paramb.a(i, str);
    if (paramd != null)
      paramd.a();
    a(paramLong1, paramInt1, paramLong3);
  }

  private void a(long paramLong1, int paramInt, long paramLong2)
  {
    ViberApplication.getInstance().getMessagesManager().d().a(paramLong1, paramInt, paramLong2);
  }

  private void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, PublicGroupConversationFragment paramPublicGroupConversationFragment)
  {
    int i = 1;
    int j;
    if (paramPublicGroupConversationItemLoaderEntity.getGroupEnterCount() < 0)
    {
      j = i;
      if (j <= 10)
        break label31;
    }
    label31: 
    do
    {
      do
      {
        return;
        j = 1 + paramPublicGroupConversationItemLoaderEntity.getGroupEnterCount();
        break;
        a(paramPublicGroupConversationItemLoaderEntity, j);
      }
      while ((j != 10) || (paramPublicGroupConversationFragment == null));
      if (paramPublicGroupConversationItemLoaderEntity.isNotShareable())
      {
        a(paramPublicGroupConversationItemLoaderEntity, 1010);
        return;
      }
    }
    while (paramPublicGroupConversationFragment.getActivity() == null);
    int k;
    if ((c) && (!paramPublicGroupConversationFragment.x()) && (((c)paramPublicGroupConversationFragment.aK).g(paramPublicGroupConversationItemLoaderEntity)))
    {
      k = i;
      label104: if ((!c) || (k != 0))
        break label138;
    }
    while (true)
    {
      c = i;
      if (k != 0)
        break;
      a(paramPublicGroupConversationItemLoaderEntity, 9);
      return;
      k = 0;
      break label104;
      label138: i = 0;
    }
  }

  public static void a(boolean paramBoolean)
  {
    c = paramBoolean;
  }

  private boolean a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    return (paramPublicGroupConversationItemLoaderEntity.isPublicGroupType()) && (paramPublicGroupConversationItemLoaderEntity.getGroupRole() != 3);
  }

  private static long b()
  {
    return System.currentTimeMillis();
  }

  private String b(int paramInt)
  {
    Resources localResources = this.b.getResources();
    int i = R.string.watchers_increase_alert_since_yesterday;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    return localResources.getString(i, arrayOfObject);
  }

  private String b(int paramInt, Calendar paramCalendar)
  {
    Resources localResources = this.b.getResources();
    int i = R.string.watchers_increase_alert_since_date;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = a(paramCalendar);
    return localResources.getString(i, arrayOfObject);
  }

  private String b(Calendar paramCalendar)
  {
    return DateUtils.formatDateTime(this.b, paramCalendar.getTimeInMillis(), 131092);
  }

  private String c(int paramInt, Calendar paramCalendar)
  {
    Resources localResources = this.b.getResources();
    int i = R.string.watchers_increase_alert_since_date;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = b(paramCalendar);
    return localResources.getString(i, arrayOfObject);
  }

  public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, int paramInt)
  {
    ViberApplication.getInstance().getMessagesManager().d().a(paramPublicGroupConversationItemLoaderEntity.getGroupId(), paramInt);
  }

  public void a(final b paramb)
  {
    int i = 0;
    long l = System.currentTimeMillis();
    a[] arrayOfa = new a[10];
    arrayOfa[0] = new a(100, 110, l - 3600000L * 13L, l);
    arrayOfa[1] = new a(100, 110, l - 1L * 86400000L, l);
    arrayOfa[2] = new a(100, 110, l - 2L * 86400000L, l);
    arrayOfa[3] = new a(100, 110, l - 3L * 86400000L, l);
    arrayOfa[4] = new a(100, 110, l - 4L * 86400000L, l);
    arrayOfa[5] = new a(100, 110, l - 5L * 86400000L, l);
    arrayOfa[6] = new a(100, 110, l - 6L * 86400000L, l);
    arrayOfa[7] = new a(100, 110, l - 7L * 86400000L, l);
    arrayOfa[8] = new a(100, 110, l - 8L * 86400000L, l);
    arrayOfa[9] = new a(100, 110, l - 365L * 86400000L, l);
    new SimpleDateFormat("EEE dd.MM.yyyy HH:mm:ss", Locale.getDefault());
    int j = arrayOfa.length;
    for (int k = 0; k < j; k++)
    {
      final a locala = arrayOfa[k];
      av.a(av.e.a).postDelayed(new Runnable()
      {
        public void run()
        {
          ((ConversationAlertView)paramb).a(ConversationAlertView.a.b, true);
          k.a(k.this, 1L, locala.b, locala.a, locala.c, locala.d, paramb, null);
        }
      }
      , i * 2000);
      i++;
    }
  }

  public void a(b paramb, PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, PublicGroupConversationFragment paramPublicGroupConversationFragment, d paramd)
  {
    if (paramPublicGroupConversationItemLoaderEntity != null)
    {
      if (paramPublicGroupConversationItemLoaderEntity.isPublicGroupType())
        a(paramPublicGroupConversationItemLoaderEntity, paramPublicGroupConversationFragment);
      if (a(paramPublicGroupConversationItemLoaderEntity))
        a(paramPublicGroupConversationItemLoaderEntity.getGroupId(), paramPublicGroupConversationItemLoaderEntity.getWatchersCount(), paramPublicGroupConversationItemLoaderEntity.getWatchersCountRef(), paramPublicGroupConversationItemLoaderEntity.getWatchersCountRefDate(), b(), paramb, paramd);
    }
  }

  class a
  {
    int a;
    int b;
    long c;
    long d;

    a(int paramInt1, int paramLong1, long arg4, long arg6)
    {
      this.a = paramInt1;
      this.b = paramLong1;
      this.c = ???;
      Object localObject;
      this.d = localObject;
    }
  }

  public static abstract interface b
  {
    public abstract void a(int paramInt, String paramString);
  }

  private static final class c
  {
    private static final k a;

    static
    {
      if (a.a() == a.a);
      for (k localk = new k(null); ; localk = null)
      {
        a = localk;
        return;
      }
    }
  }

  public static abstract interface d
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.publicaccount.k
 * JD-Core Version:    0.6.2
 */