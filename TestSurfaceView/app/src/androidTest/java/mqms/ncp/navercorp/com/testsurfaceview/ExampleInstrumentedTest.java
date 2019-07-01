package mqms.ncp.navercorp.com.testsurfaceview;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.view.KeyEvent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private UiDevice mDevice;
    private Context appContext;
    private Instrumentation instrumentation;

    @Before
    public void setUp() throws Exception {
        instrumentation = InstrumentationRegistry.getInstrumentation();
        mDevice = UiDevice.getInstance(instrumentation);
        appContext = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        assertEquals("mqms.ncp.navercorp.com.testsurfaceview", appContext.getPackageName());
    }

    @Test
    public void testFunc() {
        Intent intent = appContext.getPackageManager().getLaunchIntentForPackage("mqms.ncp.navercorp.com.testsurfaceview");
        instrumentation.startActivitySync(intent);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        KeyEvent keyEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER);
        KeyEvent.changeFlags(keyEvent, KeyEvent.FLAG_SOFT_KEYBOARD|KeyEvent.FLAG_KEEP_TOUCH_MODE|KeyEvent.FLAG_EDITOR_ACTION);
        instrumentation.sendKeySync(keyEvent);


//        instrumentation.pressKey(new KeyEvent(AndroidKey.ENTER)
//                .withFlag(KeyEventFlag.SOFT_KEYBOARD)
//                .withFlag(KeyEventFlag.KEEP_TOUCH_MODE)
//                .withFlag(KeyEventFlag.EDITOR_ACTION));


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
