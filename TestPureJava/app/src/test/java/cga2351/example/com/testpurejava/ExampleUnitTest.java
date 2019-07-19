package cga2351.example.com.testpurejava;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    public static byte[] encodeYUV420SP(int[] argb, int width, int height) {
        int size = (int) ((Math.ceil(width / 2.0)) * (Math.ceil(height / 2.0)));
        int frameSize = width * height;
        byte[] yuvs = new byte[frameSize + size * 2];
        int y = 0, u = 0, v = 0;
        int r = 0, g = 0, b = 0, a = 0;
        int index = 0, uvindex = frameSize;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                r = (argb[index] &0xff0000) >>16;
                g = (argb[index] &0xff00) >>8;
                b = (argb[index] &0xff) >>0;

                //转换公式
                y = (int) (0.299 * r + 0.587 * g + 0.114 * b);
                u = (int) (-0.1687 * r - 0.3313 * g + 0.5 * b + 128);
                v = (int) (0.5 * r - 0.4187 * g - 0.0813 * b + 128);

                System.out.println("x:" + i + "y:" + j + "  y:" + y + " u:" + u + " v:" + v);
                yuvs[index++] = (byte) ((y < 0) ? 0 : ((y > 255) ? 255 : y));
                if (i % 2 == 0 && j % 2 == 0) {
                    yuvs[uvindex++] = (byte) ((u < 0) ? 0 : ((u > 255) ? 255 : u));
                    yuvs[uvindex++] = (byte) ((v < 0) ? 0 : ((v > 255) ? 255 : v));
                    //yuvs[uvindex++]=(byte)120;
                    // yuvs[uvindex++] = (byte) ((v < 0) ? 0 : ((v > 255) ? 255 : v));
                    // yuvs[uvindex++]=(byte)240;
                }
            }
        }
        return yuvs;
    }



    @Test
    public void addition_isCorrect() {

        double yNetNv21 = 0.299*80f + 0.587*125f + 0.114*250f;
        double uNetNv21 = -0.1687*80 - 0.3313*125 + 0.5*250 + 128;
        double vNetNv21 = 0.5*80 - 0.4187*125 - 0.0813*250 + 128;

        double yNetCbCr = 0.257*80f + 0.504*125f + 0.098*250f + 16;
        double uNetCbCr = -0.148*80f - 0.291*125f + 0.439*250f + 128;
        double vNetCbCr = 0.439*80f - 0.368*125f - 0.071*250f + 128;

        double yLocal = ((66 * 80 + 129 * 125 + 25 * 250 + 128) >> 8) + 16;
        double uLocal = ((-38 * 80 - 74 * 125+ 112 * 250 + 128) >> 8) + 128;
        double vLocal = ((112 * 80 - 94 * 125 - 18 * 250 + 128) >> 8) + 128;

        int width = 720;
        int height = 1280;

        int len = ((int) ((Math.ceil(width / 2.0)) * (Math.ceil(height / 2.0)))) * 2 + width * height;
        int len2 = width * height + 2 * (int) Math.ceil(width / 2.0) * (int) Math.ceil(height / 2.0);
        assertEquals(4, 2 + 2);
    }
}