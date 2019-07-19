package com.viber.voip.user.viberid;

import android.content.Context;
import android.text.TextUtils;
import com.viber.common.b.h;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.settings.d.bg;
import com.viber.voip.stickers.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViberIdPromoStickerPackHelper
{
  public static final String DEFAULT_COUNTRY_CODE_KEY = "";
  static final String ID_KEY = "id";
  static final String IMAGE_KEY = "image";
  private static final com.viber.common.a.e L = ViberEnv.getLogger();
  public static final int MAX_NUMBER_OF_PROMO_IDS = 3;
  static final String PROMO_ID_KEY = "promo_id";
  public static final long SYNC_VIBER_ID_PROMO_STICKERS_JSON_DELAY_MILLIS = 0L;
  public static final String VIBER_ID_PROMO_STICKER_PACK_JSON_KEY = "viberid_packs";
  private final h mVberIdPromoStickersConfigPref;

  public ViberIdPromoStickerPackHelper()
  {
    this(d.bg.d);
  }

  ViberIdPromoStickerPackHelper(h paramh)
  {
    this.mVberIdPromoStickersConfigPref = paramh;
  }

  public MessageEntity createFreeStickerPackMessage(Context paramContext)
  {
    ViberIdPromoStickerPackInfo localViberIdPromoStickerPackInfo = getViberIdPromoStickerPackInfo();
    if ((localViberIdPromoStickerPackInfo != null) && (localViberIdPromoStickerPackInfo.image != null))
      return com.viber.voip.messages.e.a(paramContext, localViberIdPromoStickerPackInfo.id, localViberIdPromoStickerPackInfo.image, R.string.viber_id_free_sticker_pack_fm, R.string.viber_id_free_sticker_pack_fm_button);
    return null;
  }

  public ViberIdPromoStickerPackInfo getViberIdPromoStickerPackInfo()
  {
    while (true)
    {
      int k;
      try
      {
        String str = this.mVberIdPromoStickersConfigPref.d();
        if (!TextUtils.isEmpty(str))
        {
          JSONObject localJSONObject = new JSONObject(str);
          int i = localJSONObject.getInt("id");
          JSONArray localJSONArray = localJSONObject.getJSONArray("promo_id");
          ArrayList localArrayList = new ArrayList(3);
          int j = localJSONArray.length();
          k = 0;
          if (k < j)
          {
            int m = localJSONArray.getJSONObject(k).getInt("id");
            if (m <= 0)
              break label194;
            if (!localArrayList.contains(Integer.valueOf(m)))
              localArrayList.add(Integer.valueOf(m));
            if (localArrayList.size() != 3)
              break label194;
          }
          int[] arrayOfInt = new int[localArrayList.size()];
          int n = localArrayList.size();
          int i1 = 0;
          if (i1 < n)
          {
            arrayOfInt[i1] = ((Integer)localArrayList.get(i1)).intValue();
            i1++;
            continue;
          }
          ViberIdPromoStickerPackInfo localViberIdPromoStickerPackInfo = new ViberIdPromoStickerPackInfo(i, arrayOfInt, localJSONObject.getString("image"));
          return localViberIdPromoStickerPackInfo;
        }
      }
      catch (JSONException localJSONException)
      {
      }
      return null;
      label194: k++;
    }
  }

  public ViberIdPromoStickerPackInfo setNewJsonConfig(String paramString, i parami)
  {
    this.mVberIdPromoStickersConfigPref.a(paramString);
    ViberIdPromoStickerPackInfo localViberIdPromoStickerPackInfo = getViberIdPromoStickerPackInfo();
    if (localViberIdPromoStickerPackInfo != null)
    {
      int[] arrayOfInt = localViberIdPromoStickerPackInfo.promo_ids;
      int i = arrayOfInt.length;
      for (int j = 0; j < i; j++)
        parami.u(arrayOfInt[j]);
    }
    return localViberIdPromoStickerPackInfo;
  }

  public static class ViberIdPromoStickerPackInfo
  {
    public final int id;
    public final String image;
    public final int[] promo_ids;

    ViberIdPromoStickerPackInfo(int paramInt, int[] paramArrayOfInt, String paramString)
    {
      this.id = paramInt;
      this.promo_ids = paramArrayOfInt;
      this.image = paramString;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool1 = true;
      boolean bool2;
      if (this == paramObject)
        bool2 = bool1;
      ViberIdPromoStickerPackInfo localViberIdPromoStickerPackInfo;
      boolean bool3;
      do
      {
        int i;
        int j;
        do
        {
          Class localClass1;
          Class localClass2;
          do
          {
            do
            {
              return bool2;
              bool2 = false;
            }
            while (paramObject == null);
            localClass1 = getClass();
            localClass2 = paramObject.getClass();
            bool2 = false;
          }
          while (localClass1 != localClass2);
          localViberIdPromoStickerPackInfo = (ViberIdPromoStickerPackInfo)paramObject;
          i = this.id;
          j = localViberIdPromoStickerPackInfo.id;
          bool2 = false;
        }
        while (i != j);
        bool3 = Arrays.equals(this.promo_ids, localViberIdPromoStickerPackInfo.promo_ids);
        bool2 = false;
      }
      while (!bool3);
      if (this.image != null)
        bool1 = this.image.equals(localViberIdPromoStickerPackInfo.image);
      while (true)
      {
        return bool1;
        if (localViberIdPromoStickerPackInfo.image != null)
          bool1 = false;
      }
    }

    public String toString()
    {
      return "ViberIdPromoStickerPackInfo{id=" + this.id + ", promo_ids=" + Arrays.toString(this.promo_ids) + ", image='" + this.image + '\'' + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.ViberIdPromoStickerPackHelper
 * JD-Core Version:    0.6.2
 */