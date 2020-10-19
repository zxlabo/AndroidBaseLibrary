package com.baselibrary.utils.launchstarter;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 延迟初始化分发器
 */
public class DelayInitDispatcher {

    private Queue<Task> mDelayTasks = new LinkedList<>();

    private MessageQueue.IdleHandler mIdleHandler = new MessageQueue.IdleHandler() {
        @Override
        public boolean queueIdle() {
            Log.e("lazy", "queueIdle");
            if (mDelayTasks.size() > 0) {
                Task task = mDelayTasks.poll();
                Log.e("lazy", "task");
                new DispatchRunnable(task).run();
            }
            Log.e("lazy", mDelayTasks.size() + "");
            return !mDelayTasks.isEmpty();
        }
    };

    public DelayInitDispatcher addTask(Task task) {
        mDelayTasks.add(task);
        return this;
    }

    public void start() {
        Looper.myQueue().addIdleHandler(mIdleHandler);
    }

}
