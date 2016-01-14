package gdgincheon.jasonkim.incheonstudysample;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by kimjason on 16. 1. 15..
 */
public class Util {

    private static final boolean DEBUG = true;
    private static final String TAG = "Util";

    private static Util m_instance;

    private static Toast m_toast;

    private Util() {
        printLog(DEBUG, TAG, "[Util]");
    }

    public static Util getInstance() {
        if (m_instance == null) {
            m_instance = new Util();
        }
        return m_instance;
    }

    private static String url = "http://openapi.naver.com";

    private static final boolean DEBUGMODE = true;


    public static String getServerURL() {
        return url;
    }


    public void printLog(boolean bPrint, String tag, String msg) {
        if (DEBUGMODE) {
            if (bPrint) {
                Log.d(tag, msg);
            }
        }
    }

    public void showSingleBtnAlertDlg(Context context, String strTitle, String strBtn, String strMsg) {
        printLog(DEBUG, TAG, "[showSingleBtnAlertDlg] strTitle : " + strTitle + ", strBtn : " + strBtn + ", strMsg : " + strMsg);
        new AlertDialog.Builder(context).setTitle(strTitle).setMessage(strMsg).setPositiveButton(strBtn, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }


    public void showLongToast(Context context, String content) {
        printLog(DEBUG, TAG, "[showToast] content : " + content);
        if (m_toast == null) {
            m_toast = Toast.makeText(context, null, Toast.LENGTH_LONG);
        }
        m_toast.setText(content);
        //   m_toast.setGravity(Gravity.BOTTOM|Gravity.CENTER,0,0);
        m_toast.show();

//		Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
        return;
    }

    public void showShortToast(Context context, String content) {
        printLog(DEBUG, TAG, "[showToast] content : " + content);
        if (m_toast == null) {
            m_toast = Toast.makeText(context, null, Toast.LENGTH_SHORT);
        }
        m_toast.setText(content);
        //  m_toast.setGravity(Gravity.BOTTOM|Gravity.CENTER,0,0);
        m_toast.show();
//		Toast.makeText(context, content, 1000).show();
        return;
    }

    public String getAPIKEY(Context context){
        String key = context.getString(R.string.apikey);

        if(key.isEmpty()){
            printLog(DEBUG,TAG,"KEY IS Broken");
        }

        return key;
    }

}
