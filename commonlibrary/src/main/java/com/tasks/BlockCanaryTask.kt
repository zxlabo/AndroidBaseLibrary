package com.tasks

import com.baselibrary.utils.launchstarter.Task
import com.github.moduth.blockcanary.BlockCanary


/**
 * author : Naruto
 * date   : 2020-07-28
 * desc   :
 * version:
 */
class BlockCanaryTask : Task() {
    override fun run() {
        // 注意在主进程初始化调用
        mContext ?: return
        BlockCanary.install(mContext, AppBlockCanaryContext()).start()
    }

}