package com.viber.voip.s.a;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.viber.provider.b;
import com.viber.voip.publicaccount.d.e;
import com.viber.voip.publicaccount.entity.PublicAccount.CategoryItem;
import com.viber.voip.s.a;
import com.viber.voip.util.af;
import com.viber.voip.util.da;

public class v extends ai
{
  public Cursor a(b paramb, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4)
  {
    Cursor localCursor = super.a(paramb, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, paramString4);
    if (af.c(localCursor))
    {
      String str1 = localCursor.getString(41);
      String str2 = localCursor.getString(42);
      if (!da.a(str1));
      for (PublicAccount.CategoryItem[] arrayOfCategoryItem = e.a(str1, str2); ; arrayOfCategoryItem = null)
      {
        if (arrayOfCategoryItem == null)
        {
          arrayOfCategoryItem = new PublicAccount.CategoryItem[2];
          arrayOfCategoryItem[0] = new PublicAccount.CategoryItem(str1, "");
          arrayOfCategoryItem[1] = new PublicAccount.CategoryItem(str2, "");
        }
        return new a(localCursor, arrayOfCategoryItem);
      }
    }
    return localCursor;
  }

  protected String a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder(1700).append("SELECT ");
    a.a(paramArrayOfString, localStringBuilder);
    localStringBuilder.append(" FROM conversations LEFT OUTER JOIN public_accounts ON (conversations.group_id=public_accounts.group_id)");
    if (!da.a(paramString1))
      localStringBuilder.append(" WHERE ").append(paramString1);
    if (!da.a(paramString4))
      localStringBuilder.append(" ORDER BY ").append(paramString4);
    return localStringBuilder.toString();
  }

  private class a extends CursorWrapper
  {
    private PublicAccount.CategoryItem[] b;

    public a(Cursor paramArrayOfCategoryItem, PublicAccount.CategoryItem[] arg3)
    {
      super();
      Object localObject;
      this.b = localObject;
    }

    public int getColumnCount()
    {
      return super.getColumnCount() + this.b.length;
    }

    public String getString(int paramInt)
    {
      if (paramInt == 52)
        return this.b[0].getName();
      if (paramInt == 53)
        return this.b[1].getName();
      return super.getString(paramInt);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a.v
 * JD-Core Version:    0.6.2
 */