package com.demo.coordemo

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import androidx.coordinatorlayout.widget.CoordinatorLayout

/**
 * author : Naruto
 * date   : 2020-09-03
 * desc   : 泛型为观察者View，跟着别人动的那个view
 * Dependent View，可以理解为被观察者。
 * 我们这个例子中，button是Dependent View，textview跟随着button移动而移动。
 *
 * version:
 */

class FollowBehavior : CoordinatorLayout.Behavior<View> {
    constructor()
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    /**
     * desc：这个方法在对界面进行布局时至少会调用一次，用来确定本次交互行为中的 Dependent View被观察者。
     * 返回true表示依赖，false不依赖。
     * dependency：表示被观察者view
     */
    override fun layoutDependsOn(parent: CoordinatorLayout, child: View,  dependency: View ): Boolean {
        return dependency is Button
    }

    /**
     * 当dependency被观察者发生变化时，这个方法会被调用。
     * 参数中的child相当于本次交互行为中的观察者，观察者可以在这个方法中对被观察者的变化做出响应，从而完成一次交互行为。
     */
    override fun onDependentViewChanged(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
        child.x=dependency.x+100
        child.y=dependency.y-100
        return true
    }

}