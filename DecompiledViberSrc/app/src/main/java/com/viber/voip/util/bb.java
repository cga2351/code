package com.viber.voip.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.widget.Toast;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.z;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberDirectShareService;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.invitelinks.CommunityFollowerData;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.extras.wink.WinkDescription;
import com.viber.voip.messages.ui.media.ComposeDataContainer;
import com.viber.voip.model.entity.g;
import com.viber.voip.news.NewsShareAnalyticsData;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.l;
import com.viber.voip.ui.dialogs.o;
import com.viber.voip.util.e.j;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

public class bb
{
  private static final Logger a = ViberEnv.getLogger();
  private static WeakReference<AppCompatActivity> b = new WeakReference(null);
  private static final Pattern c = Pattern.compile("(?i)^END:VCARD");
  private static final Pattern d = Pattern.compile("(?i)^BEGIN:VCARD");
  private static final Pattern e = Pattern.compile("(?i)(^FN|TEL)(?:;?([^:]*):(.*))?");

  private static void a(Context paramContext, final Uri paramUri, final ConversationData paramConversationData)
  {
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        File localFile = dv.o.a(this.a, paramUri.toString());
        if (localFile == null)
        {
          bb.b();
          return;
        }
        ComposeDataContainer localComposeDataContainer;
        Intent localIntent1;
        if (j.a(ViberApplication.getApplication(), paramUri, localFile) != null)
        {
          Pair localPair = bb.a(localFile);
          if (localPair != null)
          {
            String str1 = (String)localPair.first;
            String str2 = PhoneNumberUtils.stripSeparators((String)localPair.second);
            String str3 = dr.a(ViberApplication.getInstance(), (CharSequence)localPair.second, str2);
            if (!da.a(str3))
            {
              localComposeDataContainer = new ComposeDataContainer(str1, null, str3, null, null, null);
              if (paramConversationData == null)
                break label171;
              localIntent1 = new Intent("com.viber.voip.action.CONVERSATION");
              localIntent1.putExtra("extra_conversation_data", paramConversationData);
              localIntent1.putExtra("compose_data_extra", localComposeDataContainer);
            }
          }
        }
        label171: for (Intent localIntent2 = localIntent1; ; localIntent2 = ViberActionRunner.u.a(localComposeDataContainer))
        {
          localIntent2.addFlags(268435456);
          bb.b(localIntent2);
          bb.b();
          return;
        }
      }
    });
  }

  private static void a(ArrayList<Uri> paramArrayList, final String paramString, final WinkDescription paramWinkDescription, final ConversationData paramConversationData, final CharSequence paramCharSequence)
  {
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.a.iterator();
        int i = 0;
        Uri localUri1;
        int k;
        Object localObject;
        if (localIterator.hasNext())
        {
          localUri1 = (Uri)localIterator.next();
          if (paramWinkDescription != null)
          {
            Uri localUri4 = at.f(ViberApplication.getApplication(), localUri1);
            k = i;
            localObject = localUri4;
          }
        }
        while (true)
        {
          if (localObject != null)
            localArrayList.add(localObject);
          i = k;
          break;
          if (localUri1.toString().contains("/Fleksy/"))
          {
            Uri localUri3 = j.a(localUri1, paramString);
            k = i;
            localObject = localUri3;
          }
          else
          {
            String str = at.g(localUri1);
            Uri localUri2 = j.a(ViberApplication.getApplication(), localUri1, str);
            if ((localUri2 == null) && (j.a(str, localUri1)))
            {
              localObject = localUri2;
              k = 1;
              continue;
              Intent localIntent;
              int j;
              if (localArrayList.size() > 0)
                if (paramConversationData != null)
                {
                  localIntent = new Intent("com.viber.voip.action.CONVERSATION");
                  localIntent.putExtra("extra_conversation_data", paramConversationData);
                  localIntent.putExtra("share_files_uri", localArrayList);
                  if (!da.a(paramCharSequence))
                    localIntent.putExtra("share_text", paramCharSequence);
                  localIntent.putExtra("external_share", true);
                  localIntent.putExtra("need_description", true).addFlags(268435456);
                  if (paramWinkDescription != null)
                  {
                    if (!"image".equals(paramString))
                      break label342;
                    j = 1;
                    label271: localIntent.putExtra("media_type", j);
                    localIntent.putExtra("enable_communities_extra", false);
                    localIntent.putExtra("show_public_groups_extra", false);
                    localIntent.putExtra("need_description", false);
                    localIntent.putExtra("com.viber.voip.wink.WINK_DESCRIPTION", paramWinkDescription);
                  }
                  bb.b(localIntent);
                }
              while (true)
              {
                bb.b();
                return;
                localIntent = ViberActionRunner.u.a(localArrayList, paramCharSequence);
                break;
                label342: j = 3;
                break label271;
                if (i != 0)
                  bb.a();
              }
            }
            else
            {
              k = i;
              localObject = localUri2;
            }
          }
        }
      }
    });
  }

  public static boolean a(final Activity paramActivity, Intent paramIntent, final boolean paramBoolean)
  {
    String str = paramIntent.getAction();
    Uri localUri = paramIntent.getData();
    if (("android.intent.action.VIEW".equals(str)) && (localUri != null))
    {
      dr.a(paramIntent.getData().getSchemeSpecificPart(), new dr.a()
      {
        public void onCheckStatus(boolean paramAnonymousBoolean, int paramAnonymousInt, ParticipantSelector.Participant paramAnonymousParticipant, g paramAnonymousg)
        {
          if ((paramAnonymousInt == 0) || (1 == paramAnonymousInt) || (7 == paramAnonymousInt))
          {
            bool = this.a.hasExtra("EXTRA_RETURN_TO_HOME");
            paramActivity.startActivity(ViberActionRunner.o.a(paramAnonymousParticipant, paramAnonymousg, bool));
          }
          while (!paramBoolean)
          {
            boolean bool;
            return;
          }
          this.a.setClass(paramActivity, ViberActionRunner.ab.a(ViberApplication.isTablet(paramActivity)));
          this.a.putExtra("EXTRA_FROM_LAUNCH_ACTIVITY", true);
          paramActivity.startActivity(this.a);
          paramActivity.finish();
        }
      });
      return true;
    }
    return false;
  }

  public static boolean a(Intent paramIntent)
  {
    return (paramIntent != null) && (("com.viber.voip.action.VIEW_CONTACT".equals(paramIntent.getAction())) || ("com.viber.voip.action.VIEW_CALL_LOG".equals(paramIntent.getAction())));
  }

  private static boolean a(FragmentActivity paramFragmentActivity, Intent paramIntent)
  {
    if ((0x100000 & paramIntent.getFlags()) == 0)
    {
      CommunityFollowerData localCommunityFollowerData = (CommunityFollowerData)paramIntent.getParcelableExtra("extra_community_follower_data");
      if (localCommunityFollowerData != null)
      {
        l.a(localCommunityFollowerData, dj.e(paramFragmentActivity)).a(paramFragmentActivity);
        return true;
      }
    }
    return false;
  }

  public static boolean a(AppCompatActivity paramAppCompatActivity, a parama, Intent paramIntent, c paramc)
  {
    b = new WeakReference(paramAppCompatActivity);
    if (com.viber.voip.util.a.a.a(b, paramIntent, paramc));
    do
    {
      do
        return true;
      while (m.a(paramAppCompatActivity, paramIntent) != null);
      if (f(paramIntent))
      {
        paramIntent.putExtra("from_navigate", true);
        parama.g(paramIntent);
        return true;
      }
      if (a(paramIntent))
      {
        parama.d(paramIntent);
        return true;
      }
      if (e(paramIntent))
      {
        parama.e(paramIntent);
        return true;
      }
      if (g(paramIntent))
      {
        parama.f(paramIntent);
        return true;
      }
      if (c(paramIntent))
      {
        paramAppCompatActivity.setIntent(ViberActionRunner.ab.e(paramAppCompatActivity));
        paramAppCompatActivity.startActivity(new Intent(paramAppCompatActivity, ViberActionRunner.ab.a(ViberApplication.isTablet(paramAppCompatActivity))));
        return true;
      }
    }
    while (a(paramAppCompatActivity, paramIntent, false));
    boolean bool = a(paramAppCompatActivity, paramIntent);
    if (paramIntent.getBooleanExtra("extra_navigate_should_register", false))
    {
      paramIntent.removeExtra("extra_navigate_should_register");
      paramAppCompatActivity.setIntent(paramIntent);
      ViberActionRunner.au.c(paramAppCompatActivity);
      paramAppCompatActivity.finish();
      return true;
    }
    return bool;
  }

  private static boolean a(String paramString)
  {
    return (paramString.length() > 0) && (paramString.charAt(-1 + paramString.length()) == '=');
  }

  // ERROR //
  private static Pair<String, String> b(File paramFile)
  {
    // Byte code:
    //   0: new 252	java/io/BufferedReader
    //   3: dup
    //   4: new 254	java/io/FileReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 257	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   12: invokespecial 260	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_1
    //   16: aconst_null
    //   17: astore_2
    //   18: aconst_null
    //   19: astore_3
    //   20: aconst_null
    //   21: astore 4
    //   23: aload_1
    //   24: invokevirtual 263	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: astore 7
    //   29: aload 7
    //   31: ifnull +303 -> 334
    //   34: getstatic 45	com/viber/voip/util/bb:d	Ljava/util/regex/Pattern;
    //   37: aload 7
    //   39: invokevirtual 267	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   42: invokevirtual 273	java/util/regex/Matcher:matches	()Z
    //   45: ifne -22 -> 23
    //   48: getstatic 41	com/viber/voip/util/bb:c	Ljava/util/regex/Pattern;
    //   51: aload 7
    //   53: invokevirtual 267	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   56: invokevirtual 273	java/util/regex/Matcher:matches	()Z
    //   59: ifeq +26 -> 85
    //   62: new 275	android/support/v4/util/Pair
    //   65: dup
    //   66: aload 4
    //   68: aload_3
    //   69: invokespecial 278	android/support/v4/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   72: astore 8
    //   74: aload_1
    //   75: invokestatic 283	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   78: aload 8
    //   80: areturn
    //   81: astore 22
    //   83: aconst_null
    //   84: areturn
    //   85: getstatic 49	com/viber/voip/util/bb:e	Ljava/util/regex/Pattern;
    //   88: aload 7
    //   90: invokevirtual 267	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   93: astore 9
    //   95: aload 9
    //   97: invokevirtual 286	java/util/regex/Matcher:find	()Z
    //   100: ifne +65 -> 165
    //   103: aload_2
    //   104: ifnull -81 -> 23
    //   107: aload 7
    //   109: invokestatic 288	com/viber/voip/util/bb:a	(Ljava/lang/String;)Z
    //   112: ifeq +32 -> 144
    //   115: aload_2
    //   116: aload 7
    //   118: iconst_0
    //   119: iconst_m1
    //   120: aload 7
    //   122: invokevirtual 240	java/lang/String:length	()I
    //   125: iadd
    //   126: invokevirtual 292	java/lang/String:substring	(II)Ljava/lang/String;
    //   129: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: goto -110 -> 23
    //   136: astore 6
    //   138: aload_1
    //   139: invokestatic 283	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   142: aconst_null
    //   143: areturn
    //   144: aload_2
    //   145: aload 7
    //   147: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_2
    //   152: invokevirtual 301	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 307	com/viber/voip/util/da:i	(Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 4
    //   160: aconst_null
    //   161: astore_2
    //   162: goto -139 -> 23
    //   165: aload 9
    //   167: iconst_1
    //   168: invokevirtual 311	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   171: astore 12
    //   173: aload 12
    //   175: ldc_w 313
    //   178: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   181: ifeq +106 -> 287
    //   184: aload 9
    //   186: iconst_2
    //   187: invokevirtual 311	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   190: astore 14
    //   192: aload 14
    //   194: invokestatic 316	com/viber/voip/util/da:a	(Ljava/lang/CharSequence;)Z
    //   197: ifne +79 -> 276
    //   200: aload 14
    //   202: invokestatic 318	com/viber/voip/util/bb:b	(Ljava/lang/String;)Z
    //   205: istore 15
    //   207: iload 15
    //   209: ifeq -186 -> 23
    //   212: aload 9
    //   214: iconst_3
    //   215: invokevirtual 311	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   218: astore 17
    //   220: aload 17
    //   222: invokestatic 288	com/viber/voip/util/bb:a	(Ljava/lang/String;)Z
    //   225: ifeq +37 -> 262
    //   228: new 294	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   235: astore 18
    //   237: aload 18
    //   239: aload 17
    //   241: iconst_0
    //   242: iconst_m1
    //   243: aload 17
    //   245: invokevirtual 240	java/lang/String:length	()I
    //   248: iadd
    //   249: invokevirtual 292	java/lang/String:substring	(II)Ljava/lang/String;
    //   252: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 18
    //   258: astore_2
    //   259: goto -236 -> 23
    //   262: aload 17
    //   264: invokestatic 307	com/viber/voip/util/da:i	(Ljava/lang/String;)Ljava/lang/String;
    //   267: astore 21
    //   269: aload 21
    //   271: astore 4
    //   273: goto -250 -> 23
    //   276: aload 9
    //   278: iconst_3
    //   279: invokevirtual 311	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   282: astore 4
    //   284: goto -261 -> 23
    //   287: aload 12
    //   289: ldc_w 322
    //   292: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   295: ifeq -272 -> 23
    //   298: aload 9
    //   300: iconst_3
    //   301: invokevirtual 311	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   304: astore 13
    //   306: aload 13
    //   308: astore_3
    //   309: goto -286 -> 23
    //   312: astore 5
    //   314: aload_1
    //   315: invokestatic 283	com/viber/voip/util/bj:a	(Ljava/io/Closeable;)V
    //   318: aload 5
    //   320: athrow
    //   321: astore 16
    //   323: goto -300 -> 23
    //   326: astore 19
    //   328: aload 18
    //   330: astore_2
    //   331: goto -308 -> 23
    //   334: aconst_null
    //   335: astore 8
    //   337: goto -263 -> 74
    //
    // Exception table:
    //   from	to	target	type
    //   0	16	81	java/io/FileNotFoundException
    //   23	29	136	java/io/IOException
    //   34	74	136	java/io/IOException
    //   85	103	136	java/io/IOException
    //   107	133	136	java/io/IOException
    //   144	160	136	java/io/IOException
    //   165	207	136	java/io/IOException
    //   212	237	136	java/io/IOException
    //   237	256	136	java/io/IOException
    //   262	269	136	java/io/IOException
    //   276	284	136	java/io/IOException
    //   287	306	136	java/io/IOException
    //   23	29	312	finally
    //   34	74	312	finally
    //   85	103	312	finally
    //   107	133	312	finally
    //   144	160	312	finally
    //   165	207	312	finally
    //   212	237	312	finally
    //   237	256	312	finally
    //   262	269	312	finally
    //   276	284	312	finally
    //   287	306	312	finally
    //   212	237	321	java/lang/IllegalArgumentException
    //   262	269	321	java/lang/IllegalArgumentException
    //   237	256	326	java/lang/IllegalArgumentException
  }

  private static boolean b(String paramString)
  {
    String[] arrayOfString = paramString.split(";");
    return (arrayOfString.length == 2) && ("ENCODING=QUOTED-PRINTABLE".equals(arrayOfString[1]));
  }

  private static boolean c(Intent paramIntent)
  {
    Activity localActivity;
    if (b != null)
    {
      localActivity = (Activity)b.get();
      if (localActivity != null)
        break label27;
    }
    label27: 
    while ((0x100000 & paramIntent.getFlags()) != 0)
    {
      return false;
      localActivity = null;
      break;
    }
    ArrayList localArrayList1 = new ArrayList();
    WinkDescription localWinkDescription = WinkDescription.from(paramIntent);
    String str1 = paramIntent.getType();
    if (!da.a(str1))
    {
      ArrayList localArrayList2 = paramIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
      if (localArrayList2 != null)
      {
        Iterator localIterator = localArrayList2.iterator();
        while (localIterator.hasNext())
        {
          Uri localUri2 = (Uri)localIterator.next();
          if (at.g(localActivity, localUri2))
            localArrayList1.add(localUri2);
        }
      }
      Uri localUri1 = (Uri)paramIntent.getParcelableExtra("android.intent.extra.STREAM");
      if (at.g(localActivity, localUri1))
        localArrayList1.add(localUri1);
      if (localArrayList1.size() > 10)
      {
        Toast.makeText(localActivity, localActivity.getResources().getString(R.string.multiple_file_limit_toast), 0).show();
        localActivity.finish();
        return true;
      }
      if (!com.viber.common.d.a.j())
        break label467;
    }
    label467: for (ConversationData localConversationData = ViberDirectShareService.a(paramIntent); ; localConversationData = null)
    {
      boolean bool1;
      if (localArrayList1.size() > 0)
      {
        ad.b().a(localActivity);
        if ("text/x-vcard".equals(str1))
        {
          a(localActivity, (Uri)localArrayList1.get(0), localConversationData);
          bool1 = true;
        }
      }
      while (true)
      {
        return bool1;
        Object localObject;
        if (paramIntent.hasExtra("android.intent.extra.TEXT"))
          localObject = paramIntent.getCharSequenceExtra("android.intent.extra.TEXT");
        while (true)
        {
          a(localArrayList1, str1, localWinkDescription, localConversationData, (CharSequence)localObject);
          bool1 = true;
          break;
          boolean bool2 = paramIntent.hasExtra("share_text");
          localObject = null;
          if (bool2)
            localObject = paramIntent.getExtras().getString("share_text");
        }
        if ((("text/plain".equals(str1)) || ("text/*".equals(str1))) && (paramIntent.hasExtra("android.intent.extra.TEXT")))
        {
          String str2 = paramIntent.getStringExtra("android.intent.extra.TEXT");
          Intent localIntent;
          if (localConversationData != null)
          {
            localIntent = new Intent("com.viber.voip.action.CONVERSATION");
            localIntent.putExtra("extra_conversation_data", localConversationData);
            localIntent.putExtra("share_text", str2);
          }
          while (true)
          {
            localIntent.putExtra("external_share", true);
            d(localIntent.addFlags(268435456));
            bool1 = true;
            break;
            if (paramIntent.hasExtra("news_provider_base_url"))
              localIntent = ViberActionRunner.u.a(str2, (NewsShareAnalyticsData)paramIntent.getParcelableExtra("news_provider_base_url"));
            else
              localIntent = ViberActionRunner.u.a(str2, false);
          }
        }
        bool1 = false;
      }
    }
  }

  private static void d()
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        AppCompatActivity localAppCompatActivity = (AppCompatActivity)bb.c().get();
        if (localAppCompatActivity != null)
          z.a(localAppCompatActivity.getSupportFragmentManager(), DialogCode.D_PROGRESS);
      }
    });
  }

  private static void d(Intent paramIntent)
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        ViberApplication.getApplication().startActivity(this.a);
      }
    });
  }

  private static void e()
  {
    av.e.a.a().post(new Runnable()
    {
      public void run()
      {
        Activity localActivity = (Activity)bb.c().get();
        if (localActivity != null)
          o.m().a(localActivity);
      }
    });
  }

  private static boolean e(Intent paramIntent)
  {
    return (paramIntent != null) && ("com.viber.voip.action.MORE".equals(paramIntent.getAction()));
  }

  private static boolean f(Intent paramIntent)
  {
    return (paramIntent != null) && (("com.viber.voip.action.CONVERSATION".equals(paramIntent.getAction())) || ("com.viber.voip.action.COMMUNITY_CONVERSATION".equals(paramIntent.getAction())));
  }

  private static boolean g(Intent paramIntent)
  {
    return (paramIntent != null) && ("com.viber.voip.action.SETTINGS".equals(paramIntent.getAction()));
  }

  public static abstract interface a
  {
    public abstract void d(Intent paramIntent);

    public abstract void e(Intent paramIntent);

    public abstract void f(Intent paramIntent);

    public abstract void g(Intent paramIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bb
 * JD-Core Version:    0.6.2
 */