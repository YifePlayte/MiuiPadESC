package com.yifeplayte.miuipadesc.hook

import com.github.kyuubiran.ezxhelper.utils.findMethod
import com.github.kyuubiran.ezxhelper.utils.hookBefore
import de.robv.android.xposed.XposedBridge

object SwitchPadMode : BaseHook() {
    override fun init() {
        try {
            findMethod("com.android.server.input.InputManagerServiceStubImpl") {
                name == "switchPadMode"
            }.hookBefore { param ->
                param.args[0] = false
                XposedBridge.log("MiuiPadESC: Hook switchPadMode success!")
            }
        } catch (e: Throwable) {
            XposedBridge.log("MiuiPadESC: Hook switchPadMode failed!")
        }
    }
}
