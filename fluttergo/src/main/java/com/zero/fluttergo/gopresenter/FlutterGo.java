package com.zero.fluttergo.gopresenter;

import android.text.TextUtils;
import android.util.Log;

import com.zero.fluttergo.constant.Constants;
import com.zero.fluttergo.entity.request.HelloWorldRequest;
import com.zero.fluttergo.entity.response.BaseResponse;
import com.zero.fluttergo.util.JsonUtil;
import com.zero.gson.reflect.TypeToken;

import fluttergo.Fluttergo;

public class FlutterGo {

    private static final String TAG = "FlutterGo";

    public static int handleAdd(int a, int b) {
        Log.e(TAG, "in handleAdd");
        synchronized (FlutterGo.class) {
            HelloWorldRequest helloWorldRequest = new HelloWorldRequest();
            helloWorldRequest.setA(a);
            helloWorldRequest.setB(b);
            int binaryResponse = getResultData(Fluttergo.helloWorld(JsonUtil.gsonToJson(helloWorldRequest)), new TypeToken<BaseResponse<Integer>>() {
            });
            return binaryResponse;
        }
    }

    public static <T> T getResultData(String responseJson, TypeToken typeToken) {
        BaseResponse<T> responseEntity = JsonUtil.gsonParse(responseJson, typeToken);
        // 处理异常
        handleErrorCode(responseEntity);
        return responseEntity.getResultData();
    }

    private static void handleErrorCode(BaseResponse responseEntity) {
        switch (responseEntity.getResultCode()) {
            case Constants.NORMAL_ERROR_CODE:
                // do nothing
                break;
            default:
//                ToastTool.toast(responseEntity.getResultMessage());
//                ToastTool.toast(MyKeyApplication.getMainApplication().getResources().getString(R.string.error_pelease_repeat_after));
                break;
        }
    }
}
