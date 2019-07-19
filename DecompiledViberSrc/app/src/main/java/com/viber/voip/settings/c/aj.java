package com.viber.voip.settings.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.j.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.plurals;
import com.viber.voip.R.string;
import com.viber.voip.R.style;
import com.viber.voip.ViberEnv;
import com.viber.voip.apps.model.AuthInfo;
import com.viber.voip.invitelinks.CommunityFollowerData;
import com.viber.voip.messages.orm.entity.json.action.OpenUrlAction;
import com.viber.voip.notif.g;
import com.viber.voip.registration.RegistrationReminderMessageReceiver;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.ad.a;
import com.viber.voip.settings.ui.DebugVideoAdActivity;
import com.viber.voip.settings.ui.x.a;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.ae;
import com.viber.voip.ui.dialogs.af;
import com.viber.voip.ui.dialogs.ag;
import com.viber.voip.ui.dialogs.ah;
import com.viber.voip.ui.dialogs.ai;
import com.viber.voip.ui.dialogs.c;
import com.viber.voip.ui.dialogs.d;
import com.viber.voip.ui.dialogs.e;
import com.viber.voip.ui.dialogs.f;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.ui.dialogs.l;
import com.viber.voip.ui.dialogs.n;
import com.viber.voip.ui.dialogs.o;
import com.viber.voip.ui.dialogs.p;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.ui.dialogs.s;
import com.viber.voip.ui.dialogs.t;
import com.viber.voip.util.ViberActionRunner.bg;
import com.viber.voip.util.ViberActionRunner.h;
import com.viber.voip.util.ab;
import com.viber.voip.util.bz;
import com.viber.voip.util.cl;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aj extends m
{
  private static final Logger b = ViberEnv.getLogger();
  private static final Class[] c = { com.viber.voip.ui.dialogs.a.class, f.class, com.viber.voip.ui.dialogs.b.class, e.class, k.class, l.class, com.viber.voip.ui.dialogs.m.class, n.class, o.class, p.class, r.class, s.class, t.class, com.viber.voip.ui.dialogs.u.class, ad.class, af.class, ag.class, ah.class, ai.class, com.viber.voip.ui.dialogs.h.class, ae.class, d.class, c.class, com.viber.voip.ui.dialogs.j.class };
  private static final SparseArray<String> d = new SparseArray();
  private Map<String, Method> e = new TreeMap();
  private Context f;
  private final Activity g;
  private final Fragment h;
  private View i;
  private final Map<String, Object[][]> j = new HashMap();
  private final Set<String> k = new HashSet();
  private final Set<String> l = new HashSet();
  private final List<String> m = new ArrayList();
  private final Map<String, b> n = new HashMap();
  private final com.viber.voip.notif.e.m o;

  static
  {
    d.put(4, "QR Code scanner");
    d.put(7, "Take photo (only camera)");
    d.put(14, "Take photo (camera & storage)");
    d.put(25, "Record video");
    d.put(26, "Record PTT");
    d.put(27, "Record IVM");
    d.put(28, "Video call");
    d.put(49, "Voice call");
    d.put(55, "Emergency call");
    d.put(40, "Viber Out call");
    d.put(75, "Contacts");
    d.put(64, "Send location");
    d.put(66, "Attach location to message");
    d.put(67, "Get location for web request");
    d.put(65, "Choose location for PA");
    d.put(68, "Search PA");
    d.put(109, "Access storage");
    d.put(115, "Email message history (contacts & storage)");
    d.put(141, "Generic permission request");
  }

  public aj(Context paramContext1, Context paramContext2, PreferenceScreen paramPreferenceScreen, Activity paramActivity, Fragment paramFragment, com.viber.voip.notif.e.m paramm)
  {
    super(paramContext1, paramPreferenceScreen);
    this.f = paramContext2;
    this.g = paramActivity;
    this.h = paramFragment;
    this.o = paramm;
    h();
    i();
  }

  private Field a(Class<?> paramClass, String paramString)
  {
    Field localField = null;
    do
      try
      {
        localField = paramClass.getDeclaredField(paramString);
        if (localField != null)
        {
          if (Modifier.isPrivate(localField.getModifiers()))
            localField.setAccessible(true);
          return localField;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        do
          paramClass = paramClass.getSuperclass();
        while (paramClass == null);
      }
    while (paramClass != Object.class);
    return localField;
  }

  private void a(String paramString1, String paramString2)
  {
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, paramString1, paramString2).a(this).a());
  }

  private Object[] a(String paramString, Class[] paramArrayOfClass)
  {
    int i1 = 0;
    Matcher localMatcher = Pattern.compile("(.*) \\[version_(\\d+)\\]").matcher(paramString);
    if (localMatcher.find())
      paramString = localMatcher.group(1);
    for (int i2 = bz.a(localMatcher.group(2), 0); ; i2 = 0)
    {
      if (!this.j.containsKey(paramString))
        return a(paramArrayOfClass);
      Object[][] arrayOfObject = (Object[][])this.j.get(paramString);
      int i3 = arrayOfObject.length;
      Object[] arrayOfObject1 = new Object[i3];
      while (i1 < i3)
      {
        arrayOfObject1[i1] = arrayOfObject[i1][i2];
        i1++;
      }
      return arrayOfObject1;
    }
  }

  private Object[] a(Class[] paramArrayOfClass)
  {
    Object[] arrayOfObject = new Object[paramArrayOfClass.length];
    int i1 = 0;
    if (i1 < arrayOfObject.length)
    {
      Class localClass = paramArrayOfClass[i1];
      if ((localClass == String.class) || (localClass == CharSequence.class))
        arrayOfObject[i1] = "<text param>";
      while (true)
      {
        i1++;
        break;
        if ((localClass == Integer.TYPE) || (localClass == Long.TYPE))
          arrayOfObject[i1] = Integer.valueOf(0);
        else if (localClass == Boolean.TYPE)
          arrayOfObject[i1] = Boolean.valueOf(true);
        else
          try
          {
            arrayOfObject[i1] = localClass.newInstance();
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            localIllegalAccessException.printStackTrace();
            arrayOfObject[i1] = null;
          }
          catch (InstantiationException localInstantiationException)
          {
            localInstantiationException.printStackTrace();
            arrayOfObject[i1] = null;
          }
      }
    }
    return arrayOfObject;
  }

  private void b(Preference paramPreference)
  {
    Context localContext = paramPreference.I();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
    StringBuilder localStringBuilder = new StringBuilder();
    long l1 = System.currentTimeMillis();
    localStringBuilder.append("Current time: ").append(localSimpleDateFormat.format(Long.valueOf(l1))).append("\n\n");
    localStringBuilder.append("User 'A' with time: ").append(localSimpleDateFormat.format(Long.valueOf(l1))).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, true, l1)).append("\n\n");
    Date localDate1 = new ab().f(15).a();
    localStringBuilder.append("User 'A' with time: ").append(localSimpleDateFormat.format(localDate1)).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, false, localDate1.getTime())).append("\n\n");
    Date localDate2 = new ab().f(1).a();
    localStringBuilder.append("User 'A' with time: ").append(localSimpleDateFormat.format(localDate2)).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, false, localDate2.getTime())).append("\n\n");
    Date localDate3 = new ab().f(59).a();
    localStringBuilder.append("User 'A' with time: ").append(localSimpleDateFormat.format(localDate3)).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, false, localDate3.getTime())).append("\n\n");
    Date localDate4 = new ab(0, 0).a(0).g(29).a();
    Date localDate5 = new ab(11, 59).a(1).c(1).g(30).a();
    localStringBuilder.append("Your time is: ").append(localSimpleDateFormat.format(localDate4)).append("\n").append("User 'A' with time: ").append(localSimpleDateFormat.format(localDate5)).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, false, localDate5.getTime(), localDate4.getTime())).append("\n\n");
    Date localDate6 = new ab().e(3).a();
    localStringBuilder.append("User 'A' with time: ").append(localSimpleDateFormat.format(localDate6)).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, false, localDate6.getTime())).append("\n\n");
    Date localDate7 = new ab().e(1).f(1).a();
    localStringBuilder.append("User 'A' with time: ").append(localSimpleDateFormat.format(localDate7)).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, false, localDate7.getTime())).append("\n\n");
    Date localDate8 = new ab().e(59).a();
    localStringBuilder.append("User 'A' with time: ").append(localSimpleDateFormat.format(localDate8)).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, false, localDate8.getTime())).append("\n\n");
    Date localDate9 = new ab().d(3).e(13).a();
    localStringBuilder.append("User 'A' with time: ").append(localSimpleDateFormat.format(localDate9)).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, false, localDate9.getTime())).append("\n\n");
    Date localDate10 = new ab(1, 2).a(0).a();
    Date localDate11 = new ab(localDate10).a(0).d(1).e(1).a();
    localStringBuilder.append("Your time is: ").append(localSimpleDateFormat.format(localDate10)).append("\n").append("User 'A' with time: ").append(localSimpleDateFormat.format(localDate11)).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, false, localDate11.getTime(), localDate10.getTime())).append("\n\n");
    Date localDate12 = new ab(11, 59).a(1).a();
    Date localDate13 = new ab(0, 1).a(0).a();
    localStringBuilder.append("Your time is: ").append(localSimpleDateFormat.format(localDate12)).append("\n").append("User 'A' with time: ").append(localSimpleDateFormat.format(localDate13)).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, false, localDate13.getTime(), localDate12.getTime())).append("\n\n");
    Date localDate14 = new ab().c(1).d(2).e(4).a();
    localStringBuilder.append("User 'A' with time: ").append(localSimpleDateFormat.format(localDate14)).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, false, localDate14.getTime())).append("\n\n");
    Date localDate15 = new ab().c(1).a();
    localStringBuilder.append("User 'A' with time: ").append(localSimpleDateFormat.format(localDate15)).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, false, localDate15.getTime())).append("\n\n");
    Date localDate16 = new ab(11, 59).a(0).a();
    Date localDate17 = new ab(0, 1).a(0).c(1).a();
    localStringBuilder.append("Your time is: ").append(localSimpleDateFormat.format(localDate16)).append("\n").append("User 'A' with time: ").append(localSimpleDateFormat.format(localDate17)).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, false, localDate17.getTime(), localDate16.getTime())).append("\n\n");
    Date localDate18 = new ab().c(20).a();
    localStringBuilder.append("User 'A' with time: ").append(localSimpleDateFormat.format(localDate18)).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, false, localDate18.getTime())).append("\n\n");
    Date localDate19 = new ab(11, 59).a(1).a();
    Date localDate20 = new ab(localDate19).c(2).a();
    localStringBuilder.append("Your time is: ").append(localSimpleDateFormat.format(localDate19)).append("\n").append("User 'A' with time: ").append(localSimpleDateFormat.format(localDate20)).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, false, localDate20.getTime(), localDate19.getTime())).append("\n\n");
    Date localDate21 = new ab(11, 59).a(1).a();
    Date localDate22 = new ab(localDate21).c(29).a();
    localStringBuilder.append("Your time is: ").append(localSimpleDateFormat.format(localDate21)).append("\n").append("User 'A' with time: ").append(localSimpleDateFormat.format(localDate22)).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, false, localDate22.getTime(), localDate21.getTime())).append("\n\n");
    Date localDate23 = new ab().b(1).a();
    localStringBuilder.append("User 'A' with time: ").append(localSimpleDateFormat.format(localDate23)).append("\n").append("has status: ").append(com.viber.voip.util.x.a(localContext, false, localDate23.getTime())).append("\n\n");
    ((h.a)((h.a)com.viber.common.dialogs.h.j().c("Last online")).a(localStringBuilder.toString())).a(this.f);
  }

  private CharSequence c(String paramString)
  {
    Matcher localMatcher = Pattern.compile("(.*) \\[version_(\\d+)\\]").matcher(paramString);
    if (localMatcher.find())
      paramString = localMatcher.group(1);
    for (int i1 = bz.a(localMatcher.group(2), 0); ; i1 = 0)
    {
      boolean bool = this.l.contains(paramString);
      if (!this.n.containsKey(paramString))
      {
        if (bool)
          return da.a(this.f, paramString, 0, new Object[0]);
        return da.a(this.f, paramString, new Object[0]);
      }
      b localb = (b)this.n.get(paramString);
      Object[][] arrayOfObject = b.a(localb);
      int i2 = arrayOfObject.length;
      int i3;
      Object[] arrayOfObject1;
      int i5;
      if (bool)
      {
        i3 = 1;
        int i4 = i2 - i3;
        arrayOfObject1 = new Object[i4];
        i5 = 0;
        label143: if (i5 >= i4)
          break label191;
        if (!bool)
          break label185;
      }
      label185: for (int i6 = 1; ; i6 = 0)
      {
        arrayOfObject1[i5] = arrayOfObject[(i6 + i5)][i1];
        i5++;
        break label143;
        i3 = 0;
        break;
      }
      label191: if (bool);
      for (Object localObject = da.a(this.f, paramString, ((Integer)arrayOfObject[0][i1]).intValue(), arrayOfObject1); ; localObject = da.a(this.f, paramString, arrayOfObject1))
      {
        if (b.b(localb))
          localObject = Html.fromHtml((String)localObject);
        return localObject;
      }
    }
  }

  private void d()
  {
    Class[] arrayOfClass = c;
    int i1 = arrayOfClass.length;
    for (int i2 = 0; i2 < i1; i2++)
      for (Method localMethod : arrayOfClass[i2].getDeclaredMethods())
        if ((0x1 & localMethod.getModifiers()) > 0)
        {
          String str1 = localMethod.getName();
          if (this.j.containsKey(str1))
          {
            Object[][] arrayOfObject = (Object[][])this.j.get(str1);
            if (arrayOfObject[0].length > 1)
              for (int i5 = 0; i5 < arrayOfObject.length; i5++)
              {
                Locale localLocale = Locale.US;
                Object[] arrayOfObject1 = new Object[2];
                arrayOfObject1[0] = str1;
                arrayOfObject1[1] = Integer.valueOf(i5);
                String str2 = String.format(localLocale, "%s [version_%d]", arrayOfObject1);
                this.e.put(str2, localMethod);
              }
          }
          this.e.put(str1, localMethod);
        }
    String[] arrayOfString = (String[])new ArrayList(this.e.keySet()).toArray(new String[this.e.size()]);
    f(new com.viber.voip.settings.ui.x(this.a, x.a.b, "dialog_name", "Select dialog").a("Select dialog ID to display").a(arrayOfString).b(arrayOfString).a(this).a());
  }

  private void e()
  {
    int i1 = d.size();
    String[] arrayOfString1 = new String[i1];
    String[] arrayOfString2 = new String[i1];
    for (int i2 = 0; i2 < i1; i2++)
    {
      int i3 = d.keyAt(i2);
      arrayOfString2[i2] = String.valueOf(i3);
      arrayOfString1[i2] = ((String)d.get(i3));
    }
    f(new com.viber.voip.settings.ui.x(this.a, x.a.b, "permission_dialog_name", "Select permissions dialog (explain dialog)").a("Select dialog ID to display").a(arrayOfString1).b(arrayOfString2).a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.b, "ask_permission_dialog_name", "Select permissions dialog (ask dialog)").a("Select dialog ID to display").a(arrayOfString1).b(arrayOfString2).a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "draw_over_other_app_dialog_name", "Show draw over other app dialog").a(this).a());
  }

  private void f()
  {
    String str = "anonymous_chat_spam_banner_description_with_common_communities:\n" + this.f.getString(R.string.anonymous_chat_spam_banner_description_with_common_communities) + "\n\nanonymous_chat_spam_banner_description_without_common_communities:\n" + this.f.getString(R.string.anonymous_chat_spam_banner_description_without_common_communities);
    ((h.a)((h.a)com.viber.common.dialogs.h.j().c("Anonymous spam banner strings")).a(str)).a(this.f);
  }

  private void g()
  {
  }

  private void h()
  {
    this.j.put("d" + DialogCode.D620.code(), new Object[][] { { "Server error. <a href=\"viber.com\">Viber.com</a>" } });
    Map localMap1 = this.j;
    String str1 = "d" + DialogCode.D1101.code();
    Object[][] arrayOfObject;1 = new Object[2][];
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Integer.valueOf(1);
    arrayOfObject1[1] = Integer.valueOf(3);
    arrayOfObject;1[0] = arrayOfObject1;
    arrayOfObject;1[1] = { "Joe", "Mark, Edison, Alex" };
    localMap1.put(str1, arrayOfObject;1);
    Map localMap2 = this.j;
    String str2 = "d" + DialogCode.D1102.code();
    Object[][] arrayOfObject;2 = new Object[2][];
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Integer.valueOf(1);
    arrayOfObject2[1] = Integer.valueOf(3);
    arrayOfObject;2[0] = arrayOfObject2;
    arrayOfObject;2[1] = { "Joe", "Mark, Tom, Alex" };
    localMap2.put(str2, arrayOfObject;2);
    this.j.put("d" + DialogCode.D1105.code(), new Object[][] { { "Mark, Emmy, Alex" } });
    Map localMap3 = this.j;
    String str3 = "d" + DialogCode.D1400.code();
    Object[][] arrayOfObject;3 = new Object[1][];
    Object[] arrayOfObject3 = new Object[1];
    arrayOfObject3[0] = new OpenUrlAction("https://viber.com");
    arrayOfObject;3[0] = arrayOfObject3;
    localMap3.put(str3, arrayOfObject;3);
    Map localMap4 = this.j;
    Object[][] arrayOfObject;4 = new Object[1][];
    Object[] arrayOfObject4 = new Object[1];
    arrayOfObject4[0] = Integer.valueOf(R.string.generic_please_wait_dialog_text);
    arrayOfObject;4[0] = arrayOfObject4;
    localMap4.put("progressDialog", arrayOfObject;4);
    Map localMap5 = this.j;
    Object[][] arrayOfObject;5 = new Object[2][];
    Object[] arrayOfObject5 = new Object[1];
    arrayOfObject5[0] = Integer.valueOf(com.viber.voip.backup.a.d.d());
    arrayOfObject;5[0] = arrayOfObject5;
    Object[] arrayOfObject6 = new Object[1];
    arrayOfObject6[0] = com.viber.voip.backup.a.e();
    arrayOfObject;5[1] = arrayOfObject6;
    localMap5.put("selectAutoBackupPeriod", arrayOfObject;5);
  }

  private void i()
  {
    this.n.put("conversation_group_call_tooltip_text", new b(new Object[][] { { "Team Meeting" } }, false, null));
    Map localMap1 = this.n;
    Object[][] arrayOfObject;1 = new Object[2][];
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Integer.valueOf(1);
    arrayOfObject1[1] = Integer.valueOf(3);
    arrayOfObject;1[0] = arrayOfObject1;
    arrayOfObject;1[1] = { "Scott", "Mark" };
    localMap1.put("plural_msg_group_call_incoming", new b(arrayOfObject;1, true, null));
    Map localMap2 = this.n;
    Object[][] arrayOfObject;2 = new Object[2][];
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Integer.valueOf(1);
    arrayOfObject2[1] = Integer.valueOf(3);
    arrayOfObject;2[0] = arrayOfObject2;
    arrayOfObject;2[1] = { "Monica", "Mark" };
    localMap2.put("plural_msg_group_call_missed", new b(arrayOfObject;2, true, null));
    this.n.put("and_items", new b(new Object[][] { { "Scott, Tor, Michael" } }, false, null));
    this.n.put("invited_you_to_call", new b(new Object[][] { { "Michael" } }, false, null));
    this.n.put("with_items", new b(new Object[][] { { "Scott, Jo, Michael" } }, false, null));
    this.n.put("invited_you_to_call_with", new b(new Object[][] { { "Cassandra" }, { "Scott, Jo, Michael, Tom" } }, false, null));
    this.n.put("ongoing_call_with", new b(new Object[][] { { "Paul, Jo, Michael, Tom" } }, false, null));
    this.n.put("send_update_link_no_calls_support_text", new b(new Object[][] { { "Pikachu" } }, false, null));
  }

  private void j()
  {
    com.viber.common.dialogs.a.b().a(false).e(17367060).a(new a(null)).a(this.f);
  }

  private void k()
  {
    am localam = new am(ak.a, al.a);
    this.k.clear();
    this.k.addAll(com.viber.voip.util.u.a(cl.a(R.string.class), localam));
    this.l.clear();
    this.l.addAll(com.viber.voip.util.u.a(cl.a(R.plurals.class), localam));
    Collection[] arrayOfCollection = new Collection[2];
    arrayOfCollection[0] = this.k;
    arrayOfCollection[1] = this.l;
    Set localSet = com.viber.voip.util.u.a(arrayOfCollection);
    this.m.clear();
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (this.n.containsKey(str1))
      {
        Object[][] arrayOfObject = b.a((b)this.n.get(str1));
        if (arrayOfObject[0].length > 1)
          for (int i1 = 0; i1 < arrayOfObject.length; i1++)
          {
            Locale localLocale = Locale.US;
            Object[] arrayOfObject1 = new Object[2];
            arrayOfObject1[0] = str1;
            arrayOfObject1[1] = Integer.valueOf(i1);
            String str2 = String.format(localLocale, "%s [version_%d]", arrayOfObject1);
            this.m.add(str2);
          }
      }
      else
      {
        this.m.add(str1);
      }
    }
    Collections.sort(this.m);
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "select_string_from_resources", "Explore strings from resources").a("Show a particular string via toast message").a(this).a());
  }

  private void l()
  {
    if (this.g == null);
    final ViewGroup localViewGroup;
    do
    {
      do
      {
        return;
        localViewGroup = (ViewGroup)this.h.getView();
      }
      while (localViewGroup == null);
      if (this.i == null)
        this.i = this.h.getLayoutInflater().inflate(R.layout.fragment_phone_end_vo_blocked_call, localViewGroup, false);
    }
    while (dj.a(this.i, localViewGroup));
    localViewGroup.addView(this.i);
    this.i.findViewById(R.id.close_admob_btn).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localViewGroup.removeView(aj.c(aj.this));
      }
    });
  }

  protected void a()
  {
    k();
    d();
    e();
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "show_gallery_album_msg_key", "Show gallery_empty_album_message").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "show_cam_failed_to_record_video_key", "Show 'Failed to record video' toast").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "show_cam_failed_to_save_video_key", "Show 'Failed to save video' toast").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "show_cam_failed_to_start_camera_key", "Show 'Failed to start camera' toast").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "show_cam_unable_to_open_camera_key", "Show 'Unable to open camera' toast").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "show_cam_unknown_error_key", "Show 'Camera unknown error' toast").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "show_cam_unable_to_use_camera_key", "Show 'Unable to use camera' toast").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "show_cam_debug_problems_toast", "Show 'We are experiencing problems with camera service' toast").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "pa_info_show_subscribe_dialog_error", "Show change subscription error toast").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "show_viber_account_manager_connect_screen", "Show VAM connect Screen").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "registration_reminder_message_1_step", "Activation reminder (1 step)").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "registration_reminder_message_2_steps", "Activation reminder (2 step)").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "custom_cam_media_cannot_save_to_gallery", "Save failed").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "public_group_share_banner_body", "Show public group share banner body").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "keyboard_extension_first_time_experience", "Show keyboard extension tooltip").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "last_online_strings", "Show last online strings").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "oops_dialog_while_changing_phone_number", "Oops dialog: while changing phone number").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "pa_changed_attributes_notif", "PA: notification about changed attributes").a(this).a());
    a("chat_ex_v3_dialog_2116_no_bot", "ChatExV3: dialog 2116 (no bot)");
    a("chat_ex_v3_dialog_2116_Spotify_bot", "ChatExV3: dialog 2116 (Spotify)");
    a("chat_ex_v3_share_location_no_bot", "ChatExV3: share location banner text (no bot)");
    a("chat_ex_v3_share_location_Spotify_bot", "ChatExV3: share location banner text (Spotify)");
    a("chat_ex_v3_internal_browser_forward_action", "ChatExV3: browser forward action text");
    a("chat_ex_v4_show_awareness_tooltip_Youtube", "ChatExV4: show awareness tooltip (Youtube)");
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "show_reply_error_dialog", "Show reply error Dialog (533)").a(this).a());
    a("debug_open_auto_backup_promo_screen", "Open Auto Backup Promo screen");
    a("debug_open_restore_after_registration", "Show restore after registration screen");
    a("debug_pref_show_video_ad_screen", "Show video ad screen");
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "show_subscriptions_restored_key", "Show subscriptions restored").a(this).a());
    f(new com.viber.voip.settings.ui.x(this.a, x.a.a, "show_stickers_restored_key", "Show stickers restored").a(this).a());
    a("show_purchase_processing_key", "Show 'Payment is processing…'");
    a("show_purchase_completed_key", "Show 'Purchase completed'");
    a("anonymous_chat_spam_banner_key", "Anonymous chat: spam banner strings");
    a("vo_blocked_user_screen", "VO blocked user: screen");
    f(new com.viber.voip.settings.ui.x(this.a, x.a.c, d.ad.a.d.c(), "Force show Burmese viber language").a("Burmese is normally hidden from viber language list below Android 6, enable this to always show").a(Boolean.valueOf(d.ad.a.d.f())).a());
    if (!ao.f())
      a("show_secondary_activation_notification_key", "Show secondary activation notification");
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("localization_tests_key");
    paramPreferenceGroup.c("Localization Tests (Debug option)");
  }

  public boolean a(Preference paramPreference)
  {
    String str1 = paramPreference.C();
    if (str1.equals("show_gallery_album_msg_key"))
    {
      Toast.makeText(this.a, R.string.gallery_empty_album_message, 0).show();
      return true;
    }
    if (str1.equals("show_cam_failed_to_record_video_key"))
    {
      Toast.makeText(this.a, R.string.cam_error_notice_failed_to_record_video, 0).show();
      return true;
    }
    if (str1.equals("show_cam_failed_to_save_video_key"))
    {
      Toast.makeText(this.a, R.string.cam_error_notice_failed_to_save_video_file, 0).show();
      return true;
    }
    if (str1.equals("show_cam_failed_to_start_camera_key"))
    {
      Toast.makeText(this.a, R.string.cam_error_notice_failed_to_start_camera_preview, 0).show();
      return true;
    }
    if (str1.equals("show_cam_unable_to_open_camera_key"))
    {
      Toast.makeText(this.a, R.string.cam_error_notice_unable_to_open_camera, 0).show();
      return true;
    }
    if (str1.equals("show_cam_unknown_error_key"))
    {
      Toast.makeText(this.a, R.string.cam_error_notice_video_error_unknown, 0).show();
      return true;
    }
    if (str1.equals("show_cam_unable_to_use_camera_key"))
    {
      Toast.makeText(this.a, R.string.custom_cam_unable_to_use_camera, 0).show();
      return true;
    }
    if (str1.equals("show_cam_debug_problems_toast"))
      Toast.makeText(this.a, R.string.debug_problems_with_camera, 1).show();
    do
    {
      while (true)
      {
        return false;
        if (str1.equals("pa_info_show_subscribe_dialog_error"))
        {
          Toast.makeText(this.a, R.string.public_group_info_unable_to_update_subscription_status, 1).show();
          return true;
        }
        if (str1.equals("show_viber_account_manager_connect_screen"))
        {
          AuthInfo localAuthInfo = new AuthInfo();
          localAuthInfo.setAuthType(1);
          localAuthInfo.setAppId(903);
          ViberActionRunner.bg.a(this.a, localAuthInfo);
          return true;
        }
        if (str1.equals("registration_reminder_message_1_step"))
        {
          String str3 = RegistrationReminderMessageReceiver.a(this.a, 0);
          if (str3 != null)
            this.o.a(str3, false);
          Toast.makeText(this.a, R.string.registration_reminder_message_1_step, 0).show();
          return true;
        }
        if (str1.equals("registration_reminder_message_2_steps"))
        {
          String str2 = RegistrationReminderMessageReceiver.a(this.a, 4);
          if (str2 != null)
            this.o.a(str2, false);
          Toast.makeText(this.a, R.string.registration_reminder_message_2_steps, 0).show();
          return true;
        }
        if (str1.equals("custom_cam_media_cannot_save_to_gallery"))
        {
          Toast.makeText(this.a, R.string.custom_cam_media_cannot_save_to_gallery, 0).show();
          return true;
        }
        if (str1.equals("public_group_share_banner_body"))
        {
          Toast.makeText(this.a, R.string.public_group_share_banner_body, 0).show();
          return true;
        }
        if (str1.equals("keyboard_extension_first_time_experience"))
        {
          Toast.makeText(this.a, R.string.keyboard_extension_first_time_experience, 0).show();
          return true;
        }
        if (str1.equals("last_online_strings"))
        {
          b(paramPreference);
          return true;
        }
        if ("oops_dialog_while_changing_phone_number".equals(str1))
        {
          h.a locala = k.n();
          int i2 = R.string.dialog_339_message_with_reason;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = this.f.getString(R.string.dialog_339_reason_change_phone_number);
          locala.b(i2, arrayOfObject).a(this.f);
        }
        else if ("pa_changed_attributes_notif".equals(str1))
        {
          ArrayList localArrayList = new ArrayList();
          for (int i1 = 1; i1 <= 3; i1++)
          {
            localArrayList.add(new com.viber.voip.model.entity.q(1L, "pa_uri", "PA: Localization Test", i1, true));
            localArrayList.add(new com.viber.voip.model.entity.q(2L, "pa_uri_1", "PA: Localization Test", i1, false));
          }
          g.a(this.a).a().a(localArrayList);
        }
        else
        {
          if ("chat_ex_v3_dialog_2116_no_bot".equals(str1))
          {
            r.a(null, null).a((Parcelable)null).a((m.a)null).d();
            return true;
          }
          if ("chat_ex_v3_dialog_2116_Spotify_bot".equals(str1))
          {
            r.a("Spotify", null).a((Parcelable)null).a((m.a)null).d();
            return true;
          }
          if ("chat_ex_v3_share_location_no_bot".equals(str1))
          {
            Toast.makeText(this.a, R.string.share_location_with_pa_banner_message_regular, 1).show();
            return true;
          }
          if ("chat_ex_v3_share_location_Spotify_bot".equals(str1))
          {
            Toast.makeText(this.a, this.a.getString(R.string.share_location_with_pa_banner_message, new Object[] { "Spotify" }), 1).show();
            return true;
          }
          if ("chat_ex_v3_internal_browser_forward_action".equals(str1))
          {
            Toast.makeText(this.a, R.string.forward_action, 1).show();
            return true;
          }
          if ("show_reply_error_dialog".equals(str1))
          {
            p.b().d();
          }
          else if (str1.equals("draw_over_other_app_dialog_name"))
          {
            com.viber.voip.ui.dialogs.q.c().d();
          }
          else if (str1.equals("debug_open_auto_backup_promo_screen"))
          {
            ViberActionRunner.h.b(this.a);
          }
          else if (str1.equals("debug_open_restore_after_registration"))
          {
            g();
          }
          else
          {
            if (!str1.equals("debug_pref_show_video_ad_screen"))
              break;
            DebugVideoAdActivity.a(this.a);
          }
        }
      }
      if (str1.equals("show_subscriptions_restored_key"))
      {
        Toast.makeText(this.a, R.string.restore_msg_subscriptions_restored, 0).show();
        return true;
      }
      if (str1.equals("show_stickers_restored_key"))
      {
        Toast.makeText(this.a, R.string.restore_msg_stickers_restored, 0).show();
        return true;
      }
      if (str1.equals("show_purchase_processing_key"))
      {
        ProgressDialog localProgressDialog = new ProgressDialog(this.a, R.style.ProgressDialogStyle);
        localProgressDialog.setMessage(this.a.getString(R.string.purchase_processing));
        localProgressDialog.setIndeterminate(true);
        localProgressDialog.setCancelable(true);
        localProgressDialog.show();
        return true;
      }
      if (str1.equals("show_purchase_completed_key"))
      {
        af.a(null, false, true).d();
        return true;
      }
      if (str1.equals("select_string_from_resources"))
      {
        j();
        return true;
      }
      if (str1.equals("anonymous_chat_spam_banner_key"))
      {
        f();
        return true;
      }
      if (str1.equals("vo_blocked_user_screen"))
      {
        l();
        return true;
      }
    }
    while (!str1.equals("show_secondary_activation_notification_key"));
    this.o.d();
    return true;
  }

  public boolean a(Preference paramPreference, Object paramObject)
  {
    a.a locala1;
    if (paramPreference.C().equals("dialog_name"))
    {
      Field localField;
      try
      {
        localMethod = (Method)this.e.get(paramObject);
        str = (String)paramObject;
        if (str.startsWith("d" + DialogCode.D307.code()))
        {
          String[] arrayOfString = { "video", "image", "file", "sound", "gif" };
          final int[] arrayOfInt = { 3, 1, 10, 2, 1005 };
          j.a locala = com.viber.common.dialogs.j.m();
          locala.c("choose file type");
          locala.a(arrayOfString);
          locala.a(false);
          locala.a(new m.a()
          {
            public void onDialogListAction(com.viber.common.dialogs.m paramAnonymousm, int paramAnonymousInt)
            {
              super.onDialogListAction(paramAnonymousm, paramAnonymousInt);
              try
              {
                Method localMethod = localMethod;
                Class localClass = localMethod.getDeclaringClass();
                Object[] arrayOfObject = new Object[1];
                arrayOfObject[0] = Integer.valueOf(arrayOfInt[paramAnonymousInt]);
                ((a.a)localMethod.invoke(localClass, arrayOfObject)).d();
                return;
              }
              catch (IllegalAccessException localIllegalAccessException)
              {
                localIllegalAccessException.printStackTrace();
                return;
              }
              catch (InvocationTargetException localInvocationTargetException)
              {
                localInvocationTargetException.printStackTrace();
              }
            }
          });
          locala.a(this.f);
        }
        else if (str.startsWith("d" + DialogCode.D2113.code()))
        {
          ((a.a)localMethod.invoke(localMethod.getDeclaringClass(), new Object[0])).a(false).a(new m.a()
          {
            public void onPrepareDialogView(com.viber.common.dialogs.m paramAnonymousm, View paramAnonymousView, int paramAnonymousInt)
            {
              TextView localTextView = (TextView)paramAnonymousView.findViewById(R.id.body);
              localTextView.setText(Html.fromHtml(localTextView.getText().toString()));
            }
          }).a(this.f);
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        localInvocationTargetException.printStackTrace();
        return false;
        if (str.equals("verifyAccountForCpn"))
        {
          m.a local3 = new m.a()
          {
            @SuppressLint({"SetTextI18n"})
            public void onPrepareDialogView(com.viber.common.dialogs.m paramAnonymousm, View paramAnonymousView, int paramAnonymousInt)
            {
              paramAnonymousView.findViewById(R.id.select_current_account).setClickable(true);
              paramAnonymousView.findViewById(R.id.select_other_account).setClickable(true);
              ImageView localImageView1 = (ImageView)paramAnonymousView.findViewById(R.id.current_account_icon);
              TextView localTextView1 = (TextView)paramAnonymousView.findViewById(R.id.current_account_name);
              ImageView localImageView2 = (ImageView)paramAnonymousView.findViewById(R.id.other_account_icon);
              TextView localTextView2 = (TextView)paramAnonymousView.findViewById(R.id.other_account_name);
              localTextView1.setText("John Doe");
              localTextView2.setText("Sam Smith");
              localImageView1.setImageResource(R.drawable.generic_image_70x70);
              localImageView2.setImageResource(R.drawable.generic_image_70x70);
            }
          };
          ad.w().a(false).a(local3).a(this.f);
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        final Method localMethod;
        String str;
        while (true)
          localIllegalAccessException.printStackTrace();
        if (str.equals("followCommunityWelcome"))
        {
          l.a(new CommunityFollowerData(1L, "Test group", null, "Awesome group", 1L, null, 0, 1, 0), dj.e(this.g)).a(this.f);
          break label704;
        }
        Object[] arrayOfObject = a(str, localMethod.getParameterTypes());
        locala1 = (a.a)localMethod.invoke(localMethod.getDeclaringClass(), arrayOfObject);
        locala1.b(true);
        if ((str.equals("d" + DialogCode.D725.code())) || (str.equals("d" + DialogCode.D726.code())) || (str.equals("d" + DialogCode.D3004.code())))
        {
          locala1.a(this.f);
          break label704;
        }
        localField = a(locala1.getClass(), "isRestorable");
        if (localField == null)
          break label706;
      }
      if (!localField.getBoolean(locala1))
        break label712;
      break label706;
    }
    while (true)
    {
      while (true)
      {
        if (i1 != 0)
        {
          locala1.d();
          break label704;
        }
        locala1.a(this.f);
        break label704;
        if ((!paramPreference.C().equals("permission_dialog_name")) && (!paramPreference.C().equals("ask_permission_dialog_name")))
          break;
        try
        {
          localm = (com.viber.voip.permissions.m)com.viber.voip.permissions.m.a(Integer.parseInt((String)paramObject)).second;
          if (localm == null)
            break;
          if (paramPreference.C().equals("ask_permission_dialog_name"))
            localm.b(this.a.getResources()).a(this.f);
        }
        catch (Exception localException)
        {
          com.viber.voip.permissions.m localm;
          while (true)
            localm = null;
          localm.a(this.a.getResources()).a(this.f);
        }
      }
      break;
      label704: return true;
      label706: int i1 = 1;
      continue;
      label712: i1 = 0;
    }
  }

  private class a extends m.a
    implements TextWatcher
  {
    private ArrayAdapter<String> b;

    private a()
    {
    }

    public void afterTextChanged(Editable paramEditable)
    {
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
    }

    public void onPrepareDialogView(com.viber.common.dialogs.m paramm, View paramView, int paramInt)
    {
      super.onPrepareDialogView(paramm, paramView, paramInt);
      if (paramInt != 17367060)
        return;
      ListView localListView = (ListView)paramView.findViewById(16908298);
      if ((paramView instanceof ViewGroup))
      {
        int i = com.viber.voip.util.e.j.a(50.0F);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localListView.getLayoutParams();
        localMarginLayoutParams.topMargin = i;
        localListView.setLayoutParams(localMarginLayoutParams);
        EditText localEditText = new EditText(aj.a(aj.this));
        localEditText.setId(16908291);
        localEditText.setBackgroundResource(17170445);
        localEditText.setPadding(com.viber.voip.util.e.j.a(16.0F), localEditText.getPaddingTop(), localEditText.getPaddingRight(), localEditText.getPaddingBottom());
        localEditText.setHint("Type resource prefix...");
        localEditText.addTextChangedListener(this);
        ((ViewGroup)paramView).addView(localEditText, new ViewGroup.LayoutParams(-1, i));
      }
      this.b = new ArrayAdapter(aj.a(aj.this), 17367043, aj.b(aj.this));
      localListView.setOnItemClickListener(new an(this));
      localListView.setAdapter(this.b);
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      this.b.getFilter().filter(paramCharSequence);
    }
  }

  private static class b
  {
    private final Object[][] a;
    private final boolean b;

    private b(Object[][] paramArrayOfObject, boolean paramBoolean)
    {
      this.a = paramArrayOfObject;
      this.b = paramBoolean;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.aj
 * JD-Core Version:    0.6.2
 */