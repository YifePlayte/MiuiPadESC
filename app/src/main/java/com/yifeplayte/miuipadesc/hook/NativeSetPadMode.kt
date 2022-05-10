package com.yifeplayte.miuipadesc.hook

import com.github.kyuubiran.ezxhelper.utils.findMethod
import com.github.kyuubiran.ezxhelper.utils.hookBefore
import de.robv.android.xposed.XposedBridge

object NativeSetPadMode : BaseHook() {
    override fun init() {
        try {
            findMethod("com.android.server.input.InputManagerService") {
                name == "nativeSetPadMode"
            }.hookBefore { param ->
                param.args[1] = false
                XposedBridge.log("MiuiPadESC: Hook nativeSetPadMode success!")
            }
        } catch (e: Throwable) {
            XposedBridge.log("MiuiPadESC: Hook nativeSetPadMode failed!")
        }
    }
}