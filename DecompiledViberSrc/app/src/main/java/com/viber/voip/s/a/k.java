package com.viber.voip.s.a;

import android.database.Cursor;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.al;
import com.viber.voip.model.entity.l;
import com.viber.voip.model.entity.m;
import com.viber.voip.s.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class k extends ai
{
  protected static final String a;
  protected static final String b;
  private static final Logger d = ViberEnv.getLogger();
  private static final String f;
  private static final String g;
  private long e;

  static
  {
    StringBuilder localStringBuilder = new StringBuilder().append("phonebookcontact.phone_label COLLATE LOCALIZED, phonebookcontact.low_display_name COLLATE LOCALIZED");
    if ((com.viber.voip.util.a.b.a()) && (com.viber.voip.util.a.b.b()));
    for (String str = ", SONY_ORDER ASC, phonebookcontact.display_name COLLATE NOCASE, phonebookcontact.display_name DESC"; ; str = "")
    {
      a = str;
      f = " SELECT " + "%s" + ", (CASE WHEN phonebookcontact.display_name=phonebookcontact.low_display_name THEN 0 ELSE 1 END) AS SONY_ORDER" + ", 1 AS alias_union_type" + ", 0 AS recently_joined" + ", %s" + "AS " + "recent" + " FROM phonebookcontact" + " LEFT OUTER JOIN phonebookdata ON (phonebookcontact._id=phonebookdata.contact_id) LEFT OUTER JOIN vibernumbers ON (phonebookdata.data2=vibernumbers.canonized_number) " + " WHERE vibernumbers.member_id NOT IN (SELECT canonized_number FROM blockednumbers)" + " AND phonebookcontact._id IN (" + "%s) AND phonebookcontact._id NOT IN(" + "%s) AND phonebookcontact.viber=1" + " GROUP BY phonebookcontact._id";
      g = " SELECT " + "%s" + ", (CASE WHEN phonebookcontact.display_name=phonebookcontact.low_display_name THEN 0 ELSE 1 END) AS SONY_ORDER" + ", 2 AS alias_union_type" + ", 0 AS recently_joined" + ", 0 AS recent" + " FROM phonebookcontact" + " LEFT OUTER JOIN phonebookdata ON (phonebookcontact._id=phonebookdata.contact_id) LEFT OUTER JOIN vibernumbers ON (phonebookdata.data2=vibernumbers.canonized_number) " + " WHERE phonebookcontact.starred=1 AND phonebookcontact.has_number=1 " + "%s" + " GROUP BY phonebookcontact._id";
      b = " SELECT " + "%s" + ", (CASE WHEN phonebookcontact.display_name=phonebookcontact.low_display_name THEN 0 ELSE 1 END) AS SONY_ORDER" + ", 3 AS alias_union_type" + ", 0 AS recently_joined" + ", 0 AS recent" + " FROM phonebookcontact" + " LEFT OUTER JOIN phonebookdata ON (phonebookcontact._id=phonebookdata.contact_id) LEFT OUTER JOIN vibernumbers ON (phonebookdata.data2=vibernumbers.canonized_number) " + " WHERE phonebookcontact.has_number=1 " + "%s" + " GROUP BY phonebookcontact._id";
      return;
    }
  }

  private String a(Set<Long> paramSet)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(CASE");
    Iterator localIterator = paramSet.iterator();
    for (int i = 1; localIterator.hasNext(); i++)
    {
      Long localLong = (Long)localIterator.next();
      localStringBuilder.append(" WHEN ").append("phonebookcontact._id").append(" = ").append(String.valueOf(localLong)).append(" THEN ").append(String.valueOf(i));
    }
    localStringBuilder.append(" ELSE 0 END)");
    return localStringBuilder.toString();
  }

  private List<Long> a()
  {
    ArrayList localArrayList1 = new ArrayList();
    if (this.e > 0L)
    {
      List localList = al.a().c(this.e);
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator1 = localList.iterator();
      while (localIterator1.hasNext())
        localArrayList2.add(String.valueOf(((l)localIterator1.next()).a()));
      Iterator localIterator2 = ak.a().b(localArrayList2).iterator();
      while (localIterator2.hasNext())
      {
        long l = ((m)localIterator2.next()).i();
        if (l > 0L)
          localArrayList1.add(Long.valueOf(l));
      }
      this.e = 0L;
    }
    return localArrayList1;
  }

  private String[] a(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int i = paramArrayOfString.length;
      int j = 0;
      if (j < i)
      {
        String str = paramArrayOfString[j];
        String[] arrayOfString;
        if (str.contains("conversationId"))
        {
          arrayOfString = str.split(":");
          if (arrayOfString.length != 2);
        }
        while (true)
        {
          try
          {
            this.e = Long.valueOf(arrayOfString[1]).longValue();
            j++;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            this.e = 0L;
            continue;
          }
          localArrayList.add(str);
        }
      }
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }

  public Cursor a(com.viber.provider.b paramb, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4)
  {
    String[] arrayOfString = a(paramArrayOfString2);
    if (!TextUtils.isEmpty(paramString1));
    for (String str = " AND (" + paramString1 + ")"; ; str = "")
      return b(paramb, paramArrayOfString1, str, a.a(arrayOfString, 3), paramString2, paramString3, paramString4);
  }

  protected String a(String paramString)
  {
    return " ORDER BY alias_union_type, recent, recently_joined ASC, " + a;
  }

  protected String a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str1 = a.d(paramArrayOfString);
    Set localSet = ab.b().n();
    List localList = a();
    StringBuilder localStringBuilder = new StringBuilder(4950);
    if (localSet.size() > 0)
    {
      String str2 = f;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = str1;
      arrayOfObject[1] = a(localSet);
      arrayOfObject[2] = a.e(localSet);
      arrayOfObject[3] = a.e(localList);
      localStringBuilder.append(String.format(str2, arrayOfObject)).append(" UNION ALL ");
    }
    localStringBuilder.append(String.format(g, new Object[] { str1, paramString1 })).append(" UNION ALL ").append(String.format(b, new Object[] { str1, paramString1 })).append(a(paramString4));
    return localStringBuilder.toString();
  }

  protected final Cursor b(com.viber.provider.b paramb, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4)
  {
    return paramb.a(1048576, a(paramArrayOfString1, paramString1, paramString2, paramString3, paramString4), paramArrayOfString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a.k
 * JD-Core Version:    0.6.2
 */